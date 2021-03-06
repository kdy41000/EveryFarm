<%@page import="com.everyfarm.member.dto.MemberDto"%>
<%@page import="com.everyfarm.board.biz.BoardBizImpl"%>
<%@page import="com.everyfarm.board.biz.BoardBiz"%>
<%@page import="com.everyfarm.chat.Broadsocket"%>
<%@page import="com.everyfarm.board.dto.BoardPagingDto"%>
<%@page import="com.everyfarm.board.dto.BoardDto"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Everyboard List</title>

<link href="../resources/css/board/everyboard.css" rel="stylesheet"
	type="text/css">
	
<script type="text/javascript" src = "https://code.jquery.com/jquery-3.4.1.js">

$(function () {
	$("#multiDeleteList").submit(function () {
		if($("#multiDeleteList input :checked").length ==0){
			alert("하나 이상 체크해주세요");
			retrun false;
		}
		
	});
	
});

</script>	

<script type="text/javascript"></script>
<script>
	function category() {
		var category = document.getElementById("selectCategory").value;
		if (category == "1") {
			location.href = '../board.do?command=boardCate1&page=1';
		} else if (category == "2") {
			location.href = '../board.do?command=boardCate2&page=1';
		}
	}
	
	function insertPopup() {
		window.open("everyboardInsert.jsp","","width=800px, height= 650px");
	}
	
	function allchk(bool) {
		var chks = document.getElementsByName("chk"); //node list로 반환된다 [chk,chk,chk,...]
		for(var i = 0; i <chks.length;i++){
			chks[i].checked = bool;			
		}		
	}
	
</script>

</head>

<%
	List<BoardDto> boardAllList = (List<BoardDto>) session.getAttribute("boardAllList");
	List<BoardDto> bestNotice = (List<BoardDto>) session.getAttribute("bestNotice");
	BoardPagingDto boardPaging = (BoardPagingDto) session.getAttribute("boardPaging");
	int pagegroup = (int) Math.ceil((double) boardPaging.getCurrentpage() / boardPaging.getPagescale());
	int startpage = boardPaging.getPagescale() * (pagegroup - 1) + 1;
	int endpage = boardPaging.getPagescale() * pagegroup;
	int totalpage = boardPaging.getTotalpage();
%>



<body>

	<%@ include file="../home/header.jsp"%>

	<div class="container">
		<div class="container_inner">
			<div class="title">
				<h1>모든 글 보기</h1>
			</div>
			<div class="selectBox">
				<select id="selectCategory" onchange="category();">
					<option selected="selected">--말머리 선택--</option>
					<option value="1">공지사항</option>
					<option value="2">자유게시판</option>
				</select>
				
				<c:if test="${not empty dto}">
				
				<input type="button" value="글쓰기"
					onclick="insertPopup();" class="btn">
				
				</c:if>
							
			</div>

			<div class="allList">
			<form action="../board.do?" method="post" id="multiDeleteList">
			<input type="hidden" name="command" value="multiDelete">
				<table class="board_list">
			<c:choose>
				<c:when test="${dto.mem_grade == 3}">				
					<colgroup>
						<col style="width: 3%">
						<col style="width: 8%">
						<col style="width: 14%">
						<col style="width: 40%">
						<col style="width: 12%">
						<col style="width: 8%">
						<col style="width: 15%">
					</colgroup>
					<thead>
						<tr>
							<th><input type="checkbox" onclick="allchk(this.checked);"></th>
							<th>글번호</th>
							<th>글종류</th>
							<th>글제목</th>
							<th>작성자</th>
							<th>조회수</th>
							<th>작성일</th>
						</tr>
					</thead>
				</c:when>
				
				<c:otherwise>
					<colgroup>
						<col style="width: 8%">
						<col style="width: 12%">
						<col style="width: 45%">
						<col style="width: 12%">
						<col style="width: 8%">
						<col style="width: 15%">
					</colgroup>
					<thead>
						<tr>
							<th>글번호</th>
							<th>글종류</th>
							<th>글제목</th>
							<th>작성자</th>
							<th>조회수</th>
							<th>작성일</th>
						</tr>
					</thead>				
				</c:otherwise>
			</c:choose>
						
						<%
							BoardBiz biz = new BoardBizImpl();
							for (int i = 0; i < bestNotice.size(); i++) {
						%>
						<tbody>
						<tr class="notice">
					<c:if test="${dto.mem_grade == 3 }">
							<td><input type="checkbox" value="<%=bestNotice.get(i).getBoard_id()%>"></td>
					</c:if>			
							<td><%=bestNotice.get(i).getBoard_id()%></td>
							<td>공지사항</td>
							<td class="tLeft"><a
								href="../board.do?command=boardDetail&board_id=<%=bestNotice.get(i).getBoard_id()%>"><%=bestNotice.get(i).getBoard_title()%>
									<%
										int replyCnt = biz.replyCnt(bestNotice.get(i).getBoard_id());
											if (replyCnt != 0) {
									%> <span class="reply">[<%=replyCnt%>]</span> <%
										}
									%></a></td>
							<td><%=bestNotice.get(i).getMem_id()%></td>
							<td><%=bestNotice.get(i).getBoard_readcnt()%></td>
							<td><%=bestNotice.get(i).getBoard_regdate()%></td>
						</tr>
						<%
							}
							for (int i = 0; i < boardAllList.size(); i++) {
						%>
						<tr>
						<c:if test="${dto.mem_grade == 3}">
							<td><input type="checkbox" name="chk" value="<%=boardAllList.get(i).getBoard_id()%>"></td>
						</c:if>
							<td><%=boardAllList.get(i).getBoard_id()%></td>
							<%
								String category = null;
									switch (boardAllList.get(i).getBoard_category()) {
									case 1:
										category = "공지사항";
										break;
									case 2:
										category = "자유게시판";
										break;
									}
							%>
							<td><%=category%></td>
							<td class="tLeft"><a
								href="../board.do?command=boardDetail&board_id=<%=boardAllList.get(i).getBoard_id()%>"><%=boardAllList.get(i).getBoard_title()%>
									<%
										int replyCnt = biz.replyCnt(boardAllList.get(i).getBoard_id());
											if (replyCnt != 0) {
									%> <span class="reply">[<%=replyCnt%>]</span><%
										}
									%></a></td>
							<td><%=boardAllList.get(i).getMem_id()%></td>
							<td><%=boardAllList.get(i).getBoard_readcnt()%></td>
							<td><%=boardAllList.get(i).getBoard_regdate()%></td>
						</tr>

						<%
							}
						%>
					</tbody>
				</table>
				<c:if test="${dto.mem_grade == 3}">
				<input type="submit" value="삭제하기" class="btn" style="float:left;">
				</c:if>
				</form>
			
			</div>

			<!--페이징 -->
			<div class="pagination">
				<%
					if (pagegroup > 1) {
				%>
				<a href="../board.do?command=boardList&page=<%=startpage - 1%>" class="prevstr">Prev</a>
				<span> <%
					 	}
					 	for (int pagenum = startpage; pagenum <= ((endpage < totalpage) ? endpage : totalpage); pagenum++) {
					 %>
				</span> <a href="../board.do?command=boardList&page=<%=pagenum%>" class="pager"><%=pagenum%></a>
				<%
					}
					if (endpage < boardPaging.getTotalpage()) {
				%>
				<a href="../board.do?command=boardList&page=<%=endpage + 1%>" class="nextstr">Next</a>
				<%
					}
				%>

			</div>
		</div>
	</div>

	<%@ include file="../home/footer.jsp"%>

</body>
</html>