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
 * ִ�����ݿ��¼��CUDR����
 */
public class MyBatisTest {
	
	public static void main(String[] args) throws IOException {
		//1.��ȡSqlSessionFactory
		String resource = "sqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		//������MyBatisTest���½�һ������main��������һ�·�����ȡInputStream���
		//InputStream is = this.getClass().getResourceAsStream(resource);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
		
		//2.��ȡSqlSession
		SqlSession session = ssf.openSession();
		
		//3.����mapperӳ���ļ��е�idִ�����ݿ��¼��CUDR����---��̬SQL
			//3-1 ��ѯ���ݿ��¼
			List<Person> personList = session.selectList("cn.gdufe.mapper/UserMapper.findAll");
			for (Person person : personList) {
				System.out.println(person);
			}
			
			//3-2 ����һ����¼
			Person person = new Person();
			person.setUserid("07");
			person.setUsername("u08");
			person.setSex("��");
			person.setAge(20);
			session.insert("cn.gdufe.mapper/UserMapper.insert",person);
			session.commit(); //ϵͳĬ���Ƿ��Զ��ύ�ģ�����Ҫ�ֶ��ύ

			//3-3 �޸�һ����¼[1.�Ȼ�ȡҪ�޸ĵļ�¼   2.set����ʵ���ಢ�ύ����]
			Person sperson = session.selectOne("cn.gdufe.mapper/UserMapper.selectone", "07");
			System.out.println(sperson);
			sperson.setUsername("u07");
			sperson.setAge(23);
			System.out.println(sperson);
			session.update("cn.gdufe.mapper/UserMapper.update", sperson);
			session.commit();
			
			//3-4 ɾ��һ����¼
			Person dperson = session.selectOne("cn.gdufe.mapper/UserMapper.selectone", "07");
			session.delete("cn.gdufe.mapper/UserMapper.delete", dperson);
			session.commit();
	}

}
