<%@page import="com.everyfarm.memberMyPage.dto.MyFarmListDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8");%>
<% response.setContentType("text/html; charset=UTF-8");%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/membermypage/buttonstyle.css">
<title>나의 주말농장</title>
<%
	List<MyFarmListDto> list = (List<MyFarmListDto>)session.getAttribute("myfarmlist");
%>
<style type="text/css">
	.box{border: 1px solid gray; padding:10px; margin:30px; background: white; border-radius: 10px;}
	.button{margin:15px; margin-left:600px;  width:180px; height:60px; font-size: 20px;}
	.button:hover {transform: translateY(-5px); background-color:#e74c3c;}
	.cctvbox{ box-shadow:0px 10px 122px 0px rgba(170,102,255,0.23);}
</style>
</head>
<body>
<%@ include file="../home/header.jsp" %>
	<div class="container-fluid">
	  <div class="row">
	  <%@ include file="../home/sidemenu.jsp" %>
	    <div class="col" >
	    	<fieldset class="box">
	      <h4><strong>나의 주말농장</strong></h4>
	     	  <div class="cctvbox" style=" width: 700px; height: 500px; margin-left: 350px"></div>
				<input type="button" class="button" value="CCTV" >
	      	<table class="table">
	      		<thead>
	      			<tr>
	      				<th>농장이름</th>
	      				<th>분양받은 땅</th>
	      				<th>주소</th>
	      				<th>신청일</th>
	      			</tr>
	      		</thead>
<%
			if(list.size() == 0){
%>
					<tr>
						<td colspan="4">신청한 내역이 없습니다.</td>
					</tr>
<%
			} else{
				for(MyFarmListDto dto : list){
%>	
					<tr>
						<td><%=dto.getWfarm_title() %></td>
						<td><%=dto.getMf_area() %>번</td>
						<td><%=dto.getWfarm_addr() %></td>
						<td><f:formatDate value="<%=dto.getMf_regDate() %>" pattern="yyyy.MM.dd"/></td>
					</tr>
<%
				}
			}
%>
			</table>
		</fieldset>
	 </div>
	</div>
   </div>
    <br><br><br><br>
     <%@ include file="../home/footer.jsp" %>
</body>
</html>