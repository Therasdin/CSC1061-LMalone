import java.util.Arrays;

public class Student extends Person{
	
	String stat;
	
	public Student()
	{
		super();
		stat = "Senior";
		
	}
	public Student(	String name, String adress, String phoneNum, String email, String stat)
	{
		super();
		this.stat = stat;
	}

	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
	@Override
	public String toString() {
		return "Student [statArray=" + stat + ", stat=" + stat + ", name=" + name + ", adress="
				+ adress + ", phoneNum=" + phoneNum + ", email=" + email + "]";
	}
	
}
