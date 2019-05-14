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
				<p class="title">팀</p>
				<p class="text">전국 팀 정보</p>
			</div>
		</div>
		<!-- sub_banner e -->
		
		<!-- nav s -->
		<div class="nav_wrap">
			<div class="nav">
				<ul>
					<li><a href="/main"><i class="xi-home"></i></a></li>
					<li>
						<a>팀</a>
					</li>
					<li>
						<a>전국 팀 정보</a>
					</li>
				</ul>
			</div>
		</div>
		
		<!-- nav e -->	
		<div id="container">
			<div class="board_form">
				
					<div class="search_form">
					<form method="GET" action="/team/allTeamInformationRegion" id="allTeamInformationRegion">
						<ul>
							<li>
								<select name="region" class="selectform1" id="regionSelect" onchange="javascript:searchRegion();">
									<option value="">전체</option>
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
							</li>
						</ul>
					</form>
					
					<form method="GET" action="/team/allTeamInformationAge" id="allTeamInformationAge">
						<ul>
							<li>
								<select name="age" class="selectform1" id="ageSelect" onchange="javascript:searchAge();">
									<option value="">전체연령</option>
									<option value="10대">10대</option>
									<option value="20대">20대</option>
									<option value="30대">30대</option>
									<option value="40대">40대</option>
									<option value="50대">50대</option>
									<option value="60대이상">60대이상</option>
								</select>
							</li>
						</ul>
					</form>
					<form method="GET" action="/team/allTeamInformationType" id="allTeamInformationType">
						<ul>
							<li>
								<select name="type" class="selectform1" id="typeSelect" onchange="javascript:searchType();">
									<option value="">소속유형</option>
									<option value="청소년">청소년</option>
									<option value="대학생">대학생</option>
									<option value="직장인">직장인</option>
									<option value="일반동호회">일반동호회</option>
									<option value="여성팀">여성팀</option>
									<option value="기타단체">기타단체</option>
								</select>
							</li>
						</ul>
					</form>
					<form method="GET" action="/team/allTeamInformation">
						<ul>
							<li>
								<input type="text" name="word" id="" class="inputform250" placeholder="팀명을 입력해주세요">
							</li>
							<li><button class="btnform7">검색</button></li>
							<li><button type="reset" class="btnform8">초기화</button></li>
						</ul>
					</form>
					</div>
				
				<div class="cb"></div>
				<table class="board_table">
					<colgroup>
						<col width="10%">
						<col width="20%">
						<col width="15%">
						<col width="*">
						<col width="*">
						<c:if test="${teamYN eq false }">
							<col width="10%">
						</c:if>
					</colgroup>
					<thead>
						<tr>
							<th>순위</th>
							<th>팀명</th>
							<th>점수</th>
							<th colspan="2">팀정보</th>
							<c:if test="${teamYN eq false }">
								<th>가입신청</th>
							</c:if>
						</tr>
					</thead>
					<tbody>
						<c:set var="tableNum" value="${tableNum}"/>
							<%
								String tableNum = pageContext.getAttribute("tableNum").toString();
								int no = Integer.parseInt(tableNum);
							%>
						<c:forEach items="${list }" var="list">
						<tr>
							<td><%=no++ %></td>
							<td>${list.team_name }</td>
							<td>${list.team_rating }</td>
							<td>
								지역 : ${list.team_region }<br>
								연령대 : ${list.team_age }<br>
								실력 : ${list.team_level }
							</td>
							<td>
								소속유형 : ${list.team_type }<br>
								팀원수 : ${list.team_cnt }명<br>
								경기수 : ${list.team_etire }
							</td>
							<c:if test="${teamYN eq false }">
								<td>
									<form action="/mypage/teamApplyInsert" method="POST">
										<input type="hidden" id="team_no" name="team_no" value="${list.team_no }">
										<button type="button" onclick="teamApply(${list.team_no });" class="btnform1">가입신청</button>
									</form> 
								</td>
							</c:if>
						</tr>
						</c:forEach>
						<c:if test="${empty list }">
						<tr>
							<td colspan="5">등록된 팀이 없습니다.</td>
						</tr>
						</c:if>
					</tbody>
				</table>

				<div class="cb"></div>
				
				<div class="paging_wrap">
			      <c:if test="${paging.totalPage != 0 }">
			         <ul class="list">
			
			            <%-- 이전 페이지 --%>
			            <c:if test="${paging.curPage eq 1 }">
			            </c:if>
			            <c:if test="${paging.curPage ne 1 }">
			               <li><a href="/team/allTeamInformation?cur=${paging.curPage-1}&search_div=${search_div}&search_word=${search_word}">&lt;</a></li>
			            </c:if>
			
			
			            <%-- 페이징 리스트 --%>
			            <c:forEach begin="${paging.startPage }" end="${paging.endPage }"
			               var="i">
			
			               <c:if test="${paging.curPage eq i}">
			                  <li class="on"><a href="/team/allTeamInformation?cur=${i }&search_div=${search_div}&search_word=${search_word}">${i }</a></li>
			               </c:if>
			               <c:if test="${paging.curPage ne i}">
			                  <li><a href="/team/allTeamInformation?cur=${i }&search_div=${search_div}&search_word=${search_word}">${i }</a></li>
			               </c:if>
			            </c:forEach>
			
			            <%-- 다음 페이지 --%>
			            <c:if test="${paging.curPage eq paging.totalPage }">
			            </c:if>
			            <c:if test="${paging.curPage ne paging.totalPage }">
			               <li><a href="/team/allTeamInformation?cur=${paging.curPage+1}&search_div=${search_div}&search_word=${search_word}">&gt;</a></li>
			            </c:if>
			         </ul>
			    </c:if>
			
			   </div>
			</div>
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
<script>
	function searchRegion(n){
		var consultForm = document.getElementById('allTeamInformationRegion');
		consultForm.action="/team/allTeamInformationRegion";
		consultForm.submit();
	}
	
	function searchAge(n){
		var consultForm = document.getElementById('allTeamInformationAge');
		consultForm.action="/team/allTeamInformationAge";
		consultForm.submit();
	}
	
	function searchType(n){
		var consultForm = document.getElementById('allTeamInformationType');
		consultForm.action="/team/allTeamInformationType";
		consultForm.submit();
	}
	
	function viewYnSearchFunc(){
		var region = $("#regionSelect").val();
		searchRegion(region);
		
		var age = $("#ageSelect").val();
		searchAge(age);
		
		var type = $("#typeSelect").val();							
		searchType(type);						
		
	}
	
	function teamApply(n) {
		$.ajax({
			type : "post",
			data : {
				team_no : n
			},
			url : "/mypage/teamApplyInsert",
			success : function(data) {
				alert(data.teamName);
			}
		});
		
	    
	}
</script>
</html>