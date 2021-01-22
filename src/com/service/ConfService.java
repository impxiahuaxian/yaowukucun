package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Conf;

@Service("confService")
public interface ConfService {
	// 插入数据 调用confDAO里的insertConf配置
	public int insertConf(Conf conf);

	// 更新数据 调用confDAO里的updateConf配置
	public int updateConf(Conf conf);

	// 删除数据 调用confDAO里的deleteConf配置
	public int deleteConf(String confid);

	// 查询全部数据 调用confDAO里的getAllConf配置
	public List<Conf> getAllConf();

	// 按照Conf类里面的字段名称精确查询 调用confDAO里的getConfByCond配置
	public List<Conf> getConfByCond(Conf conf);

	// 按照Conf类里面的字段名称模糊查询 调用confDAO里的getConfByLike配置
	public List<Conf> getConfByLike(Conf conf);

	// 按主键查询表返回单一的Conf实例 调用confDAO里的getConfById配置
	public Conf getConfById(String confid);

}
