<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					<p class="text">이용약관</p>
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
			
			<!-- 회원가입 step1 s -->
			<div class="content_form">
				<p class="j_title">이용약관</p>				
				<div class="j_textform">
				
				</div>
				<div class="j_input">
					<input type="checkbox" name="chk" id="chk1"><label for="chk1">이용약관에 동의합니다.</label>
				</div>
				<div class="cb"></div>
				
				<p class="j_title">개인정보 수집이용</p>				
				<div class="j_textform">
				
				</div>
				<div class="j_input">
					<input type="checkbox" name="chk" id="chk2"><label for="chk2">개인정보 수집·이용에 동의합니다.</label>
				</div>
				<div class="cb"></div>
				
				<div class="j_button">
					<a onclick="infoCheckFunc();" class="btnform0">회원가입</a>
				</div>
			</div>
			<!-- 회원가입 step1 e -->
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
<script>
function infoCheckFunc(){
	if($("#chk1").is(":checked")==false){
		alert("이용약관에 동의를 해주셔야 합니다.");
	}else if($("#chk2").is(":checked")==false){
		alert("개인정보 수집 및 이용에 동의를 해주셔야 합니다.");
	}else{
		location.href='/member/joinStep_2';
	}
}
</script>

</html>