
public class Employee extends Person{

	int office;
	int salary;
	int dHire;
	
	public Employee ()
	{
		super();
		office = 101;
		salary = 10000;
		dHire = 02132023;
	}
	public Employee (String name, String adress, int phoneNum, String email, int office, int salary, int dHire)
	{
		super();
		this.office = office;
		this.salary = salary;
		this.dHire = dHire;
	}
	public int getOffice() {
		return office;
	}
	public void setOffice(int office) {
		this.office = office;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getdHire() {
		return dHire;
	}
	public void setdHire(int dHire) {
		this.dHire = dHire;
	}
	@Override
	public String toString() {
		return "Employee [office=" + office + ", salary=" + salary + ", dHire=" + dHire + ", name=" + name + ", adress="
				+ adress + ", phoneNum=" + phoneNum + ", email=" + email + "]";
	}
	
}
