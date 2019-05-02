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
			<div class="board_form">
				<form method="GET" action="/community/soccerVideoList">
					<div class="search_form">
						<ul>
							<li>
								<select name="search" class="selectform1">
									<option value="board_title">제목</option>
									<option value="board_content">내용</option>
									<option value="user_nick">작성자</option>
								</select>
							</li>
							<li>
								<input type="text" name="word" id="" class="inputform250">
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
						<col width="20%">
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
						<c:forEach items="${list }" var="i">
							<c:if test="${ i.delete_yn eq 'N'}">
								<tr>
									<td><%=no-- %></td>
									<td class="title"><a href="/community/soccerVideoView?board_no=${i.board_no }">${i.board_title }<span class="fb chs">[ ${i.board_reply_cnt } ]</span></a></td>
									<td>${i.user_nick }</td>
									<td><fmt:formatDate value="${i.board_date }" pattern="yyyy-MM-dd"></fmt:formatDate></td>
									<td>${i.board_cnt }</td>
								</tr>
							</c:if>
							
						</c:forEach>
						<c:if test="${totalCount eq 0}">
							<tr>
								<td colspan="5">등록된 내용이 없습니다.</td>
							</tr>
						</c:if>	
					</tbody>
				</table>
				
				<div class="j_button fr mt20 mb20">
						<c:if test="${empty login }">
							<a href="#" class="btnform7" onclick="notlogin();">글쓰기</a>
						</c:if>
						<c:if test="${login }">
							<a href="/community/soccerVideoWrite" class="btnform7">글쓰기</a>
						</c:if>
				</div>
				
					
				<div class="paging_wrap">
			      <c:if test="${paging.totalPage != 0 }">
			         <ul class="list">
			
			            <%-- 이전 페이지 --%>
			            <c:if test="${paging.curPage eq 1 }">
			            </c:if>
			            <c:if test="${paging.curPage ne 1 }">
			               <li><a href="/community/soccerVideoList?curPage=${paging.curPage-1}&search=${search}&word=${word}">&lt;</a></li>
			            </c:if>
			
			
			            <%-- 페이징 리스트 --%>
			            <c:forEach begin="${paging.startPage }" end="${paging.endPage }"
			               var="i">
			
			               <c:if test="${paging.curPage eq i}">
			                  <li class="on"><a href="/community/soccerVideoList?curPage=${i }&search=${search}&word=${word}">${i }</a></li>
			               </c:if>
			               <c:if test="${paging.curPage ne i}">
			                  <li><a href="/community/soccerVideoList?curPage=${i }&search=${searc}&word=${word}">${i }</a></li>
			               </c:if>
			            </c:forEach>
			
			            <%-- 다음 페이지 --%>
			            <c:if test="${paging.curPage eq paging.totalPage }">
			            </c:if>
			            <c:if test="${paging.curPage ne paging.totalPage }">
			               <li><a href="/community/soccerVideoList?curPage=${paging.curPage+1}&search=${search}&word=${word}">&gt;</a></li>
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