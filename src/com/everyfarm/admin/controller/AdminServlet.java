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

import com.everyfarm.admin.dao.AuctionApprovalDao;
import com.everyfarm.admin.dao.PagingDao;
import com.everyfarm.admin.dao.UpgradeListDao;
import com.everyfarm.admin.dto.AuctionApprovalDto;
import com.everyfarm.admin.dto.PagingDto;
import com.everyfarm.admin.dto.UpgradeListDto;

@WebServlet("/admin.do")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminServlet() {
        super();
    }

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
		
		if(command.equals("adminmain")) {
			response.sendRedirect("admin/adminmain.jsp");
		}
		else if(command.equals("upgradelist")) {
			int currentpage = Integer.parseInt(request.getParameter("pageNumber"));
			PagingDto paging = null;
			paging = pagingMethod(currentpage);
			List<UpgradeListDto> list = upgradeListDao.selectList(paging.getFrom(), paging.getTo());
			
			HttpSession session =request.getSession();
			session.setAttribute("upgradelist_paging", paging);
			session.setAttribute("upgradelist", list);
			response.sendRedirect("admin/upgradelist.jsp");
		}
		else if(command.equals("upgraderes")) {
			String id = request.getParameter("id");
			int res = upgradeListDao.upgradeRes(id);
			if(res>0) {
				jsResponse("등업성공", response);
			} else {
				jsResponse("등업실패", response);
			}
			int currentpage = Integer.parseInt(request.getParameter("pageNumber"));
			PagingDto paging = null;
			paging = pagingMethod(currentpage);
			List<UpgradeListDto> list = upgradeListDao.selectList(paging.getFrom(), paging.getTo());
			
			HttpSession session =request.getSession();
			session.setAttribute("upgradelist_paging", paging);
			session.setAttribute("upgradelist", list);
			response.sendRedirect("admin/upgradelist.jsp");
		}
		else if(command.equals("auctionapproval")) {
			int currentpage = Integer.parseInt(request.getParameter("pageNumber"));
			PagingDto paging = null;
			paging = pagingMethod(currentpage);
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
			if(res>0) {
				jsResponse("경매 등록 성공", response);
			} else {
				jsResponse("경매 등록 실패", response);
			}
			int currentpage = Integer.parseInt(request.getParameter("pageNumber"));
			PagingDto paging = null;
			paging = pagingMethod(currentpage);
			List<AuctionApprovalDto> list = approvalDao.selectList(paging.getFrom(), paging.getTo());
			
			HttpSession session =request.getSession();
			session.setAttribute("approvallist_paging", paging);
			session.setAttribute("approvallist", list);
			response.sendRedirect("admin/auctionapproval.jsp");

		}
		else if(command.equals("realtimeauction")) {
			response.sendRedirect("admin/realtimeauction.jsp");
		}
		
	}
	
	private PagingDto pagingMethod(int currentpage) {
		PagingDto paging = new PagingDto();
		PagingDao pagingdao = new PagingDao();
		paging.setCurrentpage(currentpage);
		paging.setTotalrows(10);	// 한 페이지에 보여줄 글 수
		paging.setPagescale(10);	// 한 블록에 표시할 페이지 수
		paging.setTotalpage(pagingdao.totalPage(paging.getTotalrows()));
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
