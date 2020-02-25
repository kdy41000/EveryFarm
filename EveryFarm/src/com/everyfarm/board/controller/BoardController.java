package com.everyfarm.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.everyfarm.board.biz.BoardBiz;
import com.everyfarm.board.biz.BoardBizImpl;
import com.everyfarm.board.dto.BoardDto;
import com.everyfarm.board.dto.BoardPagingDto;
import com.everyfarm.member.dto.MemberDto;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/board.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("<"+command+">");
		
		BoardBiz biz = new BoardBizImpl();
		HttpSession session = request.getSession();
		
		
		/////////////////////////////////notice % free board//////////////////////////////////////
		if(command.equals("boardList")) {
			// All List paging
			int currentpage = Integer.parseInt(request.getParameter("page"));
			System.out.println("페이지"+currentpage);
			
			BoardPagingDto boardPaging = new BoardPagingDto();
			boardPaging.setCurrentpage(currentpage);
			boardPaging.setTotalrows(10);
			boardPaging.setPagescale(5);
			boardPaging.setTotalpage(biz.totalpage(boardPaging.getTotalrows()));	//정해준 totalrows에 맞는 총 페이지			
			
			// 모든 리스트 뿌리기
			List<BoardDto> bestNotice = biz.bestNotice();
			session.setAttribute("bestNotice", bestNotice);
			List<BoardDto> boardAllList = biz.boardSelectAll(boardPaging);
			session.setAttribute("boardAllList", boardAllList);	// 받아온 모든 List 뿌리기
			session.setAttribute("boardPaging", boardPaging);
			response.sendRedirect("board/everyboard.jsp");

		}else if(command.equals("boardDetail")) {
			if(session.getAttribute("dto") == null) {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('로그인 후 이용 가능합니다')");
				out.println("location.href='login/loginform.jsp'");
				out.println("</script>");
			}else {
				int board_id = Integer.parseInt(request.getParameter("board_id"));
				System.out.println(board_id);
				BoardDto boardDetail = biz.boardDetail(board_id);
				session.setAttribute("boardDetail", boardDetail);
				List<BoardDto> boardReplyAll = biz.boardReplyAll(board_id);
				session.setAttribute("boardReplyAll", boardReplyAll);
				
				response.sendRedirect("board/everyboardDetail.jsp");
			}
		
		}else if(command.contentEquals("boardReplyUpdatePage")) {
			int reply_board_id = Integer.parseInt(request.getParameter("board_id"));
			int reply_comment_no = Integer.parseInt(request.getParameter("comment_no"));
			System.out.println(reply_comment_no);
			session.setAttribute("reply_comment_no", reply_comment_no);
			BoardDto boardReplyUpdate = biz.boardDetail(reply_board_id);
			session.setAttribute("boardReplyUpdate", boardReplyUpdate);
			List<BoardDto> replyUpdate = biz.boardReplyAll(reply_board_id);
			session.setAttribute("replyUpdate", replyUpdate);
			response.sendRedirect("board/BoardReplyUpdate.jsp");
			
			
		}else if(command.equals("boardReplyUpdate")) {
			int comment_no = Integer.parseInt(request.getParameter("comment_no"));
			String comment_content_update = request.getParameter("comment_content_update");
			int board_id = Integer.parseInt(request.getParameter("board_id"));
			
			int boardReplyUpdate = biz.boardReplyUpdate(comment_no, comment_content_update);
			if(boardReplyUpdate>0) {
				jsResponse("댓글수정 성공", "board.do?command=boardDetail&board_id="+board_id, response);
			}else {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('실패')");
				out.println("history.back()");
				out.println("</script>");
			}
			
			
		}else if(command.equals("boardReplyDelete")) {
			int reply_board_id = Integer.parseInt(request.getParameter("board_id"));
			int reply_comment_no = Integer.parseInt(request.getParameter("comment_no"));
			
			int boardReplyDelete = biz.boardReplyDelete(reply_board_id, reply_comment_no);
			if(boardReplyDelete>0) {
				jsResponse("댓글삭제성공", "board.do?command=boardDetail&board_id="+reply_board_id, response);
			}else {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('실패')");
				out.println("history.back()");
				out.println("</script>");
				
			}
			
		}else if(command.equals("boardInsert")) {	//팝업으로 대체해서 이 커멘드는 사용안함
			if(session.getAttribute("dto")==null) {
				jsResponse("로그인 후 사용가능합니다.", "login/loginform.jsp", response);
			}else {
				response.sendRedirect("board/everyboardInsert.jsp");				
			}
			
		}else if(command.equals("boardUpdate")) {
			int board_id = Integer.parseInt(request.getParameter("board_id"));
			BoardDto boardDetail = biz.boardDetail(board_id);
			session.setAttribute("boardDetail", boardDetail);
			response.sendRedirect("board/everyboardUpdate.jsp");
		
		}else if(command.equals("boardUpdateDb")) {
			int board_id = Integer.parseInt(request.getParameter("board_id"));
			int board_category = Integer.parseInt(request.getParameter("board_category"));
			String board_title = request.getParameter("board_title");
			String board_content = request.getParameter("board_content");
			
			BoardDto boardDto = new BoardDto();
			boardDto.setBoard_id(board_id);
			boardDto.setBoard_category(board_category);
			boardDto.setBoard_title(board_title);
			boardDto.setBoard_content(board_content);
			
			int updateRes = biz.boardUpdate(boardDto);
			if(updateRes>0) {
				jsResponse("수정 성공", "board.do?command=boardList&page=1", response);
			}
		
		}else if(command.equals("boardDelete")) {	
			int board_id = Integer.parseInt(request.getParameter("board_id"));
			int deleteRes = biz.boardDelete(board_id);
			
			if(deleteRes>0) {
				jsResponse("삭제성공", "board.do?command=boardList&page=1", response);
			}else {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('실패')");
				out.println("history.back()");
				out.println("</script>");
			}
		
		}else if(command.equals("boardCate1")) {	//공지사항
			int currentpage = Integer.parseInt(request.getParameter("page"));
			
			BoardPagingDto boardPaging = new BoardPagingDto();
			boardPaging.setCurrentpage(currentpage);
			boardPaging.setTotalrows(10);
			boardPaging.setPagescale(5);
			boardPaging.setTotalpage(biz.cate1_totalpage(boardPaging.getTotalrows()));	//정해준 totalrows에 맞는 총 페이지			
			
			// 모든 리스트 뿌리기
			List<BoardDto> boardNoticeAll = biz.boardNoticeAll(boardPaging);
			session.setAttribute("boardNoticeAll", boardNoticeAll);	// 받아온 모든 List 뿌리기
			session.setAttribute("boardPaging", boardPaging);
			response.sendRedirect("board/everyboard_cate1.jsp");
	
		}else if(command.equals("boardCate2")) {	//자유게시판
			int currentpage = Integer.parseInt(request.getParameter("page"));
			
			BoardPagingDto boardPaging = new BoardPagingDto();
			boardPaging.setCurrentpage(currentpage);
			boardPaging.setTotalrows(10);
			boardPaging.setPagescale(5);
			boardPaging.setTotalpage(biz.cate2_totalpage(boardPaging.getTotalrows()));	//정해준 totalrows에 맞는 총 페이지			
			
			// 모든 리스트 뿌리기
			List<BoardDto> freeBoardAll = biz.freeBoardAll(boardPaging);
			session.setAttribute("freeBoardAll", freeBoardAll);	// 받아온 모든 List 뿌리기
			session.setAttribute("boardPaging", boardPaging);
			response.sendRedirect("board/everyboard_cate2.jsp");
		
		}else if(command.equals("boardReply")) {	//댓글 등록
			String mem_id_reply = request.getParameter("mem_id_reply");
			int board_id_reply = Integer.parseInt(request.getParameter("board_id_reply"));
			String comment_content = request.getParameter("comment_content");
			
			BoardDto board_reply = new BoardDto();
			board_reply.setMem_id(mem_id_reply);
			board_reply.setBoard_id(board_id_reply);
			board_reply.setComment_content(comment_content);
			
			int replyInsertRes = biz.boardReplyInsert(board_reply);
			if(replyInsertRes>0) {
				jsResponse("댓글등록 성공", "board.do?command=boardDetail&board_id="+board_id_reply, response);
			}
			
			/////////////////////////////////Q&A board//////////////////////////////////////
		}else if(command.equals("qaList")) {
				MemberDto memDto = (MemberDto)session.getAttribute("dto");
				if(memDto==null) {
					jsResponse("로그인이 필요합니다.", "login/loginform.jsp", response);
				}else if(memDto.getMem_grade()==1) {
					jsResponse("회원 문의 게시판으로","board.do?command=qaCate3&page=1", response);
				}else if(memDto.getMem_grade()==2) {
					jsResponse("농부 문의 게시판으로", "board.do?command=qaCate4&page=1", response);
				}else {
				
			// All List paging
				int currentpage = Integer.parseInt(request.getParameter("page"));
				System.out.println("페이지"+currentpage);
				
				BoardPagingDto boardPaging = new BoardPagingDto();
				boardPaging.setCurrentpage(currentpage);
				boardPaging.setTotalrows(10);
				boardPaging.setPagescale(5);
				boardPaging.setTotalpage(biz.qaTotalpage(boardPaging.getTotalrows()));	//정해준 totalrows에 맞는 총 페이지			
				
				// 모든 리스트 뿌리기
				List<BoardDto> qaAllList = biz.qaSelectAll(boardPaging);
				session.setAttribute("qaAllList", qaAllList);	// 받아온 모든 List 뿌리기
				session.setAttribute("boardPaging", boardPaging);
				response.sendRedirect("board/everyboard_qa_list.jsp");
				}
		
		}else if(command.equals("qaDetail")) {
			if(session.getAttribute("dto") == null) {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('로그인 후 이용 가능합니다')");
				out.println("location.href='login/loginform.jsp'");
				out.println("</script>");
			}else {
				int board_id = Integer.parseInt(request.getParameter("board_id"));
				System.out.println(board_id);
				BoardDto boardDetail = biz.boardDetail(board_id);
				session.setAttribute("boardDetail", boardDetail);
				List<BoardDto> boardReplyAll = biz.boardReplyAll(board_id);
				session.setAttribute("boardReplyAll", boardReplyAll);
				
				response.sendRedirect("board/everyboard_qa_detail.jsp");
			}
			
		}else if(command.equals("qaUpdateDb")) {
			int board_id = Integer.parseInt(request.getParameter("board_id"));
			int board_category = Integer.parseInt(request.getParameter("board_category"));
			String board_title = request.getParameter("board_title");
			String board_content = request.getParameter("board_content");
			
			BoardDto boardDto = new BoardDto();
			boardDto.setBoard_id(board_id);
			boardDto.setBoard_category(board_category);
			boardDto.setBoard_title(board_title);
			boardDto.setBoard_content(board_content);
			
			int updateRes = biz.boardUpdate(boardDto);
			if(updateRes>0) {
				jsResponse("수정 성공", "board.do?command=qaList&page=1", response);
			}
		}else if(command.equals("qaDelete")) {
			int board_id = Integer.parseInt(request.getParameter("board_id"));
			int deleteRes = biz.boardDelete(board_id);
			
			if(deleteRes>0) {
				jsResponse("삭제성공", "board.do?command=qaList&page=1", response);
			}else {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('실패')");
				out.println("history.back()");
				out.println("</script>");
			}
		}else if(command.equals("qaReply")) {
			String mem_id_reply = request.getParameter("mem_id_reply");
			int board_id_reply = Integer.parseInt(request.getParameter("board_id_reply"));
			String comment_content = request.getParameter("comment_content");
			
			BoardDto board_reply = new BoardDto();
			board_reply.setMem_id(mem_id_reply);
			board_reply.setBoard_id(board_id_reply);
			board_reply.setComment_content(comment_content);
			
			int replyInsertRes = biz.boardReplyInsert(board_reply);
			if(replyInsertRes>0) {
				jsResponse("댓글등록 성공", "board.do?command=qaDetail&board_id="+board_id_reply, response);
			}
		}else if(command.equals("qaReplyUpdate")) {
			int reply_board_id = Integer.parseInt(request.getParameter("board_id"));
			int reply_comment_no = Integer.parseInt(request.getParameter("comment_no"));
			System.out.println(reply_comment_no);
			session.setAttribute("reply_comment_no", reply_comment_no);
			BoardDto boardReplyUpdate = biz.boardDetail(reply_board_id);
			session.setAttribute("boardReplyUpdate", boardReplyUpdate);
			List<BoardDto> replyUpdate = biz.boardReplyAll(reply_board_id);
			session.setAttribute("replyUpdate", replyUpdate);
			response.sendRedirect("board/qaReplyUpdate.jsp");
			
		}else if(command.equals("qaReplyUpdateDb")) {
			int comment_no = Integer.parseInt(request.getParameter("comment_no"));
			String comment_content_update = request.getParameter("comment_content_update");
			int board_id = Integer.parseInt(request.getParameter("board_id"));
			
			int boardReplyUpdate = biz.boardReplyUpdate(comment_no, comment_content_update);
			if(boardReplyUpdate>0) {
				jsResponse("댓글수정 성공", "board.do?command=boardDetail&board_id="+board_id, response);
			}else {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('실패')");
				out.println("history.back()");
				out.println("</script>");
			}
		}else if(command.equals("qaReplyDelete")) {
			int reply_board_id = Integer.parseInt(request.getParameter("board_id"));
			int reply_comment_no = Integer.parseInt(request.getParameter("comment_no"));
			
			int boardReplyDelete = biz.boardReplyDelete(reply_board_id, reply_comment_no);
			if(boardReplyDelete>0) {
				jsResponse("댓글삭제성공", "board.do?command=qaDetail&board_id="+reply_board_id, response);
			}else {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('실패')");
				out.println("history.back()");
				out.println("</script>");
				
			}
		}else if(command.equals("qaCate3")) {	//회원 문의사항
			int currentpage = Integer.parseInt(request.getParameter("page"));
			
			BoardPagingDto boardPaging = new BoardPagingDto();
			boardPaging.setCurrentpage(currentpage);
			boardPaging.setTotalrows(10);
			boardPaging.setPagescale(5);
			boardPaging.setTotalpage(biz.cate3_totalpage(boardPaging.getTotalrows()));	//정해준 totalrows에 맞는 총 페이지			
			
			// 모든 리스트 뿌리기
			List<BoardDto> userQa = biz.userQa(boardPaging);
			session.setAttribute("userQa", userQa);
			session.setAttribute("boardPaging", boardPaging);
			response.sendRedirect("board/qaCate3.jsp");
			
		}else if(command.equals("qaCate4")) {	//농부 문의사항
			int currentpage = Integer.parseInt(request.getParameter("page"));
			
			BoardPagingDto boardPaging = new BoardPagingDto();
			boardPaging.setCurrentpage(currentpage);
			boardPaging.setTotalrows(10);
			boardPaging.setPagescale(5);
			boardPaging.setTotalpage(biz.cate4_totalpage(boardPaging.getTotalrows()));	//정해준 totalrows에 맞는 총 페이지			
			
			// 모든 리스트 뿌리기
			List<BoardDto> farmerQa = biz.farmerQa(boardPaging);
			session.setAttribute("farmerQa", farmerQa);
			session.setAttribute("boardPaging", boardPaging);
			response.sendRedirect("board/qaCate4.jsp");
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("<"+command+">");
		
		BoardBiz biz = new BoardBizImpl();
		HttpSession session = request.getSession();
		
		if(command.equals("boardInsertDb")) {
			MemberDto mem_dto = (MemberDto)session.getAttribute("dto");
			int board_category = Integer.parseInt(request.getParameter("board_category"));
			String board_title =(String)request.getParameter("board_title");
			String board_content = (String)request.getParameter("board_content");
			
			BoardDto boardDto = new BoardDto();
			boardDto.setMem_id(mem_dto.getMem_id());
			boardDto.setBoard_category(board_category);
			boardDto.setBoard_title(board_title);
			boardDto.setBoard_content(board_content);
			
			int boardInsertDbRes = biz.boardInsert(boardDto);
			if(boardInsertDbRes >0) {
				jsResponse("글작성 성공", "board.do?command=boardList&page=1", response);
			}else {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('"+"글작성 실패"+"')");
				out.println("history.back();");
				out.println("</script>");
			}
			
		}else if(command.equals("imageUpload")) {
			System.out.println("이미지 컨트롤러 진입");
		
		}else if(command.equals("qaInsertDb")) {
			MemberDto mem_dto = (MemberDto)session.getAttribute("dto");
			int board_category = Integer.parseInt(request.getParameter("board_category"));
			String board_title =(String)request.getParameter("board_title");
			String board_content = (String)request.getParameter("board_content");
			
			BoardDto boardDto = new BoardDto();
			boardDto.setMem_id(mem_dto.getMem_id());
			boardDto.setBoard_category(board_category);
			boardDto.setBoard_title(board_title);
			boardDto.setBoard_content(board_content);
			
			int boardInsertDbRes = biz.boardInsert(boardDto);
			if(boardInsertDbRes >0) {
				jsResponse("글작성 성공", "board.do?command=qaList&page=1", response);
			}else {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('"+"글작성 실패"+"')");
				out.println("history.back();");
				out.println("</script>");
			}
	
		}else if(command.equals("multiDelete")) {
			String [] board_id = request.getParameterValues("chk");
			int multiDelRes = biz.multiDelete(board_id);
			if(multiDelRes>0) {
				jsResponse("삭제성공", "board.do?command=boardList&page=1", response);
			}else {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('"+"삭제실패"+"')");
				out.println("history.back();");
				out.println("</script>");				
			}
		
		}else if(command.equals("multiDelete2")) {
			String [] board_id = request.getParameterValues("chk");
			int multiDelRes = biz.multiDelete(board_id);
			if(multiDelRes>0) {
				jsResponse("삭제성공", "board.do?command=qaList&page=1", response);
			}else {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('"+"삭제실패"+"')");
				out.println("history.back();");
				out.println("</script>");				
			}
		}	
		
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void jsResponse (String msg, String url, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('"+msg+"')");
		out.println("location.href='"+url+"'");
		out.println("</script>");
	}

}
