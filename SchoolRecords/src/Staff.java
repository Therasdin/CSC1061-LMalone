
public class Staff extends Employee{
	
	private String title;
	public Staff()
	{
		super ();
		title = "teacher";
	}
	public Staff (String name, String adress, String phoneNum, String email, String office, String salary, String dHire, String title)
	{
		super(name, adress, phoneNum, email, office, salary, dHire);
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Staff [title=" + title + "]";
	}

	
}

