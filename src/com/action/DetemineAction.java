package com.action;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Detemine;
import com.service.DetemineService;
import com.entity.Admin;
import com.entity.Vegs;
import com.service.AdminService;
import com.service.VegsService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/detemine", produces = "text/plain;charset=utf-8")
public class DetemineAction extends BaseAction {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	@Resource
	private DetemineService detemineService;
	@Autowired
	@Resource
	private AdminService adminService;
	@Autowired
	@Resource
	private VegsService vegsService;

	// 准备添加数据
	@RequestMapping("createDetemine.action")
	public String createDetemine() {
		List<Admin> adminList = this.adminService.getAllAdmin();
		this.getRequest().setAttribute("adminList", adminList);
		List<Vegs> vegsList = this.vegsService.getAllVegs();
		this.getRequest().setAttribute("vegsList", vegsList);
		return "adddetemine";
	}

	// 添加数据
	@RequestMapping("addDetemine.action")
	public String addDetemine(Detemine detemine) {
		String adminid = (String) this.getSession().getAttribute("adminid");
		detemine.setAdminid(adminid);
		detemine.setAddtime(VeDate.getStringDateShort());
		this.detemineService.insertDetemine(detemine);
		return "redirect:/detemine/createDetemine.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteDetemine.action")
	public String deleteDetemine(String id) {
		this.detemineService.deleteDetemine(id);
		return "redirect:/detemine/getUserDetemine.action";
	}

	// 批量删除数据
	@RequestMapping("deleteDetemineByIds.action")
	public String deleteDetemineByIds() {
		String[] ids = this.getRequest().getParameterValues("detemineid");
		for (String detemineid : ids) {
			this.detemineService.deleteDetemine(detemineid);
		}
		return "redirect:/detemine/getUserDetemine.action";
	}

	// 更新数据
	@RequestMapping("updateDetemine.action")
	public String updateDetemine(Detemine detemine) {
		this.detemineService.updateDetemine(detemine);
		return "redirect:/detemine/getUserDetemine.action";
	}

	// 显示全部数据
	@RequestMapping("getAllDetemine.action")
	public String getAllDetemine(String number) {
		List<Detemine> detemineList = this.detemineService.getAllDetemine();
		PageHelper.getPage(detemineList, "detemine", null, null, 10, number, this.getRequest(), null);
		return "listdetemine";
	}

	@RequestMapping("getUserDetemine.action")
	public String getUserDetemine(String number) {
		String adminid = (String) this.getSession().getAttribute("adminid");
		Detemine detemine = new Detemine();
		detemine.setAdminid(adminid);
		List<Detemine> detemineList = this.detemineService.getDetemineByCond(detemine);
		PageHelper.getUserPage(detemineList, "detemine", 10, number, this.getRequest());
		return "listdetemine";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryDetemineByCond.action")
	public String queryDetemineByCond(String cond, String name, String number) {
		Detemine detemine = new Detemine();
		if (cond != null) {
			if ("adminid".equals(cond)) {
				detemine.setAdminid(name);
			}
			if ("vegsid".equals(cond)) {
				detemine.setVegsid(name);
			}
			if ("num".equals(cond)) {
				detemine.setNum(Double.parseDouble(name));
			}
			if ("addtime".equals(cond)) {
				detemine.setAddtime(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.detemineService.getDetemineByLike(detemine), "detemine", nameList, valueList, 10, number, this.getRequest(),
				"query");
		name = null;
		cond = null;
		return "querydetemine";
	}

	// 按主键查询数据
	@RequestMapping("getDetemineById.action")
	public String getDetemineById(String id) {
		Detemine detemine = this.detemineService.getDetemineById(id);
		this.getRequest().setAttribute("detemine", detemine);
		List<Admin> adminList = this.adminService.getAllAdmin();
		this.getRequest().setAttribute("adminList", adminList);
		List<Vegs> vegsList = this.vegsService.getAllVegs();
		this.getRequest().setAttribute("vegsList", vegsList);
		return "editdetemine";
	}

	public DetemineService getDetemineService() {
		return detemineService;
	}

	public void setDetemineService(DetemineService detemineService) {
		this.detemineService = detemineService;
	}

}
