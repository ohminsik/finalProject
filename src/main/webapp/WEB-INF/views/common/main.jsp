<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="meta.jsp" />
<%@page session="true"%>

<body>
<%-- 전체 방문자 수: ${sessionScope.totalCount}

오늘의 방문자 수: ${sessionScope.todayCount}  --%>
	<div id="wrap">
		<jsp:include page="header.jsp" />		
		<div id="container">
			<div class="main_wrap">
				<div class="main_core">
					<div class="main_top">
						<img alt="" src="/resources/img/logo.png">
					</div>
					<div class="main_bot">
						<form method="GET" action="/team/allTeamInformation">											
							<input type="text" name="word" id="" class="" placeholder="팀명을 입력해주세요">
							<button>Matching</button>
						</form>
					</div>
				</div>			
			</div>
		</div>
		<jsp:include page="footer.jsp" />
	</div>
</body>
<script>
	$(document).ready(function(){
		$(".main_wrap").css({
			height : $(window).height() + "px"
		})
		$(window).resize(function() {
			$(".main_wrap").css({
				height : $(window).height() + "px"
			})
		})
	})
</script>
</html>