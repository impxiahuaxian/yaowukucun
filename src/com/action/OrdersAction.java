package com.action;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Orders;
import com.service.OrdersService;
import com.entity.Admin;
import com.entity.Detemine;
import com.entity.Vegs;
import com.service.AdminService;
import com.service.DetemineService;
import com.service.VegsService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/orders", produces = "text/plain;charset=utf-8")
public class OrdersAction extends BaseAction {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	@Resource
	private OrdersService ordersService;
	@Autowired
	@Resource
	private AdminService adminService;
	@Autowired
	@Resource
	private VegsService vegsService;
	@Autowired
	@Resource
	private DetemineService detemineService;

	// 准备添加数据
	@RequestMapping("createOrders.action")
	public String createOrders() {
		List<Admin> adminList = this.adminService.getAllAdmin();
		this.getRequest().setAttribute("adminList", adminList);
		List<Vegs> vegsList = this.vegsService.getAllVegs();
		this.getRequest().setAttribute("vegsList", vegsList);
		return "addorders";
	}

	// 添加数据
	@RequestMapping("addOrders.action")
	public String addOrders() {
		String adminid = (String) this.getSession().getAttribute("adminid");
		String[] ids = this.getRequest().getParameterValues("ids");
		for (String x : ids) {
			Detemine detemine = this.detemineService.getDetemineById(x);
			Vegs vegs = this.vegsService.getVegsById(detemine.getVegsid());
			Orders orders = new Orders();
			orders.setOrdercode("DO" + VeDate.getStringDatex());
			orders.setNum("" + detemine.getNum());
			orders.setPrice(vegs.getPrice());
			orders.setTotal("" + (Double.parseDouble(vegs.getPrice()) * detemine.getNum()));
			orders.setAddtime(VeDate.getStringDateShort());
			orders.setAdminid(adminid);
			orders.setStatus("未完成");
			orders.setVegsid(detemine.getVegsid());
			this.ordersService.insertOrders(orders);
			this.detemineService.deleteDetemine(x);
		}
		return "redirect:/orders/getUserOrders.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteOrders.action")
	public String deleteOrders(String id) {
		this.ordersService.deleteOrders(id);
		return "redirect:/orders/getAllOrders.action";
	}

	// 批量删除数据
	@RequestMapping("deleteOrdersByIds.action")
	public String deleteOrdersByIds() {
		String[] ids = this.getRequest().getParameterValues("ordersid");
		for (String ordersid : ids) {
			this.ordersService.deleteOrders(ordersid);
		}
		return "redirect:/orders/getAllOrders.action";
	}

	// 更新数据
	@RequestMapping("updateOrders.action")
	public String updateOrders(Orders orders) {
		this.ordersService.updateOrders(orders);
		return "redirect:/orders/getAllOrders.action";
	}

	@RequestMapping("over.action")
	public String over(String id) {
		Orders orders = this.ordersService.getOrdersById(id);
		orders.setStatus("完成");
		Vegs vegs = this.vegsService.getVegsById(orders.getVegsid());
		if (Double.parseDouble(vegs.getSnum()) >= Double.parseDouble(orders.getNum())) {
			vegs.setSnum("" + (Double.parseDouble(vegs.getSnum()) - Double.parseDouble(orders.getNum())));
			this.vegsService.updateVegs(vegs);
			this.ordersService.updateOrders(orders);
		}
		return "redirect:/orders/getAllOrders.action";
	}

	// 显示全部数据
	@RequestMapping("getAllOrders.action")
	public String getAllOrders(String number) {
		List<Orders> ordersList = this.ordersService.getAllOrders();
		PageHelper.getPage(ordersList, "orders", null, null, 10, number, this.getRequest(), null);
		return "listorders";
	}

	@RequestMapping("getUserOrders.action")
	public String getUserOrders(String number) {
		String adminid = (String) this.getSession().getAttribute("adminid");
		Orders orders = new Orders();
		orders.setAdminid(adminid);
		List<Orders> ordersList = this.ordersService.getOrdersByCond(orders);
		PageHelper.getUserPage(ordersList, "orders", 10, number, this.getRequest());
		return "xlistorders";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryOrdersByCond.action")
	public String queryOrdersByCond(String cond, String name, String number) {
		Orders orders = new Orders();
		if (cond != null) {
			if ("ordercode".equals(cond)) {
				orders.setOrdercode(name);
			}
			if ("adminid".equals(cond)) {
				orders.setAdminid(name);
			}
			if ("vegsid".equals(cond)) {
				orders.setVegsid(name);
			}
			if ("num".equals(cond)) {
				orders.setNum(name);
			}
			if ("price".equals(cond)) {
				orders.setPrice(name);
			}
			if ("total".equals(cond)) {
				orders.setTotal(name);
			}
			if ("addtime".equals(cond)) {
				orders.setAddtime(name);
			}
			if ("status".equals(cond)) {
				orders.setStatus(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.ordersService.getOrdersByLike(orders), "orders", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "queryorders";
	}

	// 按主键查询数据
	@RequestMapping("getOrdersById.action")
	public String getOrdersById(String id) {
		Orders orders = this.ordersService.getOrdersById(id);
		this.getRequest().setAttribute("orders", orders);
		List<Admin> adminList = this.adminService.getAllAdmin();
		this.getRequest().setAttribute("adminList", adminList);
		List<Vegs> vegsList = this.vegsService.getAllVegs();
		this.getRequest().setAttribute("vegsList", vegsList);
		return "editorders";
	}

	public OrdersService getOrdersService() {
		return ordersService;
	}

	public void setOrdersService(OrdersService ordersService) {
		this.ordersService = ordersService;
	}

}
