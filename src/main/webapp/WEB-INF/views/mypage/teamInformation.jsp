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
				
				<div class="team111 mt50">
					<p>현재 소속된 팀이 없습니다.<br>새로운 팀을 생성하거나 다른 팀에 가입 신청을 하세요</p>
					<ul class="mt30">
						<li><a href="/mypage/teamCreate" class="btnform0">팀 생성</a></li>
						<li><a href="#" class="btnform0">팀 검색</a></li>
					</ul>
				</div>
				
				<div class="teaminfo mt50">
					<ul>
						<li>
							<div class="top">
								<p class="img mb30"><img src="/resources/img/logo.png"></p>
								<p class="title mb10">팀이름</p>
								<p class="score">0전 0승 0무 0패</p>
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
											<td>인천/남동구</td>
											<td>활동구장</td>
											<td>XXX체육공원</td>
										</tr>
										<tr>
											<td>팀 유형</td>
											<td>성인</td>
											<td>평균 연령</td>
											<td>20대</td>
										</tr>
										<tr>
											<td>실력</td>
											<td>중</td>
											<td>팀원수</td>
											<td>11명</td>
										</tr>
										<tr>											
											<td>유니폼 소개</td>
											<td colspan="3">레알마드리드 홈 유니폼</td>
										</tr>
										<tr>
											<td>팀 소개</td>
											<td colspan="3">팀소개입니다</td>
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
									<tr>
										<td>오민식(omsik)</td>
										<td>SK</td>
										<td>팀 개설자</td>
										<td><a href="#">관리</a></td>
									</tr>
									<tr>
										<td>김형기(omsik)</td>
										<td>LK</td>
										<td>팀원</td>
										<td><a href="#">관리</a></td>
									</tr>
									<tr>
										<td>김준환(omsik)</td>
										<td>GK</td>
										<td>팀원</td>
										<td><a href="#">관리</a></td>
									</tr>
									<tr>
										<td>김강환(omsik)</td>
										<td>LWK</td>
										<td>팀원</td>
										<td><a href="#">관리</a></td>
									</tr>
									<tr>
										<td>이용환(omsik)</td>
										<td>SK</td>
										<td>팀원</td>
										<td><a href="#">관리</a></td>
									</tr>
								</tbody>
							</table>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>