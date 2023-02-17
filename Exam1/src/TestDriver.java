import java.util.ArrayList;

public class TestDriver {

	public static void main(String[] args) {
//	Account account = new Account(1122, 20000.00);
//	CheckingAccount bob = new CheckingAccount();
//	SavingAccount Ron = new SavingAccount();
//	account.setAnnualInterestRate(4.5);
//	account.getmonthlyInterestRate();
//	account.getMonthlyInterest();
//	account.withdraw(2500);
//	
//	System.out.println(account.toString());	
//	bob.withdraw(6000);

		CheckingAccount george = new CheckingAccount("George", 1122, 1000.00, 5000);
		george.setAnnualInterestRate(1.5);
		george.deposit(30);
		george.deposit(40);
		george.deposit(50);
		george.withdraw(5);
		george.withdraw(4);
		george.withdraw(2);
		print(george);
	}

	public static void print(Account account) {
		ArrayList<Transaction> list = new ArrayList<Transaction>();
		System.out.println(account.getId());
		System.out.println(account.getName());
		System.out.println(account.getAnnualInterestRate() * 100);
		System.out.println("$" + account.balance);

	}

}
