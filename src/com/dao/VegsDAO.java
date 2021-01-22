package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Vegs;

@Repository("vegsDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface VegsDAO {

	/**
	 * VegsDAO 接口 可以按名称直接调用vegs.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包vegs.xml里的insertVegs配置 返回值0(失败),1(成功)
	public int insertVegs(Vegs vegs);

	// 更新数据 调用entity包vegs.xml里的updateVegs配置 返回值0(失败),1(成功)
	public int updateVegs(Vegs vegs);

	// 删除数据 调用entity包vegs.xml里的deleteVegs配置 返回值0(失败),1(成功)
	public int deleteVegs(String vegsid);

	// 查询全部数据 调用entity包vegs.xml里的getAllVegs配置 返回List类型的数据
	public List<Vegs> getAllVegs();

	// 按照Vegs类里面的值精确查询 调用entity包vegs.xml里的getVegsByCond配置 返回List类型的数据
	public List<Vegs> getVegsByCond(Vegs vegs);

	// 按照Vegs类里面的值模糊查询 调用entity包vegs.xml里的getVegsByLike配置 返回List类型的数据
	public List<Vegs> getVegsByLike(Vegs vegs);

	// 按主键查询表返回单一的Vegs实例 调用entity包vegs.xml里的getVegsById配置
	public Vegs getVegsById(String vegsid);

}
