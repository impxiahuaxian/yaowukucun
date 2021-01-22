package com.action;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Conf;
import com.service.ConfService;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/conf", produces = "text/plain;charset=utf-8")
public class ConfAction extends BaseAction {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	@Resource
	private ConfService confService;

	// 更新数据
	@RequestMapping("updateConf.action")
	public String updateConf(Conf conf) {
		this.confService.updateConf(conf);
		return "redirect:/conf/getConfById.action?id=1";
	}

	// 按主键查询数据
	@RequestMapping("getConfById.action")
	public String getConfById(String id) {
		Conf conf = this.confService.getConfById(id);
		this.getRequest().setAttribute("conf", conf);
		return "editconf";
	}

	public ConfService getConfService() {
		return confService;
	}

	public void setConfService(ConfService confService) {
		this.confService = confService;
	}

}
