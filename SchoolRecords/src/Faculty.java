import java.util.Arrays;

public class Faculty extends Employee{

	
	private String rank;
	private String officeH;
	
	public Faculty()
	{
	super();
	rank= "Senior";
	officeH = "1-2pm everyday";

	}
	public Faculty(String name, String adress, String phoneNum, String email, String office, String salary, String dHire, String rank, String officeH)
	{
		super (name, adress, phoneNum, email, office, salary, dHire);
		this.rank = rank;
		this.officeH = officeH;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
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
		return "Faculty [rank=" + rank + ", officeH=" + officeH + "]";
	}

	
}
