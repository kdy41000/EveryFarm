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
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="../resources/js/admin/bootstrap.js"></script>
	<script src="../resources/js/admin/dist/Chart.bundle.js"></script>

<style>
	.chart-container{
		width: 95%;
		height: 55vh;
		border: 1px solid #ddd;
		padding: 5%;
		border-radius: 8px;
		margin-left: 2.5%;
	}
	.pie-chart{
		width: 100px;
	}
</style>

<body>
<%@ include file="../home/header.jsp" %>
<div class="container-fluid">
	<div class="row">
	<%@ include file="admin_sidebar.jsp" %>
		<div class="col" >
			
		<!-- 바디 -->
		<div class="section_content">
			<h2 style="margin: 40px;">정산</h2>

			<!-- 좌측바디 -->
			<div style="width:50%; float: left;">
		
				<!-- 차트1 -->			
				<div class="chart-container">
				품목수
				  <canvas id="pie-chart"></canvas>
				</div> 
				 
				<script>
					var mychart = $('#pie-chart');
					var data2019 = {
					  label:'2019',
					  data:[10,8,6,5,3,9],
					  backgroundColor:[
					    'rgba(200,0,0,.45)',
					    'rgba(200,200,0,.45)',
					    'rgba(0,200,0,.45)',
					    'rgba(0,200,200,.45)',
					    'rgba(0,0,200,.45)',
					    'rgba(200,0,200,.45)'
					  ],
					  borderColor:'white',
					  borderWidth:2,
					};
					
					var myLineChart = new Chart(mychart,{
					  type:'pie',
					  data: {
					    labels:['과일','채소','곡류','견과류','약용작물','버섯'],
					    datasets:[data2019]
					  },
					  options:{
					    maintainAspectRatio:false,
					    cutoutPercentage: 40,
					    rotation: 30    
					  }
					});
				</script>
				<!-- 차트 1 끝 -->
			</div>
			
			<!-- 우측바디 -->
			<div style="width:50%; float: left;">
	
					<!-- 차트2 -->			
				<div class="chart-container">
				  <canvas id="bar-chart3"></canvas>
				</div>
				 
				<script>
				var mychart3 = $('#bar-chart3');
				var myBarChart3 = new Chart(mychart3, {
				     type: 'bar',
				     data: {
				       labels: ['경매', '펀드'],
				       datasets: [{
				         label: '총액',
				         yAxisID: 'A',
				         data:[320, 240],
				         backgroundColor:'rgba(40,161,130,.5)',
				         borderColor:'rgba(40,161,130)',
				         borderWidth:1
				       }, {
				         label: '인원수',
				         yAxisID: 'B',
				         data: [8,13],
				         backgroundColor:'rgba(160,60,20,.5)',
				         borderColor:'rgba(160,60,20)',
				         borderWidth:1
				       }]
				     },
				     options: {
				       maintainAspectRatio:false,
				       scales: {
				         yAxes: [{
				           id: 'A',
				           type: 'linear',
				           position: 'left',
				           ticks: {
				             min: 0
				           },
				           gridLines : { display : false }
				         }, {
				           id: 'B',
				           type: 'linear',
				           position: 'right',
				           ticks: {
				             min: 0
				           }
				         }]
				       }
				     }
				});
				</script>
				<!-- 차트 2 끝 -->
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
</script>
</html>