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
					<p class="text">회원가입</p>
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
			
			<!-- 회원가입 step2 s -->
			<div class="content_form">
				<form action="/member/joinStep_2" method="post" id="join_form" enctype="multipart/form-data">
				<table class="j_table_form">
					<colgroup>
						<col width="20%">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<td>이름</td>
							<td>
								<input type="text" name="user_name" id="user_name" class="inputform250" oninput="checkName()" >
								<p id="enrollnametxt" style="display: inline-block; margin-left:10px;" ></p>
							</td>
						</tr>
						<tr>
							<td>닉네임</td>
							<td>
								<input type="text" name="user_nick" id="user_nick" class="inputform250" oninput="checkNickName()">
								<p id="enrollnicktxt" style="display: inline-block; margin-left:10px;" ></p>
							</td>
						</tr>
						<tr>
							<td>아이디</td>
							<td>
								<input type="text" name="user_id" id="user_id" class="inputform250" oninput='return checkId()' onblur='return checkId()' placeholder="영어소문자, 숫자로만 5-13자">
								<p id="enrollidtxt" style="display: inline-block; margin-left:10px;" ></p>
							</td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td>
								<input type="password" name="user_pw" id="user_pw" class="inputform250" oninput="checkPwd()" placeholder="영문, 숫자 8~14자리 조합">
								<p id="enrollpwdtxt" style="display: inline-block; margin-left:10px;" ></p>
							</td>
						</tr>
						<tr>
							<td>비밀번호확인</td>
							<td>
								<input type="password" name="user_pw2" id="user_pw2" class="inputform250" oninput="checkPwd()">
								<p id="confirmpwdtxt" style="display: inline-block; margin-left:10px;" ></p>
							</td>
						</tr>
						<tr>
							<td>이메일</td>
							<td><input type="text" name="user_email" id="user_email" class="inputform250" oninput="checkEmail()"> @ <input type="text" name="user_email1" id="user_email1" class="inputform250" oninput="checkEmail()">
								<select name="user_email2" id="user_email2" class="selectform2 vm" >
									<option value="">직접입력</option>
									<option value="naver.com">naver.com</option>
									<option value="hanmail.net">hanmail.net</option>
									<option value="nate.com">nate.com</option>
								</select>
								<p id="emailtxt" style="display: inline-block; margin-left:10px;" ></p>
							</td>
						</tr>
						<tr>
							<td>전화번호</td>
							<td>
								<select name="user_phone1" id="user_phone1" class="selectform2">
									<option value="010">010</option>
									<option value="011">011</option>
									<option value="016">016</option>
									<option value="017">017</option>
									<option value="018">018</option>
									<option value="019">019</option>
								</select>
							 - <input type="text" name="user_phone2" id="user_phone2" class="inputform250" oninput="checkPhone()"> - <input type="text" name="user_phone3" id="user_phone3" class="inputform250" oninput="checkPhone()">
							   <p id="phonetxt" style="display: inline-block; margin-left:10px;" ></p>
							</td>
						</tr>
						<tr>
							<% 
								int year = 2019;
								int month = 1;
								int day = 1;
							%>
							<td>생년월일</td>
							<td>
								<select name="year" id="year" class="selectform1">
									<c:forEach var="i" begin="1" end="80">			
									<option value="<%=year %>"><%=year %></option>
									<%year--;%>
									</c:forEach>
								</select>
								<select name="month" id="month" class="selectform1">
									<c:forEach var="i" begin="1" end="12">			
									<option value="<%=month %>"><%=month %></option>
									<%month++; %>
									</c:forEach>
								</select>
								<select name="day" id="day" class="selectform1">
									<c:forEach var="i" begin="1" end="31">			
									<option value="<%=day %>"><%=day %></option>
									<%day++; %>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td>지역</td>
							<td>
								<select name="user_region" id="user_region" class="selectform1">											
									<option value="서울" selected="selected">서울</option>
									<option value="인천">인천</option>
									<option value="대전">대전</option>
									<option value="대구">대구</option>
									<option value="울산">울산</option>
									<option value="부산">부산</option>
									<option value="세종">세종</option>
									<option value="광주">광주</option>
									<option value="경기">경기</option>
									<option value="강원">강원</option>
									<option value="충북">충북</option>
									<option value="충남">충남</option>
									<option value="전북">전북</option>
									<option value="전남">전남</option>
									<option value="경북">경북</option>
									<option value="경남">경남</option>
									<option value="제주">제주</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>프로필사진</td>
							<td><input type="file" name="file" id="user_profile"></td>
						</tr>
						<tr>
							<td>주 종목</td>
							<td class="sport_user">
								<input type="radio" name="user_sport" id="scooer" value="scooer"><label for="scooer">축구</label>
								<input type="radio" name="user_sport" id="bascketball" value="bascketball"><label for="bascketball">농구</label>
								<input type="radio" name="user_sport" id="jukgu" value="jukgu"><label for="jukgu">족구</label>
								<input type="radio" name="user_sport" id="bollring" value="bollring"><label for="bollring">볼링</label>
								<input type="radio" name="user_sport" id="takgu" value="takgu"><label for="takgu">탁구</label>
							</td>
						</tr>
						<tr class="position_tr">
							<td>포지션</td>
							<td>
								<select name="user_position" class="selectform2">
									<option value="GK">GK - 골키퍼</option>
									<option value="DF">DF - 수비수</option>
									<option value="CB">CB - 센터백</option>
									<option value="SW">SW - 스위퍼</option>
									<option value="FB">FB - 풀백</option>
									<option value="LB">LB - 왼쪽 풀백</option>
									<option value="RB">RB - 오른쪽 풀백</option>
									<option value="WB">WB - 윙백</option>
									<option value="LWB">LWB - 왼쪽 윙백</option>
									<option value="RWB">RWB - 오른쪽 윙백</option>
									<option value="MF">MF - 미드필더</option>
									<option value="CM">CM - 중앙미드필더</option>
									<option value="DM">DM - 수비형미드필더</option>
									<option value="AM">AM - 공격형미드필더</option>
									<option value="LW">LW - 왼쪽  윙</option>
									<option value="RW">RW - 오른쪽 윙</option>
									<option value="FW">FW - 공격수</option>
									<option value="CS">CS - 중앙공격수</option>
									<option value="SS">SS - 세컨드 스트라이커</option>
								</select>
							</td>
						</tr>
					</tbody>
				</table>
				<div class="j_button mt50 tac">
					<button type="submit" id="signupbtn" disabled="disabled" class="btnform0" >회원가입</button>
				</div>
				</form>
			</div>
			<!-- 회원가입 step2 e -->
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
<script>
	var mail2 = document.getElementById('user_email1');
	var mail3 = document.getElementById('user_email2');
	mail3.onchange = function(event){
	        var _val = this.value.trim();
	        mail2.value = _val ;
	}
</script>
<script>

$(document).ready(function(){
	$(".sport_user > input:eq(0)").click(function(){
		$(".position_tr").show();
	})
	$(".sport_user > input:eq(1)").click(function(){
		$(".position_tr").hide();
	})
	$(".sport_user > input:eq(2)").click(function(){
		$(".position_tr").hide();
	})
	$(".sport_user > input:eq(3)").click(function(){
		$(".position_tr").hide();
	})
	$(".sport_user > input:eq(4)").click(function(){
		$(".position_tr").hide();
	})
})


var IdCheck = 0;
var pwdInputCheck = 0;
var pwdConfirmCheck = 0;
var nameCheck = 0;
var nicknameCheck = 0;
var addrCheck = 0;
var emailCheck = 0;
var phoneCheck = 0;
var agreeCheck=0;

//사용자이름을 입력하지 않았을 경우 가입버튼 비활성화
function checkName() {
	var username = $("#user_name").val();
	if (username == "") {
		nameCheck = 0;
		$("#user_name").css("background-color", "white");
	} else {
		var pattern = /^[가-힣]{2,5}|[a-zA-Z]{2,10}$/;
		if(pattern.test(username)){
			nameCheck = 1;
			$("#user_name").css("background-color", "#B0F6AC");
			$("#enrollnametxt").html("사용가능").css("color","green");
		}else{
			nameCheck = 0;
			$("#user_name").css("background-color", "#FFCECE");
			$("#enrollnametxt").html("이름을 입력하세요").css("color","red");
		}	
	}
	nextStepFunc();
}

//닉네임을 입력하지 않았을 경우 가입버튼 비활성화
function checkNickName() {
	var usernick = $("#user_nick").val();
	if (usernick == "") {
		nicknameCheck = 0;
		$("#user_nick").css("background-color", "white");
	} else {
		var pattern = /^[가-힣]{2,5}|[a-zA-Z0-9]{2,10}$/;
		if(pattern.test(usernick)){
			nicknameCheck = 1;
			$("#user_nick").css("background-color", "#B0F6AC");
			$("#enrollnicktxt").html("사용가능").css("color","green");
		}else{
			nicknameCheck = 0;
			$("#user_nick").css("background-color", "#FFCECE");
			$("#enrollnicktxt").html("닉네임을 입력하세요").css("color","red");
		}	
	}
	nextStepFunc();
}

//아이디 체크하여 가입버튼 비활성화, 중복확인.
function checkId() {
	var ernollid = $('#user_id').val();
	var regexp = /^[a-z0-9]{5,13}$/; // 영어소문자 숫자로만 5-13자
	
	$.ajax({
		type : "post",
		data : {
			inpuid : ernollid
		},
		url : "/member/checkId",
		success : function(data) {
			if (ernollid == "" && data.data == 0) {
				$("#user_id").css("background-color", "white");
				$("#enrollidtxt").html("영문소문자, 숫자로 5~13자입력").css("color","red");		
				IdCheck = 0;
			} else {
				if(!regexp.test(ernollid))
				{
					$("#user_id").css("background-color", "#FFCECE");
					$("#enrollidtxt").html("영문소문자, 숫자로 5~13자입력").css("color","red");
					IdCheck = 0;
				}else if (data.data == 0)
				{
					$("#user_id").css("background-color", "#B0F6AC");
					$("#enrollidtxt").html("사용 가능").css("color","green");
					IdCheck = 1;
				} else if (data.data == 1)
				{
					$("#user_id").css("background-color", "#FFCECE");
					$("#enrollidtxt").html("사용 불가").css("color","red");
					IdCheck = 0;
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
	var ernollpwd = $('#user_pw').val();
	var confirmpwd = $('#user_pw2').val();
	if (ernollpwd == "") {
		$("#user_pw").css("background-color", "#FFCECE");
	} else{	
		if(!regexp1.test(ernollpwd)){
			$("#user_pw").css("background-color", "#FFCECE");
			$("#enrollpwdtxt").html("영문, 숫자 8~14자리 조합").css("color","red");
			pwdCheck = 0;
		}
		else{
			$("#user_pw").css("background-color", "#B0F6AC");
			$("#enrollpwdtxt").html("사용가능").css("color","green");
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
			$("#confirmpwdtxt").html("비밀번호 같음").css("color","green");
			pwdConfirmCheck = 1;
		} else if (ernollpwd != confirmpwd) {
			$("#user_pw2").css("background-color", "#FFCECE");
			$("#confirmpwdtxt").html("비밀번호 다름").css("color","red");
			pwdConfirmCheck = 0;
		}
	}
	nextStepFunc();
}

//이메일 유효성검사
function checkEmail(){
	var email1 = $('#user_email').val();
	var email2 = $('#user_email1').val();
	var email = email1 + '@' + email2;
	
	if(email1 == "" && email2 == ""){
		$("#user_email").css("background-color", "white");
		$("#user_email1").css("background-color", "white");
	}else{
		var pattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		
		if(pattern.test(email)){
			$("#user_email").css("background-color", "#B0F6AC");
			$("#user_email1").css("background-color", "#B0F6AC");
			emailCheck = 1;
			$("#emailtxt").html("사용가능").css("color","green");
		}else{
			$("#user_email").css("background-color", "#FFCECE");
			$("#user_email1").css("background-color", "#FFCECE");
			emailCheck = -1;
			$("#emailtxt").html("사용불가").css("color","red");
		}
	}
	nextStepFunc();
}

//휴대폰번호 유효성검사
function checkPhone() {
	var phone1 = $("#user_phone1").val();
	var phone2 = $("#user_phone2").val();
	var phone3 = $("#user_phone3").val();
	var phone = phone1 + phone2 + phone3;
	
	if (phone2 == "" && phone3 == "") {
		$("#user_phone2").css("background-color", "white");
		$("#user_phone3").css("background-color", "white");
		phoneCheck = 0;
	} else {
		
		var pattern =  /(01[016789])([1-9]{1}[0-9]{2,3})([0-9]{4})$/;

		if(pattern.test(phone)){
			$("#user_phone2").css("background-color", "#B0F6AC");
			$("#user_phone3").css("background-color", "#B0F6AC");
			phoneCheck = 1;
			$("#phonetxt").html("사용가능").css("color","green");
		}else{
			$("#user_phone2").css("background-color", "#FFCECE");
			$("#user_phone3").css("background-color", "#FFCECE");
			phoneCheck = -1;
			$("#phonetxt").html("사용불가").css("color","red");
		}
	}
	nextStepFunc();
}




function nextStepFunc(){					
	var activeBtn = IdCheck + pwdCheck + pwdConfirmCheck + nameCheck + nicknameCheck + emailCheck + phoneCheck;
	console.log(activeBtn);
	if (activeBtn == 7) {
		$("#signupbtn").prop("disabled", false);
	} else {
		$("#signupbtn").prop("disabled", true);
	}
}
</script>
</html>