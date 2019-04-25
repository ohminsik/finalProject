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
				<p class="title">매치보드</p>
				<p class="text">매치신청</p>
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
						<a>매치신청</a>
					</li>
				</ul>
			</div>
		</div>
		<!-- nav e -->	
		<div id="container">
			<div class="match_wrap">
				<ul class="match_apply">
					<li>
						<div class="match_apply_div">
							<p class="blue">
								<img src="/resources/img/logo.png">
								<span>블루팀</span>
							</p>
							<p class="vs">VS</p>
							<p class="purple">
								<img src="/resources/img/logo.png">
								<span>퍼플팀</span>
							</p>
						</div>
						<table class="match_apply_table">
							<colgroup>
								<col width="20%">
								<col width="*">
							</colgroup>
							<tbody>
								<tr>
									<td>지역 :</td>
									<td>서울 - 은평</td>
								</tr>
								<tr>
									<td>구장 :</td>
									<td>토트넘 스타디움</td>
								</tr>
								<tr>
									<td>날짜 :</td>
									<td>2019-04-25 16:00</td>
								</tr>
								<tr>
									<td>연락처 :</td>
									<td>010-0000-0000</td>
								</tr>
								<tr>
									<td>비용 :</td>
									<td>0 원</td>
								</tr>
								<tr>
									<td>개설자 :</td>
									<td>김준환</td>
								</tr>
								<tr>
									<td>유니폼색상 :</td>
									<td>레알마드리드 홈팀 색</td>
								</tr>
							</tbody>
						</table>
					</li>
					<li>
						<div class="title mb10">남기는 한마디</div>
						<div class="memo">남기는 한마디</div>
						<div class="match_btn_list">
							<ul>
								<li><a href="#" class="btnform1">매치신청</a></li>
								<li><a href="/match/matchBoard" class="btnform1">목록</a></li>
							</ul>
						</div>
					</li>
				</ul>				
				
			</div>
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>