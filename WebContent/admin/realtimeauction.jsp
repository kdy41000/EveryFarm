<%@page import="com.google.gson.annotations.Until"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.everyfarm.admin.dto.AuctionApprovalDto"%>
<%@page import="com.everyfarm.admin.dto.PagingDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8");%>
<% response.setContentType("text/html; charset=UTF-8");%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
</head>

    <link rel="stylesheet" href="../resources/css/admin/admin.css">   
	<link rel="stylesheet" href="../resources/css/membermypage/buttonstyle.css">
    <style type="text/css">
    	span {
    		display: inline-block;
    	}
    	table{
    		width: 100%; table-layout: fixed;
    	}
    	th{
    		color: #333333;
    	}
    	th:nth-child(7){
    		 font-size:15px;
    	}
    	td{
    		padding: 5px;
    		text-align: center;
    		vertical-align: middle;
    		overflow: hidden;
    		white-space: nowrap;
    		text-overflow: ellipsis;
    	}
    	td:nth-child(2){
    		text-align: justify;
    		margin-left: 5px;
    	}
    </style>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="../resources/js/admin/bootstrap.js"></script>
    <script type="text/javascript">
    	// 깜빡임
    	$( document ).ready(function() {
        	$("td").eq(3).addClass('blink');
        	setInterval("$('.blink').fadeOut().fadeIn();", 1000);
		});

		function realtimeFunction(){
			for(var i = 0; i < realDto.length; i++){
				var str = realDto[i];
				$("#realtime_table_body").append(
						"<tr>"+
							"<td>"+str.mem_id+"</td>"+
							"<td>"+str.stock_name+"</td>"+
							"<td>"+str.auc_startPrice+"</td>"+
							"<td>"+str.auc_nowPrice+"</td>"+
							"<td>"+str.auc_regDate+"</td>"+
							"<td>"+str.auc_endDate+"</td>"+
							"<td>"+str.auc_join+"</td>"+
						"</tr>"	
				);
				$('table').scrollTop($('table')[0].scrollHeight);
			}
		}
		
		function addrecode(){
			$("#realtime_table_body").append(
				"<tr>"+
					"<td>"+"test"+"</td>"+
					"<td>"+"test"+"</td>"+
					"<td>"+"test"+"</td>"+
					"<td>"+"test"+"</td>"+
					"<td>"+"test"+"</td>"+
					"<td>"+"test"+"</td>"+
					"<td>"+"1"+"</td>"+
				"</tr>"	
			);
			
		}
		
		
		
    </script>	
	
<body>
<%@ include file="../home/header.jsp" %>
<div class="container-fluid">
	<div class="row">
	<%@ include file="admin_sidebar.jsp" %>
		<div class="col" >
			
		<!-- 바디 -->
		<div class="section_content">
			<h2 style="margin: 40px;">실시간 경매 현황</h2>
			
				<!-- 테이블 영역 -->
				<div style="margin: 20px;">
					<div style="background-color: gray; text-align: center;">
						<div style="padding:1.2%;">
							<table class="table-bordered">
							<col width=10%><col width=28%><col width=15%><col width=15%>
							<col width=12%><col width=12%><col width=8%>
								<tr>
									<th>아이디</th>
									<th>상품명</th>
									<th>시작가</th>
									<th>현재가</th>
									<th>등록일</th>
									<th>종료일</th>
									<th>참가인원</th>
								</tr>
							</table>
						</div>	
					</div>
					<div style="padding:1%; background-color: lightgray; overflow-y: auto;" >
						<div style="padding:1%; background-color: white; border-radius: 10px; overflow-y: auto;">
							<table id="realtime_table_body" class="table-bordered">
							<col width=10%><col width=28%><col width=15%><col width=15%>
							<col width=12%><col width=12%><col width=8%>
								<c:choose>
									<c:when test="${empty adminrealtime }">
										<tr>
											<td colspan="8">경매 목록이 없습니다.</td>
										</tr>
									</c:when>
									<c:otherwise>
										<c:forEach items="${adminrealtime }" var="dto">
											<tr>
												<td>${dto.mem_id }</td>
												<td>${dto.stock_name }</td>
												<td>${dto.auc_startPrice }</td>
												<td>${dto.auc_nowPrice }</td>
												<td>${dto.auc_regDate }</td>
												<td>${dto.auc_endDate }</td>
												<td>${dto.auc_join }</td>
											</tr>								
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</table>
							<input type="button" value="추가" onclick="addrecode();">
						</div>				
					</div>
				</div>
				
	    	</div>
	    </div>
	</div>
</div>
	
	
<%@ include file="../home/footer.jsp" %>
</body>
<script src="../resources/js/admin/admin.js"></script>
<script type="text/javascript">
	/* 	if(${empty sessionScope.dto.mem_id}){
			alert("로그인이 필요합니다");
			location.href="../home/section.jsp";
		} */
		
	// 새로고침 간격
	function 함수이름(){  
      setTimeout('location.reload()',5000); 
	}
</script>
</html>