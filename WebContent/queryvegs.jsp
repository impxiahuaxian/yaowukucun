<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%><%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%><jsp:include page="check_logstate.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%><!doctype html>
<html lang="zh_CN">
<head>
<base href="<%=basePath%>" />
<title>欢迎使用蔬菜批发管理系统</title>
<link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
<script src="lib/jquery-1.11.1.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
<link rel="stylesheet" type="text/css" href="stylesheets/premium.css">
</head>
<body class=" theme-blue">
	<jsp:include page="top.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="content">
		<div class="header">
			<h1 class="page-title">菜品信息列表</h1>
		</div>
		<div class="main-content">
			<table class="table">
				<thead>
					<tr>
						<th class="text-center">编号</th>
						<th class="text-center">蔬菜名称</th>
						<th class="text-center">蔬菜类型</th>
						<th class="text-center">销售价格</th>
						<th class="text-center">库存数量</th>
						<th class="text-center">产地</th>
						<th class="text-center">备注</th>
						<th class="text-center">创建日期</th>
					</tr>
				</thead>
				<c:forEach items="${vegsList}" var="vegs">
					<tr align="center">
						<td class="center">${vegs.vno}</td>
						<td class="center">${vegs.vegsname}</td>
						<td class="center">${vegs.catename}</td>
						<td class="center">${vegs.price}</td>
						<td class="center">${vegs.snum}</td>
						<td class="center">${vegs.product}</td>
						<td class="center">${vegs.memo}</td>
						<td class="center">${vegs.addtime}</td>
					</tr>
				</c:forEach>
			</table>
			<ul class="pagination">
				<li>
					<form action="vegs/queryVegsByCond.action" name="myform" method="post">
						<label>查询条件: <select name="cond" style="width: 100px">
								<option value="vegsname">按菜品名称查询</option>
								<option value="cateid">按菜品类型查询</option>
								<option value="price">按销售价格查询</option>
								<option value="snum">按库存数量查询</option>
								<option value="product">按产地查询</option>
								<option value="memo">按备注查询</option>
								<option value="addtime">按创建日期查询</option>
						</select>
						</label>&nbsp;&nbsp;&nbsp; <label>关键字: <input type="text" name="name" required style="width: 100px" /></label>&nbsp;&nbsp;&nbsp;
						<label><input type="submit" value="查询" class="mws-button green" /> </label>${html }
					</form>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>
