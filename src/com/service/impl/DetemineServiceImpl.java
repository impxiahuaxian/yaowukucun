package com.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.DetemineDAO;
import com.entity.Detemine;
import com.service.DetemineService;

@Service("detemineService")
public class DetemineServiceImpl implements DetemineService {
	@Autowired
	@Resource
	private DetemineDAO detemineDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertDetemine(Detemine detemine) {
		return this.detemineDAO.insertDetemine(detemine);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateDetemine(Detemine detemine) {
		return this.detemineDAO.updateDetemine(detemine);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteDetemine(String detemineid) {
		return this.detemineDAO.deleteDetemine(detemineid);
	}

	@Override // 继承接口的查询全部
	public List<Detemine> getAllDetemine() {
		return this.detemineDAO.getAllDetemine();
	}

	@Override // 继承接口的按条件精确查询
	public List<Detemine> getDetemineByCond(Detemine detemine) {
		return this.detemineDAO.getDetemineByCond(detemine);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Detemine> getDetemineByLike(Detemine detemine) {
		return this.detemineDAO.getDetemineByLike(detemine);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Detemine getDetemineById(String detemineid) {
		return this.detemineDAO.getDetemineById(detemineid);
	}

}
