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
				<p class="title">마이페이지</p>
				<p class="text">내정보</p>
			</div>
		</div>
		<!-- sub_banner e -->
		
		<!-- nav s -->
		<div class="nav_wrap">
			<div class="nav">
				<ul>
					<li><a href="/main"><i class="xi-home"></i></a></li>
					<li>
						<a>마이페이지</a>
					</li>
					<li>
						<a>내정보</a>
					</li>
				</ul>
			</div>
		</div>
		<!-- nav e -->	
		<div id="container">
			<div class="team_form">
				<div class="team_btn_list">
					<ul>
						<li class="on"><a href="/mypage/mypageInformation">내 정보</a></li>
						<li><a href="/mypage/mypagepersonalMessage">개인 메세지</a></li>
						<li><a href="/mypage/mypageBoardList">내가 쓴 게시글</a></li>
						<li><a href="/mypage/mypageMatchList">내가 쓴 매치글</a></li>
					</ul>
				</div>
				<form action="/mypage/mypageInformationUpdate" method="POST">
				<div class="mypage_form mt30">
					<table class="j_table_form1">
						<colgroup>
							<col width="20%">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<td>아이디</td>
								<td>KKKKK</td>
							</tr>
							<tr>
								<td>이름</td>
								<td>김준환</td>
							</tr>
							<tr>
								<td>이메일</td>
								<td><input type="text" name="user_email" id="user_email" class="inputform250"> @ <input type="text" name="" id="" class="inputform250">
									<select name="user_email2" class="selectform2">
										<option value="">직접입력</option>
										<option value="naver.com">naver.com</option>
										<option value="hanmail.net">hanmail.net</option>
										<option value="hanmail.net">nate.com</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>전화번호</td>
								<td>
									<select name="user_phone1" id="user_phone1" class="selectform2">
										<option value="010">010</option>
										<option value="011">011</option>
										<option value="016">016</option>
										<option value="017">017</option>
										<option value="018">018</option>
										<option value="019">019</option>
									</select>
								 - <input type="text" name="user_phone2" id="user_phone2" class="inputform250"> - <input type="text" name="user_phone3" id="user_phone3" class="inputform250">
								</td>
							</tr>
							<tr>
								<% 
									int year = 2019;
									int month = 1;
									int day = 1;
								%>
								<td>생년월일</td>
								<td>
									<select name="year" id="year" class="selectform1">
										<c:forEach var="i" begin="1" end="80">			
										<option><%=year-- %></option>
										</c:forEach>
									</select>
									<select name="month" id="month" class="selectform1">
										<c:forEach var="i" begin="1" end="12">			
										<option><%=month++ %></option>
										</c:forEach>
									</select>
									<select name="day" id="day" class="selectform1">
										<c:forEach var="i" begin="1" end="31">			
										<option><%=day++ %></option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<td>지역</td>
								<td>
									<select name="region" id="region" class="selectform1">											
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
							<tr>
								<td>프로필사진</td>
								<td><input type="file" name="profile" id="profile"></td>
							</tr>
							<tr>
								<td>주 종목</td>
								<td>
									<input type="radio" name="sport" id="scooer" value="scooer"><label for="scooer">축구</label>
									<input type="radio" name="sport" id="bascketball" value="bascketball"><label for="bascketball">농구</label>
									<input type="radio" name="sport" id="jukgu" value="jukgu"><label for="jukgu">족구</label>
									<input type="radio" name="sport" id="bollring" value="bollring"><label for="bollring">볼링</label>
									<input type="radio" name="sport" id="takgu" value="takgu"><label for="takgu">탁구</label>
								</td>
							</tr>
						</tbody>
					</table>
					
					<div class="j_button mt30">
						<ul>
							<li><a href="#" class="btnform0">회원정보 수정</a></li>
							<li><a href="/mypage/mypageInformation" class="btnform0">취소</a></li>
						</ul>
					</div>				
				</div>
				</form>
			</div>
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>