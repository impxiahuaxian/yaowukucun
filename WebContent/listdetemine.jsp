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
			<h1 class="page-title">客户预定信息列表</h1>
		</div>
		<div class="main-content">
			<form action="orders/addOrders.action" name="myform" method="post">
				<table class="table">

					<thead>
						<tr>
							<th class="text-center">&nbsp;</th>
							<th class="text-center">用户</th>
							<th class="text-center">菜品</th>
							<th class="text-center">销售价格</th>
							<th class="text-center">库存数量</th>
							<th class="text-center">需求数量</th>
							<th class="text-center">日期</th>
							<th class="text-center">操作</th>
						</tr>
					</thead>
					<c:forEach items="${detemineList}" var="detemine">
						<tr align="center">
							<td><c:if test="${detemine.snum gt detemine.num}">
									<input type="checkbox" name="ids" value="${detemine.detemineid}">
								</c:if></td>
							<td>${detemine.realname}</td>
							<td>${detemine.vegsname}</td>
							<td>${detemine.price}</td>
							<td>${detemine.snum}</td>
							<td>${detemine.num}</td>
							<td>${detemine.addtime}</td>
							<td><a href="detemine/getDetemineById.action?id=${detemine.detemineid}"><i class="fa fa-pencil"></i></a>&nbsp;&nbsp;<a
								href="detemine/deleteDetemine.action?id=${detemine.detemineid}"
								onclick="{if(confirm('确定要删除吗?')){return true;}return false;}"><i class="fa fa-trash-o"></i></a></td>
						</tr>
					</c:forEach>
					<tr align="center">
						<td colspan="8"><input type="submit" value="下订单" class="btn btn-primary"></td>
					</tr>
				</table>
			</form>
			<div class="pagination">${html }</div>
		</div>
	</div>
</body>
</html>
