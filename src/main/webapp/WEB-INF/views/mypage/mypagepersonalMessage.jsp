<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
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
							<col width="10%">
							<col width="20%">
							<col width="*">
							<col width="20%">
							<col width="20%">							
						</colgroup>
						<thead>
							<tr>
								<th>구분</th>
								<th>보낸사람</th>
								<th>메세지 내용</th>
								<th>확인여부</th>
								<th>날짜</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${messageList }" var="messageList">
							<tr>
								<c:if test="${messageList.reciveruser_no eq user.user_no}">
									<td class="check">받은메세지</td>
								</c:if>
								<c:if test="${messageList.reciveruser_no ne user.user_no}">
									<td class="nocheck">보낸메세지</td>
								</c:if>
								<td>${messageList.senduser_name }</td>
								<td class="tddd"><a href="javascript:void(0);" onclick="openMessage(${messageList.message_no},${messageList.reciveruser_no},${user.user_no });">${messageList.message_content }</a></td>
								<c:if test="${messageList.message_YN eq 'Y'}">
									<td class="check" id="checkch${messageList.message_no}">확인</td>
								</c:if>
								<c:if test="${messageList.message_YN eq 'N'}">
									<td class="nocheck" id="checkch${messageList.message_no}">미확인</td>
								</c:if>
								<td><fmt:formatDate value="${messageList.message_date }" pattern="yyyy-MM-dd"/></td>
								<div class="message_wrap" id="message_wrap${messageList.message_no}">
									<div>
										<p>보낸사람 : ${messageList.senduser_name }(${messageList.senduser_id })</p>
										<i class="xi-close messageclosebtn"></i>
										<textarea readonly="readonly" class="textareaform100p mt20">${messageList.message_content }</textarea>
										<c:if test="${messageList.reciveruser_no eq user.user_no}">
											<button type="button" onclick="deleteMessage(${messageList.message_no});" class="btnform1 oh1 mt20">삭제</button>
											<button type="button" onclick="replyMessage(${messageList.message_no});"class="btnform1 oh1 mt20" >답장</button>
										</c:if>
									</div>								
								</div>
								
								<div class="message_wrap" id="replymessage_wrap${messageList.message_no}">
									<form action="/mypage/replyMessage" method="POST">
										<input type="hidden" name="senduser_no" value="${messageList.reciveruser_no }">
										<input type="hidden" name="reciveruser_no" value="${messageList.senduser_no }">
										<div>
											<p>받는사람 : ${messageList.senduser_name }(${messageList.senduser_id })</p>
											<i class="xi-close messageclosebtn"></i>
											<textarea class="textareaform100p mt20" name="message_content"></textarea>
											<button class="btnform1 oh1 mt20" >전송</button>
										</div>	
									</form>							
								</div>
							
							</tr>
							</c:forEach>
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
function openMessage(n,r,u){
	var messageno = n;	
	if(r==u){
		$.ajax({
			type : "post",
			data : {
				messageno : messageno
			},
			url : "/mypage/MessageYN",
			success : function(data) {
				$("#checkch"+n).removeClass("nocheck");
				$("#checkch"+n).addClass("check");
				$("#checkch"+n).html("확인");
				console.log("완료");
			}
		});
	}
	$(".messagebg").fadeIn();
	$("#message_wrap"+n).fadeIn();
}

function replyMessage(n){
	$("#message_wrap"+n).hide();
	$("#replymessage_wrap"+n).show();	
}


function deleteMessage(n){
	var messageno = n;	
	$.ajax({
		type : "post",
		data : {
			messageno : messageno
		},
		url : "/mypage/MessageDelete",
		success : function(data) {
			location.href="/mypage/mypagepersonalMessage";
		}
	});
	
}


$(document).ready(function(){	
	$(".messageclosebtn").click(function(e){
		e.preventDefault();
		$(".messagebg").fadeOut();
		$(".message_wrap").fadeOut();
	})
})
</script>

</html>