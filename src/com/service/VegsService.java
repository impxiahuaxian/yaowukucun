package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Vegs;

@Service("vegsService")
public interface VegsService {
	// 插入数据 调用vegsDAO里的insertVegs配置
	public int insertVegs(Vegs vegs);

	// 更新数据 调用vegsDAO里的updateVegs配置
	public int updateVegs(Vegs vegs);

	// 删除数据 调用vegsDAO里的deleteVegs配置
	public int deleteVegs(String vegsid);

	// 查询全部数据 调用vegsDAO里的getAllVegs配置
	public List<Vegs> getAllVegs();

	// 按照Vegs类里面的字段名称精确查询 调用vegsDAO里的getVegsByCond配置
	public List<Vegs> getVegsByCond(Vegs vegs);

	// 按照Vegs类里面的字段名称模糊查询 调用vegsDAO里的getVegsByLike配置
	public List<Vegs> getVegsByLike(Vegs vegs);

	// 按主键查询表返回单一的Vegs实例 调用vegsDAO里的getVegsById配置
	public Vegs getVegsById(String vegsid);

}
