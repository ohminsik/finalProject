<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			
			
			<form action="/admin/board/write?board_div=${board_div }" method="post" id="utf_form" enctype="multipart/form-data">

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
								<td><input type="text" class="inputform100p" name="board_title" id=""	placeholder="제목 입력"></input></td>
							</tr>
							<c:if test="${board_div eq 10 }">
								<tr>
									<td><label for="">주소</label></td>
									<td>
										<a class="btnform1" onclick="DaumPostcode()">우편번호찾기</a><br>
										<input type="text" id="user_address1" name="user_address1" class="inputform100p" placeholder="우편번호 입력" style="width: 313px" /><br>
										<input type="text" id="user_address2" name="user_address2" class="inputform100p" placeholder="주소 입력" style="width: 400px; margin-top: 5px" /><br>
										<input type="text" id="user_address3" name="user_address3" class="inputform100p" placeholder="경기장 이름 입력" style="width: 400px; margin-top: 5px" />
									</td>
								</tr>
							</c:if>
							<tr>
								<td><label for="">내용</label></td>
								<td><textarea name="board_content" id=""	placeholder="내용 입력" class="textareaform100p"></textarea></td>
							</tr>
							<tr>
								<td>파일첨부</td>
								<td><input type="file" name="file" id="file"></td>
							</tr>
							<tr>
								<td>이미지</td>
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
<!-- 우편 주소 s -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	function DaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
						// 예제를 참고하여 다양한 활용법을 확인해 보세요.
						// 각 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var addr = ''; // 주소 변수
						var extraAddr = ''; // 참고항목 변수
						//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
							addr = data.roadAddress;
						} else { // 사용자가 지번 주소를 선택했을 경우(J)
							addr = data.jibunAddress;
						}
						// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
						if (data.userSelectedType === 'R') {
							// 법정동명이 있을 경우 추가한다. (법정리는 제외)
							// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
							if (data.bname !== ''
									&& /[동|로|가]$/g.test(data.bname)) {
								extraAddr += data.bname;
							}
							// 건물명이 있고, 공동주택일 경우 추가한다.
							if (data.buildingName !== ''
									&& data.apartment === 'Y') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName
										: data.buildingName);
							}
						}
						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('user_address1').value = data.zonecode;
						document.getElementById("user_address2").value = addr;
						// 커서를 상세주소 필드로 이동한다.
					}
				}).open();
	}
</script>
<!-- 우편 주소 e -->
</body>
</html>
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