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
					<li><a href="#" class="btnform1">공지사항</a></li>
				</ul>
			</div>
			<div class="main_title">
				<p>공지사항 등록</p>
			</div>
			
			
			<form action="" method="post" id="utf_form">

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
								<td><input type="text" class="inputform100p" name="" id=""	placeholder="제목 입력"></input></td>
							</tr>
							<tr>
								<td><label for="">내용</label></td>
								<td><textarea name="notice_content" id="notice_content"	placeholder="내용 입력" class="textareaform100p"></textarea></td>
							</tr>
							<tr>
								<td>파일첨부</td>
								<td><input type="file" name="" id=""></td>
							</tr>
						</tbody>
					</table>
					<div class="cont_btn1">
						<ul>
							<li>
								<button type="button" id="btnWrite" class="btnform0">등록</button>
							</li>
							<li>

								<a id="btnCancel" class="btnform0" href="/admin/board/notice">취소</a>

							</li>
						</ul>
					</div>
				</div>
			</form>

			
		</div>
		<!--container s-->
	</div>

	
	
</body>
<script type="text/javascript">

    $(function(){
    	var editorConfig = { filebrowserUploadUrl : "/Editor/upload" };
        
        var ck = null;

        window.onload = function(){
            ck = CKEDITOR.replace("notice_content" , editorConfig);
        };
    });



</script>

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