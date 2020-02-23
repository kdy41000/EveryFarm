package com.everyfarm.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everyfarm.admin.dao.RealtimeDao;
import com.everyfarm.admin.dto.AuctionApprovalDto;


@WebServlet("/RealtimeServlet")
public class RealtimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		RealtimeDao realtimeDao = new RealtimeDao();
		realtimeDao.delete(); // 프라이머리 키 때문에 지우고 시작.
		
		if(command.equals("first")) {
			response.sendRedirect("bike01.jsp");
		}
		else if(command.equals("firstdb")) {
			
			String[]bike = request.getParameterValues("bike");
			List<AuctionApprovalDto> bikes = new ArrayList<AuctionApprovalDto>();
			for(int i=0; i<bike.length; i++) {
				String[]tmp = bike[i].split("/");
				//System.out.println(tmp[0]+" "+tmp[5]+", "+tmp[6]);
				
				//1.dto에 담자
				AuctionApprovalDto dto = new AuctionApprovalDto();
//					tmp[0], Integer.parseInt(tmp[1]), tmp[2], tmp[3], 
//					Integer.parseInt(tmp[4]), Double.parseDouble(tmp[5]), 
//					Double.parseDouble(tmp[6]));
				//2.dto를 list(bikes)에 담자
//				bikes.add(dto);
			}
			//3. dao에 list를 보내서 insert하자.
			int res = realtimeDao.insert(bikes);
			if(res==bikes.size()) {
				System.out.println("insert 성공");
			} else {
				System.out.println("insert 실패");
			}
			
			//4. 저장 완료되면 index.html로 보내자.
			response.sendRedirect("index.html");	
		}

	}
	
}
