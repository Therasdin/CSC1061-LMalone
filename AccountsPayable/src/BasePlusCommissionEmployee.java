
public class BasePlusCommissionEmployee extends CommissionEmployee {

	double basePay = 250;

	public BasePlusCommissionEmployee() {
		basePay = 250;
		payment = basePay + super.getPaymentAmount();
		employeeType = 4;
	}

	public BasePlusCommissionEmployee(String first, String last, int sSN, double grossSales, double ComissionRate,
			double basePay) {
		super(first, last, sSN, grossSales, ComissionRate);
		this.basePay = basePay;
		payment = basePay + super.getPaymentAmount();
		employeeType = 4;
	}

	public double getBasePay() {
		return basePay;
	}

	public void setBasePay(double basePay) {
		this.basePay = basePay;
	}

	@Override
	public double getPaymentAmount() {
		payment = basePay + super.getPaymentAmount();
		return payment;
	}

	@Override
	public String toString() {
		return "BasePlusCommissionEmployee [basePay=" + basePay + ", grossSales=" + grossSales + ", ComissionRate="
				+ ComissionRate + ", firstName=" + firstName + ", lastName=" + lastName + ", sSN=" + sSN + ", payment="
				+ payment + "]";
	}

}
