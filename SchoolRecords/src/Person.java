
public class Person {
	String name;
	String adress;
	int phoneNum;
	String email;
	
	public Person ()
	{
	name = "John Doe";
	adress = "123 Main Street";   
	phoneNum = 1234567890;
	email = "JohnDoe@gmail.com";
	}
	
	public Person (	String name, String adress, int phoneNum, String email) 
	{
		this.name = name;
		this.adress = adress;
		this.phoneNum = phoneNum;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", adress=" + adress + ", phoneNum=" + phoneNum + ", email=" + email + "]";
	}
	
}
