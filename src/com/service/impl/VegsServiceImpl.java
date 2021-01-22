package com.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.VegsDAO;
import com.entity.Vegs;
import com.service.VegsService;

@Service("vegsService")
public class VegsServiceImpl implements VegsService {
	@Autowired
	@Resource
	private VegsDAO vegsDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertVegs(Vegs vegs) {
		return this.vegsDAO.insertVegs(vegs);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateVegs(Vegs vegs) {
		return this.vegsDAO.updateVegs(vegs);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteVegs(String vegsid) {
		return this.vegsDAO.deleteVegs(vegsid);
	}

	@Override // 继承接口的查询全部
	public List<Vegs> getAllVegs() {
		return this.vegsDAO.getAllVegs();
	}

	@Override // 继承接口的按条件精确查询
	public List<Vegs> getVegsByCond(Vegs vegs) {
		return this.vegsDAO.getVegsByCond(vegs);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Vegs> getVegsByLike(Vegs vegs) {
		return this.vegsDAO.getVegsByLike(vegs);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Vegs getVegsById(String vegsid) {
		return this.vegsDAO.getVegsById(vegsid);
	}

}
