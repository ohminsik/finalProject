<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<jsp:include page="../common/meta.jsp"/>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.fm.www.dao.face.MypageDao"%>
<%@page import="com.fm.www.dto.Match"%>
<%@page import="com.fm.www.service.face.MatchService"%>

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
							<ul class="ul-element">
								<li><a href="javascript:void(0)">전체 지역</a></li>
								<li>
									<ul class="ul-element1">
										<li><input type="hidden" value="서울"><a href="javascript:void(0)">서울</a></li>
										<li><input type="hidden" value="인천"><a href="javascript:void(0)">인천</a></li>
										<li><input type="hidden" value="대전"><a href="javascript:void(0)">대전</a></li>
										<li><input type="hidden" value="대구"><a href="javascript:void(0)">대구</a></li>
										<li><input type="hidden" value="울산"><a href="javascript:void(0)">울산</a></li>
										<li><input type="hidden" value="부산"><a href="javascript:void(0)">부산</a></li>
										<li><input type="hidden" value="세종"><a href="javascript:void(0)">세종</a></li>
										<li><input type="hidden" value="광주"><a href="javascript:void(0)">광주</a></li>
										<li><input type="hidden" value="경기"><a href="javascript:void(0)">경기</a></li>
										<li><input type="hidden" value="강원"><a href="javascript:void(0)">강원</a></li>
										<li><input type="hidden" value="충북"><a href="javascript:void(0)">충북</a></li>
										<li><input type="hidden" value="충남"><a href="javascript:void(0)">충남</a></li>
										<li><input type="hidden" value="전북"><a href="javascript:void(0)">전북</a></li>
										<li><input type="hidden" value="전남"><a href="javascript:void(0)">전남</a></li>
										<li><input type="hidden" value="경북"><a href="javascript:void(0)">경북</a></li>
										<li><input type="hidden" value="경남"><a href="javascript:void(0)">경남</a></li>
										<li><input type="hidden" value="제주"><a href="javascript:void(0)">제주</a></li>
									</ul>
								</li>
							</ul>
						</div>
					</li>
					<li>
						<table class="week">
			                <tr height="30">
			                    <td align="center">
			                        <a href="/match/matchBoard?selectRegion=0&year=<%=year%>&month=<%=month-1%>">◀</a>
			                        <span><%=year %>년 <%=month %>월</span>
			                        <a href="/match/matchBoard?selectRegion=0&year=<%=year%>&month=<%=month+1%>">▶</a>
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
<%-- 			               <c:set value="${matchCnt }" var="matchCnt"></c:set>
 --%>			               
<!-- 			                	int matchCntt = Integer.parseInt(pageContext.getAttribute("matchCnt").toString()); -->
			                <%
			                
			                    int newLine = 0;
			                    //1일이 어느 요일에서 시작하느냐에 따른 빈칸 삽입
			                    //매치 등록되면 캘린더에 추가
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
			                        /* 2019/05/10등록된 매치일정 추가 */
			                        
			                        out.println("<td><a color=" + fc + " href='javascript:void(0)'>"
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
					<form id="matchSearch"  method="get">	
					<input type="hidden" id="regionItem" name="selectRegion"/>			
					<ul>
						<li><button onclick="matchSearch()" class="btnform0">매치검색</button></li>
						<!-- 로그인 안되어 있을 경우 -->
						<c:if test="${empty login }">
						<!-- 로그인 하기 -->
					    <li><a onclick="notlogin();" class="btnform0" id="match_enroll">매치등록</a></li>
					    </c:if>
					    <!-- 로그인 된 경우 -->
					    <c:if test="${login }">
						    <c:if test="${teamYN eq false}">
						    	<script>
						    		function noteam(){
						    			alert("팀이 없습니다. 팀을 만드세요");
						    		}
					    		</script>
					    		<li><a href="/mypage/teamInformation" onclick="noteam();" class="btnform0" id="match_enroll">매치등록</a></li>
					    	</c:if>
					    	<c:if test="${teamYN eq true}">
					    		<li><a href="/match/matchRegister" class="btnform0" id="match_enroll">매치등록</a></li>
					    	</c:if>
					    </c:if>
					</ul>
					</form>
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
										<td><fmt:formatDate value="${match.fight_date }" pattern="yyyy/MM/dd"/><br>매치 요청합니다</td>
										<td>지역 : ${match.match_region }<br>팀원 : ${match.team_cnt }명<br>장소 : ${match.match_ground }</td>
										<td>남기는 한마디 : ${match.match_content }</td>
									
										<!-- match_ground_yn 있을 때/없을 떄 >> 구장 있음, 구장없음 -->
										<!-- fight_date : 경기일 지나면 ::기간만료 출력:: -->
										<!-- 매치신청 시 match_no 전달 -->
										<!-- 여기서부터 아래 쭉 2019/05/08 로그인 했을 경우 안했을 경우 -->
										<c:if test="${empty login }">
										<c:choose>
											<c:when test="${match.match_ground_yn eq 'Y'}">
												<c:if test="${match.curDateYn eq false}">
													<td><span class="btnform7 mb10">구장있음</span><a href="javascript:void(0)" id="finish1" class="btnform8">기간만료</a></td>
												</c:if>
													<c:if test="${match.curDateYn eq true}">
													<td><span class="btnform7 mb10">구장있음</span><a onclick="notlogin();" class="btnform7">매치신청</a></td>
												</c:if>
											</c:when>
											<c:when test="${match.match_ground_yn eq 'N'}">
												<c:if test="${match.curDateYn eq false }">
													<td><span class="btnform7 mb10">구장없음</span><a href="javascript:void(0)" id="finish1"  class="btnform8">기간만료</a></td>
												</c:if>
												<c:if test="${match.curDateYn eq true}">
													<td><span class="btnform7 mb10">구장없음</span><a onclick="notlogin();" class="btnform7">매치신청</a></td>
												</c:if>
											</c:when>
										</c:choose>
										</c:if>
										<!-- 로그인 된 경우 -->
										<!-- 로그인해서 팀이 없는 경우도 처리 -->
										<c:if test="${login}">
										<!-- 팀 없는 경우  -->
											<c:if test="${teamYN eq false}">
						    					<script>
						    						function noteam2(){
						    							alert("매치를 신청하려면 팀을 만들어야합니다");
						    								}
					    						</script>
					    						
					    						<c:choose>
											<c:when test="${match.match_ground_yn eq 'Y'}">
												<c:if test="${match.curDateYn eq false}">
													<td><span class="btnform7 mb10">구장있음</span><a href="javascript:void(0)" id="finish1" class="btnform8">기간만료</a></td>
												</c:if>
												<c:if test="${match.curDateYn eq true}">
													<td><span class="btnform7 mb10">구장있음</span><a onclick="noteam2();" href="/mypage/teamInformation" class="btnform7">매치신청</a></td>
												</c:if>
											</c:when>
											<c:when test="${match.match_ground_yn eq 'N'}">
												<c:if test="${match.curDateYn eq false }">
													<td><span class="btnform7 mb10">구장없음</span><a href="javascript:void(0)" id="finish1"  class="btnform8">기간만료</a></td>
												</c:if>
												<c:if test="${match.curDateYn eq true}">
													<td><span class="btnform7 mb10">구장없음</span><a onclick="noteam2();" href="/mypage/teamInformation" class="btnform7">매치신청</a></td>
												</c:if>
											</c:when>
										</c:choose>
					    					</c:if>
					    					<!-- 팀 있을 경우 -->
					    					<c:if test="${teamYN eq true}">
										<c:choose>
											<c:when test="${match.match_ground_yn eq 'Y'}">
												<c:if test="${match.curDateYn eq false}">
												
													<td><span class="btnform7 mb10">구장있음</span><a href="javascript:void(0)" class="btnform8">기간만료</a></td>
												</c:if>
													<c:if test="${match.curDateYn eq true}">
													<td>
														<span class="btnform7 mb10">구장있음</span>
														<c:if test="${match.purpleteam_no == ''  }">
														<a href="/match/matchApply?match_no=${match.match_no }" class="btnform7">매치신청</a>
														</c:if>
														<c:if test="${match.purpleteam_no != ''  }">
														<a href="javascript:void(0)" class="btnform8">매치마감</a>
														</c:if>
													</td>
												</c:if>
											</c:when>
											<c:when test="${match.match_ground_yn eq 'N'}">
												<c:if test="${match.curDateYn eq false }">
													<td><span class="btnform7 mb10">구장없음</span><a href="javascript:void(0)" class="btnform8">기간만료</a></td>
												</c:if>
												<c:if test="${match.curDateYn eq true}">
													<td>
														<span class="btnform7 mb10">구장없음</span>
														<c:if test="${match.purpleteam_no == ''  }">
														<a href="/match/matchApply?match_no=${match.match_no }" class="btnform7">매치신청</a>
														</c:if>
														<c:if test="${match.purpleteam_no != ''}">
														<a href="#" class="btnform8">매치마감</a>
														</c:if>
													</td>
												</c:if>
											</c:when>
										</c:choose>
										</c:if>
										<!-- 팀있을 경우 끝 -->
										</c:if>
										<!-- 로그인 된 경우 끝 -->
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
	

<script>
	
	//지역선택 시 담을 변수 초기값 0
	var selectRegion = 0;

	$(document).ready(function(){
		 
		var d = new Date();
		console.log(d);
		console.log(typeof d);
		
			//배열
		 	var sp = new Array();
			sp = $(".btnform8");
			//반복
			$(".btnform8").each(function(sp,element){
					//기간만료 부분 CSS 바꾸기
					$(this).css({'background-color':'#cecece'});
					$(this).css({'color':'#c62266'});
			});
			
			//ul태그의 자식태그인 li태그 클릭 시 selectRegion에 값 담기
			$(".ul-element1 li").click(function(){
			/* console.log($(this).val());
			alert($(this).find("input").val()); */
			
			//li 태그 클릭시 값 변수에 담기
			selectRegion = $(this).find("input").val();
		});

	});
	
	//선택된 li태그의 값을 /match/matchBoard 컨트롤러로 전달
	function matchSearch(){
		
		var matchSearch = document.getElementById("matchSearch");
		$("#regionItem").val(selectRegion);
		matchSearch.action = "/match/matchBoard";
		matchSearch.submit();
	}
	//테스트 a태그 클릭하면 클릭한 부분 css 변함(기간만료 부분)
	/*  $("a").click(function(){
		$(this).css({'background-color':'#cecece'});
		$(this).css({'color':'#c62266'});
	});  */
</script>
</html>



