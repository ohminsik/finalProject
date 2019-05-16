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
					
				<!-- 인스타 s -->
				<div id="instafeed" class="instafeed" style="font-size: 14px; border: 1px solid #DDD; background: #fafafa;
 				     position: absolute; top: 56%; height: 300px; width: 400px;left: 19%; padding: 0 29px 29px 29px;">INSTAGRAM
				</div>
				<!-- 인스타 e -->
				
			</div>
		</div>
		<jsp:include page="footer.jsp" />
	</div>
</body>
<!-- 인스타 s -->
<script type="text/javascript" src="/resources/css/instafeed.min.js"></script> <!-- js 파일 로드 -->
<script type="text/javascript">    
var userFeed = new Instafeed({
    get: 'user',
    userId: 13118366147,
    sortBy: "most-recent",
    limit: 4,
    template: '<a href="{{link}}" target="_blank"><img src="{{image}}" />{{caption}}</a>', 
    // {{link}} : 게시물 링크, {{image}} : 사진 url, {{caption}} : 게시물 텍스트
    accessToken: '13118366147.8dc7a7b.65b613d465df4302addc9fa51f8fc8ee'        
});
 
userFeed.run();
</script>
<!-- 인스타 e -->
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