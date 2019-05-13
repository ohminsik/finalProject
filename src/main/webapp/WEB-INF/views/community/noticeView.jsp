<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="../common/meta.jsp"/>
<body>
	<div id="wrap">
		<jsp:include page="../common/header.jsp"/>	
		<!-- sub_banner s -->
		<div class="sub_banner">
			<span class="bg"></span>
			<div class="textBox">
				<p class="title">커뮤니티</p>
				<p class="text">공지사항</p>
			</div>
		</div>
		<!-- sub_banner e -->
		
		<!-- nav s -->
		<div class="nav_wrap">
			<div class="nav">
				<ul>
					<li><a href="/main"><i class="xi-home"></i></a></li>
					<li>
						<a>커뮤니티</a>
					</li>
					<li>
						<a>공지사항</a>
					</li>
				</ul>
			</div>
		</div>
		<!-- nav e -->	
		<div id="container">
			<div class="board_form">
				<table class="board_table board_table1">
					<colgroup>
						<col width="90%">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<td class="fb">${board.board_title }</td>
							<td class="fb"><fmt:formatDate value="${board.board_date }" pattern="yyyy-MM-dd"/></td>
						</tr>
						<tr>
							<td colspan="2">
							<c:if test="${empty photo.photo_stored }">
							</c:if>
							<c:if test="${photo ne null}">
								<img src="/uploadImg/${photo.photo_stored }" alt="${photo.photo_stored }"><br>
							</c:if>
							 ${board.board_content } </td>			
						</tr>
		
					</tbody>
				</table>
				
				<table class="board_table board_table1 mt30">
					<colgroup>
						<col width="10%">
						<col width="*">
					</colgroup>
					<tbody>
						<c:forEach items="${list }" var="l">
						
							<tr>
								<td class="tal">${l.user_nick }
									<br><fmt:formatDate value="${l.reply_date }" pattern="yyyy-MM-dd"/>
							
								</td>
								<td>
									${l.reply_content }
									<c:if test="${user_no eq l.user_no }">
									<a href="/community/noticeCommentDelete?reply_no=${l.reply_no }&board_no=${board.board_no }"><i class="xi-close deleteBtn"></i></a>
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<form action="/community/noticeCommentInsert?board_no=${board.board_no }" method="POST">
					<table class="board_table board_table1 mt30">
						<colgroup>
							<col width="10%">
							<col width="*">
							<col width="10%">
						</colgroup>
						<tbody>
							<tr>
								<td class="tal">
									${user_nick }
								</td>
								<td>
									<input type="text" name="reply_content" id="" class="inputform100p">
								</td>
								<td>
									<c:if test="${empty login }">
									<a class="btnform7" onclick="notlogin();">댓글등록</a>
									</c:if>
									<c:if test="${login }">
									<button class="btnform7">댓글등록</button>
									</c:if>
								</td>
							</tr>
						</tbody>
					</table>
				</form>
				
				
				<div class="j_button mt20 mb20 tac">
			
					<a href="/community/noticeList"class="btnform7">목록</a>
				</div>
			</div>
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>