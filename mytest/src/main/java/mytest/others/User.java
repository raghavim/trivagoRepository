package mytest.others;

import java.util.Map;
public class User {
    private static String name;
    private int age;
    private Map<String, String> address;
    private String[] roles;
    public static String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Map<String, String> getAddress() {
        return address;
    }
    public void setAddress(Map<String, String> address) {
        this.address = address;
    }
    public String[] getRoles() {
        return roles;
    }
    public void setRoles(String[] roles) {
        this.roles = roles;
    }
	public static String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
}