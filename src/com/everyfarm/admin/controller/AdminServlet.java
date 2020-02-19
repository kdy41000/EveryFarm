package com.everyfarm.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.everyfarm.admin.dao.AdminFundListDao;
import com.everyfarm.admin.dao.AuctionApprovalDao;
import com.everyfarm.admin.dao.UpgradeListDao;
import com.everyfarm.admin.dao.UserListDao;
import com.everyfarm.admin.dto.AdminFundListDto;
import com.everyfarm.admin.dto.AuctionApprovalDto;
import com.everyfarm.admin.dto.PagingDto;
import com.everyfarm.admin.dto.UpgradeListDto;
import com.everyfarm.admin.dto.UserListDto;

@WebServlet("/admin.do")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private static int TOTAL_PAGE_ROW = 10;		// 한 페이지에 보여줄 글 수
	private static int PAGE_BLOCK_SIZE = 10; 	// 한 블록에 표시할 페이지 수

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("<"+command+">");
		
		UpgradeListDao upgradeListDao = new UpgradeListDao();
		AuctionApprovalDao approvalDao = new AuctionApprovalDao();
		UserListDao userListDao = new UserListDao();
		AdminFundListDao fundListDao = new AdminFundListDao();
		
		//------------- 메인화면 (admin main) -------------------
		if(command.equals("adminmain")) {
			response.sendRedirect("admin/adminmain.jsp");
		}
		//------------- 등급관리 (upgradelist) -------------------
		else if(command.equals("upgradelist")) {
			int currentpage = Integer.parseInt(request.getParameter("pageNumber"));
			PagingDto paging = null;
			int totalpage = upgradeListDao.totalPage(TOTAL_PAGE_ROW);
			paging = pagingMethod(currentpage, totalpage);
			List<UpgradeListDto> list = upgradeListDao.selectList(paging.getFrom(), paging.getTo());
			
			HttpSession session =request.getSession();
			session.setAttribute("upgradelist_paging", paging);
			session.setAttribute("upgradelist", list);
			response.sendRedirect("admin/upgradelist.jsp");
		}
		else if(command.equals("upgraderes")) {
			String id = request.getParameter("id");
			int res = upgradeListDao.upgradeRes(id);
			if(res==0) {
				jsResponse("경매 등록 실패", response);
			} 
			int currentpage = Integer.parseInt(request.getParameter("pageNumber"));
			PagingDto paging = null;
			int totalpage = upgradeListDao.totalPage(TOTAL_PAGE_ROW);
			paging = pagingMethod(currentpage, totalpage);
			List<UpgradeListDto> list = upgradeListDao.selectList(paging.getFrom(), paging.getTo());
			
			HttpSession session =request.getSession();
			session.setAttribute("upgradelist_paging", paging);
			session.setAttribute("upgradelist", list);
			response.sendRedirect("admin/upgradelist.jsp");
		}
		//------------- 경매관리 (auction approval) -------------------
		else if(command.equals("auctionapproval")) {
			int currentpage = Integer.parseInt(request.getParameter("pageNumber"));
			PagingDto paging = null;
			int totalpage = approvalDao.totalPage(TOTAL_PAGE_ROW);
			paging = pagingMethod(currentpage, totalpage);
			List<AuctionApprovalDto> list = approvalDao.selectList(paging.getFrom(), paging.getTo());
			
			HttpSession session =request.getSession();
			session.setAttribute("approvallist_paging", paging);
			session.setAttribute("approvallist", list);
			response.sendRedirect("admin/auctionapproval.jsp");
		}
		else if(command.equals("approvalres")) {
			int no = Integer.parseInt(request.getParameter("no"));
			System.out.println(no);
			int res = approvalDao.approvalRes(no);
			if(res==0) {
				jsResponse("경매 등록 실패", response);
			} 
			int currentpage = Integer.parseInt(request.getParameter("pageNumber"));
			PagingDto paging = null;
			int totalpage = approvalDao.totalPage(TOTAL_PAGE_ROW);
			paging = pagingMethod(currentpage, totalpage);
			List<AuctionApprovalDto> list = approvalDao.selectList(paging.getFrom(), paging.getTo());
			
			HttpSession session =request.getSession();
			session.setAttribute("approvallist_paging", paging);
			session.setAttribute("approvallist", list);
			response.sendRedirect("admin/auctionapproval.jsp");

		}
		//------------- 실시간 현황  (**수정 예정) -------------------
		else if(command.equals("realtimeauction")) {
			response.sendRedirect("admin/realtimeauction.jsp");
		}
		//------------- 회원관리 (userlist) -------------------
		else if(command.equals("userlist")) {
			int currentpage = Integer.parseInt(request.getParameter("pageNumber"));
			PagingDto paging = null;
			int totalpage = userListDao.totalPage(TOTAL_PAGE_ROW);
			paging = pagingMethod(currentpage, totalpage);
			List<UserListDto> list = userListDao.selectList(paging.getFrom(), paging.getTo());
			
			HttpSession session =request.getSession();
			session.setAttribute("userlist_paging", paging);
			session.setAttribute("userlist_admin", list);
			response.sendRedirect("admin/userlist.jsp");
		}
		//------------- 펀드관리 (admin fund list) -------------------
		else if(command.equals("adminfundlist")) {
			int currentpage = Integer.parseInt(request.getParameter("pageNumber"));
			PagingDto paging = null;
			int totalpage = fundListDao.totalPage(TOTAL_PAGE_ROW);
			paging = pagingMethod(currentpage, totalpage);
			List<AdminFundListDto> list = fundListDao.selectList(paging.getFrom(), paging.getTo());
			
			HttpSession session =request.getSession();
			session.setAttribute("adminfundlist_paging", paging);
			session.setAttribute("adminfundlist", list);
			response.sendRedirect("admin/adminfundlist.jsp");
		}
	}
	
	private PagingDto pagingMethod(int currentpage, int totalpage) {
		PagingDto paging = new PagingDto();
		paging.setCurrentpage(currentpage);
		paging.setTotalrows(TOTAL_PAGE_ROW);
		paging.setPagescale(PAGE_BLOCK_SIZE);	
		paging.setTotalpage(totalpage);
		paging.setFrom(paging.getTotalrows() * (currentpage-1) +1);
		paging.setTo(paging.getTotalrows() * currentpage);
		return paging;
	}

	private void jsResponse(String msg, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>");
		out.println("alert('"+msg+"')");
		out.println("</script>");
	}	

}