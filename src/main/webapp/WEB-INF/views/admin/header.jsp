<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<header>
	<div class="header">
		<div class="head_right">
			<ul class="">
				<li>2017년 9월 5일 월요일</li>
				<c:if test="${adminlogin ne null }">
					<li>${admin_id }님 환영합니다.</li>
				</c:if>
				<li class="nav_button"><a href="/admin/logout">로그아웃</a></li>
			</ul>
		</div>
	</div>
</header>
