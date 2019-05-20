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
		var nowDate = new Date();//현재 날짜 반환
		
		var year = nowDate.getFullYear();
		var month = nowDate.getMonth()+1;
		var day = nowDate.getDate();
		
		if((day+"").length<2){//한자리이면 앞에 0 붙여줌
			day = "0" +day;
		}
		
		if((month+"").length<2){//한자리이면 앞에 0 붙여줌
			month = "0"+month;
		}
		
		var comNow = year+"/"+month+"/"+day;
		console.log("comNow값:"+comNow);
		console.log("comNow타입:"+typeof comNow);
		//======================== 받은 날짜 ================================
		
		var selectDate = $("#selDate").val();
		var selectHour = $("#selectHours").val();
		var selectMinute = $("#selectMinute").val();
		
	/* 	console.log("selectDate값:"+selectDate);
		console.log("selectHour값:"+selectHour);
		console.log("selectMinute값:"+selectMinute); */
		
		var combineDate = selectDate;
		/* console.log("combineDate값:"+combineDate);
		console.log("combineDate타입:"+typeof combineDate);
		 */
		/* console.log(comNow < combineDate);//true false반환 */
		
		
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
	 }else if(comNow >= combineDate){//지난날짜, 당일날짜는 등록 x
		 alert("지난 날짜, 당일은 매치 등록을 할 수 없습니다.");
		 $("#selDate").focus();
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











