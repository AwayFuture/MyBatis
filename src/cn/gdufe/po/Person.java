package cn.gdufe.po;

/**
 * @author AwayFuture
 * ��ʵ�����е�����������ø����ݿ��е��ֶ�����һһ��Ӧ���������׳���sql��������
 * �ο���https://blog.csdn.net/u010502101/article/details/78989162
 */
public class Person {
	private String userid;
	private String username;
	private String sex;
	private Integer age;

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [userid=" + userid + ", username=" + username + ", sex=" + sex + ", age=" + age + "]";
	}
	
}
