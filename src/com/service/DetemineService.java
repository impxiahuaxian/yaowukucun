package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Detemine;

@Service("detemineService")
public interface DetemineService {
	// 插入数据 调用detemineDAO里的insertDetemine配置
	public int insertDetemine(Detemine detemine);

	// 更新数据 调用detemineDAO里的updateDetemine配置
	public int updateDetemine(Detemine detemine);

	// 删除数据 调用detemineDAO里的deleteDetemine配置
	public int deleteDetemine(String detemineid);

	// 查询全部数据 调用detemineDAO里的getAllDetemine配置
	public List<Detemine> getAllDetemine();

	// 按照Detemine类里面的字段名称精确查询 调用detemineDAO里的getDetemineByCond配置
	public List<Detemine> getDetemineByCond(Detemine detemine);

	// 按照Detemine类里面的字段名称模糊查询 调用detemineDAO里的getDetemineByLike配置
	public List<Detemine> getDetemineByLike(Detemine detemine);

	// 按主键查询表返回单一的Detemine实例 调用detemineDAO里的getDetemineById配置
	public Detemine getDetemineById(String detemineid);

}
