<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
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
						<li class="on"><a href="/mypage/teamMatchInfo">팀 매치 정보</a></li>
						<li><a href="/mypage/teamMatchResult">팀 매치 결과</a></li>
						<li><a href="/mypage/teamBoard">팀 게시판</a></li>
					</ul>
				</div>
				
				<div class="teammatchinfo mt50">
					<p>내가 등록한 매치</p>
					<ul>
						<c:forEach items="${matchList }" var="matchList">
						<li>
							<div class="wrapppppppp">
								<div class="left">
									<p class="img mb30"><img src="/uploadImg/${matchList.blue_mark }"></p>
									<p class="title mb10">${matchList.blue_name }</p>
									<p class="score">${matchList.blue_etire }전 ${matchList.blue_win }승 ${matchList.blue_tie }무 ${matchList.blue_lose }패</p>
								</div>
								<div class="right">
									<p class="img mb30"><img src="/uploadImg/${matchList.purple_mark }"></p>
									<p class="title mb10">${matchList.purple_name }</p>
									<p class="score">${matchList.purple_etire }전 ${matchList.purple_win }승 ${matchList.purple_tie }무 ${matchList.purple_lose }패</p>
								</div>	
								<div class="center">
									<p>VS</p>
								</div>
								
								<div class="leftscore">
									<p>${matchList.blueteam_score }</p>
								</div>
								
								<div class="rightscore">
									<p>${matchList.purpleteam_score }</p>
								</div>	
								
							</div>
							<div class="timetable">
								<p class="mb10">장소 : ${matchList.match_ground }</p>
								<p>날짜, 시간 : <fmt:formatDate value="${matchList.fight_date }" pattern="yyyy-MM-dd , HH:mm"/></p>
							</div>
							<c:if test="${matchList.match_score = 'N' }">
							<div class="tac mt20">
								<a href="/mypage/teamScoreInsert?match_no=${matchList.match_no }" class="btnform0 oh1">매치결과입력</a>
							</div>			
							</c:if>		
						</li>
						</c:forEach>
					</ul>
				</div>
				
				<div class="teammatchinfo mt50">
					<p>내가 신청한 매치</p>
					<ul>
						<c:forEach items="${matchList1 }" var="matchList">
						<li>
							<div class="wrapppppppp">
								<div class="left">
									<p class="img mb30"><img src="/uploadImg/${matchList.blue_mark }"></p>
									<p class="title mb10">${matchList.blue_name }</p>
									<p class="score">${matchList.blue_etire }전 ${matchList.blue_win }승 ${matchList.blue_tie }무 ${matchList.blue_lose }패</p>
								</div>
								<div class="right">
									<p class="img mb30"><img src="/uploadImg/${matchList.purple_mark }"></p>
									<p class="title mb10">${matchList.purple_name }</p>
									<p class="score">${matchList.purple_etire }전 ${matchList.purple_win }승 ${matchList.purple_tie }무 ${matchList.purple_lose }패</p>
								</div>	
								<div class="center">
									<p>VS</p>
								</div>
								
								<div class="leftscore">
									<p>${matchList.blueteam_score }</p>
								</div>
								
								<div class="rightscore">
									<p>${matchList.purpleteam_score }</p>
								</div>	
								
							</div>
							<div class="timetable">
								<p class="mb10">장소 : ${matchList.match_ground }</p>
								<p>날짜, 시간 : <fmt:formatDate value="${matchList.fight_date }" pattern="yyyy-MM-dd , HH:mm"/></p>
							</div>
							<c:if test="${matchList.match_score = 'N' }">
							<div class="tac mt20">
								<a href="/mypage/teamScoreInsert?match_no=${matchList.match_no }" class="btnform0 oh1">매치결과입력</a>
							</div>					
							</c:if>
						</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>