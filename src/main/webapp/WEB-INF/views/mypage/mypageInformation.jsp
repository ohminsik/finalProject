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
								<td>${userinfo.user_id }</td>
							</tr>
							<tr>
								<td>이름</td>
								<td>${userinfo.user_name }</td>
							</tr>
							<tr>
								<td>Email</td>
								<td>${userinfo.user_email }</td>
							</tr>
							<tr>
								<td>전화번호</td>
								<td>${userinfo.user_phone }</td>
							</tr>
							<tr>
								<td>생년월일</td>
								<td>${userinfo.user_birth }</td>
							</tr>
							<tr>
								<td>지역</td>
								<td>${userinfo.user_region }</td>
							</tr>
							<tr>
								<td>주종목</td>
								<td>${userinfo.user_sport }</td>
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
			<form action="/mypage/pwChange" method="POST">
			<p>비밀번호 변경</p>
			<i class="xi-close passwordclosebtn"></i>
			<ul class="mt20">
				<li>
					<input type="password" name="user_origin_pw" id="user_origin_pw" placeholder="현재 비밀번호 " oninput='return checkpw()' onblur='return checkpw()' class="inputform250 mt10">
					<p id="user_origin_pwtxt" style="font-size:12px; width:100px; display:inline-block; text-align:center;" ></p>
				</li>
				<li>
					<input type="password" name="user_pw" id="user_pw" oninput="checkPwd()" placeholder="새로운 비밀번호 ,영문, 숫자 8~14자리 조합" class="inputform250 mt10">
					<p id="user_pwtxt" style="font-size:12px; width:100px; display:inline-block; text-align:center;" ></p>
				</li>
				<li>
					<input type="password" name="user_pw2" id="user_pw2" oninput="checkPwd()" placeholder="새로운 비밀번호 확인" class="inputform250 mt10">
					<p id="user_pw2txt" style="font-size:12px; width:100px; display:inline-block; text-align:center;" ></p>
				</li>
			</ul>
			<button type="submit" id="signupbtn" disabled="disabled" class="btnform1 oh1 mt20" onclick="updatePw();">비밀번호 변경</button>
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
<script>
pwCheck=0;
pwdCheck=0;
pwdConfirmCheck=0;
//아이디 체크하여 가입버튼 비활성화, 중복확인.
	function checkpw() {
		var ernollpw = $('#user_origin_pw').val();
		var regexp = /^(?=.*[a-z])(?=.*[0-9]).{8,14}$/; // 영어소문자 숫자로만 5-13자
		
		$.ajax({
			type : "post",
			data : {
				inputpw : ernollpw
			},
			url : "/mypage/checkPw",
			success : function(data) {
				if (ernollpw == "" && data.data == 0) {
					$("#user_origin_pw").css("background-color", "white");
					$("#user_origin_pwtxt").html("영문, 숫자 8~14자리 조합").css("color","red");		
					pwCheck = 0;
				} else {
					if(!regexp.test(ernollpw))
					{
						$("#user_origin_pw").css("background-color", "#FFCECE");
						$("#user_origin_pwtxt").html("영문, 숫자 8~14자리 조합").css("color","red");
						pwCheck = 0;
					}else if (data.data == 0)
					{
						$("#user_origin_pw").css("background-color", "#FFCECE");
						$("#user_origin_pwtxt").html("현재비밀번호와 불일치").css("color","red");
						pwCheck = 0;
					} else if (data.data == 1)
					{
						$("#user_origin_pw").css("background-color", "#B0F6AC");
						$("#user_origin_pwtxt").html("현재비밀번호와 일치").css("color","green");;
						pwCheck = 1;
					}
				}
			}
		});
		return false;
		nextStepFunc();
	    
	}
//재입력 비밀번호 체크하여 가입버튼 비활성화 또는 맞지않음을 알림.
	function checkPwd() {
		var regexp1 = /^(?=.*[a-z])(?=.*[0-9]).{8,14}$/;
		var originpw = $('#user_origin_pw').val();
		var ernollpwd = $('#user_pw').val();
		var confirmpwd = $('#user_pw2').val();
		if (ernollpwd == "") {
			$("#user_pw").css("background-color", "#FFCECE");
		} else{	
			if(!regexp1.test(ernollpwd)){
				$("#user_pw").css("background-color", "#FFCECE");
				$("#user_pwtxt").html("영문, 숫자 8~14자리 조합").css("color","red");
				pwdCheck = 0;
			}
			else if(originpw==ernollpwd){
				$("#user_pw").css("background-color", "#FFCECE");
				$("#user_pwtxt").html("현재비밀번호와 같습니다.").css("color","red");
				pwdCheck = 0;
			}
			else{
				$("#user_pw").css("background-color", "#B0F6AC");
				$("#user_pwtxt").html("사용가능").css("color","green");
				pwdCheck = 1;
			}
		}	
		
		if (confirmpwd == "") {
			$("#user_pw2").css("background-color", "white");
		} else {
			$("#user_pw2").css("background-color", "#B0F6AC");
		}
		
		if (ernollpwd == "" && confirmpwd == "" && ernollpwd.length < 8) {
			$("#user_pw2").css("background-color", "white");
			$("#user_pw").css("background-color", "white");
		} else {
			if (ernollpwd == confirmpwd) {
				$("#user_pw2").css("background-color", "#B0F6AC");
				$("#user_pw2txt").html("비밀번호 같음").css("color","green");
				pwdConfirmCheck = 1;
			} else if (ernollpwd != confirmpwd) {
				$("#user_pw2").css("background-color", "#FFCECE");
				$("#user_pw2txt").html("비밀번호 다름").css("color","red");
				pwdConfirmCheck = 0;
			}
		}
		nextStepFunc();
	}

	function nextStepFunc(){					
		var activeBtn = pwCheck + pwdCheck + pwdConfirmCheck;
		console.log(activeBtn);
		if (activeBtn == 3) {
			$("#signupbtn").prop("disabled", false);
		} else {
			$("#signupbtn").prop("disabled", true);
			
		}
	}
</script>
<script>
	function updatePw(){
		var ernollpw = $('#user_pw').val();		
		$.ajax({
			type : "post",
			data : {
				user_pw : ernollpw
			},
			url : "/mypage/pwChange",
			success : function(data) {
				alert("비밀번호가 변경되었습니다");
				document.location.href = data.url; 
			}
		});
	}
	
</script>
</html>