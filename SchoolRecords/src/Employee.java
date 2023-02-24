
public class Employee extends Person{

	String office;
	String salary;
	String dHire;
	
	public Employee ()
	{
		super();
		office = "101";
		salary = "10000";
		dHire = "02132023";
	}
	public Employee (String name, String adress, String phoneNum, String email, String office, String salary, String dHire)
	{
		super();
		this.office = office;
		this.salary = salary;
		this.dHire = dHire;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getdHire() {
		return dHire;
	}
	public void setdHire(String dHire) {
		this.dHire = dHire;
	}
	@Override
	public String toString() {
		return "Employee [office=" + office + ", salary=" + salary + ", dHire=" + dHire + ", name=" + name + ", adress="
				+ adress + ", phoneNum=" + phoneNum + ", email=" + email + "]";
	}
	
}
