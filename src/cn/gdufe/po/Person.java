package cn.gdufe.po;

/**
 * @author AwayFuture
 * 该实体类中的属性名称最好跟数据库中的字段名称一一对应，否则容易出现sql操作错误
 * 参考：https://blog.csdn.net/u010502101/article/details/78989162
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
