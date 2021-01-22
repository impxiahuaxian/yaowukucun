package com.action;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Vegs;
import com.service.VegsService;
import com.entity.Cate;
import com.service.CateService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/vegs", produces = "text/plain;charset=utf-8")
public class VegsAction extends BaseAction {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	@Resource
	private VegsService vegsService;
	@Autowired
	@Resource
	private CateService cateService;

	// 准备添加数据
	@RequestMapping("createVegs.action")
	public String createVegs() {
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		return "addvegs";
	}

	// 添加数据
	@RequestMapping("addVegs.action")
	public String addVegs(Vegs vegs) {
		vegs.setSnum("0");
		vegs.setAddtime(VeDate.getStringDateShort());
		this.vegsService.insertVegs(vegs);
		return "redirect:/vegs/createVegs.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteVegs.action")
	public String deleteVegs(String id) {
		this.vegsService.deleteVegs(id);
		return "redirect:/vegs/getAllVegs.action";
	}

	// 批量删除数据
	@RequestMapping("deleteVegsByIds.action")
	public String deleteVegsByIds() {
		String[] ids = this.getRequest().getParameterValues("vegsid");
		for (String vegsid : ids) {
			this.vegsService.deleteVegs(vegsid);
		}
		return "redirect:/vegs/getAllVegs.action";
	}

	// 更新数据
	@RequestMapping("updateVegs.action")
	public String updateVegs(Vegs vegs) {
		this.vegsService.updateVegs(vegs);
		return "redirect:/vegs/getAllVegs.action";
	}

	// 显示全部数据
	@RequestMapping("getAllVegs.action")
	public String getAllVegs(String number) {
		List<Vegs> vegsList = this.vegsService.getAllVegs();
		PageHelper.getPage(vegsList, "vegs", null, null, 10, number, this.getRequest(), null);
		return "listvegs";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryVegsByCond.action")
	public String queryVegsByCond(String cond, String name, String number) {
		Vegs vegs = new Vegs();
		if (cond != null) {
			if ("vegsname".equals(cond)) {
				vegs.setVegsname(name);
			}
			if ("cateid".equals(cond)) {
				vegs.setCateid(name);
			}
			if ("price".equals(cond)) {
				vegs.setPrice(name);
			}
			if ("snum".equals(cond)) {
				vegs.setSnum(name);
			}
			if ("product".equals(cond)) {
				vegs.setProduct(name);
			}
			if ("memo".equals(cond)) {
				vegs.setMemo(name);
			}
			if ("addtime".equals(cond)) {
				vegs.setAddtime(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.vegsService.getVegsByLike(vegs), "vegs", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "queryvegs";
	}

	// 按主键查询数据
	@RequestMapping("getVegsById.action")
	public String getVegsById(String id) {
		Vegs vegs = this.vegsService.getVegsById(id);
		this.getRequest().setAttribute("vegs", vegs);
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		return "editvegs";
	}

	public VegsService getVegsService() {
		return vegsService;
	}

	public void setVegsService(VegsService vegsService) {
		this.vegsService = vegsService;
	}

}
