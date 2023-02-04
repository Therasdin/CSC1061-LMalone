
public class SalariedEmployee extends Employee {

	double wSal = 1000;

	public SalariedEmployee() {
		payment = wSal;
		employeeType = 3;
	}

	public SalariedEmployee(String first, String last, int sSN, double wSal) {
		super(first, last, sSN);
		this.wSal = wSal;
		payment = wSal;
		employeeType = 3;
	}

	public double getwSal() {
		return wSal;
	}

	public void setwSal(double wSal) {
		payment = wSal;
	}

	@Override
	public double getPaymentAmount() {
		payment = wSal;
		return payment;
	}

	@Override
	public String toString() {
		return "SalariedEmployee [wSal=" + wSal + ", firstName=" + firstName + ", lastName=" + lastName + ", sSN=" + sSN
				+ ", payment=" + payment + "]";
	}
}
