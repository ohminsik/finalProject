<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:include page="../common/meta.jsp"/>
<body>
	<div id="wrap">
		<div id="container">
			<div class="board_form" style="padding:10px; box-sizing:border-box; margin:20px auto;">
				<form method="GET" action="/ground/groundSearch">
					<div class="search_form">
						<ul>
							<li>
								<input type="text" name="word" id="word" placeholder="구장명을 입력하세요" class="inputform250">
							</li>
							<li><button class="btnform7">검색</button></li>
						</ul>
					</div>
				</form>
			</div>
			<div class="ground_table_wrap">
				<table class="ground_Table">
					<colgroup>
						<col width="20%">
						<col width="*">
						<col width="20%">					
					</colgroup>
					<thead>
						<tr>
							<th>구장명</th>
							<th>구장주소</th>
							<th>선택</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list }" var="list">
						<tr>
							<td>${list.ground_name }</td>
							<td>${list.ground_addr }</td>
							<td>
								<form action="/ground/groundSearch" method="POST">
									<input type="hidden" id="ground_name${list.board_no}" name="ground_name" value="${list.ground_name }">
									<button type="button" onclick="javascript:p_ground(${list.board_no})" class="btnform1">선택</button>
								</form>
							</td>
						</tr>
						</c:forEach>
						<c:if test="${empty list }">
							<tr>
								<td colspan="3">등록된 구장이 없습니다.</td>
							</tr>
						</c:if>
					</tbody>
				</table>
			</div>
			
			<div class="paging_wrap">
			      <c:if test="${paging.totalPage != 0 }">
			         <ul class="list">
			
			            <%-- 이전 페이지 --%>
			            <c:if test="${paging.curPage eq 1 }">
			            </c:if>
			            <c:if test="${paging.curPage ne 1 }">
			               <li><a href="/ground/groundSearch?curPage=${paging.curPage-1}&word=${word}">&lt;</a></li>
			            </c:if>
			
			
			            <%-- 페이징 리스트 --%>
			            <c:forEach begin="${paging.startPage }" end="${paging.endPage }"
			               var="i">
			
			               <c:if test="${paging.curPage eq i}">
			                  <li class="on"><a href="/ground/groundSearch?curPage=${i }&word=${word}">${i }</a></li>
			               </c:if>
			               <c:if test="${paging.curPage ne i}">
			                  <li><a href="/ground/groundSearch?curPage=${i }&word=${word}">${i }</a></li>
			               </c:if>
			            </c:forEach>
			
			            <%-- 다음 페이지 --%>
			            <c:if test="${paging.curPage eq paging.totalPage }">
			            </c:if>
			            <c:if test="${paging.curPage ne paging.totalPage }">
			               <li><a href="/ground/groundSearch?curPage=${paging.curPage+1}&word=${word}">&gt;</a></li>
			            </c:if>
			         </ul>
			    </c:if>
			
			   </div>
		</div>
	</div>
</body>
<script>
	function p_ground(n){
		var g_name = $("#ground_name"+n).val();
		
		$(opener.location).attr("href", "javascript:sendData("+"'"+g_name+"')");
		
		window.self.close();
	}
	
</script>
</html>