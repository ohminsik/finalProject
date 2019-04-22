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
						<li class="on"><a href="/mypage/teamMatchInfo">팀 매치 정보</a></li>
						<li><a href="#">팀 매치 결과</a></li>
						<li><a href="/mypage/teamBoard">팀 게시판</a></li>
					</ul>
				</div>
				
				<div class="teammatchinfo mt50">
					<ul>
						<li>
							<div class="wrapppppppp">
								<div class="left">
									<p class="img mb30"><img src="/resources/img/logo.png"></p>
									<p class="title mb10">팀이름</p>
									<p class="score">0전 0승 0무 0패</p>
								</div>
								<div class="right">
									<p class="img mb30"><img src="/resources/img/logo.png"></p>
									<p class="title mb10">팀이름</p>
									<p class="score">0전 0승 0무 0패</p>
								</div>	
								<div class="center">
									<p>VS</p>
								</div>
								
								<div class="leftscore">
									<p>1</p>
								</div>
								
								<div class="rightscore">
									<p>5</p>
								</div>	
								
							</div>
							<div class="timetable">
								<p class="mb10">장소 : 토트넘스타디움</p>
								<p>날짜 : 2019-02-02, 시간 : 13:00</p>
							</div>
							<div class="tac mt20">
								<a href="/mypage/teamScoreInsert" class="btnform0 oh1">매치결과입력</a>
							</div>					
						</li>
						
					</ul>
				</div>
			</div>
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>