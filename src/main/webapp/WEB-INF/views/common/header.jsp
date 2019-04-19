<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="header">
	<div class="h_top_wrap">
		<div class="h_top">
			<ul>
				<li><a href="#">홈</a></li>
				<li><a href="#" class="login">로그인</a></li>
				<li><a href="/member/joinStep_1">회원가입</a></li>
			</ul>
		</div>
	</div>
	<div class="h_mid_wrap">
		<div class="h_mid">
			<ul>
				<li class="on">
					<a href="#">
						<img alt="" src="/resources/img/top_icon01.png">
						<p>축구</p>
					</a>
				</li>
				<li>
					<a href="#">
						<img alt="" src="/resources/img/top_icon02.png">
						<p>농구</p>
					</a>
				</li>
				<li>
					<a href="#">
						<img alt="" src="/resources/img/top_icon03.png">
						<p>족구</p>
					</a>
				</li>
				<li>
					<a href="#">
						<img alt="" src="/resources/img/top_icon04.png">
						<p>볼링</p>
					</a>
				</li>
				<li>
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
				<li>
					<a href="#">마이페이지</a>
					<ul>
						<li><a href="#">내 정보</a></li>
						<li><a href="#">팀 정보</a></li>
						<li><a href="#">팀 게시판</a></li>
						<li><a href="#">개인메세지</a></li>
						<li><a href="#">내가 쓴 게시글</a></li>
						<li><a href="#">내가 쓴 매치글</a></li>
					</ul>
				</li>
				<li>
					<a href="#">매치보드</a>
					<ul>
						<li><a href="#">매치신청</a></li>
					</ul>
				</li>
				<li>
					<a href="#">팀</a>
					<ul>
						<li><a href="#">전국 팀 정보</a></li>
					</ul>
				</li>
				<li>
					<a href="/community/notice">커뮤니티</a>
					<ul>
						<li><a href="/community/notice">공지사항</a></li>
						<li><a href="#">팀 가입인사</a></li>
						<li><a href="#">팀 모집게시판</a></li>
						<li><a href="#">자유게시판</a></li>
						<li><a href="#">경기 후기</a></li>
						<li><a href="#">중고장터</a></li>
						<li><a href="#">축구동영상</a></li>
					</ul>
				</li>
				<li>
					<a href="#">대회</a>
					<ul>
						<li><a href="#">대회 일정</a></li>
					</ul>
				</li>
				<li>
					<a href="#">경기장</a>
					<ul>
						<li><a href="#">경기장 리스트</a></li>
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
        <form action="" method="post" id="login_form" name="login_form">
	        <div class="body">
	            <div class="input"><i class="xi-mail-o"></i><input type="text" placeholder="아이디" id="login_id" name="login_id" value=""></div>
	            <div class="input"><i class="xi-key"></i><input type="password" class="password" placeholder="비밀번호" id="login_pw" name="login_pw"></div>
	            <label class="id_save"><input name="loginChk01" id="loginChk01" type="checkbox">로그인 기억</label>
	            
	            <ul class="menu">
	                <li><a class="find_id_btn">아이디찾기</a></li>
	                <li><span></span></li>
	                <li><a class="find_pw_btn">비밀번호찾기</a></li>
	            </ul>
	            <div class="cb"></div>
	            <div class="button" onclick="login_btn();">로그인</div>
	           <!--  <div class="line"></div>	
	            <ul class="sns">
	                <li class="n"><a class="cp"><i class="xi-naver-square"></i>네이버</a></li>
	                <li class="k"><a class="cp"><i class="xi-kakaotalk"></i>카카오톡</a></li>
	                <li class="f"><a class="cp"><i class="xi-facebook"></i>Facebook</a></li>
	                <li class="g"><a class="cp"><i class="xi-google-plus"></i>Google+</a></li>						
	            </ul>		 -->
	            <div class="line"></div>
	            <div class="join_btn">아직 계정이 없으신가요? <a href="/join">회원가입 바로가기</a></div>		            
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



<script>
	/* $(document).ready(function(){
		 $(".h_bot_list > li > a").mouseover(function(){
			$(this).siblings("ul").slideDown();
			$(this).parent().siblings().find("ul").slideUp();
		});
		
		$(".h_bot_list > li > ul").mouseleave(function(){
			$(this).slideUp();			
			$(".h_bot_list").mouseleave(function(){
				$(".h_bot_list > li > ul").slideUp();
			})
		});	
	}); */
	
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
						if(data != "N"){
							var dataText="";							
							dataText ='<p class="mt20 tac lh20 f16 fb c333">'+data.user_id+'</p><br>';								
							
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
							if(data != "N"){
								var dataText="";
								var dataText="";							
								dataText ='<p class="mt20 tac lh20 f16 fb c333">'+data.user_id+'</p><br>';	
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
					if(data.chknum >= 1){						
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
						if(data.chknum >= 1){						
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