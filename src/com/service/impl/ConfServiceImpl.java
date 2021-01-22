package com.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.ConfDAO;
import com.entity.Conf;
import com.service.ConfService;

@Service("confService")
public class ConfServiceImpl implements ConfService {
	@Autowired
	@Resource
	private ConfDAO confDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertConf(Conf conf) {
		return this.confDAO.insertConf(conf);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateConf(Conf conf) {
		return this.confDAO.updateConf(conf);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteConf(String confid) {
		return this.confDAO.deleteConf(confid);
	}

	@Override // 继承接口的查询全部
	public List<Conf> getAllConf() {
		return this.confDAO.getAllConf();
	}

	@Override // 继承接口的按条件精确查询
	public List<Conf> getConfByCond(Conf conf) {
		return this.confDAO.getConfByCond(conf);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Conf> getConfByLike(Conf conf) {
		return this.confDAO.getConfByLike(conf);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Conf getConfById(String confid) {
		return this.confDAO.getConfById(confid);
	}

}
