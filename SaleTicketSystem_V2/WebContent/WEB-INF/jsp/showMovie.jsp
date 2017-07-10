<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
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
	function selectTime(tr) {
		var name = $(tr).attr("name");
		var time = $(tr).attr("time");
		//alert(name+","+time);
		$("#name").val(name);
		$("#time").val(time);
		$("form").submit();
	}
</script>
</head>
<body>
	<%@ include file="/WEB-INF/static/head.html"%>

	<div class="table-responsive">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>电影名称</th>
					<th>英文名称</th>
					<th>导演</th>
					<th>主要演员</th>
					<th>类型</th>
					<th>价格</th>
					<th>时间</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${movieList}" var="movie">
					<tr class="btn-default" onclick="selectTime(this)"
						name="${movie.电影名称 }"
						time="<fmt:formatDate value="${movie.时间}"
									pattern="yyyy年MM月dd日 HH点mm分" />">
						<td>${movie.电影名称 }</td>
						<td>${movie.英文名称 }</td>
						<td>${movie.导演 }</td>
						<td>${movie.主要演员 }</td>
						<td>${movie.类型}</td>
						<td>￥${movie.价格 }</td>
						<td><fmt:formatDate value="${movie.时间}"
								pattern="yyyy年MM月dd日 HH点mm分" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<form action="/SaleTicketSystem_V2/showSeat" method="post">
		<input type="hidden" id="name" name="name" value="" /> <input
			type="hidden" id="time" name="time" value="" />
	</form>
	<%@ include file="/WEB-INF/static/foot.html"%>
</body>
</html>