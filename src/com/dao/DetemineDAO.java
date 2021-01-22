package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Detemine;

@Repository("detemineDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface DetemineDAO {

	/**
	 * DetemineDAO 接口 可以按名称直接调用detemine.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包detemine.xml里的insertDetemine配置 返回值0(失败),1(成功)
	public int insertDetemine(Detemine detemine);

	// 更新数据 调用entity包detemine.xml里的updateDetemine配置 返回值0(失败),1(成功)
	public int updateDetemine(Detemine detemine);

	// 删除数据 调用entity包detemine.xml里的deleteDetemine配置 返回值0(失败),1(成功)
	public int deleteDetemine(String detemineid);

	// 查询全部数据 调用entity包detemine.xml里的getAllDetemine配置 返回List类型的数据
	public List<Detemine> getAllDetemine();

	// 按照Detemine类里面的值精确查询 调用entity包detemine.xml里的getDetemineByCond配置
	// 返回List类型的数据
	public List<Detemine> getDetemineByCond(Detemine detemine);

	// 按照Detemine类里面的值模糊查询 调用entity包detemine.xml里的getDetemineByLike配置
	// 返回List类型的数据
	public List<Detemine> getDetemineByLike(Detemine detemine);

	// 按主键查询表返回单一的Detemine实例 调用entity包detemine.xml里的getDetemineById配置
	public Detemine getDetemineById(String detemineid);

}
