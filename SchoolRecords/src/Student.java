import java.util.Arrays;

public class Student extends Person{
	String statArray[] = new String [] {"Freshman","Sophmore","Junior","Senior"};
	int stat;
	
	public Student()
	{
		super();
		stat = 0;
		
	}
	public Student(	String name, String adress, int phoneNum, String email, String[] statArray, int stat)
	{
		super();
		this.statArray = statArray;
		this.stat = stat;
	}
	public String getStatArray() {
		return statArray[stat];
	}
	public int getStat() {
		return stat;
	}
	public void setStat(int stat) {
		this.stat = stat;
	}
	@Override
	public String toString() {
		return "Student [statArray=" + Arrays.toString(statArray) + ", stat=" + stat + ", name=" + name + ", adress="
				+ adress + ", phoneNum=" + phoneNum + ", email=" + email + "]";
	}
	
}
