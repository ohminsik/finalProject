<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<jsp:include page="../common/meta.jsp"/>
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
    
    int end = now.getActualMaximum(Calendar.DAY_OF_MONTH);    //해당월의 마지막 날짜
    int w = now.get(Calendar.DAY_OF_WEEK);    //1~7(일~토)
%>
<body>
	<div id="wrap">
		<jsp:include page="../common/header.jsp"/>	
		<!-- sub_banner s -->
		<div class="sub_banner">
			<span class="bg"></span>
			<div class="textBox">
				<p class="title">매치보드</p>
				<p class="text">매치신청</p>
			</div>
		</div>
		<!-- sub_banner e -->
		
		<!-- nav s -->
		<div class="nav_wrap">
			<div class="nav">
				<ul>
					<li><a href="/main"><i class="xi-home"></i></a></li>
					<li>
						<a>매치보드</a>
					</li>
					<li>
						<a>매치신청</a>
					</li>
				</ul>
			</div>
		</div>
		<!-- nav e -->	
		<div id="container">
			<div class="match_wrap">
				<ul class="match_wrap_ul">
					<li>
						<div class="title mb10">매치등록은 신중하게 작성하여 주시기 바랍니다.</div>
						<div class="region">
							<ul>
								<li><a href="#">전체 지역</a></li>
								<li>
									<ul>
										<li><a href="#">서울</a></li>
										<li><a href="#">인천</a></li>
										<li><a href="#">대전</a></li>
										<li><a href="#">대구</a></li>
										<li><a href="#">울산</a></li>
										<li><a href="#">부산</a></li>
										<li><a href="#">세종</a></li>
										<li><a href="#">광주</a></li>
										<li><a href="#">경기</a></li>
										<li><a href="#">강원</a></li>
										<li><a href="#">충북</a></li>
										<li><a href="#">충남</a></li>
										<li><a href="#">전북</a></li>
										<li><a href="#">전남</a></li>
										<li><a href="#">경북</a></li>
										<li><a href="#">경남</a></li>
										<li><a href="#">제주</a></li>
									</ul>
								</li>
							</ul>
						</div>
					</li>
					<li>
						<table class="week">
			                <tr height="30">
			                    <td align="center">
			                        <a href="/match/matchBoard?year=<%=year%>&month=<%=month-1%>">◀</a>
			                        <span><%=year %>년 <%=month %>월</span>
			                        <a href="/match/matchBoard?year=<%=year%>&month=<%=month+1%>">▶</a>
			                    </td>
			                </tr>
			            </table>
			            
			            <table class="date">
			               <thead>
			               	 <tr height="25">
			                    <td style="color:red">일</td>
			                    <td>월</td>
			                    <td>화</td>
			                    <td>수</td>
			                    <td>목</td>
			                    <td>금</td>
			                    <td style="color:blue">토</td>
			                </tr>
			               </thead>
			               <tbody>
			                <%
			                    int newLine = 0;
			                    //1일이 어느 요일에서 시작하느냐에 따른 빈칸 삽입
			                    out.println("<tr>");
			                    for(int i=1; i<w; i++)
			                    {
			                        out.println("<td>&nbsp;</td>");
			                        newLine++;
			                    }
			                    
			                    String fc, bg;
			                    for(int i=1; i<=end; i++)
			                    {
			                        
			                        fc = (newLine == 0)?"red":(newLine==6?"blue":"#000000");
			                        bg = "#ffffff";
			                        out.println("<td><a color=" + fc + " href='#'>"
			                                + i + "</a></td>");
			                        newLine++;
			                        if(newLine == 7 && i != end)
			                        {
			                            out.println("</tr>");
			                            out.println("<tr height='25'>");
			                            newLine = 0;
			                        }
			                    }
			                    
			                    while(newLine>0 && newLine<7)
			                    {
			                        out.println("<td bgcolor='ffffff'>&nbsp;</td>");
			                        newLine++;    
			                    }
			                    out.println("</tr>");
			                %>
			                </tbody>
			            </table>
					</li>
				</ul>

				<div class="match_btn_list">
									
					<ul>
						<li><a href="/match/matchBoard" class="btnform0">매치검색</a></li>
						<!-- <li><a href="/match/matchRegister" class="btnform0" id="team_enroll">매치등록</a></li> -->
					    <li><a href="/match/matchRegister" class="btnform0" id="match_enroll">매치등록</a></li>
					</ul>
				</div>
				<div class="match_diary">
					<ul>
						<li class="mb10">이달의 매치일정</li>
						<li>
							<table>
								<colgroup>
									<col width="10%">
									<col width="15%">
									<col width="15%">
									<col width="15%">
									<col width="*">
									<col width="15%">
								</colgroup>
								<tbody>
									<c:forEach items="${matchList }" var="match">
									<tr>
										<td><img src="/resources/img/logo.png"></td>
										<td>${match.team_name }<br>${match.team_etire }전 ${match.team_win }승 ${match.team_tie }무 ${match.team_lose }패</td>
										<td><fmt:formatDate value="${match.fight_date }" pattern="yyyy/MM/dd"/> <br>매치 요청합니다</td>
										<td>지역 : ${match.team_region }<br>팀원 : ${match.team_cnt }명<br>장소 : ${match.match_ground }</td>
										<td>남기는 한마디 : ${match.match_content }</td>
										<td><span class="btnform7 mb10">구장있음</span><a href="/match/matchApply" class="btnform7">매치신청</a></td>
									</tr>
									</c:forEach>
								</tbody>
							</table>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
	
</body>
</html>