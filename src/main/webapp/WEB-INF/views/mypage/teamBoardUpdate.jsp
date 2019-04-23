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
				<p class="title">마이페이지</p>
				<p class="text">팀정보</p>
			</div>
		</div>
		<!-- sub_banner e -->
		
		<!-- nav s -->
		<div class="nav_wrap">
			<div class="nav">
				<ul>
					<li><a href="/main"><i class="xi-home"></i></a></li>
					<li>
						<a>마이페이지</a>
					</li>
					<li>
						<a>팀정보</a>
					</li>
				</ul>
			</div>
		</div>
		<!-- nav e -->
		<div id="container">
			<div class="team_form">
				<div class="team_btn_list">
					<ul>
						<li><a href="/mypage/teamInformation">팀 정보</a></li>
						<li><a href="/mypage/teamMatchInfo">팀 매치 정보</a></li>
						<li><a href="#">팀 매치 결과</a></li>
						<li class="on"><a href="/mypage/teamBoard">팀 게시판</a></li>
					</ul>
				</div>
				
			<form action="/mypage/teamBoardUpdate" method="POST">
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
						<a href="/mypage/teamBoard"class="btnform7">목록</a>
					</div>
				</div>
			</form>
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>