<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
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
						<a>팀정보</a>
					</li>
				</ul>
			</div>
		</div>
		<!-- nav e -->	
		<div id="container">
			<div class="team_form">
				<div class="team_btn_list">
					<ul>
						<li><a href="/mypage/teamInformation">팀 정보</a></li>
						<li><a href="/mypage/teamMatchInfo">팀 매치 정보</a></li>
						<li><a href="#">팀 매치 결과</a></li>
						<li class="on"><a href="/mypage/teamBoard">팀 게시판</a></li>
					</ul>
				</div>
				
				<div class="board_form">
					<form method="GET" action="/mypage/teamBoard">
						<div class="search_form">
							<ul>
								<li>
									<select name="search_div" class="selectform1">
										<option value="제목">제목</option>
										<option value="내용">내용</option>
										<option value="작성자">작성자</option>
									</select>
								</li>
								<li>
									<input type="text" name="search_word" id="" class="inputform250">
								</li>
								<li><button class="btnform7">검색</button></li>
							</ul>
						</div>
					</form>
					<div class="cb"></div>
					<table class="board_table">
						<colgroup>
							<col width="10%">
							<col width="*">
							<col width="10%">
							<col width="10%">
							<col width="10%">
						</colgroup>
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>글쓴이</th>
								<th>등록일</th>
								<th>조회수</th>
							</tr>
						</thead>
						<tbody>
							<c:set var="tableNum" value="${tableNum}"/>
							<%
								String tableNum = pageContext.getAttribute("tableNum").toString();
								int no = Integer.parseInt(tableNum);
							%>
							<c:if test="${!empty mypageboardList }">
							<c:forEach items="${mypageboardList }" var="mypageboardList">
							<tr>
								<td><%=no-- %></td>
								<td class="title"><a href="/mypage/teamBoardView?board_no=${mypageboardList.board_no }">${mypageboardList.board_title } <span class="fb chs">[ ${mypageboardList.board_reply_cnt } ]</span></a></td>
								<td>${mypageboardList.user_nick }</td>
								<td><fmt:formatDate value="${mypageboardList.board_date }" pattern="yyyy-MM-dd"/></td>
								<td>${mypageboardList.board_cnt } </td>
							</tr>
							</c:forEach>
							</c:if>
							<c:if test="${empty mypageboardList  }">
							<tr>
								<td colspan="5">등록된 내용이 없습니다.</td>
							</tr>
							</c:if>
						</tbody>
					</table>
					
					<div class="j_button fr mt20 mb20">
						<a href="/mypage/teamBoardWrite" class="btnform7">글쓰기</a>
					</div>
					<div class="cb"></div>
					
					<div class="paging_wrap">
				      <c:if test="${paging.totalPage != 0 }">
				         <ul class="list">
				
				            <%-- 이전 페이지 --%>
				            <c:if test="${paging.curPage eq 1 }">
				            </c:if>
				            <c:if test="${paging.curPage ne 1 }">
				               <li><a href="/mypage/teamBoard?cur=${paging.curPage-1}&search_div=${search_div}&search_word=${search_word}">&lt;</a></li>
				            </c:if>
				
				
				            <%-- 페이징 리스트 --%>
				            <c:forEach begin="${paging.startPage }" end="${paging.endPage }"
				               var="i">
				
				               <c:if test="${paging.curPage eq i}">
				                  <li class="on"><a href="/mypage/teamBoard?cur=${i }&search_div=${search_div}&search_word=${search_word}">${i }</a></li>
				               </c:if>
				               <c:if test="${paging.curPage ne i}">
				                  <li><a href="/mypage/teamBoard?cur=${i }&search_div=${search_div}&search_word=${search_word}">${i }</a></li>
				               </c:if>
				            </c:forEach>
				
				            <%-- 다음 페이지 --%>
				            <c:if test="${paging.curPage eq paging.totalPage }">
				            </c:if>
				            <c:if test="${paging.curPage ne paging.totalPage }">
				               <li><a href="/mypage/teamBoard?cur=${paging.curPage+1}&search_div=${search_div}&search_word=${search_word}">&gt;</a></li>
				            </c:if>
				         </ul>
				    </c:if>
				
				   </div>
				</div>
			</div>
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>