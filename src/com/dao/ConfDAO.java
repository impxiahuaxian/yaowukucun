package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Conf;

@Repository("confDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface ConfDAO {

	/**
	 * ConfDAO 接口 可以按名称直接调用conf.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包conf.xml里的insertConf配置 返回值0(失败),1(成功)
	public int insertConf(Conf conf);

	// 更新数据 调用entity包conf.xml里的updateConf配置 返回值0(失败),1(成功)
	public int updateConf(Conf conf);

	// 删除数据 调用entity包conf.xml里的deleteConf配置 返回值0(失败),1(成功)
	public int deleteConf(String confid);

	// 查询全部数据 调用entity包conf.xml里的getAllConf配置 返回List类型的数据
	public List<Conf> getAllConf();

	// 按照Conf类里面的值精确查询 调用entity包conf.xml里的getConfByCond配置 返回List类型的数据
	public List<Conf> getConfByCond(Conf conf);

	// 按照Conf类里面的值模糊查询 调用entity包conf.xml里的getConfByLike配置 返回List类型的数据
	public List<Conf> getConfByLike(Conf conf);

	// 按主键查询表返回单一的Conf实例 调用entity包conf.xml里的getConfById配置
	public Conf getConfById(String confid);

}
