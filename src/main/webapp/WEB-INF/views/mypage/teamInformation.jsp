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
						<li class="on"><a href="/mypage/teamInformation">팀 정보</a></li>
						<li><a href="/mypage/teamMatchInfo">팀 매치 정보</a></li>
						<li><a href="#">팀 매치 결과</a></li>
						<li><a href="/mypage/teamBoard">팀 게시판</a></li>
					</ul>
				</div>
				
				<c:if test="${teamYN eq false }">
				<div class="team111 mt50">
					<p>현재 소속된 팀이 없습니다.<br>새로운 팀을 생성하거나 다른 팀에 가입 신청을 하세요</p>
					<ul class="mt30">
						<li><a href="/mypage/teamCreate" class="btnform0">팀 생성</a></li>
						<li><a href="#" class="btnform0">팀 검색</a></li>
					</ul>
				</div>
				</c:if>
				
				<c:if test="${teamYN eq true }">
				<div class="teaminfo mt50">
					<ul>
						<li>
							<div class="top">
								<p class="img mb30"><img src="/uploadImg/${team.team_mark }"></p>
								<p class="title mb10">${team.team_name }</p>
								<p class="score">${team.team_entire }전 ${team.team_win }승 ${team.team_tie }무 ${team.team_lose }패</p>
							</div>
							<div class="bot mt20">
								<table class="j_table_form1">
									<colgroup>
										<col width="20%">
										<col width="30%">
										<col width="20%">
										<col width="30%">
									</colgroup>
									<tbody>
										<tr>
											<td>지역</td>
											<td>${team.team_region}</td>
											<td>활동구장</td>
											<td>${team.team_field }</td>
										</tr>
										<tr>
											<td>팀 유형</td>
											<td>${team.team_type }</td>
											<td>평균 연령</td>
											<td>${team.team_age }</td>
										</tr>
										<tr>
											<td>실력</td>
											<td>${team.team_level }</td>
											<td>팀원수</td>
											<td>${team.team_cnt }</td>
										</tr>
										<tr>											
											<td>유니폼 소개</td>
											<td colspan="3">${team.team_uniform }</td>
										</tr>
										<tr>
											<td>팀 소개</td>
											<td colspan="3">${team.team_hello }</td>
										</tr>
									</tbody>
								</table>
							</div>
						</li>
						<li>
							<table class="j_table_form1">
								<colgroup>
									<col width="*">
									<col width="20%">
									<col width="20%">
									<col width="20%">
								</colgroup>
								<thead>
									<tr>
										<th>이름(아이디)</th>
										<th>포지션</th>
										<th>역할</th>
										<th>관리</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${userList }" var="userList">
									<tr>
										<td>${userList.user_name }(${userList.user_id })</td>
										<td>${userList.user_position }</td>
										<td>팀 개설자</td>
										<td><a href="#">관리</a></td>
									</tr>
									</c:forEach>
								</tbody>
							</table>
						</li>
					</ul>
				</div>
				<form action="/mypage/teamDelete" method="POST">
					<div class="j_button mt50">
						<button class="btnform0">팀 해체</button>
					</div>
				</form>
				</c:if>
			</div>
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>