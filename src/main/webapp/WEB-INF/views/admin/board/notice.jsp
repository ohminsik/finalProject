<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
					<li><a href="/admin/board?board_div=1" class="btnform1">공지사항</a></li>
					<li><a href="/admin/board?board_div=2" class="btnform1">팀 가입인사</a></li>
					<li><a href="/admin/board?board_div=3" class="btnform1">팀 모집게시판</a></li>
					<li><a href="/admin/board?board_div=4" class="btnform1">자유게시판</a></li>
					<li><a href="/admin/board?board_div=5" class="btnform1">경기후기</a></li>
					<li><a href="/admin/board?board_div=6" class="btnform1">중고장터</a></li>
					<li><a href="/admin/board?board_div=7" class="btnform1">축구동영상</a></li>
					<li><a href="/admin/board?board_div=8" class="btnform1">팀 게시판</a></li>
					<li><a href="/admin/board?board_div=9" class="btnform1">대회일정</a></li>
					<li><a href="/admin/board?board_div=10" class="btnform1">경기장 리스트</a></li>
				</ul>
			</div>
			<div class="main_title">
				<c:if test="${board_div eq 1 }">
					<p>공지사항 관리</p>
				</c:if>
				<c:if test="${board_div eq 2 }">
					<p>팀가입인사 관리</p>
				</c:if>
				<c:if test="${board_div eq 3 }">
					<p>팀모집게시판 관리</p>
				</c:if>
				<c:if test="${board_div eq 4 }">
					<p>자유게시판 관리</p>
				</c:if>
				<c:if test="${board_div eq 5}">
					<p>경기후기 관리</p>
				</c:if>
				<c:if test="${board_div eq 6 }">
					<p>중고장터 관리</p>
				</c:if>
				<c:if test="${board_div eq 7 }">
					<p>축구동영상 관리</p>
				</c:if>
				<c:if test="${board_div eq 8 }">
					<p>팀게시판 관리</p>
				</c:if>
				<c:if test="${board_div eq 9 }">
					<p>대회일정 관리</p>
				</c:if>
				<c:if test="${board_div eq 10 }">
					<p>경기장리스트 관리</p>
				</c:if>
				
			</div>

			<div class="category_wrap">
			<form action="/admin/board?board_div=${board_div }" method="get">
				<ul class="ul_form1">
					<li><select name="search" title="" class="selectform1">
							<option value="board_title" selected="selected">제목</option>
							<option value="board_content">내용</option>
							<option value="board_title+board_content">제목 + 내용</option>
					</select></li>
					<li><input type="text" class="inputform150" title="" value="" name="word" /></li>
					<li><button class="btnform1">검색</button></li>
					<li><a href="/admin/board?board_div=${board_div }" class="btnform2">전체보기</a></li>
				</ul>
			</form>
				<ul class="ul_form2">
					<li><a href="/admin/board/write?board_div=${board_div }" class="btnform3">등록</a></li>
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
					<c:forEach items="${list }" var="l">
						<tr>
							<td><input type="checkbox" name="check2" id="check22" value="" /><label for="check2"></label></td>
							<td>${l.board_no }</td>
							<td>${l.board_title }<span class="fb chs">[ ${l.board_reply_cnt } ]</span></td>
							<td>${l.board_content }</td>
							<td><fmt:formatDate value="${l.board_date }" pattern="yyyy-MM-dd"></fmt:formatDate></td>
							<td>${l.board_cnt }</td>
							<td><c:if test="${l.delete_yn.equals('Y') }">삭제</c:if>
								<c:if test="${l.delete_yn.equals('N') }">존재</c:if></td>
							<td>
								<a class="btnform5">수정</a>
								<a class="btnform6" href="/admin/boardDelete?board_no=${l.board_no }&board_div=${board_div}" onclick="return deletee();">삭제</a>
							</td>
						</tr>
					</c:forEach>		
					<c:if test="${totalCount eq 0 }">				
						<tr>
							<td colspan="8">등록된 게시물이 없습니다.</td>
						</tr>					
					</c:if>
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
				               <li><a href="/admin/board?board_div=${board_div }&curPage=${paging.curPage-1}&search=${search}&word=${word}">&lt;</a></li>
				            </c:if>
				
				
				            <%-- 페이징 리스트 --%>
				            <c:forEach begin="${paging.startPage }" end="${paging.endPage }"
				               var="i">
				
				               <c:if test="${paging.curPage eq i}">
				                  <li class="on"><a href="/admin/board?board_div=${board_div }&curPage=${i }&search=${search}&sword=${word}">${i }</a></li>
				               </c:if>
				               <c:if test="${paging.curPage ne i}">
				                  <li><a href="/admin/board?board_div=${board_div }&curPage=${i }&search=${search}&word=${word}">${i }</a></li>
				               </c:if>
				            </c:forEach>
				
				            <%-- 다음 페이지 --%>
				            <c:if test="${paging.curPage eq paging.totalPage }">
				            </c:if>
				            <c:if test="${paging.curPage ne paging.totalPage }">
				               <li><a href="/admin/board?board_div=${board_div }&curPage=${paging.curPage+1}&search=${search}&word=${word}">&gt;</a></li>
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

		function deletee() {
			if (confirm("게시글을 삭제하겠습니까?")) {
				var board_no = "${l.board_no }";
				alert("삭제되었습니다");
			} else {
				return false;
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
.paging_wrap ul li {
    display: inline-block;
}
</style>