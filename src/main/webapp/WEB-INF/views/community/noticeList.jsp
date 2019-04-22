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
				<p class="text">공지사항</p>
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
						<a>공지사항</a>
					</li>
				</ul>
			</div>
		</div>
		<!-- nav e -->	
		<div id="container">
			<div class="board_form">
				<form method="GET" action="/community/noticeList">
					<div class="search_form">
						<ul>
							<li>
								<select name="" class="selectform1">
									<option value="제목">제목</option>
									<option value="내용">내용</option>
									<option value="작성자">작성자</option>
								</select>
							</li>
							<li>
								<input type="text" name="" id="" class="inputform250">
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
						<tr>
							<td>1</td>
							<td class="title"><a href="/community/noticeView">제목이다</a></td>
							<td>글쓴이다</td>
							<td>등록일이다</td>
							<td>조회수다</td>
						</tr>
						<tr>
							<td colspan="5">등록된 내용이 없습니다.</td>
						</tr>
					</tbody>
				</table>
				
				<div class="j_button fr mt20 mb20">
					<a href="/community/noticeWrite" class="btnform7">글쓰기</a>
				</div>
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