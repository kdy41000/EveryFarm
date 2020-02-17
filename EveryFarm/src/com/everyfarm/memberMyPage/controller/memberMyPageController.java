package com.everyfarm.memberMyPage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.everyfarm.member.dto.MemberDto;
import com.everyfarm.memberMyPage.dao.MemberMyPageDao;
import com.everyfarm.memberMyPage.dao.MemberMyPageDaoImpl;

@WebServlet("/memberMyPage.do")
public class memberMyPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public memberMyPageController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command= request.getParameter("command");
		MemberMyPageDao dao = new MemberMyPageDaoImpl();
		
		if(command.equals("mypage")) {	//마이페이지
			response.sendRedirect("memberMyPage/membermypage.jsp");
			
			
		} else if(command.equals("myinfo")) {	//내정보 조회
			String mem_id = request.getParameter("mem_id");
			MemberDto dto = dao.selectMyInfo(mem_id);
			request.setAttribute("dto", dto);
			response.sendRedirect("memberMyPage/myinformation.jsp");
			
		} else if(command.equals("myinfoupdate")) {		//내정보 수정
			String mem_id = request.getParameter("mem_id");
			String mem_pw = request.getParameter("mem_pw");
			String mem_phone = request.getParameter("mem_phone");
			String mem_email = request.getParameter("mem_email");
			String mem_zonecode = request.getParameter("mem_zonecode");
			String mem_addr = request.getParameter("mem_addr");
			String mem_addretc = request.getParameter("mem_addretc");
			MemberDto dto = new MemberDto(mem_id, mem_pw, "", mem_phone, mem_zonecode, mem_addr, 
					                      mem_addretc, mem_email, 0, "0", "");
			int res = dao.updateMyInfo(dto);
			if(res>0) {
				jsResponse("회원정보가 수정되었습니다", "memberMyPage/myinformation.jsp", response);
			} else {
				jsResponse("회원정보 수정에 실패하였습니다", "memberMyPage/myinformation.jsp", response);
			}
			
		} else if(command.equals("memberdelete")) {		//회원탈퇴 페이지 이동
			response.sendRedirect("memberMyPage/memberdelete.jsp");
			
		} else if(command.equals("memberdeleteres")) {	//회원탈퇴 결과
			String mem_id = request.getParameter("mem_id");
			int res = dao.memberDelete(mem_id);
			if(res>0) {
				HttpSession session = request.getSession();
				session.invalidate();
				jsResponse("탈퇴되었습니다", "home/section.jsp", response);
			} else {
				jsResponse("탈퇴에 실패하였습니다", "memberMyPage/membermypage.jsp", response);
			}
		} else if(command.equals("grade")) {	//내 등급조회
			String mem_id = request.getParameter("mem_id");
			MemberDto dto = dao.selectGrade(mem_id);
			HttpSession session = request.getSession();
			session.setAttribute("mem", dto);
			response.sendRedirect("memberMyPage/gradeup.jsp");
			
		} else if(command.equals("gradeup")) {		//농부로 등업신청
			String mem_id = request.getParameter("mem_id");
			int res = dao.applyGradeUp(mem_id);
			if(res>0) {
				jsResponse("신청되었습니다", "memberMyPage/gradeup.jsp", response);
			} else {
				jsResponse("신청 실패하였습니다", "memberMyPage/gradeup.jsp", response);
			}
			
		} else if(command.equals("myfundlist")) {	//내 펀드내역 조회
			String mem_id = request.getParameter("mem_id");
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		doGet(request, response);
	}
	private void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		String res = "<script type='text/javascript'>"
					+"alert('"+msg+"');"
					+ "location.href='"+url+"';"
					+ "</script>";
		PrintWriter out = response.getWriter();
		out.println(res);
	}
	
}
