<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="java.util.Calendar"%>
<%
Calendar now = Calendar.getInstance();
int year = now.get(Calendar.YEAR);
int month = now.get(Calendar.MONTH)+1;
%>
<!-- 카카오 로그인  s -->
<meta charset="utf-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<!-- 카카오 로그인  e -->
<div id="header">
	<div class="h_top_wrap">
		<div class="h_top">
			<ul>
				<li><a href="/main">홈</a></li>
				<c:if test="${empty login }">
				<li><a href="#" class="login">로그인</a></li>
				<li><a href="/member/joinStep_1">회원가입</a></li>
				</c:if>
				
				<c:if test="${login }">
				<li><a href="/logout" class="logout">로그아웃</a></li>
				<li><a href="/mypage/mypageInformation">마이페이지</a></li>
				</c:if>
			</ul>
		</div>
	</div>
	<div class="h_mid_wrap">
		<div class="h_mid">
			<ul>
				
				<li class="<c:if test="${userInfo eq '축구'}">on</c:if>">
					<a href="#">
						<img alt="" src="/resources/img/top_icon01.png">
						<p>축구</p>
					</a>
				</li>
				<li class="<c:if test="${userInfo eq '농구'}">on</c:if>">
					<a href="#">
						<img alt="" src="/resources/img/top_icon02.png">
						<p>농구</p>
					</a>
				</li>
				<li class="<c:if test="${userInfo eq '족구'}">on</c:if>">
					<a href="#">
						<img alt="" src="/resources/img/top_icon03.png">
						<p>족구</p>
					</a>
				</li>
				<li class="<c:if test="${userInfo eq '볼링'}">on</c:if>">
					<a href="#">
						<img alt="" src="/resources/img/top_icon04.png">
						<p>볼링</p>
					</a>
				</li>
				<li class="<c:if test="${userInfo eq '탁구'}">on</c:if>">
					<a href="#">
						<img alt="" src="/resources/img/top_icon05.png">
						<p>탁구</p>
					</a>
				</li>
			</ul>
		</div>
	</div>
	<div class="h_bot_wrap">
		<div class="h_bot">
			<ul class="h_bot_list">
				<c:if test="${empty login }">
				<li>
					<a>마이페이지</a>
					<ul>
						<li><a onclick="notlogin();">내 정보</a></li>
						<li><a onclick="notlogin();">팀 정보</a></li>
						<li><a onclick="notlogin();">팀 게시판</a></li>
						<li><a onclick="notlogin();">개인 메세지</a></li>
						<li><a onclick="notlogin();">내가 쓴 게시글</a></li>
						<li><a onclick="notlogin();">내가 쓴 매치글</a></li>
					</ul>
				</li>
				</c:if>
				<c:if test="${login }">
				<li>
					<a>마이페이지</a>
					<ul>
						<li><a href="/mypage/mypageInformation">내 정보</a></li>
						<li><a href="/mypage/teamInformation">팀 정보</a></li>
						<c:if test="${teamYN eq false }">
							<li><a href="#" onclick="javascript:notTeam();">팀 게시판</a></li>
						</c:if>
						<c:if test="${teamYN eq true }">
							<li><a href="/mypage/teamBoard">팀 게시판</a></li>
						</c:if>
						<li><a href="/mypage/mypagepersonalMessage">개인 메세지</a></li>
						<li><a href="/mypage/mypageBoardList">내가 쓴 게시글</a></li>
						<c:if test="${teamYN eq false }">
							<li><a href="#" onclick="javascript:notTeam();">내가 쓴 매치글</a></li>
						</c:if>
						<c:if test="${teamYN eq true }">
							<li><a href="/mypage/mypageMatchList">내가 쓴 매치글</a></li>
						</c:if>
					</ul>
				</li>
				</c:if>
				<c:if test="${empty login }">
				<li>
					<a href="#">매치보드</a>
					<ul>
						<li><a onclick="notlogin();"">매치신청</a></li>
						<li><a onclick="notlogin();"">오늘의 추천 상대</a></li>
					</ul>
				</li>
				
				<li>
					<a href="#">팀</a>
					<ul>
						<li><a onclick="notlogin();">전국 팀 정보</a></li>
					</ul>
				</li>
				</c:if>
				<c:if test="${login }">
				<li>
					<a href="#">매치보드</a>
					<ul>
						<li><a href="/match/matchBoard?selectRegion=0&year=<%=year %>&month=<%=month %>">매치신청</a></li>
						<c:if test="${teamYN eq false }">
							<li><a href="#" onclick="javascript:notTeam();">오늘의 추천 상대</a></li>
						</c:if>
						<c:if test="${teamYN eq true }">
							<li><a href="/match/reommndOpponent">오늘의 추천 상대</a></li>
						</c:if>
						
					</ul>
				</li>
				
				<li>
					<a href="#">팀</a>
					<ul>
						<li><a href="/team/allTeamInformation">전국 팀 정보</a></li>
					</ul>
				</li>
				</c:if>
				<li>
					<a href="/community/noticeList">커뮤니티</a>
					<ul>
						<li><a href="/community/noticeList">공지사항</a></li>
						<li><a href="/community/teamIntroList">팀 가입인사</a></li>
						<li><a href="/community/teamAddList">팀 모집게시판</a></li>
						<li><a href="/community/freeList">자유게시판</a></li>
						<li><a href="/community/reviewList">경기 후기</a></li>
						<li><a href="/community/usedList">중고장터</a></li>
						<li><a href="/community/soccerVideoList">축구동영상</a></li>
					</ul>
				</li>
				<li>
					<a href="#">대회</a>
					<ul>
						<li><a href="/tournament/tournamentRegion">대회 일정</a></li>
					</ul>
				</li>
				<li>
					<a href="#">경기장</a>
					<ul>
						<li><a href="/ground/groundList">경기장 리스트</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</div>


<!-- 로그인  s-->
<div class="h_login login_show">
	<div class="box">
        <div class="head">
        	<p><i class="xi-profile-o"></i>로그인</p>
    		<i class="xi-close"></i>
        </div>
        <form action="/login" method="post" id="login_form" name="login_form">
	        <div class="body">
	            <div class="input"><i class="xi-mail-o"></i><input type="text" placeholder="아이디" id="login_id" name="user_id" value=""></div>
	            <div class="input"><i class="xi-key"></i><input type="password" class="password" placeholder="비밀번호" id="login_pw" name="user_pw"></div>
	            <label class="id_save"><input name="loginChk01" id="loginChk01" type="checkbox">로그인 기억</label>
	            
	            <ul class="menu">
	                <li><a class="find_id_btn">아이디찾기</a></li>
	                <li><span></span></li>
	                <li><a class="find_pw_btn">비밀번호찾기</a></li>
	            </ul>
	            <div class="cb"></div>
	            <button class="button mb10" onclick="login_btn();" style="width: 100%; border: 1px solid #000;">로그인</button><br>
	            <style>
					#kakao-login-btn img{width:100% }	
					.snsbtn_wrap{overflow: hidden}
					.snsbtn{float:left; width: 50%;}
					.snsbtn a{width:100%;}
					.snsbtn a img{width:100%;}            
	            </style>
	            <div class="snsbtn_wrap">
	            	<div class="snsbtn"><a id="kakao-login-btn" class="kko" onclick="login_kko();"></a></div>
	            	<div class="snsbtn" id="naver_id_login" style="text-align:center"><a href="${url}" onclick="naverfuc();"><img src="${pageContext.request.contextPath}/resources/img/네이버 아이디로 로그인_완성형_Green.PNG"/></a></div>
	            </div>
	           <!--  <div class="line"></div>	
	            <ul class="sns">
	                <li class="n"><a class="cp"><i class="xi-naver-square"></i>네이버</a></li>
	                <li class="k"><a class="cp"><i class="xi-kakaotalk"></i>카카오톡</a></li>
	                <li class="f"><a class="cp"><i class="xi-facebook"></i>Facebook</a></li>
	                <li class="g"><a class="cp"><i class="xi-google-plus"></i>Google+</a></li>						
	            </ul>		 -->
	            <div class="line"></div>
	            <div class="join_btn">아직 계정이 없으신가요? <a href="/member/joinStep_1">회원가입 바로가기</a></div>		            
	        </div>
        </form>
    </div>
	<div class="cb"></div>
</div>
<!-- 로그인 e -->

<!-- 아이디 찾기:s -->
<div class="h_login find_id_show">
	<div class="box">
        <div class="head">
        	<p><i class="xi-mail-o"></i>아이디찾기</p>
    		<i class="xi-close" onclick="javascript: $('#findName').val('');$('#findEmail').val('');"></i>
        </div>
    	<div class="body">
        	<div class="input"><i class="xi-user"></i><input type="text" placeholder="이름" id="findName" name="findName" onkeydown="javascript: findEmailEntFunc()"></div>
            <div class="input"><i class="xi-key"></i><input type="text" placeholder="이메일" id="findEmail" name="findEmail" onkeydown="javascript: findEmailEntFunc()"></div>
			<div class="mt20 button " onclick="javascript: findEmailFunc()">확인</div>
        </div>
    </div>
</div>

<div class="h_login find_id_ok_show">
	<div class="box">
        <div class="head">
        	<p><i class="xi-mail-o"></i>아이디찾기</p>
    		<i class="xi-close"></i>
        </div>
    	<div class="body">
        	<p class="tac lh20 f14 c666">가입 시 입력하신 아이디입니다.</p>
			<div id="dixBox">
				<p class="mb20 tac lh20 f16 fb c333"></p>
			</div>
            <div class="mt20 button" onclick="javascript: $('#dixBox').html('')">확인</div>
        </div>
    </div>
</div>
<!-- 아이디찾기:e -->

<!-- 비밀번호찾기:s -->
<div class="h_login find_pw_show">
	<div class="box">
        <div class="head">
        	<p><i class="xi-key"></i>비밀번호찾기</p>
    		<i class="xi-close" onclick="javascript: $('#findEmail').val('')"></i>
        </div>
    	<div class="body">
        	<!--<p class="mb10 lh20 f14 c666">가입 시 입력하신 이메일주소입력</p>-->
			<p class="mb10 lh20 f14 c666">가입 시 사용하신 이메일 주소와 아이디를 입력하시면<br>등록하신 이메일로 비밀번호를 전송해 드립니다.</p>
			<div class="input"><i class="xi-emoticon-smiley-o"></i><input type="text" placeholder="아이디" id="findId" name="findId" onkeydown="javascript: passwdFindEntFunc()"></div>
            <div class="input"><i class="xi-mail-o"></i><input type="text" placeholder="이메일" id="findEmail1" name="findEmail1" onkeydown="javascript: passwdFindEntFunc()"></div>            
            <!--<a class="mt20 button" href="/contents/join/password.html" onclick="javascript: passwdFindFunc()">확인</a>-->
			<a class="mt20 button" onclick="javascript: passwdFindFunc()">확인</a>
        </div>
    </div>
</div>
<!-- 비밀번호찾기:e -->



<!-- 카카오 로그인 s -->
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type='text/javascript'>

var userNickName =null;
    // 사용할 앱의 JavaScript 키를 설정해 주세요.
    Kakao.init('bb438f14804322b4ec156a7f31cd1b46');
    // 카카오 로그인 버튼을 생성합니다.
    Kakao.Auth.createLoginButton({
      container: '#kakao-login-btn',
      success: function(authObj) {
    	  // 로그인 성공시, API를 호출합니다
    	  Kakao.API.request({
    		  url: '/v1/user/me',
    		  success: function(res){
    			  /* alert(JSON.stringify(res)); res에 담겨있는 json 값을 모두 볼수있다 */
        		  alert(res.properties.nickname+'님 환영합니다.');
    		  
    			  // 사용자 정보 가져와서 출력
    			  var userID = res.id;      //유저의 카카오톡 고유 id
    		      userNickName = res.properties.nickname; //유저가 등록한 별명
    		      console.log(userID);
    		      console.log(userNickName);
    		      
    		      $.ajax({
    		          type: "post"
    		          , url: "/kko"
//     		          , data: JSON.stringify(userNickName)
    		          , data: {"userNickName":userNickName, "userID":userID}	         
    		          , dataType: "html"
    		          , success: function (data){
    		        	 location.href="/kko";
    		             console.log("성공");
    		          }
    		       }); 
    		  },
    		   fail: function(err) {
    		   		alert(JSON.stringify(err));
    		   }
    	  });
      },
      fail: function(err) {
         alert(JSON.stringify(err));
      }
    });
</script>
<!-- 카카오 로그인 e -->
<script>
	
	
	$(document).ready(function(){
		// gnb:s
		$('.h_bot_list > li').mouseenter(function(){
			$('> ul',this).slideDown();
			$(this).mouseleave(function(){
				$('> ul',this).slideUp(200)
			})
		})
	});
	function login_btn(){
		if($("#login_id").val()==""){
			alert("아이디를 입력하셔야 합니다.");
			$("#login_id").focus();
		}
		else if($("#login_pw").val()==""){
			alert("비밀번호를 입력하셔야 합니다.");
			$("#login_pw").focus();
		}
		else{
			var login_form = document.getElementById("login_form");
			login_form.action="/login";
			login_form.submit();
		}
		
	}
	
	function notlogin(){
		alert("로그인을 하셔야합니다");
		$(".login_show").stop().fadeIn(200);
		$(".login_show .xi-close").click(function(){
			$(".login_show").stop().fadeOut(200)
		})
	}
	
	$(document).ready(function(){
		// login
		$(".login").click(function(){
			$(".login_show").stop().fadeIn(300)
			$(".login_show .xi-close").click(function(){
				$(".login_show").stop().fadeOut(200)
			})
		})

		// find id
		$(".find_id_btn").click(function(){
			$(".login_show").stop().fadeOut(200)
			$(".find_id_show").stop().fadeIn(300)
			$(".find_id_show .xi-close").click(function(){
				$(".find_id_show").stop().fadeOut(200)
			})
		})
		/*$(".find_id_ok_btn").click(function(){
			$(".find_id_show").stop().fadeOut(200)
			$(".find_id_ok_show").stop().fadeIn(300)
			$(".find_id_ok_show .xi-close").click(function(){
				$(".find_id_ok_show").stop().fadeOut(200)
			})
		})*/

		// find pw
		$(".find_pw_btn").click(function(){
			$(".login_show").stop().fadeOut(200)
			$(".find_pw_show").stop().fadeIn(300)
			$(".find_pw_show .xi-close").click(function(){
				$(".find_pw_show").stop().fadeOut(200)
			})
		})
	});
	
	
	//이메일 찾기 버튼 클릭 :s
	function findEmailFunc(){
		if($("#findName").val()==""){
			alert("이름을 입력하셔야 합니다.");
			$("#findName").focus();
		}else if($("#findEmail").val()==""){
			alert("이메일을 입력하셔야 합니다.");
			$("#findEmail").focus();
		}else{
			$.ajax({
					data:{'name':$("#findName").val(),'email':$("#findEmail").val()},
					url:'/idChk',
					type:"post",
					success:function(data){
						if(data.data != "N"){
							var dataText="";							
							dataText ='<p class="mt20 tac lh20 f16 fb c333">'+data.findid+'</p><br>';								
							
							$("#dixBox").html(dataText);
							$(".find_id_show").stop().fadeOut(200)
							$(".find_id_ok_show").stop().fadeIn(300)
							$(".find_id_ok_show .xi-close, .find_id_ok_show .button").click(function(){
								$(".find_id_ok_show").stop().fadeOut(200)
								$(".login_show").stop().fadeIn(300)
							})
							$("#findName").val("");
							$("#findEmail").val("");
						}else{
							alert("이메일 또는 이름을 다시 확인하세요.");
						}
					}
				});
		}
	}
	//이메일 찾기 버튼 클릭:e

	//이메일 찾기 엔터 클릭 :s
	function findEmailEntFunc(){
		if(event.keyCode==13){
			if($("#findEmail").val()==""){
				alert("이메일을 입력하셔야 합니다.");
				$("#findEmail").focus();
			}else if($("#findPasswd").val()==""){
				alert("이름을 입력하셔야 합니다.");
				$("#findName").focus();
			}else{
				$.ajax({
						data:{'name':$("#findName").val(),'email':$("#findEmail").val()},
						url:'/idChk',
						type:"post",
						success:function(data){
							if(data.data != "N"){
								var dataText="";
								var dataText="";							
								dataText ='<p class="mt20 tac lh20 f16 fb c333">'+data.findid+'</p><br>';	
								$("#dixBox").html(dataText);
								$(".find_id_show").stop().fadeOut(200)
								$(".find_id_ok_show").stop().fadeIn(300)
								$(".find_id_ok_show .xi-close, .find_id_ok_show .button").click(function(){
									$(".find_id_ok_show").stop().fadeOut(200)
									$(".login_show").stop().fadeIn(300)
								})
							}else{
								alert("이름 또는 패스워드를 다시 확인하세요.");
							}
						}
					});
			}
		}
	}
	//이메일 찾기 엔터 클릭:e
	//비밀번호 찾기 버튼 클릭:s
	function passwdFindFunc(){
		if($("#findEmail1").val()==""){
			alert("이메일을 입력하셔야 합니다.");
			$("#findEmail1").focus();
		}else if($("#findId").val()==""){
			alert("아이디를 입력하셔야 합니다.");
			$("#findId").focus();
		}else{
			$.ajax({
				data:{'email':$("#findEmail1").val(),'id':$("#findId").val()},
				url:'/pwChk',
				type:"post",
				success:function(data){
					if(data.data >= 1){						
						 $('#findEmail1').val('');
						 $('#findId').val('');
						 $('.find_pw_show').fadeOut();
						 alert("입력하신 이메일로 메일을 발송하였습니다. 확인해주세요.");
					}else{
						 alert("확인된 정보가 없습니다. 다시 확인해주세요.");
						 $('#findEmail1').val('');
						 $('#findId').val('');
					}
					
				}
			});
		}
	}
	//비밀번호 찾기 버튼 클릭:e
	//비밀번호 찾기 엔터:s
	function passwdFindEntFunc(){
		if(event.keyCode==13){
			if($("#findEmail1").val()==""){
				alert("이메일을 입력하셔야 합니다.");
				$("#findEmail1").focus();
			}else if($("#findId").val()==""){
				alert("아이디를 입력하셔야 합니다.");
				$("#findId").focus();
			}else{
				$.ajax({
					data:{'email':$("#findEmail1").val(),'id':$("#findId").val()},
					url:'/pwChk',
					type:"post",
					success:function(data){						
						if(data.data >= 1){						
							 $('#findEmail1').val('');
							 $('#findId').val('');
							 $('.find_pw_show').fadeOut();
							 alert("입력하신 이메일로 메일을 발송하였습니다. 확인해주세요.");
						}else{
							 alert("확인된 정보가 없습니다. 다시 확인해주세요.");
							 $('#findEmail1').val('');
							 $('#findId').val('');
						}
						
					}
				});
			}
		}
	}
	//비밀번호 찾기 엔터:e

	


</script>

<script type="text/javascript">
var userID = null;
var nickname = null;
//네이버 정보
	$(document).ready(function() {
		var userID = ${result}.response.id;
		var nickname = ${result}.response.nickname;
// 		console.log('nickname :'+nickname);확인
	    $.ajax({
	        type: "post"
	        , url: "/naver"
	        , data: {"nickname":nickname, "userID":userID}	         
	        , dataType: "html"
	        , success: function (data){
	        	location.href="/main"
	           console.log("성공");
	        }
	     });
	  });

</script>

<script>
	function notTeam(){
		alert("팀이 없습니다. 팀을 만들거나 다른 팀에 가입해주세요");
		location.href="/mypage/teamInformation";
	}
</script>