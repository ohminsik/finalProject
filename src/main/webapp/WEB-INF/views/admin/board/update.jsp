<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:include page="../../common/adminmeta.jsp" />
<body>
	<div id="wrap">
		<!--header s-->
		<jsp:include page="../../admin/header.jsp" />
		<jsp:include page="../../admin/nav.jsp" />
		<!--header e-->
		<!--container s-->
		<div id="container">
			<div class="main_title">
				<ul class="">
					<li><a href="/admin/board?board_div=1" class="btnform1">공지사항</a></li>
					<li><a href="/admin/board?board_div=2" class="btnform1">팀 가입인사</a></li>
					<li><a href="/admin/board?board_div=3" class="btnform1">팀 모집게시판</a></li>
					<li><a href="/admin/board?board_div=4" class="btnform1">자유게시판</a></li>
					<li><a href="/admin/board?board_div=5" class="btnform1">경기후기</a></li>
					<li><a href="/admin/board?board_div=6" class="btnform1">중고장터</a></li>
					<li><a href="/admin/board?board_div=7" class="btnform1">축구동영상</a></li>
					<li><a href="/admin/board?board_div=8" class="btnform1">팀 게시판</a></li>
					<li><a href="/admin/board?board_div=9" class="btnform1">대회일정</a></li>
					<li><a href="/admin/board?board_div=10" class="btnform1">경기장 리스트</a></li>
				</ul>
			</div>
			<div class="main_title">
				<c:if test="${board_div eq 1 }">
					<p>공지사항 관리</p>
				</c:if>
				<c:if test="${board_div eq 2 }">
					<p>팀가입인사 관리</p>
				</c:if>
				<c:if test="${board_div eq 3 }">
					<p>팀모집게시판 관리</p>
				</c:if>
				<c:if test="${board_div eq 4 }">
					<p>자유게시판 관리</p>
				</c:if>
				<c:if test="${board_div eq 5}">
					<p>경기후기 관리</p>
				</c:if>
				<c:if test="${board_div eq 6 }">
					<p>중고장터 관리</p>
				</c:if>
				<c:if test="${board_div eq 7 }">
					<p>축구동영상 관리</p>
				</c:if>
				<c:if test="${board_div eq 8 }">
					<p>팀게시판 관리</p>
				</c:if>
				<c:if test="${board_div eq 9 }">
					<p>대회일정 관리</p>
				</c:if>
				<c:if test="${board_div eq 10 }">
					<p>경기장리스트 관리</p>
				</c:if>
			</div>
			
			
			<form action="/admin/board/update?board_div=${board_div }&board_no=${board.board_no }" method="post" id="utf_form" enctype="multipart/form-data">

				<div class="table1_wrap">
					<table>
						<colgroup>
							<col width="10%" />
							<col width="*" />
						</colgroup>
						<!--공지사항 수정 s!-->
						<tbody>
						
							<tr>
								<td><label for="">제목</label></td>
								<td><input type="text" class="inputform100p" name="board_title" id=""	placeholder="제목 입력" value="${board.board_title }"></input></td>
							</tr>
							<c:if test="${board_div eq 9 }">
								<tr>
									<td><label for="">신청기간</label></td>
									<td>
										<input type="text" name="con_reg_dates" id="selDate1" value="<fmt:formatDate value="${tournament.con_reg_dates }" pattern="yyyy/MM/dd"/>" class="inputform200" readonly
										placeholder="<fmt:formatDate value="${tournament.con_reg_dates }" pattern="yyyy/MM/dd"/>">
										<i class="xi-calendar-list" onclick="focusFunc1()"></i>
										~
										<input type="text" name="con_reg_datee" id="selDate2" value="<fmt:formatDate value="${tournament.con_reg_datee }" pattern="yyyy/MM/dd"/>" class="inputform200" readonly>
										<i class="xi-calendar-list" onclick="focusFunc2()"></i>
									</td>
								</tr>
								
								<tr>
									<td><label for="">대회기간</label></td>
									<td>
										<input type="text" name="con_con_dates" id="selDate3" value="<fmt:formatDate value="${tournament.con_con_dates }" pattern="yyyy/MM/dd"/>" class="inputform200" readonly>
										<i class="xi-calendar-list" onclick="focusFunc3()"></i>
										~
										<input type="text" name="con_con_datee" id="selDate4" value="<fmt:formatDate value="${tournament.con_con_datee }" pattern="yyyy/MM/dd"/>" class="inputform200" readonly>
										
										<i class="xi-calendar-list" onclick="focusFunc4()"></i>
									</td>
								</tr>
								
								<tr>
									<td><label for="">대회지역</label></td>
									<td>
										<select name="con_region" id="con_region" class="selectform1" >
											<option value="서울">서울</option>
											<option value="인천">인천</option>
											<option value="대전">대전</option>
											<option value="대구">대구</option>
											<option value="울산">울산</option>
											<option value="부산">부산</option>
											<option value="세종">세종</option>
											<option value="광주">광주</option>
											<option value="경기">경기</option>
											<option value="강원">강원</option>
											<option value="충북">충북</option>
											<option value="충남">충남</option>
											<option value="전북">전북</option>
											<option value="전남">전남</option>
											<option value="경북">경북</option>
											<option value="경남">경남</option>
											<option value="제주">제주</option>
										</select>
									</td>
									
								</tr>
							</c:if>
							<tr>
								<td><label for="">내용</label></td>
								<td><textarea name="board_content" id="board_content"	placeholder="내용 입력" class="textareaform100p">${board.board_content }</textarea><img alt="" src="/uploadImg/${photo.photo_stored }"></td>
							</tr>
							<tr>
								<td>파일첨부</td>
								<td><input type="file" name="file" id="file"></td>
							</tr>
							<tr>	
								<td>수정 이미지 미리보기</td>
								<td><img alt="" src="#" id="foo"></td>
							</tr>
						</tbody>
					</table>
					<div class="cont_btn1">
						<ul>
							<li>
								<button id="btnWrite" class="btnform0">등록</button>
							</li>
							<li>

								<a id="btnCancel" class="btnform0" href="javascript:history.back();">취소</a>

							</li>
						</ul>
					</div>
				</div>
			</form>

			
		</div>
		<!--container s-->
	</div>
<script type="text/javascript">
	
	function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function(e) {
                $('#foo').attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }

    $("#file").change(function() {
        readURL(this);
    });
</script>	
	
</body>
</html>
<script type="text/javascript">

$(function(){
	
	var editorConfig = { filebrowserUploadUrl : "/Editor/upload" };
    
    var ck = null;

    window.onload = function(){
        ck = CKEDITOR.replace("board_content" , editorConfig);
    };
});



</script>
<script type="text/javascript">
//datePicker 추가
    $( function() {
    	$( "#selDate1" ).datepicker();
    	$( "#selDate1" ).datepicker( "option", "dateFormat", "yy/mm/dd" );
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
    function focusFunc1(){
    	$( "#selDate1" ).focus();		
    }
    
    $( function() {
    	$( "#selDate2" ).datepicker();
    	$( "#selDate2" ).datepicker( "option", "dateFormat", "yy/mm/dd" );
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
    	$( "#selDate2" ).focus();		
    }
    
    $( function() {
    	$( "#selDate3" ).datepicker();
    	$( "#selDate3" ).datepicker( "option", "dateFormat", "yy/mm/dd" );
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
    function focusFunc3(){
    	$( "#selDate3" ).focus();		
    }
    
    $( function() {
    	$( "#selDate4" ).datepicker();
    	$( "#selDate4" ).datepicker( "option", "dateFormat", "yy/mm/dd" );
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
    function focusFunc4(){
    	$( "#selDate4" ).focus();		
    }
    

</script>	

<style>
/*관리자 1:1문의페이지*/
.table1_wrap {
	background: #fff;
	height: 100%;
	border: 1px solid #dbdde2;
	margin-left: 25px;
	margin-right: 25px;
	padding: 12px 25px;
	box-sizing: border-box;
	margin-top: 25px;
	overflow: hidden;
}

table {
	width: 100%;
	max-height: 100%;
}

table thead tr td:first-child {
	background: #f8f9fd;
	text-align: center;
}

table thead tr td {
	border: 1px solid #dbdde2;
	color: #6d6d6d;
	padding: 10px 5px;
	text-align: left;
}

table tbody tr td {
	max-height: 100%;
	border: 1px solid #dbdde2;
	color: #6d6d6d;
	padding: 10px 5px;
	text-align: left;
}

table tbody tr td:first-child {
	background: #f8f9fd;
	text-align: center;
}

table tbody tr td textarea {
	width: 100%;
	height: 300px;
	border: 1px solid #e1e1e1;
	color: #333;
	padding: 20px;
	box-sizing: border-box;
}

table thead tr td textarea {
	width: 100%;
	height: 45px;
	border: 1px solid #e1e1e1;
	color: #333;
	padding: 13px;
	box-sizing: border-box;
}

.selectbox {
	
}

.cont_btn1 {
	width: 100%;
	height: 100%;
	max-width: 1240px;
	margin: 35px auto;
	padding: 0 3px;
}

.cont_btn1 ul {
	text-align: center;
}

.cont_btn1 ul li {
	display: inline-block;
}



.menuuuuuu {
	
}

.menuuuuuu li {
	margin-bottom: 20px;
}

.menuuuuuu li p {
	font-size: 20px;
}

.menuuuuuu li p span {
	font-size: 20px;
}
</style>