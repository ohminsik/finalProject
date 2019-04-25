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
				<form action="/member/joinStep_2" method="post" id="join_form">
				<table class="j_table_form">
					<colgroup>
						<col width="20%">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<td>이름</td>
							<td><input type="text" name="user_name" id="user_name" class="inputform100p"></td>
						</tr>
						<tr>
							<td>아이디</td>
							<td><input type="text" name="user_id" id="user_id" class="inputform100p"></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" name="user_pw" id="user_pw" class="inputform100p"></td>
						</tr>
						<tr>
							<td>비밀번호확인</td>
							<td><input type="password" name="user_pw2" id="user_pw2" class="inputform100p"></td>
						</tr>
						<tr>
							<td>이메일</td>
							<td><input type="text" name="user_email" id="user_email" class="inputform250"> @ <input type="text" name="" id="" class="inputform250">
								<select name="user_email2" class="selectform2">
									<option value="">직접입력</option>
									<option value="naver.com">naver.com</option>
									<option value="hanmail.net">hanmail.net</option>
									<option value="hanmail.net">nate.com</option>
								</select>
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
							 - <input type="text" name="user_phone2" id="user_phone2" class="inputform250"> - <input type="text" name="user_phone3" id="user_phone3" class="inputform250">
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
								<select name="region" id="region" class="selectform1">											
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
							<td><input type="file" name="profile" id="profile"></td>
						</tr>
						<tr>
							<td>주 종목</td>
							<td>
								<input type="radio" name="sport" id="scooer" value="scooer"><label for="scooer">축구</label>
								<input type="radio" name="sport" id="bascketball" value="bascketball"><label for="bascketball">농구</label>
								<input type="radio" name="sport" id="jukgu" value="jukgu"><label for="jukgu">족구</label>
								<input type="radio" name="sport" id="bollring" value="bollring"><label for="bollring">볼링</label>
								<input type="radio" name="sport" id="takgu" value="takgu"><label for="takgu">탁구</label>
							</td>
						</tr>
					</tbody>
				</table>
				<div class="j_button mt50 tac">
					<a onclick="nextStepFunc();" class="btnform0">회원가입</a>
				</div>
				</form>
			</div>
			<!-- 회원가입 step2 e -->
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
<script>
function nextStepFunc(){					
	/* if($("#user_id").val()==""){
		alert("아이디를 입력하셔야 합니다.");
		$("#user_id").focus();
	}			
	else if($("#user_pw").val()==""){
		alert("비밀번호를 입력하셔야 합니다.");
		$("#user_pw").focus();
	}
	else if($("#user_pw2").val()==""){
		alert("비밀번호확인을 입력하셔야 합니다.");
		$("#user_pw2").focus();
	}
	else if($("#user_pw").val()!=$("#user_pw2").val()){
		alert("비밀번호를 다시확인해 주세요.");
		$("#user_pw2").focus();
	}
	else if($("#user_name").val()==""){
		alert("이름을 입력하셔야 합니다.");
		$("#user_name").focus();
	}
	else if($("#user_phone1").val()==""){
		alert("핸드폰번호를 입력하셔야 합니다.");
		$("#user_phone1").focus();
	}
	else if($("#user_phone2").val()==""){
		alert("핸드폰번호를 입력하셔야 합니다.");
		$("#user_phone2").focus();
	}
	else if($("#user_email").val()==""){
		alert("이메일을 입력하셔야 합니다.");
		$("#user_email").focus();
	}
	else if($("#user_email2").val()==""){
		alert("이메일을 입력하셔야 합니다.");
		$("#user_email2").focus();
	}
	else */{
		var signInForm = document.getElementById("join_form");
		signInForm.action="/member/joinStep_2";
		signInForm.submit();
	}
}
</script>
</html>