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
				
			<div class="board_form">
				<table class="board_table board_table1">
					<colgroup>
						<col width="90%">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<td class="fb">제목</td>
							<td class="fb">2019-01-01</td>
						</tr>
						<tr>
							<td colspan="2">내용</td>						
						</tr>
					</tbody>
				</table>
				
				<table class="board_table board_table1 mt30">
					<colgroup>
						<col width="10%">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<td class="tal">
								닉네임<br>
								2019-01-01
							</td>
							<td>
								댓글내용
								<i class="xi-close deleteBtn"></i>
							</td>
						</tr>
						<tr>
							<td class="tal">
								닉네임<br>
								2019-01-01
							</td>
							<td>
								댓글내용
								<i class="xi-close deleteBtn"></i>
							</td>
						</tr>
						<tr>
							<td class="tal">
								닉네임<br>
								2019-01-01
							</td>
							<td>
								댓글내용
								<i class="xi-close deleteBtn"></i>
							</td>
						</tr>
					</tbody>
				</table>
				
				<form action="/mypage/teamBoardCommentInsert" method="POST">
					<table class="board_table board_table1 mt30">
						<colgroup>
							<col width="10%">
							<col width="*">
							<col width="10%">
						</colgroup>
						<tbody>
							<tr>
								<td class="tal">
									자기닉네임
								</td>
								<td>
									<input type="text" name="" id="" class="inputform100p">
								</td>
								<td>
									<button class="btnform7">댓글등록</button>
								</td>
							</tr>
						</tbody>
					</table>
				</form>
				
				
				<div class="j_button mt20 mb20 tac">
					<a href="/mypage/teamBoardUpdate"class="btnform7">수정</a>
					<a href="/mypage/teamBoardDelete"class="btnform7">삭제</a>
					<a href="/mypage/teamBoard"class="btnform7">목록</a>
				</div>
			</div>
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>