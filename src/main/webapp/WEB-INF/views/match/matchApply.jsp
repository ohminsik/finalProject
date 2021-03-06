<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %> 
<jsp:include page="../common/meta.jsp"/>
<body>
	<div id="wrap">
		<jsp:include page="../common/header.jsp"/>	
		<!-- sub_banner s -->
		<div class="sub_banner">
			<span class="bg"></span>
			<div class="textBox">
				<p class="title">매치보드</p>
				<p class="text">매치신청</p>
			</div>
		</div>
		<!-- sub_banner e -->
		
		<!-- nav s -->
		<div class="nav_wrap">
			<div class="nav">
				<ul>
					<li><a href="/main"><i class="xi-home"></i></a></li>
					<li>
						<a>매치보드</a>
					</li>
					<li>
						<a>매치신청</a>
					</li>
				</ul>
			</div>
		</div>
		<!-- nav e -->	
		<div id="container">
			<div class="match_wrap">
				<ul class="match_apply">
					<li>
						<div class="match_apply_div">
							<p class="blue">
								<img src="/resources/img/logo.png">
								<span>${match.team_name }</span>
							</p>
							<p class="vs">VS</p>
							<p class="purple">
								<img src="/resources/img/logo.png">
								<span>? ? ? ? ?</span>
							</p>
						</div>
						<table class="match_apply_table">
							<colgroup>
								<col width="20%">
								<col width="*">
							</colgroup>
							<tbody>
								<tr>
									<td>지역 :</td>
									<td>${match.match_region } - ${match.team_region }</td>
								</tr>
								<tr>
									<td>구장 :</td>
									<td>${match.match_ground }</td>
								</tr>
								<tr>
									<td>날짜 :</td>
									<td><fmt:formatDate value="${match.fight_date }" pattern="yyyy-MM-dd"/></td>
								</tr>
								<tr>
									<td>연락처 :</td>
									<td>${match.user_phone }</td>
								</tr>
								<tr>
									<td>비용 :</td>
									<td>${match.match_money } 원</td>
								</tr>
								<tr>
									<td>개설자 :</td>
									<td>${match.user_name }</td>
								</tr>
								<tr>
									<td>유니폼색상 :</td>
									<td>${match.match_uniform }</td>
								</tr>
							</tbody>
						</table>
					</li>
					<li>
						<div class="title mb10">남기는 한마디</div>
						<div class="memo">${match.match_content }</div>
						<div class="match_btn_list">
							<ul>
								<li><a class="btnform1 messageapply">메세지보내기</a></li>
								<li>
								<form action="/match/matchApply" method="POST">
									<input type="hidden" name="match_no" value="${match.match_no }"/>
									<button id="matchAppl" onclick="clickBtnMthApp();" class="btnform1">매치신청</button>
									<script>
										 function clickBtnMthApp(){
											 alert("신청완료 되었습니다");
										}
									</script>
								</form>
								</li>
								<li><a href="/match/matchBoard?selectRegion=0" class="btnform1">목록</a></li>
							</ul>
						</div>
					</li>
				</ul>				
				
			</div>
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
<div class="messagebg"></div>
<div class="message_wrap" id="replymessage_wrap" style="text-align:center;">
	<form action="/mypage/replyMessage" method="POST">
		<input type="hidden" name="senduser_no" value="${user_no }">
		<input type="hidden" name="reciveruser_no" value="${reciver.user_no }">
		<div>
			<p>받는사람 : ${reciver.user_name }(${reciver.user_id })</p>
			<i class="xi-close messageclosebtn" style="top:20px; right:20px;"></i>
			<textarea class="textareaform100p mt20" name="message_content"></textarea>
			<button class="btnform1 oh1 mt20" >전송</button>
		</div>	
	</form>							
</div>
</body>
<script>
	$(document).ready(function(){	
		$(".messageapply").click(function(e){
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