package cn.gdufe.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.gdufe.po.Person;

/**
 * @author AwayFuture
 * 执行数据库记录的CUDR操作
 */
public class MyBatisTest {
	
	public static void main(String[] args) throws IOException {
		//1.获取SqlSessionFactory
		String resource = "sqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		//或者在MyBatisTest中新建一个【非main】方法用一下方法获取InputStream亦可
		//InputStream is = this.getClass().getResourceAsStream(resource);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
		
		//2.获取SqlSession
		SqlSession session = ssf.openSession();
		
		//3.调用mapper映射文件中的id执行数据库记录的CUDR操作---静态SQL
			//3-1 查询数据库记录
			List<Person> personList = session.selectList("cn.gdufe.mapper/UserMapper.findAll");
			for (Person person : personList) {
				System.out.println(person);
			}
			
			//3-2 插入一条记录
			Person person = new Person();
			person.setUserid("07");
			person.setUsername("u08");
			person.setSex("男");
			person.setAge(20);
			session.insert("cn.gdufe.mapper/UserMapper.insert",person);
			session.commit(); //系统默认是非自动提交的，故需要手动提交

			//3-3 修改一条记录[1.先获取要修改的记录   2.set对象实体类并提交事务]
			Person sperson = session.selectOne("cn.gdufe.mapper/UserMapper.selectone", "07");
			System.out.println(sperson);
			sperson.setUsername("u07");
			sperson.setAge(23);
			System.out.println(sperson);
			session.update("cn.gdufe.mapper/UserMapper.update", sperson);
			session.commit();
			
			//3-4 删除一条记录
			Person dperson = session.selectOne("cn.gdufe.mapper/UserMapper.selectone", "07");
			session.delete("cn.gdufe.mapper/UserMapper.delete", dperson);
			session.commit();
	}

}
