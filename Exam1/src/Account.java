import java.time.LocalDate;
import java.util.ArrayList;

public class Account {
	String name = "John Doe";
	public int id = 0;
	public double balance = 0;
	private double annualInterestRate = 0;
	LocalDate dateCreated = java.time.LocalDate.now();
	private double monthlyInterestRate = 0;
	double MonthlyInterest = 0;
	int type = 0; // 0 for deposit, 1 for withdraw
	ArrayList<Transaction> transList = new ArrayList<Transaction>();

	public Account() {

	}

	public Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
	}

	public Account(String name, int id, double balance) {
		this.name = name;
		this.id = id;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate / 100;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public double getmonthlyInterestRate() {
		return this.monthlyInterestRate = getAnnualInterestRate() / 12;
	}

	public double getMonthlyInterest() {
		return this.MonthlyInterest = balance * monthlyInterestRate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double withdraw(double amount) {
		type = 1;
		balance = balance - amount;
		transList.add(new Transaction(type, amount));

		return balance;
	}

	public double deposit(double amount) {
		type = 2;
		balance = balance + amount;
		transList.add(new Transaction(type, amount));
		return balance;

	}

	public ArrayList<Transaction> getTransList() {
		return transList;
	}

	public void setTransList(ArrayList<Transaction> transList) {
		this.transList = transList;
	}

	public void printTransList() {

	}
}
