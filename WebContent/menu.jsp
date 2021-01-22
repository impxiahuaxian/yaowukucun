<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
	$(function() {
		var uls = $('.sidebar-nav > ul > *').clone();
		uls.addClass('visible-xs');
		$('#main-menu').append(uls.clone());
	});
</script>
<script src="lib/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
	$("[rel=tooltip]").tooltip();
	$(function() {
		$('.demo-cancel-click').click(function() {
			return false;
		});
	});
</script>
<c:if test="${sessionScope.role == '管理员' }">
	<div class="sidebar-nav">
		<ul>

			<li><a data-target=".legal-menu1" class="nav-header collapsed" data-toggle="collapse">系统用户信息管理<i
					class="fa fa-collapse"></i></a></li>
			<li><ul class="legal-menu1 nav nav-list collapse">
					<li><a href="admin/createAdmin.action"><span class="fa fa-caret-right"></span>新增系统用户信息</a></li>
					<li><a href="admin/getAllAdmin.action"><span class="fa fa-caret-right"></span>系统用户信息列表</a></li>
					<li><a href="admin/queryAdminByCond.action"><span class="fa fa-caret-right"></span>系统用户信息查询</a></li>
				</ul></li>

			<li><a data-target=".legal-menu2" class="nav-header collapsed" data-toggle="collapse">参数设置信息管理<i
					class="fa fa-collapse"></i></a></li>
			<li><ul class="legal-menu2 nav nav-list collapse">
					<li><a href="conf/getConfById.action?id=1"><span class="fa fa-caret-right"></span>参数设置信息</a></li>
				</ul></li>

			<li><a data-target=".legal-menu3" class="nav-header collapsed" data-toggle="collapse">菜品类型信息管理<i
					class="fa fa-collapse"></i></a></li>
			<li><ul class="legal-menu3 nav nav-list collapse">
					<li><a href="cate/createCate.action"><span class="fa fa-caret-right"></span>新增菜品类型信息</a></li>
					<li><a href="cate/getAllCate.action"><span class="fa fa-caret-right"></span>菜品类型信息列表</a></li>
					<li><a href="cate/queryCateByCond.action"><span class="fa fa-caret-right"></span>菜品类型信息查询</a></li>
				</ul></li>

			<li><a data-target=".legal-menu4" class="nav-header collapsed" data-toggle="collapse">菜品信息管理<i
					class="fa fa-collapse"></i></a></li>
			<li><ul class="legal-menu4 nav nav-list collapse">
					<li><a href="vegs/createVegs.action"><span class="fa fa-caret-right"></span>新增菜品信息</a></li>
					<li><a href="vegs/getAllVegs.action"><span class="fa fa-caret-right"></span>菜品信息列表</a></li>
					<li><a href="chartBar/preChartBar.action"><span class="fa fa-caret-right"></span>菜品信息统计</a></li>
					<li><a href="vegs/queryVegsByCond.action"><span class="fa fa-caret-right"></span>菜品信息查询</a></li>
				</ul></li>

			<li><a data-target=".legal-menu5" class="nav-header collapsed" data-toggle="collapse">菜品采购信息管理<i
					class="fa fa-collapse"></i></a></li>
			<li><ul class="legal-menu5 nav nav-list collapse">
					<li><a href="chartBar/print.action"><span class="fa fa-caret-right"></span>菜品采购需求</a></li>
					<li><a href="buy/createBuy.action"><span class="fa fa-caret-right"></span>新增菜品采购信息</a></li>
					<li><a href="buy/getAllBuy.action"><span class="fa fa-caret-right"></span>菜品采购信息列表</a></li>
					<li><a href="buy/queryBuyByCond.action"><span class="fa fa-caret-right"></span>菜品采购信息查询</a></li>
				</ul></li>


			<li><a data-target=".legal-menu7" class="nav-header collapsed" data-toggle="collapse">订单信息管理<i
					class="fa fa-collapse"></i></a></li>
			<li><ul class="legal-menu7 nav nav-list collapse">
					<li><a href="orders/getAllOrders.action"><span class="fa fa-caret-right"></span>订单信息列表</a></li>
					<li><a href="orders/queryOrdersByCond.action"><span class="fa fa-caret-right"></span>订单信息查询</a></li>
				</ul></li>

		</ul>
	</div>
</c:if>
<c:if test="${sessionScope.role != '管理员' }">
	<div class="sidebar-nav">
		<ul>
			<li><a data-target=".legal-menu4" class="nav-header collapsed" data-toggle="collapse">菜品信息管理<i
					class="fa fa-collapse"></i></a></li>
			<li><ul class="legal-menu4 nav nav-list collapse">
					<li><a href="vegs/queryVegsByCond.action"><span class="fa fa-caret-right"></span>菜品信息查询</a></li>
				</ul></li>

			<li><a data-target=".legal-menu6" class="nav-header collapsed" data-toggle="collapse">客户预定信息管理<i
					class="fa fa-collapse"></i></a></li>
			<li><ul class="legal-menu6 nav nav-list collapse">
					<li><a href="detemine/createDetemine.action"><span class="fa fa-caret-right"></span>客户预定菜品信息</a></li>
					<li><a href="detemine/getUserDetemine.action"><span class="fa fa-caret-right"></span>我的预定信息列表</a></li>
				</ul></li>

			<li><a data-target=".legal-menu7" class="nav-header collapsed" data-toggle="collapse">订单信息管理<i
					class="fa fa-collapse"></i></a></li>
			<li><ul class="legal-menu7 nav nav-list collapse">
					<li><a href="orders/getUserOrders.action"><span class="fa fa-caret-right"></span>我的订单信息列表</a></li>
				</ul></li>

		</ul>
	</div>
</c:if>
