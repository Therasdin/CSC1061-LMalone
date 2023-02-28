import java.util.Arrays;

public class Student extends Person{
	
	private String stat;
	
	public Student()
	{
		super();
		stat = "Senior";
		
	}
	public Student(	String name, String adress, String phoneNum, String email, String stat)
	{
		super(name, adress, phoneNum, email);
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
		return "Student [stat=" + stat + "]";
	}
	
}
