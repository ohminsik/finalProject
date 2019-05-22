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
				<p class="text">경기 후기</p>
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
						<a>경기 후기</a>
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
							<td class="fb"><fmt:formatDate value="${board.board_date }" pattern="yyyy-MM-dd"></fmt:formatDate></td>
						</tr>
						<tr>
							<td colspan="2" class="content">
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
						<col width="12%">
						<col width="*">
					</colgroup>
					<tbody>
					 	
						  <c:forEach items="${list }" var="l">	
							<c:if test="${l.reply_delete_yn eq 'N' }">
								<tr>
									<td class="tal">
										${l.user_nick }<br>
										<fmt:formatDate value="${l.reply_date }" pattern="yyyy-MM-dd"></fmt:formatDate>
									</td>
									<td>
										${l.reply_content }
										<c:if test="${user_no eq l.user_no }">
											 <a href="/community/reviewCommentDelete?reply_no=${l.reply_no }&board_no=${board.board_no }"><i class="xi-close deleteBtn"></i></a>
										</c:if>
									</td>
								</tr>
							</c:if>
						  </c:forEach>
					</tbody>
				</table>
				
				<form action="/community/reviewCommentInsert?board_no=${board.board_no }" method="POST">
					<table class="board_table board_table1 mt30">
						<colgroup>
							<col width="12%">
							<col width="*">
							<col width="10%">
						</colgroup>
						<tbody>
							<tr>
								<td class="tal">
									${user_nick }
								</td>
								<td>
									<input type="text" name="reply_content" id="reply_content" class="inputform100p">
								</td>
								<td>
									<c:if test="${empty login }">
										<a href="#" class="btnform7" onclick="notlogin();">댓글등록</a>
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
						<c:if test="${user_no == board.user_no }">
							<a href="/community/reviewUpdate?board_no=${board.board_no }"class="btnform7">수정</a>
							<a href="/community/reviewDelete?board_no=${board.board_no }"class="btnform7">삭제</a>
						</c:if>	
					<a href="/community/reviewList"class="btnform7">목록</a>
				</div>
			</div>
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>