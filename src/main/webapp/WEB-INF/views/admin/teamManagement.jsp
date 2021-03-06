<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="../common/adminmeta.jsp" />
<body>
   <div id="wrap">
      <!--header s-->
      <jsp:include page="../admin/header.jsp" />
      <jsp:include page="../admin/nav.jsp" />
      <!--header e-->
      <!--container s-->
      <div id="container">
         <div class="main_title">
            <ul class="">
               <li><a href="/admin/memManagement" class="btnform1">유저 정보</a></li>
               <li><a href="/admin/teamManagement" class="btnform1">팀 정보</a></li>

            </ul>
         </div>
         <div class="main_title">
               <p>팀 정보</p>      
         </div>

         <div class="category_wrap">
         <form action="/admin/teamManagement" method="get">
         <input type="hidden">
            <ul class="ul_form1">
               <li><select name="search" title="" class="selectform1">
                     <option value="team_no" selected="selected">NO</option>
                     <option value="team_name">팀 명</option>
                     <option value="team_region">팀 지역</option>
                     <option value="team_field">활동구장</option>
                     <option value="team_cnt">팀원 수</option>
               </select></li>
               <li><input type="text" class="inputform150" title="" value="" name="word" /></li>
               <li><button class="btnform1">검색</button></li>
               <li><a href="/admin/teamManagement" class="btnform2">전체보기</a></li>
            </ul>
         </form>
            <ul class="ul_form2"> 
               <li><a href="#" class="btnform4" onclick="alldelete();">삭제</a></li>
            </ul>
         </div>


         <div class="table_wrap">
            <table>
               <colgroup>
                  <col width="5%" />
                  <col width="5%" />
                  <col width="15%" />
                  <col width="15%" />
                  <col width="*%" />
                  <col width="10%" />
                  <col width="10%" />
                  <col width="10%" />
                  <col width="5%" />
               </colgroup>
               <thead>
                  <tr>
                     <th><input type="checkbox" name="Allcheck" id="check1" onclick="Allcheck();" /><label for="check1"></label></th>
                     <th>NO</th>
                     <th>팀 명</th>
                     <th>팀 지역</th>
                     <th>활동구장</th>
                     <th>팀원 수</th>
                     <th>총 전적</th>
                     <th>레이팅</th>
                     <th>편집</th>
                  </tr>
               </thead>
               <tbody>
               <c:forEach items="${list }" var="l">
                  <tr>
                     <td><input type="checkbox" name="checkRow" value="${l.team_no }" /><label for="check2"></label></td>
                     <td>${l.team_no }</td>
                     <td>${l.team_name }</td>
                     <td>${l.team_region }</td>
                     <td>${l.team_field }</td>
                     <td>${l.team_cnt }</td>
                     <td>${l.team_etire }</td>
                     <td>${l.team_rating }</td>
                     <td><a class="btnform6" href="/admin/teamManagement/delete?team_no=${l.team_no }" onclick="return deletee();">삭제</a></td>
                  </tr>
               </c:forEach>      
               <c:if test="${totalCount eq 0 }">            
                  <tr>
                     <td colspan="9">등록된 게시물이 없습니다.</td>
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
                           <li><a href="/admin/teamManagement?curPage=${paging.curPage-1}&search=${search}&word=${word}">&lt;</a></li>
                        </c:if>
                        <%-- 페이징 리스트 --%>
                        <c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="i">
            
                           <c:if test="${paging.curPage eq i}">
                              <li class="on"><a href="/admin/teamManagement?curPage=${i }&search=${search}&sword=${word}">${i }</a></li>
                           </c:if>
                           <c:if test="${paging.curPage ne i}">
                              <li><a href="/admin/teamManagement?curPage=${i }&search=${search}&word=${word}">${i }</a></li>
                           </c:if>
                        </c:forEach>
            
                        <%-- 다음 페이지 --%>
                        <c:if test="${paging.curPage eq paging.totalPage }">
                        </c:if>
                        <c:if test="${paging.curPage ne paging.totalPage }">
                           <li><a href="/admin/teamManagement?curPage=${paging.curPage+1}&search=${search}&word=${word}">&gt;</a></li>
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
          $("input[name=checkRow]").prop("checked", true);
       } else {
          $("input[name=checkRow]").prop("checked", false);
       }

    }

    function deletee() {
       if (confirm("게시글을 삭제하겠습니까?")) {
          var team_no = "${l.team_no }";
          alert("삭제되었습니다");
       } else {
          return false;
       }
    }
    
    function alldelete(){
         var checkRow = "";
         var team_no= "&team_no=${team_no}";
         $( "input[name='checkRow']:checked" ).each (function (){
           checkRow = checkRow + $(this).val()+"," ;
         });
         checkRow = checkRow.substring(0,checkRow.lastIndexOf( ",")); //맨끝 콤마 지우기
        
         if(checkRow == ''){
           alert("삭제할 게시글을 선택하세요.");
           return false;
         }
        
        
         if(confirm("게시글을 삭제하겠습니까?")){
             
             //삭제처리 후 다시 불러올 리스트 url      
             var url = document.location.href;

             location.href="/admin/teamManagement/delete?team_no="+checkRow;      
      
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