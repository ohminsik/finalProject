<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 푸터 s -->
<div id="footer">				
	<div id="footer_top">
		<div class="foot_left">
			<img class="foot_logo" src="/resources/img/logo.png" alt="logo">
		</div>
		<div class="foot_mid">
			<ul class="foot_mid_list">
				<li class="foot_mid_list_title">
					<a href="/mypage/mypageInformation">마이페이지</a>
				</li>							
			</ul>
			<ul class="foot_mid_list">
				<li class="foot_mid_list_title">
					<a href="/match/matchBoard">매치보드</a>
				</li>								
			</ul>
			<ul class="foot_mid_list">
				<li class="foot_mid_list_title">
					<a href="/team/allTeamInformation">팀</a>
				</li>							
			</ul>						
			<ul class="foot_mid_list">
				<li class="foot_mid_list_title">
					<a href="/community/noticeList">커뮤니티</a>
				</li>							
			</ul>
			<ul class="foot_mid_list">
				<li class="foot_mid_list_title">
					<a href="#">대회</a>
				</li>							
			</ul>
			<ul class="foot_mid_list">
				<li class="foot_mid_list_title">
					<a href="#">경기장</a>
				</li>							
			</ul>
			
		</div>
		<div class="foot_right">
			<ul class="address">
				<li class="address_title">ADDRESS</li>
				<li>서울시 강남구 역삼동 KH정보교육원 2층 3번째줄 왼쪽에서 두번째</li>
				<li>전화 : 010-8466-9868 / 팩스 : 010-8466-9868</li>
				<li>FinalMatch@text.com</li>
			</ul>
		</div>
	 </div>
	 <div class="line1"></div>
	 <div class="line2"></div>

	 <div id="footer_bot">
		<div class="footer_bot_left">
			<p>COPYRIGHT(C) FinalMatch. ALL RIGHTS RESERVED</p>
		</div>

		<div class="footer_bot_right">
			<div class="form">
				<div class="main_select"><select class="footer_select" onchange="if(this.value){window.open(value,'_blank')}">
					<option value="1" selected="selected">FAMILY SITE</option>
					<option value="#">familysite1</option>									
				</select><span class="select_text">FAMILY SITE</span><span class="select_arrow"></span></div>	
			</div>							
		</div>
	 </div>	
	 <div class="footer_bg"></div>
</div>

<c:if test="${login }">
	<div class="container chat_wrap hide">
		<div class="cnt" id="cnt"></div>
		<div class="chatArea_wrap">
			<div id="chatAreabox">
				<div id="chatArea"></div>
				
			</div>
		</div>
		<div class="mt20">
			 <input type="text" id="chatInput" class="inputform250" style="width:375px; height:35px;"/>
			 <input type="button" id="sendBtn" value="전송" class="btnform7"	/>
		</div>
		<i class="xi-close close_btnnnnnn"></i>
		<i class="xi-plus"></i>
	</div>	
</c:if>
	
<!-- 푸터 e -->
<script type="text/javascript">
$(document).ready(function(){
	$(".close_btnnnnnn").click(function(){
		$(".chat_wrap").addClass("hide");
	});
	
	$(".chat_wrap .xi-plus").click(function(){
		$(".chat_wrap").removeClass("hide");
	});
})
//sockjs 를 이용한 서버와 연결되는 객체
var ws = null;
var user_nick= null;


function showMessage(message) {
	
    console.log(message);
    var jsonMessage = JSON.parse(message);
    if(jsonMessage.cnt !==0){
	    $("#cnt").html('현재 접속자 수 :'+jsonMessage.cnt);
    }
   
    if('${user_nick}' == jsonMessage.name){
    	
   		$("#chatArea").append("<p class='myp'>"+jsonMessage.message+'</p>'+'<p class="cb"></p>');
    }else{
    	$("#chatArea").append("<p class='youp'>"+jsonMessage.name +" : "+ jsonMessage.message +"</p>"+'<p class="cb"></p>');
    }
     var textArea = $('#chatAreabox');
     textArea.scrollTop( textArea[0].scrollHeight - textArea.height()   );

}


function connect() {
    // SockJS라이브러리를 이용하여 서버에 연결
    ws = new WebSocket("ws://192.168.20.18:8088/chatEcho");
  

    // 서버가 메시지를 보내주면 함수가 호출된다.
    ws.onmessage = function(message) {
        showMessage(message.data);
    }
}

function disconnect() {
    if (ws != null) {
        ws.close();
    }
    setConnected(false);
    console.log("Disconnected");
}

function send() {
    // 웹소켓 서버에 메시지를 전송
    ws.send(JSON.stringify({'message': $("#chatInput").val()}));
    // 채팅입력창을 지우고 포커싱하라.
    $("#chatInput").val('');
    $("#chatInput").focus();
}


// $(함수(){ 함수내용 });  // jquery에서 문서가 다 읽어들이면 함수()를 호출한다.
$(function () {
	if('${login}'){
   	 connect();
	}
    // 채팅입력창에서 키가 눌리면 함수가 호출
    // 엔터를 입력하면 send()함수가 호출
    $("#chatInput").keypress(function(e) {
        if (e.keyCode == 13){
            send();
        }
    });

    $( "#sendBtn" ).click(function() { send(); });
});
</script>
