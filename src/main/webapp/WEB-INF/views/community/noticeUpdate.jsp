<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
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
			<form action="/community/noticeUpdate" method="POST">
				<div class="board_form">
					<table class="board_table board_table1">
						<colgroup>
							<col width="10%">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<td>제목</td>
								<td><input type="text" name="" id="" class="inputform100p"></td>
							</tr>
							<tr>
								<td>내용</td>
								<td><textarea name="" id="" class="textareaform100p"></textarea></td>								
							</tr>
							<tr>
								<td>파일첨부</td>
								<td><input type="file" name="" id=""></td>
							</tr>
						</tbody>
					</table>
					<div class="j_button mt20 mb20 tac">
						<button class="btnform7">수정</button>
						<a href="/community/noticeList"class="btnform7">목록</a>
					</div>
				</div>
				
				
			</form>
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>