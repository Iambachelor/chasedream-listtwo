package cn.dreamchase.dreamchaselisttwo.statements;

import java.util.List;
import java.util.Map;

import cn.dreamchase.dreamchaselisttwo.pojos.Person;

/**
 * getMapper() 方法的使用： 
 * 1. 创建Mapper接口。 
 * 2. 创建Mapper接口同名的mapper.xml文件 
 * 3. 在mapper.xml文件中的namespace属性中的值为 mapper接口的全限定性类名 
 * 4. 实例化SqlSessionFactory 
 * 5.
 * 
 * @author MENGDEFANG
 *
 */
public interface PersonMapper {

	/**
	 * 插入数据并返回行号
	 * 
	 * @param person
	 * @return
	 */
	int insertReturnValue(Person person);

	/**
	 * 插入数据至数据库中
	 * 传入参数为对象
	 * 
	 * @param person
	 */
	void insert(Person person);

	/**
	 * 传入参数为非对象第一种
	 * @param id
	 * @param name
	 * @param age
	 */
	void insert(int id, String name, int age);
	

	/**
	 * 更新数据库中的数据
	 * 
	 * @param person
	 */
	void update(Person person);

	/**
	 * 删除数据库中的数据
	 * 
	 * @param person
	 */
	void delete(Person person);

	/**
	 * 根据id查询单条数据
	 * 
	 * @param id
	 * @return
	 */
	Person getPersonById(int id);

	/**
	 * 查询所有的数据
	 * 
	 * @return
	 */
	List<Person> getPerson();

	/**
	 * 查询所有的数据
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	List getPersonByp();

	/**
	 * 查询所有的数据
	 * 
	 * @return
	 */
	Map<String, Object> getPersonMap();

	/**
	 * 查询所有的数据
	 * 
	 * @return
	 */
	List<Map<String, Object>> getPersons();

}
