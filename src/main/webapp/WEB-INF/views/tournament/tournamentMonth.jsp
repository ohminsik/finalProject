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
							<p class="title">${list.board_title }</p>						
							<p class="text">신청 기간 : ${list.con_reg_dates } ~ ${list.con_reg_datee }</p>
							<p class="text">대회 기간 : ${list.con_con_dates } ~ ${list.con_con_datee }</p>
							<p class="text">대회 지역 : ${list.con_region }</p>		
						</a>				
					</li>
					
				</ul>
				
				<div class="paging_wrap">
			      <c:if test="${paging2.totalPage != 0 }">
			         <ul class="list">
			
			            <%-- 이전 페이지 --%>
			            <c:if test="${paging2.curPage eq 1 }">
			            </c:if>
			            <c:if test="${paging2.curPage ne 1 }">
			               <li><a href="/tournament/tournamentMonth?curPage=${paging2.curPage-1}">&lt;</a></li>
			            </c:if>
			
			
			            <%-- 페이징 리스트 --%>
			            <c:forEach begin="${paging2.startPage }" end="${paging2.endPage }"
			               var="i">
			
			               <c:if test="${paging2.curPage eq i}">
			                  <li class="on"><a href="/tournament/tournamentMonth?curPage=${i }">${i }</a></li>
			               </c:if>
			               <c:if test="${paging2.curPage ne i}">
			                  <li><a href="/tournament/tournamentMonth?curPage=${i }">${i }</a></li>
			               </c:if>
			            </c:forEach>
			
			            <%-- 다음 페이지 --%>
			            <c:if test="${paging2.curPage eq paging2.totalPage }">
			            </c:if>
			            <c:if test="${paging2.curPage ne paging2.totalPage }">
			               <li><a href="/tournament/tournamentMonth?curPage=${paging2.curPage+1}">&gt;</a></li>
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