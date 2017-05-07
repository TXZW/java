<%@page import="com.txzw.util.SysConstants"%>
<%@page import="com.txzw.util.Datas"%>
<%@page import="com.txzw.client.ClientBIZ"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	alert("删除成功");
</script>
</head>
<body>
	<%
		ClientBIZ clientBIZ = (ClientBIZ) session.getAttribute("clientBIZ");
		//输入需要删除的学员编号
		String ids = (String) request.getAttribute("id");
		if (null != ids) {
			int id = Integer.parseInt(ids);
			// 调用客户端业务的删除方法,获取服务器返回信息
			Datas datas = clientBIZ.doDelete(id);
			// 判断服务器返回状态
			if (datas.getFlag().equals(SysConstants.SYS_DELETE)) {
				System.out.println("删除失败!");
				response.sendRedirect("student.jsp");
			} else {
				System.out.println("删除失败!");
				response.sendRedirect("student.jsp");
			}
		}
	%>

</body>
</html>
<%
	if (null == request.getAttribute("id")) {
		response.sendRedirect("login.jsp");
	}
%>