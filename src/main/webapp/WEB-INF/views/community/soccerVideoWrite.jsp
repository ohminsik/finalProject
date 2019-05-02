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
				<p class="title">커뮤니티</p>
				<p class="text">축구 동영상</p>
			</div>
		</div>
		<!-- sub_banner e -->
		
		<!-- nav s -->
		<div class="nav_wrap">
			<div class="nav">
				<ul>
					<li><a href="/main"><i class="xi-home"></i></a></li>
					<li>
						<a>커뮤니티</a>
					</li>
					<li>
						<a>축구 동영상</a>
					</li>
				</ul>
			</div>
		</div>
		<!-- nav e -->	
		<div id="container">
			<form action="/community/soccerVideoWrite" method="POST" >
				<div class="board_form">
					<table class="board_table board_table1">
						<colgroup>
							<col width="10%">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<td>제목</td>
								<td><input type="text" name="board_title" id="board_title" class="inputform100p"></td>
							</tr>
							<tr>
								<td>내용</td>
								<td><textarea name="board_content" id="board_content" class="textareaform100p"></textarea></td>								
							</tr>
							<tr>
								<td>링크<p style="color : red;">(필수 입력)</p></td>
								<td><input type="text" name="movie_address" id="movie_address" class="inputform100p" value=""></td>
							</tr>
						</tbody>
					</table>
					<div class="j_button mt20 mb20 tac">
						<button class="btnform7">등록</button>
						<a href="javascript:history.back();"class="btnform7">목록</a>
					</div>
				</div>
				
				
			</form>
		</div>

		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>