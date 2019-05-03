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
				<p class="title">대회</p>
				<p class="text">대회일정</p>
			</div>
		</div>
		<!-- sub_banner e -->
		
		<!-- nav s -->
		<div class="nav_wrap">
			<div class="nav">
				<ul>
					<li><a href="/main"><i class="xi-home"></i></a></li>
					<li>
						<a>대회</a>
					</li>
					<li>
						<a>대회일정</a>
					</li>
				</ul>
			</div>
		</div>
		<!-- nav e -->	
		<div id="container">
			<div class="tournament_div">
				<ul class="tournament_ul">
					<li><a href="/tournament/tournamentRegion" class="btnform0">지역별 일정</a></li>
					<li><a href="/tournament/tournamentMonth" class="btnform0 on">월별 일정</a></li>
				</ul>
				
				<ul class="tournament_list">
					<li>
						<a href="#">
							<img alt="" src="/resources/img/defalutimg.png">
							<p class="title">포카리 스웨트와 함께하는 ~~</p>						
							<p class="text">신청 기간 : 2019/02/02 ~ 2019/02/02</p>
							<p class="text">대회 기간 : 2019/02/02 ~ 2019/02/02</p>
							<p class="text">대회 지역 : 서울</p>		
						</a>				
					</li>
					
					<li>
						<a href="#">
							<img alt="" src="/resources/img/defalutimg.png">
							<p class="title">포카리 스웨트와 함께하는 ~~</p>						
							<p class="text">신청 기간 : 2019/02/02 ~ 2019/02/02</p>
							<p class="text">대회 기간 : 2019/02/02 ~ 2019/02/02</p>
							<p class="text">대회 지역 : 서울</p>		
						</a>				
					</li>
					
					<li>
						<a href="#">
							<img alt="" src="/resources/img/defalutimg.png">
							<p class="title">포카리 스웨트와 함께하는 ~~</p>						
							<p class="text">신청 기간 : 2019/02/02 ~ 2019/02/02</p>
							<p class="text">대회 기간 : 2019/02/02 ~ 2019/02/02</p>
							<p class="text">대회 지역 : 서울</p>		
						</a>				
					</li>
					
					<li>
						<a href="#">
							<img alt="" src="/resources/img/defalutimg.png">
							<p class="title">포카리 스웨트와 함께하는 ~~</p>						
							<p class="text">신청 기간 : 2019/02/02 ~ 2019/02/02</p>
							<p class="text">대회 기간 : 2019/02/02 ~ 2019/02/02</p>
							<p class="text">대회 지역 : 서울</p>		
						</a>				
					</li>
					
					<li>
						<a href="#">
							<img alt="" src="/resources/img/defalutimg.png">
							<p class="title">포카리 스웨트와 함께하는 ~~</p>						
							<p class="text">신청 기간 : 2019/02/02 ~ 2019/02/02</p>
							<p class="text">대회 기간 : 2019/02/02 ~ 2019/02/02</p>
							<p class="text">대회 지역 : 서울</p>		
						</a>				
					</li>
					
					<li>
						<a href="#">
							<img alt="" src="/resources/img/defalutimg.png">
							<p class="title">포카리 스웨트와 함께하는 ~~</p>						
							<p class="text">신청 기간 : 2019/02/02 ~ 2019/02/02</p>
							<p class="text">대회 기간 : 2019/02/02 ~ 2019/02/02</p>
							<p class="text">대회 지역 : 서울</p>		
						</a>				
					</li>
					
					<li>
						<a href="#">
							<img alt="" src="/resources/img/defalutimg.png">
							<p class="title">포카리 스웨트와 함께하는 ~~</p>						
							<p class="text">신청 기간 : 2019/02/02 ~ 2019/02/02</p>
							<p class="text">대회 기간 : 2019/02/02 ~ 2019/02/02</p>
							<p class="text">대회 지역 : 서울</p>		
						</a>				
					</li>
					
					<li>
						<a href="#">
							<img alt="" src="/resources/img/defalutimg.png">
							<p class="title">포카리 스웨트와 함께하는 ~~</p>						
							<p class="text">신청 기간 : 2019/02/02 ~ 2019/02/02</p>
							<p class="text">대회 기간 : 2019/02/02 ~ 2019/02/02</p>
							<p class="text">대회 지역 : 서울</p>		
						</a>				
					</li>
				</ul>
				
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