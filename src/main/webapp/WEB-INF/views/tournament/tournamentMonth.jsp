<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@page import="java.util.Calendar"%>
<%
    request.setCharacterEncoding("utf-8");
    
    Calendar now = Calendar.getInstance();
    int year = now.get(Calendar.YEAR);
    int month = now.get(Calendar.MONTH)+1;
    
    String _year = request.getParameter("year");
    String _month = request.getParameter("month");
    
    if(_year != null)
        year = Integer.parseInt(_year);
    
    if(_month != null)
        month = Integer.parseInt(_month);
    
    now.set(year, month-1, 1);    //출력할 년도, 월로 설정
    
    year = now.get(Calendar.YEAR);    //변화된 년, 월
    month = now.get(Calendar.MONTH) + 1;
%> 
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
				
				<ul class="tournament_region_ul tournament_region_ul1">
					<li><a href="/tournament/tournamentMonth?year=<%=year%>&month=<%=month-1%>">◀</a></li>
                    <li><span><%=year %>년 <%=month %>월</span></li>
                    <li><a href="/tournament/tournamentMonth?year=<%=year%>&month=<%=month+1%>">▶</a></li>
				</ul>
				
				<ul class="tournament_list">
					<c:forEach items="${list }" var="list">
						<li>
							<a href="/tournament/tournamentView?board_no=${list.board_no }">
								<c:if test="${empty list.photo_stored }">
								<img alt="" src="/resources/img/defalutimg.png">
								</c:if>
								<c:if test="${list.photo_stored ne null}">
								<img alt="${list.photo_stored }" src="/uploadImg/${list.photo_stored }">
								</c:if>
								<p class="title">${list.board_title }</p>						
								<p class="text">신청 기간 :<fmt:formatDate value="${list.con_reg_dates }" pattern="yyyy-MM-dd"/> ~ <fmt:formatDate value="${list.con_reg_datee }" pattern="yyyy-MM-dd"/></p>
								<p class="text">대회 기간 :<fmt:formatDate value="${list.con_con_dates }" pattern="yyyy-MM-dd"/> ~ <fmt:formatDate value="${list.con_con_datee }" pattern="yyyy-MM-dd"/></p>
								<p class="text">대회 지역 : ${list.con_region }</p>		
							</a>				
						</li>
					</c:forEach>
				</ul>
				
				<div class="paging_wrap">
			      <c:if test="${totalCount eq 0 }">
			      </c:if>
			      <c:if test="${totalCount ne 0 }">
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
			    </c:if>
			
			   </div>
			</div>
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>