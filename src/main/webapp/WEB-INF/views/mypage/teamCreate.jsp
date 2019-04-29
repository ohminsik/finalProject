<!-- 팀정보 페이지 -->
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
				<p class="text">팀정보</p>
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
						<a>팀생성</a>
					</li>
				</ul>
			</div>
		</div>
		<!-- nav e -->	
		<div id="container">
			<div class="team_form">
				<div class="team_btn_list">
					<ul>
						<li class="on"><a href="/mypage/teamInformation">팀 정보</a></li>
						<li><a href="/mypage/teamMatchInfo">팀 매치 정보</a></li>
						<li><a href="#">팀 매치 결과</a></li>
						<li><a href="/mypage/teamBoard">팀 게시판</a></li>
					</ul>
				</div>
				
				<form action="/mypage/teamCreate" method="post" enctype="multipart/form-data">
				<table class="j_table_form mt50">
					<colgroup>
						<col width="20%">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<td>팀 명</td>
							<td><input type="text" name="team_name" id="team_name" class="inputform100p"></td>
						</tr>
						<tr>
							<td>팀 원수</td>
							<td><input type="text" name="team_cnt" id="team_cnt" class="inputform100p"></td>
						</tr>
						<tr>
							<td>팀 지역</td>
							<td>
								<select name="team_region1" id="team_region1" class="selectform1">											
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
								
								<select name="team_region2" id="team_region2" class="selectform1">											
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
							<td>평균연령대</td>
							<td>
								<select name="team_age" id="team_age" class="selectform1">
									<option value="10대">10대</option>
									<option value="20대">20대</option>
									<option value="30대">30대</option>
									<option value="40대">40대</option>
									<option value="50대">50대</option>
									<option value="60대이상">60대이상</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>소속 유형</td>
							<td>								
								<select name="team_type" id="team_type" class="selectform1">											
									<option value="청소년">청소년</option>
									<option value="데학생">대학생</option>
									<option value="직장인">직장인</option>
									<option value="일반동호회">일반동호회</option>
									<option value="여성팀">여성팀</option>
									<option value="기타단체">기타단체</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>팀 실력</td>
							<td>								
								<select name="team_level" id="team_level" class="selectform1">											
									<option value="상">상</option>
									<option value="중">중</option>
									<option value="하">하</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>유니폼 설명</td>
							<td><input type="text" name="team_uniform" id="team_uniform" class="inputform100p"></td>
						</tr>
						<tr>
							<td>활동 구장</td>
							<td>
								※ 주로 경기하는 구장명을 넣어주세요. 검색이 안되면 그냥 입력해주세요.<br>
								<input type="text" name="team_field" id="team_field" class="inputform200 vm mt5">
								<a href="#" class="btnform1 oh1 vm mt5">구장검색</a>
							</td>
						</tr>
						<tr>
							<td>팀 엠블럼</td>
							<td><input type="file" name="file" id="team_mark"></td>
						</tr>
						<tr>
							<td>가입인사<br>(간단한 팀소개)</td>
							<td><input type="text" name="team_hello" id="team_hello" class="inputform100p"></td>
						</tr>
						<tr>
							<td>팀원 정보 공개여부</td>
							<td>
								<input type="radio" name="team_YN" id="gong" value="Y"><label for="gong">공개</label>
								<input type="radio" name="team_YN" id="be"  value="N"><label for="be">비공개</label>
							</td>
						</tr>
					</tbody>
				</table>
				<div class="j_button mt50">
					<button class="btnform0">팀 생성</button>
				</div>
				</form>
			</div>
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>