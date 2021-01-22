package com.action;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Buy;
import com.service.BuyService;
import com.entity.Vegs;
import com.entity.Admin;
import com.service.VegsService;
import com.service.AdminService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/buy", produces = "text/plain;charset=utf-8")
public class BuyAction extends BaseAction {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	@Resource
	private BuyService buyService;
	@Autowired
	@Resource
	private VegsService vegsService;
	@Autowired
	@Resource
	private AdminService adminService;

	// 准备添加数据
	@RequestMapping("createBuy.action")
	public String createBuy() {
		List<Vegs> vegsList = this.vegsService.getAllVegs();
		this.getRequest().setAttribute("vegsList", vegsList);
		List<Admin> adminList = this.adminService.getAllAdmin();
		this.getRequest().setAttribute("adminList", adminList);
		this.getRequest().setAttribute("buyno", "B" + VeDate.getStringId());
		return "addbuy";
	}

	// 添加数据
	@RequestMapping("addBuy.action")
	public String addBuy(Buy buy) {
		String adminid = (String) this.getSession().getAttribute("adminid");
		buy.setAdminid(adminid);
		this.buyService.insertBuy(buy);
		Vegs vegs = this.vegsService.getVegsById(buy.getVegsid());
		vegs.setSnum("" + (Double.parseDouble(vegs.getSnum()) + Double.parseDouble(buy.getNum())));
		this.vegsService.updateVegs(vegs);
		return "redirect:/buy/createBuy.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteBuy.action")
	public String deleteBuy(String id) {
		this.buyService.deleteBuy(id);
		return "redirect:/buy/getAllBuy.action";
	}

	// 批量删除数据
	@RequestMapping("deleteBuyByIds.action")
	public String deleteBuyByIds() {
		String[] ids = this.getRequest().getParameterValues("buyid");
		for (String buyid : ids) {
			this.buyService.deleteBuy(buyid);
		}
		return "redirect:/buy/getAllBuy.action";
	}

	// 更新数据
	@RequestMapping("updateBuy.action")
	public String updateBuy(Buy buy) {
		this.buyService.updateBuy(buy);
		return "redirect:/buy/getAllBuy.action";
	}

	// 显示全部数据
	@RequestMapping("getAllBuy.action")
	public String getAllBuy(String number) {
		List<Buy> buyList = this.buyService.getAllBuy();
		PageHelper.getPage(buyList, "buy", null, null, 10, number, this.getRequest(), null);
		return "listbuy";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryBuyByCond.action")
	public String queryBuyByCond(String cond, String name, String number) {
		Buy buy = new Buy();
		if (cond != null) {
			if ("buyno".equals(cond)) {
				buy.setBuyno(name);
			}
			if ("vegsid".equals(cond)) {
				buy.setVegsid(name);
			}
			if ("num".equals(cond)) {
				buy.setNum(name);
			}
			if ("price".equals(cond)) {
				buy.setPrice(name);
			}
			if ("adminid".equals(cond)) {
				buy.setAdminid(name);
			}
			if ("addtime".equals(cond)) {
				buy.setAddtime(name);
			}
			if ("memo".equals(cond)) {
				buy.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.buyService.getBuyByLike(buy), "buy", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "querybuy";
	}

	// 按主键查询数据
	@RequestMapping("getBuyById.action")
	public String getBuyById(String id) {
		Buy buy = this.buyService.getBuyById(id);
		this.getRequest().setAttribute("buy", buy);
		List<Vegs> vegsList = this.vegsService.getAllVegs();
		this.getRequest().setAttribute("vegsList", vegsList);
		List<Admin> adminList = this.adminService.getAllAdmin();
		this.getRequest().setAttribute("adminList", adminList);
		return "editbuy";
	}

	public BuyService getBuyService() {
		return buyService;
	}

	public void setBuyService(BuyService buyService) {
		this.buyService = buyService;
	}

}
