package cn.gdufe.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.gdufe.po.Person;

public class MyBatisTest2 {
	public static void main(String[] args) throws IOException {
		//1.通过SqlSessionFactoryBuilder获取SqlSessionFactory
		String resource = "sqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
		
		//2.获取Session
		SqlSession session = ssf.openSession();
		
		//3.UDR操作--->动态SQL
			//3-1 查询
			Person p1 = new Person();
			p1.setAge(20);
			List<Person> personlist = session.selectList("cn.gdufe.mapper/UserMapper.findAll-active",p1);
			for (Person person : personlist) {
				System.out.println(person);
			}
			
			//3-2修改
			Person p2 = new Person();
			p2.setUserid("06");
			p2.setUsername("u06");
			session.update("cn.gdufe.mapper/UserMapper.update-active", p2);
			session.commit();
			
			//3-3 删除--->3种批量删除方法：Array,List,Map
			session.delete("cn.gdufe.mapper/UserMapper.deleteArray", new String[]{"01","02"});
			session.commit();
			
			List<String> list = new ArrayList<String>();
			list.add("03");
			list.add("04");
			session.delete("cn.gdufe.mapper/UserMapper.deleteList", list);
			session.commit();
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("ids", new String[]{"05","06"});
			map.put("age", 20);
			session.delete("cn.gdufe.mapper/UserMapper.deleteMap", map);
			session.commit();
	}
}
