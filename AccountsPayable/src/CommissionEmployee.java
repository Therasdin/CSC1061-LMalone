
public class CommissionEmployee extends Employee {
	public double grossSales = 4000;
	public double ComissionRate = 0.15;

	public CommissionEmployee() {
		grossSales = 4000;
		ComissionRate = 0.15;
		payment = grossSales * ComissionRate;
		employeeType = 1;
	}

	public CommissionEmployee(String first, String last, int sSN, double grossSales, double ComissionRate) {
		super(first, last, sSN);
		this.ComissionRate = ComissionRate;
		this.grossSales = grossSales;
		payment = grossSales * ComissionRate;
		employeeType = 1;
	}

	public double getgrossSales() {
		return grossSales;
	}

	public void setgrossSales(double grossSales) {
		this.grossSales = grossSales;
	}

	public double getComissionRate() {
		return ComissionRate;
	}

	public void setComissionRate(double comissionRate) {
		ComissionRate = comissionRate;
	}

	@Override
	public double getPaymentAmount() {
		payment = grossSales * ComissionRate;
		return payment;
	}

	@Override
	public String toString() {
		return "CommissionEmployee [grossSales=" + grossSales + ", ComissionRate=" + ComissionRate + ", firstName="
				+ firstName + ", lastName=" + lastName + ", sSN=" + sSN + ", payment=" + payment + "]";
	}

}
