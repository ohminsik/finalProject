<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<jsp:include page="../common/meta.jsp"/>
<body>
	<div id="wrap">
		<jsp:include page="../common/header.jsp"/>	
		<!-- sub_banner s -->
		<div class="sub_banner">
			<span class="bg"></span>
			<div class="textBox">
				<p class="title">매치보드</p>
				<p class="text">오늘의 추천 상대</p>
			</div>
		</div>
		<!-- sub_banner e -->
		
		<!-- nav s -->
		<div class="nav_wrap">
			<div class="nav">
				<ul>
					<li><a href="/main"><i class="xi-home"></i></a></li>
					<li>
						<a>매치보드</a>
					</li>
					<li>
						<a>오늘의 추천 상대</a>
					</li>
				</ul>
			</div>
		</div>
		<!-- nav e -->	
		<div id="container">
				<div class="team_form">
					<div class="teaminfo mt50">
						<ul>
							<li>
								<div class="top">
									<p class="img mb30"><img src="/uploadImg/${team.team_mark }"></p>
									<p class="title mb10">${team.team_name }</p>
									<p class="score">${team.team_etire }전 ${team.team_win }승 ${team.team_tie }무 ${team.team_lose }패</p>
									<p class="title mt10">Rating : ${team.team_rating }</p>
								</div>
								
							</li>
							<li>
								<div class="bot">
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
						</ul>
						
						
					</div>
					<ul class="tac mt20">
							<li class="oh1"><a class="btnform0">매치신청</a></li>
							<li class="oh1"><a href="/match/reommndOpponent" class="btnform0">다른 상대 찾기</a></li>
						</ul>
				</div>
			
		<jsp:include page="../common/footer.jsp"/>
		</div>
	</div>
</body>
</html>



