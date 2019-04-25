<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/adminmeta.jsp"/>
<body>
	<div class="login_bg">
		<form action="/admin" method="post">
			<div class="login_wrap">
				<div class="top">
					<div>ADMIN</div>
					<a href="/index">X</a>
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
					<button class="loginbtn">로그인</button>
				</div>
			</div>
		</form>
	</div>
</body>
<c:if test="${adminlogin eq false}">
	<script type="text/javascript">
		alert("로그인에 실패했습니다");
	</script>
	<%
		request.getSession().invalidate();
	%>
</c:if>
</html>