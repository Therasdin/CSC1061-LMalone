
public class CheckingAccount extends Account {

	double overdraft;

	public CheckingAccount() {
		super();
		overdraft = 5000;
	}

	public CheckingAccount(String name, int id, double balance, double overdraft) {
		this.name = name;
		this.id = id;
		this.balance = balance;
		this.overdraft = overdraft;
	}

	public double getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(double overdraft) {
		this.overdraft = overdraft;
	}

	@Override
	public double withdraw(double amount) {

		if (amount < overdraft) {
			type = 1;
			transList.add(new Transaction(type, amount));
		} else {
			System.out.println("You went over your overdraft fee!");
		}
		return balance;
	}

}
