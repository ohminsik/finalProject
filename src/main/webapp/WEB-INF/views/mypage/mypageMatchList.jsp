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
				<p class="title">마이페이지</p>
				<p class="text">내가 쓴 매치글</p>
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
						<a>내가 쓴 매치글</a>
					</li>
				</ul>
			</div>
		</div>
		<!-- nav e -->	
		<div id="container">
			<div class="team_form">
				<div class="team_btn_list">
					<ul>
						<li><a href="/mypage/mypageInformation">내 정보</a></li>
						<li><a href="/mypage/mypagepersonalMessage">개인 메세지</a></li>
						<li><a href="/mypage/mypageBoardList">내가 쓴 게시글</a></li>
						<li class="on"><a href="/mypage/mypageMatchList">내가 쓴 매치글</a></li>
					</ul>
				</div>
				
				<div class="board_form">
					<table class="board_table">
						<colgroup>
							<col width="20%">
							<col width="20%">
							<col width="15%">
							<col width="15%">
							<col width="*">
						</colgroup>
						<thead>
							<tr>
								<th>매치날짜</th>
								<th>등록날짜</th>
								<th>지역</th>
								<th>장소</th>
								<th>남기는한마디</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${!empty matchList }">
							<c:forEach items="${matchList }" var="matchList">
							<tr>
								<td><fmt:formatDate value="${matchList.fight_date }" pattern="yyyy-MM-dd"/></td>
								<td><fmt:formatDate value="${matchList.match_date }" pattern="yyyy-MM-dd"/></td>
								<td>${matchList.match_region }</td>
								<td>${matchList.match_ground }</td>
								<td>${matchList.match_content }</td>
							</tr>
							</c:forEach>
							</c:if>
							<c:if test="${empty matchList }">
							<tr>
								<td colspan="5">등록된 내용이 없습니다.</td>
							</tr>
							</c:if>
						</tbody>
					</table>
					
					<div class="cb"></div>
					
					
				</div>
			</div>
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>