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
</head>
<body class=" theme-blue">
	<jsp:include page="top.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="content">
		<div class="header">
			<h1 class="page-title">订单信息列表</h1>
		</div>
		<div class="main-content">
			<table class="table">

				<thead>
					<tr>
						<th class="text-center">订单号</th>
						<th class="text-center">用户</th>
						<th class="text-center">菜品</th>
						<th class="text-center">数量</th>
						<th class="text-center">单价</th>
						<th class="text-center">总计</th>
						<th class="text-center">日期</th>
						<th class="text-center">状态</th>
						<th class="text-center">操作</th>
					</tr>
				</thead>
				<c:forEach items="${ordersList}" var="orders">
					<tr align="center">
						<td>${orders.ordercode}</td>
						<td>${orders.realname}</td>
						<td>${orders.vegsname}</td>
						<td>${orders.num}</td>
						<td>${orders.price}</td>
						<td>${orders.total}</td>
						<td>${orders.addtime}</td>
						<td>${orders.status}</td>
						<td><c:if test="${orders.status eq '未完成'}">
								<a href="orders/over.action?id=${orders.ordersid}">完成</a>
							</c:if><a href="orders/deleteOrders.action?id=${orders.ordersid}"
							onclick="{if(confirm('确定要删除吗?')){return true;}return false;}"><i class="fa fa-trash-o"></i></a></td>
					</tr>
				</c:forEach>
			</table>
			<div class="pagination">${html }</div>
		</div>
	</div>
</body>
</html>
