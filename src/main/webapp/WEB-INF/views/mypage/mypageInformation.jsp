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
				<p class="text">내정보</p>
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
						<a>내정보</a>
					</li>
				</ul>
			</div>
		</div>
		<!-- nav e -->	
		<div id="container">
			<div class="team_form">
				<div class="team_btn_list">
					<ul>
						<li class="on"><a href="/mypage/mypageInformation">내 정보</a></li>
						<li><a href="/mypage/mypagepersonalMessage">개인 메세지</a></li>
						<li><a href="/mypage/mypageBoardList">내가 쓴 게시글</a></li>
						<li><a href="/mypage/mypageMatchList">내가 쓴 매치글</a></li>
					</ul>
				</div>
				
				<div class="mypage_form mt30">
					<table class="j_table_form1">
						<colgroup>
							<col width="20%">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<td>아이디</td>
								<td>KKKKK</td>
							</tr>
							<tr>
								<td>이름</td>
								<td>김준환</td>
							</tr>
							<tr>
								<td>Email</td>
								<td>final@gmail.com</td>
							</tr>
							<tr>
								<td>전화번호</td>
								<td>010-1234-1234</td>
							</tr>
							<tr>
								<td>생년월일</td>
								<td>1993/02/18</td>
							</tr>
							<tr>
								<td>지역</td>
								<td>서울</td>
							</tr>
							<tr>
								<td>주종목</td>
								<td>축구</td>
							</tr>
						</tbody>
					</table>
					
					<div class="j_button mt30">
						<ul>
							<li><a href="#" class="btnform0 passwordbtn">비밀번호 변경</a></li>
							<li><a href="/mypage/mypageInformationUpdate" class="btnform0">회원정보 수정</a></li>
						</ul>
					</div>
					
					
				</div>
			</div>
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
	
	
	<div class="password_wrap_bg"></div>
	<div class="password_wrap">
		<div>
			<form action="" method="POST">
			<p>비밀번호 변경</p>
			<i class="xi-close passwordclosebtn"></i>
			<ul class="mt20">
				<li><input type="password" name="" id="" placeholder="현재 비밀번호 " class="inputform100p mt10"></li>
				<li><input type="password" name="" id="" placeholder="새로운 비밀번호" class="inputform100p mt10"></li>
				<li><input type="password" name="" id="" placeholder="새로운 비밀번호 확인" class="inputform100p mt10"></li>
			</ul>
			<button class="btnform1 oh1 mt20">비밀번호 변경</button>
			</form>
		</div>
	</div>
</body>
<script>
	$(document).ready(function(){
		$(".passwordbtn").click(function(e){
			e.preventDefault();
			$(".password_wrap_bg").fadeIn();
			$(".password_wrap").fadeIn();
		})
		
		$(".passwordclosebtn").click(function(e){
			e.preventDefault();
			$(".password_wrap_bg").fadeOut();
			$(".password_wrap").fadeOut();
		})
	})
</script>
</html>