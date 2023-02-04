
public class Employee {

	public String firstName;
	public String lastName;
	public int sSN;
	public double payment;
	int employeeType = 0;

	public Employee() {
		firstName = "John";
		lastName = "Doe";
		sSN = 123456789;
		payment = 0;
		employeeType = 0;
	}

	public Employee(String firstName, String lastName, int sSN) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.sSN = sSN;
		payment = 17.00;
		employeeType = 0;
	}

	public double getPaymentAmount() {
		return payment;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public float getsSN() {
		return sSN;
	}

	public void setsSN(int sSN) {
		this.sSN = sSN;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", " + "lastName=" + lastName + ", " + "sSN=" + sSN + ", "
				+ "payment=" + payment + "]";
	}

}
