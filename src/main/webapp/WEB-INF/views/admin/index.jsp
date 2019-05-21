<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="../common/adminmeta.jsp"/>
<body>
<div id="wrap">
	<!--header s-->
	<jsp:include page="header.jsp"/>
	<jsp:include page="nav.jsp"/>
	<!--header e-->
	<!--container s-->
		<div id="container">
			<div class="main_title">
				<p>ADMIN 관리</p>
			</div>

			<div class="category_wrap">
				<ul class="menuuuuuu">
					<li><a href="#"><i class="xi-user"></i>오늘 방문자 수 <span>${todayCount }</span></a></li>				
					<li><a href="#"><i class="xi-users"></i>전체 방문자 수<span>${totalCount }</span></a></li>				
					<li><a href="#"><i class="xi-user-plus"></i>오늘 가입 인원<span>${todayJoinCnt }</span> </a></li>				
					<li><a href="#"><i class="xi-users-plus"></i>전체 가입 인원<span>${totalJoinCnt }</span></a></li>				
					<li><a href="#"><i class="xi-bell"></i>오늘 매치 등록 수<span>${todayMatchCnt }</span></a></li>				
					<li><a href="#"><i class="xi-bell-o"></i>총 매치 등록 수<span>${totalMatchCnt }</span></a></li>								
				</ul>
				<ul class="menuuuuuu">
					<li><a href="/admin/board?board_div=1"><i class="xi-list-dot"></i>공지사항</a></li>				
					<li><a href="/admin/board?board_div=2"><i class="xi-list-square"></i>팀가입인사</a></li>				
					<li><a href="/admin/board?board_div=3"><i class="xi-list-number"></i>팀모집게시판</a></li>				
					<li><a href="/admin/board?board_div=4"><i class="xi-list"></i>자유게시판</a></li>				
					<li><a href="/admin/board?board_div=5"><i class="xi-spinner-1"></i>경기후기</a></li>				
					<li><a href="/admin/board?board_div=6"><i class="xi-cart-o"></i>중고장터</a></li>								
					<li><a href="/admin/board?board_div=7"><i class="xi-movie"></i>동영상</a></li>								
					<li><a href="/admin/board?board_div=8"><i class="xi-list"></i>팀게시판</a></li>								
					<li><a href="/admin/board?board_div=9"><i class="xi-library-image"></i>대회일정</a></li>								
					<li><a href="/admin/board?board_div=10"><i class="xi-library-image-o"></i>경기장리스트</a></li>								
					<li><a href="/admin/memManagement"><i class="xi-user"></i>회원관리</a></li>								
					<li><a href="/admin/teamManagement"><i class="xi-group"></i>팀관리</a></li>								
				</ul>
			</div>		
		</div>
	<!--container s-->
	</div>

 </body>
</html>
<style>
	.menuuuuuu > * {transition:all,.5s;}
	.menuuuuuu{overflow: hidden;}
	.menuuuuuu li{margin-bottom:30px; float:left; width:15.666%; text-align: center; border:1px solid #3f4b5c; box-sizing:border-box; margin-right:1%; padding:20px 0;}
	.menuuuuuu li a{text-align: center; font-size:20px;}
	.menuuuuuu li a span{text-align: center; font-size:20px; display: block;}
	.menuuuuuu li a i{font-size:36px; display: block;text-align: center;}
	.menuuuuuu li p{font-size:20px;}
	.menuuuuuu li p span{font-size:20px;}
	
	.menuuuuuu li:hover{border:1px solid #5383e8}
	.menuuuuuu li:hover a{color:#5383e8}
	.menuuuuuu li:hover a span{color:#5383e8}
	.menuuuuuu li:hover a i{color:#5383e8}
</style>