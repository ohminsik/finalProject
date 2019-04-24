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
				<form method="GET" action="/team/allTeamInformation">
					<div class="search_form">
						<ul>
							<li>
								<select name="" class="selectform1">
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
							<li>
								<select name="" class="selectform1">
									<option value="">전체연령</option>
									<option value="10대">10대</option>
									<option value="20대">20대</option>
									<option value="30대">30대</option>
									<option value="40대">40대</option>
									<option value="50대">50대</option>
									<option value="60대이상">60대이상</option>
								</select>
							</li>
							<li>
								<select name="" class="selectform1">
									<option value="">소속유형</option>
									<option value="청소년">청소년</option>
									<option value="데학생">대학생</option>
									<option value="직장인">직장인</option>
									<option value="일반동호회">일반동호회</option>
									<option value="여성팀">여성팀</option>
									<option value="기타단체">기타단체</option>
								</select>
							</li>
							<li>
								<input type="text" name="" id="" class="inputform250" placeholder="팀명을 입력해주세요">
							</li>
							<li><button class="btnform7">검색</button></li>
							<li><button type="reset" class="btnform8">초기화</button></li>
						</ul>
					</div>
				</form>
				<div class="cb"></div>
				<table class="board_table">
					<colgroup>
						<col width="10%">
						<col width="20%">
						<col width="15%">
						<col width="27.5%">
						<col width="*">
					</colgroup>
					<thead>
						<tr>
							<th>순위</th>
							<th>팀명</th>
							<th>점수</th>
							<th colspan="2">팀정보</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>FC 김준환</td>
							<td>1503</td>
							<td>
								지역 : 서울-강남<br>
								연령대 : 20대<br>
								실력 : 하
							</td>
							<td>
								소속유형 : 대학생<br>
								팀원수 : 19명<br>
								경기유형 : 축구
							</td>
						</tr>
						<tr>
							<td colspan="5">등록된 팀이 없습니다.</td>
						</tr>
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
			               <li><a href="/board/list?cur=${paging.curPage-1}&search_div=${search_div}&search_word=${search_word}">&lt;</a></li>
			            </c:if>
			
			
			            <%-- 페이징 리스트 --%>
			            <c:forEach begin="${paging.startPage }" end="${paging.endPage }"
			               var="i">
			
			               <c:if test="${paging.curPage eq i}">
			                  <li class="on"><a href="/board/list?cur=${i }&search_div=${search_div}&search_word=${search_word}">${i }</a></li>
			               </c:if>
			               <c:if test="${paging.curPage ne i}">
			                  <li><a href="/board/list?cur=${i }&search_div=${search_div}&search_word=${search_word}">${i }</a></li>
			               </c:if>
			            </c:forEach>
			
			            <%-- 다음 페이지 --%>
			            <c:if test="${paging.curPage eq paging.totalPage }">
			            </c:if>
			            <c:if test="${paging.curPage ne paging.totalPage }">
			               <li><a href="/board/list?cur=${paging.curPage+1}&search_div=${search_div}&search_word=${search_word}">&gt;</a></li>
			            </c:if>
			         </ul>
			    </c:if>
			
			   </div>
			</div>
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>