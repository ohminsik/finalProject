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
								<input type="text" name="" id="" placeholder="날짜선택" class="inputform200">
								<i class="xi-calendar-list"></i>
								<%
									int hh = 0;
									int mm = 0;
								%>
								<select name="" class="selectform1">
									<c:forEach var="i" begin="1" end="24">			
									<option value="<%=hh %>"><%=hh %>시</option>
									<%hh++; %>
									</c:forEach>									
								</select>
								<select name="" class="selectform1">
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
								<input type="text" name="" id="" class="inputform200 vm oh1">
								<a href="#" class="btnform1 vm oh1">구장검색</a>
							</td>
						</tr>
						<tr>
							<td>구장비</td>
							<td>
								<input type="text" name="" id="" class="inputform200">
							</td>
						</tr>						
						<tr>
							<td>유니폼색상</td>
							<td>
								<input type="text" name="" id="" class="inputform200">
							</td>
						</tr>
						<tr>
							<td>경기가능지역</td>
							<td>
								<input type="text" name="" id="" class="inputform200 vm oh1">
								<a href="#" class="btnform1 vm oh1">검색</a>
							</td>
						</tr>	
						<tr>
							<td>남기는한마디</td>
							<td>
								<textarea name="" id="" class="textareaform100p"></textarea>
							</td>
						</tr>		
					</tbody>
				</table>
				
				<div class="match_btn_list">
					<ul>
						<li><button class="btnform1">등록</button></li>
						<li><a href="/match/matchBoard" class="btnform1">목록</a></li>
					</ul>
				</div>
			</div>
			</form>
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>