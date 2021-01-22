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
<script type="text/javascript" src="js/selwin.js" charset="utf-8"></script>

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
						<th class="text-center">菜品名称</th>
						<th class="text-center">菜品类型</th>
						<th class="text-center">销售价格</th>
						<th class="text-center">库存数量</th>
						<th class="text-center">产地</th>
						<th class="text-center">备注</th>
						<th class="text-center">创建日期</th>
						<th class="text-center">操作</th>
					</tr>
				</thead>
				<c:forEach items="${vegsList}" var="vegs" varStatus="status">
					<tr align="center">
						<td>${vegs.vno}</td>
						<td>${vegs.vegsname}</td>
						<td>${vegs.catename}</td>
						<td>${vegs.price}</td>
						<td>${vegs.snum}</td>
						<td>${vegs.product}</td>
						<td>${vegs.memo}</td>
						<td>${vegs.addtime}</td>
						<td><input type="hidden" value="${vegs.vegsid}" class="m0" />
							<button type="button" id="btnShow" name="btnShow">
								<i id="btnShow" class="fa fa-search"></i>
							</button> &nbsp;&nbsp; <a href="vegs/getVegsById.action?id=${vegs.vegsid}"><i class="fa fa-pencil"></i></a>&nbsp;&nbsp;<a
							href="vegs/deleteVegs.action?id=${vegs.vegsid}" onclick="{if(confirm('确定要删除吗?')){return true;}return false;}"><i
								class="fa fa-trash-o"></i></a></td>
					</tr>
				</c:forEach>
			</table>
			<div class="pagination">${html }</div>
		</div>
	</div>
</body>
</html>
