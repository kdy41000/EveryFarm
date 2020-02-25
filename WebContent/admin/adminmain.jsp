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
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="../resources/js/admin/bootstrap.js"></script>
	<style>
		.admin_container{
			width: 95%;
			height: 350px;
			border: 1px solid #ddd;
			padding: 8%;
			border-radius: 8px;
			margin-left: 3.5%;
			overflow-y: auto;
		}
	</style>	
<body>
<%@ include file="../home/header.jsp" %>
<div class="container-fluid">
	<div class="row">
	<%@ include file="admin_sidebar.jsp" %>
		<div class="col" >
		<div class="section_content">	
			<h2 style="margin: 40px;">메인화면</h2>
			<!-- 좌측바디 -->
			<div style="width:69%; float: left; border-right: 1px solid #ddd;">
				
				<div class="admin_container">
		
				</div> 
				<br>
				<div class="admin_container">
		
				</div> 
				
			</div>
			
			<!-- 우측바디 -->
			<div style="width:30%; float: left;">

				<div class="admin_container">
		
				</div> 
				<br>
				<div class="admin_container">
		
				</div> 

			</div> 
	    </div>
		</div>
	</div>
</div>
	
	
<%@ include file="../home/footer.jsp" %>
</body>
<script type="text/javascript">
/* 	if(${empty sessionScope.dto.mem_id}){
		alert("로그인이 필요합니다");
		location.href="../home/section.jsp";
	} */
</script>
</html>