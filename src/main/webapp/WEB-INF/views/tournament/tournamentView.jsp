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
				<p class="title">대회</p>
				<p class="text">대회일정</p>
			</div>
		</div>
		<!-- sub_banner e -->
		
		<!-- nav s -->
		<div class="nav_wrap">
			<div class="nav">
				<ul>
					<li><a href="/main"><i class="xi-home"></i></a></li>
					<li>
						<a>대회</a>
					</li>
					<li>
						<a>대회일정</a>
					</li>
				</ul>
			</div>
		</div>
		<!-- nav e -->	
		<div id="container">
			<div class="tournament_div">
				<div class="tournamentView_div">
					<ul class="tournamentView">
						<li>
							<img alt="" src="/resources/img/defalutimg.png">
						</li>
						<li>
							<p class="title">${tournment.board_title }</p>						
							<p class="text">신청 기간 : ${tournment.con_reg_dates } ~ ${tournment.con_reg_datee }</p>
							<p class="text">대회 기간 : ${tournment.con_con_dates } ~ ${tournment.con_con_datee }</p>
							<p class="text">대회 지역 : ${tournment.con_region }</p>	
							<p class="text">대회 설명 : ${tournment.board_content }</p>	
						</li>
					</ul>
					
					<ul class="mt50 mb50 btnform123123">
						<li><a href="#" class="btnform0">대회 바로가기</a></li>
						<li><a href="/tournament/tournamentRegion" class="btnform0">목록</a></li>
					</ul>
					
					
				</div>
				
			</div>
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>