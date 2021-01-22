<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="check_logstate.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!doctype html>
<html lang="zh_CN">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎使用蔬菜批发管理系统</title>
<link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
<script src="lib/jquery-1.11.1.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
<link rel="stylesheet" type="text/css" href="stylesheets/premium.css">
<script src="echart/echarts.min.js" charset="UTF-8"></script>
<script src="echart/chartbar2.js" charset="UTF-8"></script>
</head>
<body class=" theme-blue">
	<table class="table">
		<tr align="center">
			<td class="block-center"><div class="text-center" id="chartmain" style="width: 99%; height: 400px;"></div></td>
		</tr>
	</table>
	<input type="hidden" name="basepath" value="<%=basePath%>">
	<input type="hidden" name="id" value="<%=request.getParameter("id")%>">
	<div id="html"></div>
</body>
</html>
