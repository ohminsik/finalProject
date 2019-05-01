<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:include page="../../common/adminmeta.jsp" />
<body>
	<div id="wrap">
		<!--header s-->
		<jsp:include page="../../admin/header.jsp" />
		<jsp:include page="../../admin/nav.jsp" />
		<!--header e-->
		<!--container s-->
		<div id="container">
			<div class="main_title">
				<ul class="">
					<li><a href="#" class="btnform1">공지사항</a></li>
				</ul>
			</div>
			<div class="main_title">
				<p>공지사항 관리</p>
			</div>

			<div class="category_wrap">
			<form action="/admin/board/notice" method="get">
				<ul class="ul_form1">
					<li><select name="search_div" title="" class="selectform1">
							<option value="notice_title" selected="selected">제목</option>
							<option value="notice_text">내용</option>
							<option value="notice_title+notice_text">제목 + 내용</option>
					</select></li>
					<li><input type="text" class="inputform150" title="" value="" name="search_word" /></li>
					<li><button type='submit' class="btnform1">검색</button></li>
					<li><a href="/admin/board/notice" class="btnform2">전체보기</a></li>
				</ul>
			</form>
				<ul class="ul_form2">
					<li><a href="/admin/board/noticeWrite" class="btnform3">등록</a></li>
					<li><a href="#" class="btnform4">삭제</a></li>
				</ul>
			</div>


			<div class="table_wrap">
				<table>
					<colgroup>
						<col width="5%" />
						<col width="10%" />
						<col width="15%" />
						<col width="*%" />
						<col width="10%" />
						<col width="5%" />
						<col width="5%" />
						<col width="10%" />
					</colgroup>
					<thead>
						<tr>
							<th><input type="checkbox" name="Allcheck" id="check1" onclick="Allcheck();" /><label for="check1"></label></th>
							<th>NO</th>
							<th>제목</th>
							<th>내용</th>
							<th>등록일</th>
							<th>조회</th>
							<th>삭제구분</th>
							<th>편집</th>
						</tr>
					</thead>
					<tbody>

						<tr>
							<td><input type="checkbox" name="check2" id="check22" value="" /><label for="check2"></label></td>
							<td>NO</td>
							<td>제목</td>
							<td>내용</td>
							<td>등록일</td>
							<td>조회</td>
							<td>삭제구분</td>
							<td>
								<a class="btnform5">수정</a>
								<a class="btnform6">삭제</a>
							</td>
						</tr>						
						<tr>
							<td colspan="8">등록된 게시물이 없습니다.</td>
						</tr>					

					</tbody>
				</table>

				<!-- 페이징 리스트  시작 -->
				<div class="paging_wrap">
				      <c:if test="${paging.totalPage != 0 }">
				         <ul class="list">
				
				            <%-- 이전 페이지 --%>
				            <c:if test="${paging.curPage eq 1 }">
				            </c:if>
				            <c:if test="${paging.curPage ne 1 }">
				               <li><a href="/admin/board/notice?cur=${paging.curPage-1}&search_div=${search_div}&search_word=${search_word}">&lt;</a></li>
				            </c:if>
				
				
				            <%-- 페이징 리스트 --%>
				            <c:forEach begin="${paging.startPage }" end="${paging.endPage }"
				               var="i">
				
				               <c:if test="${paging.curPage eq i}">
				                  <li class="on"><a href="/admin/board/notice?cur=${i }&search_div=${search_div}&search_word=${search_word}">${i }</a></li>
				               </c:if>
				               <c:if test="${paging.curPage ne i}">
				                  <li><a href="/admin/board/notice?cur=${i }&search_div=${search_div}&search_word=${search_word}">${i }</a></li>
				               </c:if>
				            </c:forEach>
				
				            <%-- 다음 페이지 --%>
				            <c:if test="${paging.curPage eq paging.totalPage }">
				            </c:if>
				            <c:if test="${paging.curPage ne paging.totalPage }">
				               <li><a href="/admin/board/notice?cur=${paging.curPage+1}&search_div=${search_div}&search_word=${search_word}">&gt;</a></li>
				            </c:if>
				         </ul>
				    </c:if>
				
				   </div>
				<!-- 페이징 리스트 끝 -->
			</div>
		</div>
		<!--container s-->
	</div>

	<!-- type="text/javascript -->
	<script>

		function Allcheck() {
			if ($("#check1").is(':checked')) {
				$("input[name=check2]").prop("checked", true);
			} else {
				$("input[name=check2]").prop("checked", false);
			}

		}

	</script>
</body>
</html>
<style>
.menuuuuuu {
	
}

.menuuuuuu li {
	margin-bottom: 20px;
}

.menuuuuuu li p {
	font-size: 20px;
}

.menuuuuuu li p span {
	font-size: 20px;
}
</style>