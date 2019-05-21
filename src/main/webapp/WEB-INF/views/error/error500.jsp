<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:include page="../common/meta.jsp"/>
<body>
	<div id="wrap">
		<div class="error_div">
			<p class="title">Error 500</p>
			<p class="text">서버 내부 에러</p>
			<a href="/main">메인으로</a>
		</div>
	</div>
</body>
<style>
	.error_div{width:600px; position: absolute; top:50%; left:50%; transform:translateX(-50%) translateY(-50%); border:2px solid #f00; text-align: center; padding:50px 20px;}
	.error_div p.title{font-size:30px; color:#f00}
	.error_div p.text{font-size:20px; color:#333}
	.error_div a{border:1px solid #f00; display: block; width:100px; height:50px; line-height: 50px; text-align: center; margin:20px auto;}
</style>
<script>
$(document).ready(function(){
	$("#wrap").css({
		height : $(window).height() + "px"
	})
	$(window).resize(function() {
		$("#wrap").css({
			height : $(window).height() + "px"
		})
	})
})
</script>
</html>