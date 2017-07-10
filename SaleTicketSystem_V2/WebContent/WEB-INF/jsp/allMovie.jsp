<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试</title>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" />
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"
	type="text/javascript"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
	function selectMovie(tr) {
		var name = $(tr).attr("name");
		//alert(name+","+time);
		$("#name").val(name);
		$("form").submit();
	}
</script>
</head>
<body>
	<%@ include file="/WEB-INF/static/head.html"%>

	<div class="row clearfix">
		<c:forEach items="${movieList}" var="movie">
			<div class="col-md-4 column btn-default" name="${movie.电影名称 }"
				onclick="selectMovie(this)">
				<h2>${movie.电影名称 }</h2>
				<h3>${movie.英文名称 }</h3>
				<p>导演:${movie.导演 }</p>
				<p>主演:${movie.主要演员 }</p>
				<p>类型:${movie.类型 }</p>
			</div>
		</c:forEach>
	</div>
	<form action="/SaleTicketSystem_V2/showMovie" method="post">
		<input type="hidden" id="name" name="name" value="" />
	</form>
	<%@ include file="/WEB-INF/static/foot.html"%>
</body>
</html>