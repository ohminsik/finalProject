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
				<form action="/mypage/mypageInformationUpdate" method="POST">
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
								<td>닉네임</td>
								<td>
									${userinfo.user_nick }
								</td>
							</tr>
							<tr>
								<td>이메일</td>
								<td><input type="text" name="user_email" id="user_email" class="inputform250" oninput="checkEmail()" value="${email1 }"> @ <input type="text" name="user_email1" id="user_email1" class="inputform250" oninput="checkEmail()" value="${email2 }">
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
								 - <input type="text" name="user_phone2" id="user_phone2" class="inputform250" oninput="checkPhone()" value="${phone1 }"> - <input type="text" name="user_phone3" id="user_phone3" class="inputform250" oninput="checkPhone()" value="${phone2 }">
								   <p id="phonetxt" style="display: inline-block; margin-left:10px;" ></p>
								</td>
							</tr>
							<tr>
								<td>생년월일</td>
								<td>
									${userinfo.user_birth }
								</td>
							</tr>
							<tr>
								<td>지역</td>
								<td>
									<select name="user_region" id="user_region" class="selectform1">											
										<option value="서울">서울</option>
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
								<td>${userinfo.user_profile }</td>
							</tr>
							<tr>
								<td>주 종목</td>
								<td>
									${userinfo.user_sport }
								</td>
							</tr>
						</tbody>
					</table>
					
					<div class="j_button mt30">
						<ul>
							<li><button type="submit" id="signupbtn" disabled="disabled" class="btnform0" >회원정보 수정</button></li>
							<li><a href="/mypage/mypageInformation" class="btnform0">취소</a></li>
						</ul>
					</div>				
				</div>
				</form>
			</div>
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
<script>
	var phone = "${phone0 }";
	var region = "${region }";
	$(document).ready(function(){
		$("#user_region").val(region);
		$("#user_phone1").val(phone);
	})

</script>
<script>
	var mail2 = document.getElementById('user_email1');
	var mail3 = document.getElementById('user_email2');
	mail3.onchange = function(event){
	        var _val = this.value.trim();
	        mail2.value = _val ;
	}
</script>
<script>	
	var emailCheck = 1;
	var phoneCheck = 1;

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
	var activeBtn = emailCheck + phoneCheck;
	console.log(activeBtn);
	if (activeBtn == 2) {
		$("#signupbtn").prop("disabled", false);
	} else {
		$("#signupbtn").prop("disabled", true);
		
	}
}
</script>
</html>