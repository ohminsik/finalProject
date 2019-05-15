<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:include page="../common/meta.jsp"/>
<body>
	<div id="wrap">
		<jsp:include page="../common/header.jsp"/>	
		<!-- sub_banner s -->
		<div class="sub_banner">
			<span class="bg"></span>
			<div class="textBox">
				<p class="title">경기장</p>
				<p class="text">경기장 리스트</p>
			</div>
		</div>
		<!-- sub_banner e -->
		
		<!-- nav s -->
		<div class="nav_wrap">
			<div class="nav">
				<ul>
					<li><a href="/main"><i class="xi-home"></i></a></li>
					<li>
						<a>경기장</a>
					</li>
					<li>
						<a>경기장 리스트</a>
					</li>
				</ul>
			</div>
		</div>
		<!-- nav e -->	
		<div id="container">
			<div class="ground_wrap">
				<ul class="tournament_region_ul">
					<li><a href="/ground/groundList" class="btnform3 <c:if test="${empty region }">on</c:if>">전체</a></li>
					<li><a href="/ground/groundList?region=서울" class="btnform3 <c:if test="${region == '서울' }">on</c:if>">서울</a></li>
					<li><a href="/ground/groundList?region=인천" class="btnform3 <c:if test="${region == '인천' }">on</c:if>">인천</a></li>
					<li><a href="/ground/groundList?region=대전" class="btnform3 <c:if test="${region == '대전' }">on</c:if>">대전</a></li>
					<li><a href="/ground/groundList?region=대구" class="btnform3 <c:if test="${region == '대구' }">on</c:if>">대구</a></li>
					<li><a href="/ground/groundList?region=울산" class="btnform3 <c:if test="${region == '울산' }">on</c:if>">울산</a></li>
					<li><a href="/ground/groundList?region=부산" class="btnform3 <c:if test="${region == '부산' }">on</c:if>">부산</a></li>
					<li><a href="/ground/groundList?region=세종" class="btnform3 <c:if test="${region == '세종' }">on</c:if>">세종</a></li>
					<li><a href="/ground/groundList?region=광주" class="btnform3 <c:if test="${region == '광주' }">on</c:if>">광주</a></li>
					<li><a href="/ground/groundList?region=경기" class="btnform3 <c:if test="${region == '경기' }">on</c:if>">경기</a></li>
					<li><a href="/ground/groundList?region=강원" class="btnform3 <c:if test="${region == '강원' }">on</c:if>">강원</a></li>
					<li><a href="/ground/groundList?region=충청" class="btnform3 <c:if test="${region == '충청' }">on</c:if>">충청</a></li>
					<li><a href="/ground/groundList?region=전라" class="btnform3 <c:if test="${region == '전라' }">on</c:if>">전라</a></li>
					<li><a href="/ground/groundList?region=경상" class="btnform3 <c:if test="${region == '경상' }">on</c:if>">경상</a></li>
					<li><a href="/ground/groundList?region=제주" class="btnform3 <c:if test="${region == '제주' }">on</c:if>">제주</a></li>
				</ul>
				<ul class="ground_list">
					<c:forEach items="${list }" var="list">
					<li>
						<a href="#">
							<c:if test="${empty list.photo_stored }">
								<img alt="" src="/resources/img/defalutimg.png">
							</c:if>
							<c:if test="${list.photo_stored ne null }">
								<img alt="" src="/uploadImg/${list.photo_stored }">
							</c:if>
							<span class="title mt10">${list.ground_name }</span>
							<span class="text mt10">${list.ground_addr }</span>
						</a>
					</li>
					</c:forEach>
				</ul>
				
				<div class="paging_wrap">
			      <c:if test="${paging.totalPage != 0 }">
			         <ul class="list">
			
			            <%-- 이전 페이지 --%>
			            <c:if test="${paging.curPage eq 1 }">
			            </c:if>
			            <c:if test="${paging.curPage ne 1 }">
			               <li><a href="/ground/groundList?curPage=${paging.curPage-1}&region=${region}">&lt;</a></li>
			            </c:if>
			
			
			            <%-- 페이징 리스트 --%>
			            <c:forEach begin="${paging.startPage }" end="${paging.endPage }"
			               var="i">
			
			               <c:if test="${paging.curPage eq i}">
			                  <li class="on"><a href="/ground/groundList?curPage=${i }&region=${region}">${i }</a></li>
			               </c:if>
			               <c:if test="${paging.curPage ne i}">
			                  <li><a href="/ground/groundList?curPage=${i }&region=${region}">${i }</a></li>
			               </c:if>
			            </c:forEach>
			
			            <%-- 다음 페이지 --%>
			            <c:if test="${paging.curPage eq paging.totalPage }">
			            </c:if>
			            <c:if test="${paging.curPage ne paging.totalPage }">
			               <li><a href="/ground/groundList?curPage=${paging.curPage+1}&region=${region}">&gt;</a></li>
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