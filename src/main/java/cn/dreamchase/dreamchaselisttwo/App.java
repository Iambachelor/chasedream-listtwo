package cn.dreamchase.dreamchaselisttwo;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.dreamchase.dreamchaselisttwo.pojos.Person;
import cn.dreamchase.dreamchaselisttwo.statements.PersonMapper;

/**
 * Hello world!
 *
 */
public class App {
	private static SqlSessionFactory factory = null;

	static {
		getFactory();
	}

	public static void getFactory() {
		try {
			factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("config/mybatis-config.xml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 插入一条数据，且有返回值
	 */
	public void insertReturnValue() {
		SqlSession session = factory.openSession();
		PersonMapper mapper = session.getMapper(PersonMapper.class);
		Person person = new Person();
		person.setId(7);
		person.setName("叶辰");
		person.setAge(28);
		int value = mapper.insertReturnValue(person);
		// 手动提交
		session.commit();
		session.close();
		System.out.println(value);
	}

	/**
	 * 插入数据，无返回值
	 */
	public void insert() {
		SqlSession session = factory.openSession();
		PersonMapper mapper = session.getMapper(PersonMapper.class);
		Person person = new Person();
		person.setId(8);
		person.setName("叶辰");
		person.setAge(28);
		mapper.insert(person);
		// 手动提交
		session.commit();
		session.close();
	}

	/**
	 * 插入数据，传入参数非对象，传入多个参数， insert(int id,String name,int age);
	 * 888888888888888888888888888888888888888888888888888888888888888 传入的参数中，#{xxx}
	 * 占位符 中的 3.4.0 之前，传入参数如以上方式时，可以使用 #{0}，#{1}，#{2}，。。。。 3.4.0 之后，可以使用 [arg2,
	 * arg1, arg0, param3, param1, param2] 表示是传入参数的顺序
	 */
	public void insertHasParam() {
		SqlSession session = factory.openSession();
		PersonMapper mapper = session.getMapper(PersonMapper.class);
		mapper.insertHasParam(9, "叶宇", 15);
		// 手动提交
		session.commit();
		session.close();
	}

	/**
	 * 插入数据，使用 Map xml 中参数为 (#{id},#{name},#{age}),
	 * 当然，使用List<String,Map<String,Object>>
	 */
	public void insertHasParam1() {
		SqlSession session = factory.openSession();
		PersonMapper mapper = session.getMapper(PersonMapper.class);
		Map<String, Object> map = new HashMap<>();
		map.put("id", 10);
		map.put("name", "叶凡");
		map.put("age", 24);
		mapper.insertHasparam1(map);
		// 手动提交
		session.commit();
		session.close();
	}

	/**
	 * 使用 @Param 传入参数 xml 参数为 (#{id},#{name},#{age}) #{} 中的 参数，也就是 占位符 于 @Param
	 * 绑定的参数 一致
	 */
	public void insertHasParam2() {
		SqlSession session = factory.openSession();
		PersonMapper mapper = session.getMapper(PersonMapper.class);
		Map<String, Object> map = new HashMap<>();
		mapper.insertHashParam2(11, "叶宇", 15);
		// 手动提交
		session.commit();
		session.close();
	}

	/**
	 * 更新数据
	 */
	public void update() {
		SqlSession session = factory.openSession();
		PersonMapper mapper = session.getMapper(PersonMapper.class);
		Person person = new Person();
		person.setId(8);
		person.setName("叶辰");
		person.setAge(28);
		mapper.update(person);
		// 手动提交
		session.commit();
		session.close();
	}

	/* 删除数据 */
	public void delete() {
		SqlSession session = factory.openSession();
		PersonMapper mapper = session.getMapper(PersonMapper.class);
		Person person = new Person();
		person.setId(11);
		mapper.delete(person);
		// 手动提交
		session.commit();
		session.close();
	}

	public void getPersonById() {
		SqlSession session = factory.openSession();
		PersonMapper mapper = session.getMapper(PersonMapper.class);
		Person person = mapper.getPersonById(8);
		System.out.println(person);
	}

	public void getPerson() {
		SqlSession session = factory.openSession();
		PersonMapper mapper = session.getMapper(PersonMapper.class);
		List<Person> persons = mapper.getPerson();
		System.out.println(persons);
	}

	/**
	 * 这种情况下的查询，会报错
	 */
	public void getPersonByp() {
		SqlSession session = factory.openSession();
		PersonMapper mapper = session.getMapper(PersonMapper.class);
		List persons = mapper.getPersonByp();
		System.out.println(persons);
	}
	
	/**
	 * 查询结果，返回Map,不能查询出多条，只能查询出一条结果
	 */
	public void getPersonMap() {
		SqlSession session = factory.openSession();
		PersonMapper mapper = session.getMapper(PersonMapper.class);
		Map<String, Object> persons = mapper.getPersonMap(1);
		System.out.println(persons);
	}
	
	public void getPersonsMap() {
		SqlSession session = factory.openSession();
		PersonMapper mapper = session.getMapper(PersonMapper.class);
		Map<String, Object> persons = mapper.getPersonsMap();
		System.out.println(persons);
	}
	
	public void getPersons() {
		SqlSession session = factory.openSession();
		PersonMapper mapper = session.getMapper(PersonMapper.class);
		List<Map<String, Object>> persons = mapper.getPersons();
		System.out.println(persons);
	}

	public static void main(String[] args) {
		App app = new App();
		app.getPersons();
	}
}
