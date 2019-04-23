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
				<p class="text">개인메세지</p>
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
						<a>개인메세지</a>
					</li>
				</ul>
			</div>
		</div>
		<!-- nav e -->	
		<div id="container">
			<div class="team_form">
				<div class="team_btn_list">
					<ul>
						<li><a href="/mypage/mypageInformation">내 정보</a></li>
						<li class="on"><a href="/mypage/mypagepersonalMessage">개인 메세지</a></li>
						<li><a href="/mypage/mypageBoardList">내가 쓴 게시글</a></li>
						<li><a href="/mypage/mypageMatchList">내가 쓴 매치글</a></li>
					</ul>
				</div>
				
				<div class="mypage_form">
					<table class="j_table_form1 j_table_form2 mt30">
						<colgroup>
							<col width="20%">
							<col width="*">
							<col width="20%">
							<col width="20%">							
						</colgroup>
						<thead>
							<tr>
								<th>보낸사람</th>
								<th>메세지 내용</th>
								<th>확인여부</th>
								<th>날짜</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>김준환</td>
								<td class="tddd"><a href="#" class="messagebtn">담경기는 ㅇㄷㅇㄷ?</a></td>
								<td class="nocheck">미확인</td>
								<td>2019-02-02</td>
								<div class="message_wrap">
									<div>
										<p>보낸사람 : 김준환(junk123)</p>
										<i class="xi-close messageclosebtn"></i>
										<textarea class="textareaform100p mt20">담경기는 ㅇㄷㅇㄷ?</textarea>
										<button type="button" class="btnform1 oh1 mt20">삭제</button>
										<button type="button" class="btnform1 oh1 mt20">답장</button>
									</div>								
								</div>
							</tr>
							<tr>
								<td>김강환</td>
								<td class="tddd"><a href="#">담경기는 ㅇㄷㅇㄷ?</a></td>
								<td class="check">확인</td>
								<td>2019-02-02</td>
							</tr>
						</tbody>
					</table>
				</div>			
			</div>
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>	
	<div class="messagebg"></div>
</body>
<script>
$(document).ready(function(){
	$(".messagebtn").click(function(e){
		e.preventDefault();
		$(".messagebg").fadeIn();
		$(".message_wrap").fadeIn();
	})
	
	$(".messageclosebtn").click(function(e){
		e.preventDefault();
		$(".messagebg").fadeOut();
		$(".message_wrap").fadeOut();
	})
})
</script>

</html>