package com.everyfarm.letters.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.everyfarm.letters.dao.LettersDao;
import com.everyfarm.letters.dao.LettersDaoImpl;
import com.everyfarm.letters.dto.LettersDto;

@WebServlet("/letters.do")
public class LettersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LettersController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command= request.getParameter("command");
		LettersDao dao = new LettersDaoImpl();
		
		if(command.equals("letters")) {	  //받은 쪽지함
			String mem_id = request.getParameter("mem_id");
			List<LettersDto> list = new ArrayList<LettersDto>();
			list = dao.inboxLetters(mem_id);
			HttpSession session = request.getSession();
			session.setAttribute("inbox", list);
			response.sendRedirect("letters/inboxletters.jsp");
			
		} else if(command.equals("write")) {	//쪽지 쓰기
			String letter_sender = request.getParameter("letter_sender");
			String mem_id = request.getParameter("mem_id");
			String letter_title = request.getParameter("letter_title");
			String letter_content = request.getParameter("letter_content");
			LettersDto dto = new LettersDto();
			dto.setLetter_sender(letter_sender);
			dto.setMem_id(mem_id);
			dto.setLetter_title(letter_title);
			dto.setLetter_content(letter_content);
			int res = dao.sendLetters(dto);
			if(res>0) {
				closePopup("쪽지를 성공적으로 보냈습니다", response);
			} else {
				closePopup("쪽지보내기 실패", response);
			}
			
		} else if(command.equals("muldel")){	//선택 삭제
			String[] letter_id = request.getParameterValues("chk");
			String mem_id = request.getParameter("mem_id");
			int res = dao.deleteLetters(letter_id);
			if(res>0) {
				jsResponse("선택한 쪽지들을 삭제 성공했습니다", "letters.do?command=letters&mem_id="+mem_id, response);
			}
		} else if(command.equals("sent")) {		//보낸 쪽지함
			String mem_id = request.getParameter("mem_id");
			List<LettersDto> list = new ArrayList<LettersDto>();
			list = dao.sentLetters(mem_id);
			HttpSession session = request.getSession();
			session.setAttribute("sent", list);
			response.sendRedirect("letters/sentletters.jsp");
			
		} else if(command.equals("detail")) {	//쪽지 상세
			int letter_id = Integer.parseInt(request.getParameter("letter_id"));
			String mem_id = request.getParameter("mem_id");
			LettersDto dto = dao.LettersDetail(letter_id);
			HttpSession session = request.getSession();
			session.setAttribute("lettersdetail", dto);
			session.setAttribute("mem_id_letter", mem_id);
			openPopup(response);
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
	private void closePopup(String msg, HttpServletResponse response) throws IOException {
		String res = "<script type='text/javascript'>"
					+"alert('"+msg+"');"
					+ "self.close();"
					+ "</script>";
		PrintWriter out = response.getWriter();
		out.println(res);
	}
	private void openPopup(HttpServletResponse response) throws IOException {
		String res = "<script type='text/javascript'>"
				+"var option = 'width=450, height=600,top = 100, left = 500, location = no';"
				+"window.open('letters/lettersdetail.jsp','쪽지상세',option);"
				+ "</script>";
		PrintWriter out = response.getWriter();
		out.println(res);
	}
}
