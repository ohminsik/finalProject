<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<jsp:include page="../common/meta.jsp" />
<body>
	<div id="wrap">
		<jsp:include page="../common/header.jsp" />		
		<div id="container">
		
			<!-- sub_banner s -->
			<div class="sub_banner">
				<span class="bg"></span>
				<div class="textBox">
					<p class="title">회원가입</p>
					<p class="text">가입완료</p>
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
							<a>회원가입</a>
						</li>
					</ul>
				</div>
			</div>
			<!-- nav e -->
			
			<!-- 회원가입 step3 s -->
			<div class="content_form">
				<div class="j_complete">
					<img src="/resources/img/logo_footer.png">
					<p class="title">회원가입이 완료되었습니다.</p>
					<p class="text"><span>name</span>님 가입을 환영합니다.</p>
				</div>
				<div class="j_button mt50">
					<a href="/main" class="btnform0">메인</a>
				</div>
			</div>
			<!-- 회원가입 step3 e -->
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>