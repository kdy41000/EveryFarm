<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8");%>
<% response.setContentType("text/html; charset=UTF-8");%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../home/header.jsp" %>
<section>
	
	<div class="movehome" style="margin: 100px 0px 0px 300px;"><a href="#" onclick="" style="color:gray;">Home</a> > <a href="#" onclick="" style="color:gray;">List</a></div>
	<img alt="sumnail" src="../resources/images/auction/apple.png" style="width:450px; height:400px; margin: 30px 0px 0px 300px;"/>
	
	<div class="sumnailcontent" style="    margin: -450px 0px 0px 900px;">
	<h1>충청도 신선한 사과</h1>
	<p>20000원</p>
	<hr style="    width: 70%; margin-left: 0px;"/>
	<p>[3월 23일(종료날짜뽑기)기준으로 발송]</p>
	<p style="color:green;">예약구매는 농부의 걱정을 덜어줍니다.<br/>
	가장 좋을 때 수확한 먹거리를 함께해 주시는 회원들에게 할인하여 제공합니다.</p>
	<p>수확일 기준으로 예약순서대로 순차적으로 발송합니다.</p>
	<p><a style="font-weight:bold;">원산지:</a>경기도 남양주시[뽑아야됨]</p>
	<p><a style="font-weight:bold;">생산자:</a>[유저이름뽑아야됨]</p>
	<img alt="img" src="../resources/images/auction/messageicon.png" style="width: 3%; margin: -4% 0% 2% 22%; cursor: pointer;"/>
	<p><a style="font-weight:bold;">배송방법:</a>택배</p>
	<p><a style="font-weight:bold;">배송비:</a>무료 | 도서산간 배송비 추가</p>
	<p><a style="font-weight:bold;">원산지: [주소입력해야됨]</a></p>
	
	<p><a style="font-weight:bold;">option</a></p>
	<select style="    width: 600px; height: 35px;">
		<option>5kg (30과 내외)(31,500원)</option>
		<option>10kg (60과 내외)(73,000원)</option>
	</select>
	
	<br/><br/>
	<span style="font-weight:bold;">총 상품 금액:&nbsp;<a>31,500원</a></span>
	<input type="button" value="구매하기" style="background:green; width:150px; height:50px; border-radius:10px; font-weight:bold; color:white;"/>
	
	</div><br/>
	<hr style="width:70%;"/>
	<div style="text-align:center;">
		<img alt="img" src="../resources/images/auction/contentfirst.png"/>
		<br/><br/><br/>
	</div>	
	<div style="margin: 0% 0% 0% 20%;">
		<a style="font-weight:bold;">상품소개</a>
	</div>	
		
	<div style="margin: -2.1% 0% 0% 40%;">	
		<p>[내용 넣어야함!!!!!!!!!!!!!!!]</p>
		<img alt="img" src="../resources/images/auction/apple.png" style="width:48%; height:45%;"/>
		<p>[내용 넣어야함!!!!!!!!!!!!!!!]</p>
		<img alt="img" src="../resources/images/auction/apple.png" style="width:48%; height:45%;"/>
		<p>[내용 넣어야함!!!!!!!!!!!!!!!]</p>
		<img alt="img" src="../resources/images/auction/apple.png" style="width:48%; height:45%;"/>
		<p>[내용 넣어야함!!!!!!!!!!!!!!!]</p>
	</div>
	<div style="margin: 0% 0% 0% 20%;">
		<p><b>고객센터</b></p><hr/>
		<p>쪽지문의</p>
		<p>현재 페이지 상단에 쪽지 버튼을 클릭하여 문의해 주십시오.</p>
		<br/>
		<p>이메일 문의(24시간 접수)</p>
		<p>kdy41000@naver.com / 운영시간에 순차적으로 답변드립니다.</p>
		<br/>
		<p>전화 문의(평일 09시~18시)</p>
		<p>010-1234-1234</p>
	</div><br/><br/><br/>
	<div style="margin: 0% 0% 0% 20%;">
		<p><b>상품정보 제공표시</b></p>
		<table border="1" style="border-top: none;
    border-bottom: none;
    border-right: none;
    border-left: none;">
			<tr>
				<td style="background:#eae9e9; width:40%;">포장단위별 중량(수량)</td>
				<td>[5kg , 10kg]</td>
			</tr>
			<tr>
				<td style="background:#eae9e9; width:40%;">생산자</td>
				<td>[이름입력]</td>
			</tr>
			<tr>
				<td style="background:#eae9e9; width:40%;">원산지</td>
				<td>국산[주소 입력되야함]</td>
			</tr>
			<tr>
				<td style="background:#eae9e9; width:40%;">보관 또는 취급방법</td>
				<td>수령 후 냉장보관, 가급적 빨리 드시길 권장드립니다.</td>
			</tr>
			<tr>
				<td style="background:#eae9e9; width:40%;">소비자 상담 관련 전화번호</td>
				<td>010-1234-1234</td>
			</tr>
		</table>
	</div>
</section>
<%@ include file="../home/footer.jsp" %>
</body>
</html>