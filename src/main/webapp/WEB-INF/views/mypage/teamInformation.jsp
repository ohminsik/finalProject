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
						<c:if test="${teamYN eq false }">
						<li><a href="#" onclick="javascript:notTeam();">팀 매치 정보</a></li>
						<li><a href="#" onclick="javascript:notTeam();" >팀 매치 결과</a></li>
						<li><a href="#" onclick="javascript:notTeam();">팀 게시판</a></li>
						</c:if>
						<c:if test="${teamYN eq true }">
						<li><a href="/mypage/teamMatchInfo">팀 매치 정보</a></li>
						<li><a href="/mypage/teamMatchResult">팀 매치 결과</a></li>
						<li><a href="/mypage/teamBoard">팀 게시판</a></li>
						</c:if>
					</ul>
				</div>
				<!-- 팀 없음 -->
				<c:if test="${teamYN eq false }">
				<div class="team111 mt50">
					<p>현재 소속된 팀이 없습니다.<br>새로운 팀을 생성하거나 다른 팀에 가입 신청을 하세요</p>
					<ul class="mt30">
						<li><a href="/mypage/teamCreate" class="btnform0">팀 생성</a></li>
						<li><a href="/team/allTeamInformation" class="btnform0">팀 검색</a></li>
					</ul>
				</div>
				</c:if>
				
				<!-- 팀 있음 -->
				<c:if test="${teamYN eq true }">
				<div class="teaminfo mt50">
					<ul>
						<li>
							<div class="top">
								<c:if test="${team.team_mark eq '구장마크' }">
										<p class="img mb30"><img src="/resources/img/defalutimg2.png"></p>
								</c:if>
								<c:if test="${team.team_mark eq null }">
									<p class="img mb30"><img src="/resources/img/defalutimg2.png"></p>
								</c:if>
								<c:if test="${team.team_mark ne '구장마크' }">
									<p class="img mb30"><img src="/uploadImg/${team.team_mark }"></p>
								</c:if>
								<p class="title mb10">${team.team_name }</p>
								<p class="score">${team.team_etire }전 ${team.team_win }승 ${team.team_tie }무 ${team.team_lose }패</p>
								<p class="title mt10">Rating : ${team.team_rating }</p>
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
									<col width="40%">
									
								</colgroup>
								<thead>
									<tr>
										<th>이름(아이디)</th>
										<th>포지션</th>
										
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${userList }" var="userList">
									<tr>
										<td>${userList.user_name }(${userList.user_id })</td>
										<td>${userList.user_position }</td>
									
									</tr>
									</c:forEach>
								</tbody>
							</table>
						</li>
					</ul>
					<p class="mt20 pt10 pb10" style="font-weight: bold; font-size:16px; border-top:2px solid #5383e8;">신청자 관리</p>
					<table class="j_table_form1">
						<colgroup>
							<col width="15%">
							<col width="10%">
							<col width="10%">
							<col width="10%">
							<col width="10%">
							<col width="*">
						</colgroup>
						<thead>
							<tr>
								<th>이름(아이디)</th>
								<th>포지션</th>
								<th>나이</th>
								<th>지역</th>								
								<th>신청날짜</th>
								<th>관리</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${!empty teamApplyList }">						
								<c:forEach items="${teamApplyList }" var="teamApplyList">
									<c:set var="now" value="<%=new java.util.Date()%>" />
									<c:set var="sysYear"><fmt:formatDate value="${now}" pattern="yyyy" /></c:set>	
									<c:set var="myYear" value="${teamApplyList.user_birth}"/>
									 <%
				                        String sysYear = pageContext.getAttribute("sysYear").toString();
									 	String myYear = (pageContext.getAttribute("myYear").toString()).substring(0,4);
				                        int pYear = Integer.parseInt(sysYear);
				                        int mYear = Integer.parseInt(myYear);
				                        int result = pYear - mYear;
				                     %>
									<tr>
										<td>${teamApplyList.user_name }(${teamApplyList.user_id })</td>
										<td>${teamApplyList.user_position }</td>
										<td><%=result+1 %></td>
										<td>${teamApplyList.user_region }</td>
										<td><fmt:formatDate value="${teamApplyList.apply_date }" pattern="yyyy-MM-dd"/></td>
										<td>
											<div style="text-align: center;">
												<form action="/mypage/teamApplyOk" method="POST" class="oh1">
													<input type="hidden" name="team_no" value="${teamApplyList.team_no }">
													<input type="hidden" name="user_no" value="${teamApplyList.user_no }">
													<button class="btnform1" style="display: inline-block;">승인</button>
												</form>
												<form action="/mypage/teamApplyNo" method="POST" class="oh1">
													<input type="hidden" name="team_no" value="${teamApplyList.team_no }">
													<input type="hidden" name="user_no" value="${teamApplyList.user_no }">
													<button class="btnform2" style="display: inline-block;">거절</button>
												</form>
											</div>
										</td>
									</tr>
								</c:forEach>
							</c:if>
							<c:if test="${empty teamApplyList }">
								<tr>
									<td colspan="6">신청 내역이 없습니다.</td>
								</tr>	
							</c:if>
						</tbody>
					</table>
				</div>
				
				</c:if>
			</div>
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>

</html>