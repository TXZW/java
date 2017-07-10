<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试</title>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"
	type="text/javascript">
	
</script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"
	type="text/javascript">
	
</script>
<script type="text/javascript">
	$(function() {
		/* $(".btn-default").click(function() {
			$(this).toggleClass("btn-success");
		}); */
		$("td").click(function() {
			if ($(this).children("input").attr("checked") == null) {
				$(this).children("input").attr("checked", "checked");
			} else {
				$(this).children("input").removeAttr("checked");
			}
			if($(this).attr("class") == "danger"){
				
			}else if ($(this).attr("class") == "btn-success") {
				$(this).attr("class","btn-default");
			} else {
				$(this).attr("class","btn-success");
			}
		});
		$("button").click(function() {
			$
		});
	});
</script>
</head>
<body>
	<%@ include file="/WEB-INF/static/head.html"%>
	<h1>座位</h1>
	<form action="/SaleTicketSystem_V2/chooseSeat" id="form" method="post">
		<table class="table table-bordered">
			<tbody>
				<c:forEach items="${seats}" var="list" varStatus="status">
					<tr>
						<td class="col-xs-1">第${status.index+1 }排</td>
						<c:forEach items="${list}" var="b" varStatus="statu">
							<c:choose>
								<c:when test="${b}">
									<td class="btn-default">
										${status.index+1}-${statu.index+1} <input type="checkbox"
										class="hidden" name="seats"
										value="${status.index+1}-${statu.index+1}" />
									</td>
								</c:when>
								<c:otherwise>
									<td class="danger">${status.index+1}-${statu.index+1}</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<input type="hidden" name="name" value="${name}" /> <input
			type="hidden" name="time" value="${time}" />
		<button class="pull-right">提交</button>
	</form>
	<%@ include file="/WEB-INF/static/foot.html"%>
</body>
</html>