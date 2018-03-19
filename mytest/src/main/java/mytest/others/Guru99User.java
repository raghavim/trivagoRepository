package mytest.others;


public class Guru99User {
	private static String name;
    private static String password;
   
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
   
    public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Guru99User [name=" + name + ", password=" + password + "]";
	}

	
}
