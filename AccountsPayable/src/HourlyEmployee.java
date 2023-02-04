public class HourlyEmployee extends Employee {
	double hSal = 15.0;
	double hours = 35;

	public HourlyEmployee() {
		hSal = 25;
		hours = 35;
		payment = hSal * hours;
		employeeType = 2;
	}

	public HourlyEmployee(String first, String last, int sSN, double hSal, double hours) {
		super(first, last, sSN);
		this.hSal = hSal;
		this.hours = hours;
		payment = hSal * hours;
		employeeType = 2;
	}

	public double gethSal() {
		return hSal;
	}

	public void sethSal(double hSal) {
		this.hSal = hSal;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}

	@Override
	public double getPaymentAmount() {
		payment = hSal * hours;
		return payment;
	}

	@Override
	public String toString() {
		return "HourlyEmployee [hSal=" + hSal + ", hours=" + hours + ", firstName=" + firstName + ", lastName="
				+ lastName + ", sSN=" + sSN + ", payment=" + payment + "]";
	}

}
