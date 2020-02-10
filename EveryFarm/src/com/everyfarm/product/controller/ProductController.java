package com.everyfarm.product.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.everyfarm.product.biz.ProductBiz;
import com.everyfarm.product.biz.ProductBizImpl;
import com.everyfarm.product.dto.ProductDto;
import com.everyfarm.product.dto.*;


@WebServlet("/product.do")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ProductController() {
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		ProductBiz biz = new ProductBizImpl();
		
		if(command.equals("auction")){    //경매페이지로 이동
			int currentpage = Integer.parseInt(request.getParameter("currentpage"));
			PagingDto pagingdto = new PagingDto();
			pagingdto.setCurrentpage(currentpage);
			pagingdto.setColumn(16);   //게시글은 16개씩
			pagingdto.setUnderpagescale(5);    //아래 페이지 수의 크기는 5개씩
			pagingdto.setTotalpage(biz.totalPage(pagingdto.getColumn()));  //마지막 페이지 번호
			
			List<ProductDto>productlist = new ArrayList<ProductDto>(); //일반 경매상품 리스트
			List<ProductDto>bestlist = new ArrayList<ProductDto>(); //best경매상품(4개)
			
			productlist = biz.productlist(pagingdto);
			bestlist = biz.bestlist();
			//System.out.println(bestlist.get(2).getStock_image()+"********");
			HttpSession session = request.getSession();
			session.setAttribute("pagingdto", pagingdto);
			session.setAttribute("productlist", productlist);
			session.setAttribute("bestlist", bestlist);
			response.sendRedirect("auction/auctionlist.jsp");
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
	}

}
