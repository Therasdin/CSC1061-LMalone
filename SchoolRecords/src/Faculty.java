import java.util.Arrays;

public class Faculty extends Employee{

	String rankArray[] = new String [] {"Junior","Senior"};
	int rank;
	String officeH;
	
	public Faculty()
	{
	super();
	rank= 0;
	officeH = "1-2pm everyduay";

	}
	public Faculty(String name, String adress, int phoneNum, String email, int office, int salary, int dHire, int rank, String officeH)
	{
		super ();
		this.rank = rank;
		this.officeH = officeH;
	}
	public String getRankArray() {
		return rankArray[rank];
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getOfficeH() {
		return officeH;
	}
	public void setOfficeH(String officeH) {
		this.officeH = officeH;
	}
	@Override
	public String toString() {
		return "Faculty rank=" + rankArray[rank] + ", officeH=" + officeH
				+ ", office=" + office + ", salary=" + salary + ", dHire=" + dHire + ", name=" + name + ", adress="
				+ adress + ", phoneNum=" + phoneNum + ", email=" + email + "]";
	}
	
	
}
