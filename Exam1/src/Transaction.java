import java.time.LocalDate;

public class Transaction extends Account {
	LocalDate dateCreated = java.time.LocalDate.now();
	char statArray[] = new char[] { 'n', 'W', 'D' };
	double amount;
	double newAmount;
	char type;
	double currentBalance;

	public Transaction(int type, double amount) {

		this.type = statArray[type];
		this.amount = amount;
		currentBalance = balance;
		print();
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public double getAmount() {
		return amount;
	}

	public char getType() {
		return type;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void print() {
		System.out.println(dateCreated);
		System.out.println(amount);
		System.out.println(type);
		System.out.println(balance);
	}

	@Override
	public String toString() {
		return "Transaction [dateCreated=" + dateCreated + ", amount=" + amount + ", type=" + type + ", currentBalance="
				+ currentBalance + "]";
	}

}
