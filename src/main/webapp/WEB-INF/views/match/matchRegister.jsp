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
				<p class="title">매치보드</p>
				<p class="text">매치등록</p>
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
						<a>매치등록</a>
					</li>
				</ul>
			</div>
		</div>
		<!-- nav e -->	
		<div id="container">
			<form method="POST" action="/match/matchRegister">
			<div class="match_wrap">			
				<table class="match_register_table">
					<colgroup>
						<col width="20%">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<td>경기일</td>
							<td>
								<input type="text" name="selDate" id="selDate" placeholder="날짜선택" class="inputform200" readonly>
								<i class="xi-calendar-list" onclick="focusFunc2()"></i>
								<%
									int hh = 0;
									int mm = 0;
								%>
								<select id="selectHours" name="hours" class="selectform1">
									<c:forEach var="i" begin="1" end="24">			
									<option value="<%=hh %>"><%=hh %>시</option>
									<%hh++; %>
									</c:forEach>									
								</select>
								<select id="selectMinute" name="minute" class="selectform1">
									<c:forEach var="i" begin="1" end="12">			
									<option value="<%=mm %>"><%=mm %>분</option>
									<%mm+=5; %>
									</c:forEach>	
								</select>
							</td>
						</tr>
						<tr>
							<td>구장</td>
							<td>
								<input type="text" name="match_ground" id="match_ground" class="inputform200 vm oh1">
								<a href="#" class="ground_change btnform1 vm oh1">구장검색</a>
							</td>
						</tr>
						<tr>
							<td>구장비</td>
							<td>
								<input type="text" name="match_money" id="match_money" class="inputform200">
							</td>
						</tr>						
						<tr>
							<td>유니폼색상</td>
							<td>
								<input type="text" name="match_uniform" id="match_uniform" class="inputform200">
							</td>
						</tr>
						<tr>
							<td>경기가능지역</td>
							<td>
								<input type="text" name="match_region" id="match_region" class="inputform200 vm oh1">
								<a href="#" class="btnform1 vm oh1">검색</a>
							</td>
						</tr>	
						<tr>
							<td>남기는한마디</td>
							<td>
								<textarea name="match_content" id="match_content" class="textareaform100p"></textarea>
							</td>
						</tr>		
					</tbody>
				</table>
				
				<div class="match_btn_list">
					<ul>
						<li><button class="btnform1" id="btnEnroll">등록</button></li>
						<li><a href="/match/matchBoard?selectRegion=0" class="btnform1">목록</a></li>
					</ul>
				</div>
			</div>
			</form>
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
<script>

//datePicker 추가
$( function() {
	$( "#selDate" ).datepicker();
	$( "#selDate" ).datepicker( "option", "dateFormat", "yy/mm/dd" );
	$.datepicker.setDefaults({
        dateFormat: 'yy/mm/dd',
        prevText: '이전 달',
        nextText: '다음 달',
        monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        dayNames: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
        showMonthAfterYear: true,
        yearSuffix: '년'
    });
	

	
});
function focusFunc2(){
	$( "#selDate" ).focus();		
}

$("#btnEnroll").click(function(){
		//====================== 현재 날짜 ============================
		//Date 객체
		var date = new Date();
		
		//1.년, 월, 일
		var fullYear = date.getFullYear();
		var month = date.getMonth();
		var day = date.getDate();
			
		//2.시, 분, 초, 밀리초까지 :: 타입 숫자
		var hours = date.getHours();
		var minutes = date.getMinutes();
		var seconds = date.getSeconds();
		var milsec = date.getMilliseconds();
		
		//3.합치면 문자형 ( 현재 날짜, 현재 시간 분 초 밀리초 )
		var mulDate = fullYear+""+month+""+day+""+hours+""+minutes;
		
		//4.숫자형으로 변환 >> 새 변수로
		var parseMulDate = parseInt(mulDate);
		
		//============================ 선택날짜 =================================
		
		//1.select :: 날짜선택, 시간, 분 숫자형으로 타입 변환
	 /* 	var pDate = $("#selDate").val();//달력에서 선택한 날짜
		var pHour = $("#selectHours").val();//옵션에서 선택한 시간
		var pMinu = $("#selectMinute").val();//옵션에서 선택한 분
		
		//2.선택한 각 변수 date형으로 변환
		var cDate = new Date(pDate);//정해지지 않은 date
		var cHour = new Date(pHour);//표준시 ("사용 ㄱ")
		var cMin = new Date(pMinu);//정해지지 않은 date
		
		var nn = new Date(parseMulDate);
		console.log("aaa"+nn);
		
		//값 및 타입 테스트
		console.log("cDate:"+cDate);
		console.log("cDate타입:"+typeof cDate);
		console.log("cHour:"+cHour);
		console.log("cHour타입:"+typeof cHour);//표준시
		console.log("cMin:"+cMin);
		console.log("cMin타입:"+typeof cMin); */
		console.log("===============================");
	/* 	console.log("내가 사용해야할 myDate:"+myDate);
		console.log("내가 사용해야할 myDate 타입:"+typeof myDate); */
		
		 
		//유효성 검사 다시
		
	if($("#selDate").val()==''){
		alert("날짜를 선택해주세요");
		$("#selDate").focus();
		return false;
	}else if($("#selectHours").val()==0){
		alert("시간을 선택해주세요");
		$("#selectHours").focus();
		return false;
	}else if($("#match_money").val()==''){
		alert("구장비가 없으면 0을 입력해주세요");
		$("#match_money").focus();
		return false;
	}else if($("#match_uniform").val()==''){
		alert("유니폼 색상을 입력해주세요");
		$("#match_uniform").focus();
		return false;
	}else if($("#match_region").val()==''){
		alert("경기가능 지역을 입력해주세요");
		$("#match_region").focus();
		return false;
	}else if($("#match_content").val()==''){
		alert("남기는 한마디를 입력해주세요");
		$("#match_content").focus();
		return false; 
	 }else{
		alert("정말 등록하시겠습니까?");
		return true;
	} 
	
	});  
			
	</script>
	<script>
		$(document).ready(function(){
			$(".ground_change").click(function(e){
				e.preventDefault();
				//화면크기 구하기
				var w = screen.availWidth;
				var h = screen.availHeight;
				
				//팝업 띄우기
				var popup = window.open(
						"",
						"",
						"status=no" //하단 상태바
						+",menubar=no" //상단 메뉴
						+",scrollbars=no" //스크롤바
						+",resizable=no" //사이즈변경
						+",width=1000" //너비
						+",height=600" //높이
						+",left="+(w-500)/2 //x 위치
						+",top="+(h-500)/2 ); //y 위치
				
				//팝업 url 설정
				popup.location = "/ground/groundSearch";
			});
			
			
		})
		function sendData(g_name) {
			$("#match_ground").val(g_name); 
		}
	</script>
</html>











