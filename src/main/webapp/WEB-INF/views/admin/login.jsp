<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/adminmeta.jsp"/>
<body>
	<div class="login_bg">
		<form action="/admin/login" method="post">
			<div class="login_wrap">
				<div class="top">
					<div>ADMIN</div>
					<a href="/main">X</a>
				</div>
				<div class="bot">
					<ul>
						<li>
							<label class="title" for="admin_id">ID</label>
							<input class="text" type="text" id="admin_id" name="admin_id">
						</li>
						<li>
							<label class="title" for="admin_pw">PW</label>
							<input class="text" type="password" id="admin_pw" name="admin_pw">
						</li>
					</ul>
					<button class="loginbtn" id="btnLogin">로그인</button>
				</div>
			</div>
		</form>
	</div>
</body>
<c:if test="${empty adminlogin}"> 
	<script type="text/javascript">
	$(document).ready(function(){
		
		$("#btnLogin").click(function(){
			
			if($("#admin_id").val()==''){
				
				alert("아이디를 입력하세요 ");
				$("#admin_id").focus();
				return false;
				
			}else if($("#admin_pw").val()==''){
				
				alert("비밀번호를 입력하세요");
				$("#admin_pw").focus();
				return false;
				
// 			}else if(($("#admin_id").val() != ${check.admin_id } ) && ($("#admin_pw").val() != ${check.admin_pw } ) ){
// 				console.log('하이');
// 				alert("로그인에 실패했습니다.");
// 				return false;
				
			}
		} 
	})
	});
	</script>
	 </c:if>
</html>