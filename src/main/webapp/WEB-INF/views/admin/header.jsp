<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="now" value="<%=new java.util.Date()%>" />




<header>
	<div class="header">
		<div class="head_left" style="height: 57px; line-height: 57px;">
			<img alt="" src="/resources/img/logo.png" style="height:100%; padding: 10px 20px; box-sizing: border-box;">
		</div>
		<div class="head_right">
			<ul class="">
				<li><fmt:formatDate value="${now}" pattern="yyyy 년 MM 월 dd 일 " /></li>				
				<li>${admin_id }님 환영합니다.</li>
				<li class="nav_button"><a href="/admin/logout">로그아웃</a></li>
			</ul>
		</div>
	</div>
</header>
