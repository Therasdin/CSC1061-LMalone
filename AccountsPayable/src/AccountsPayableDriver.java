import java.util.ArrayList;
import java.util.Scanner;

public class AccountsPayableDriver {

	static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		ArrayList<Employee> payableEmployees = new ArrayList<Employee>();
		int choice = 0;
		int choice1;
		String first;
		String last;
		int sSN;
		double hold1;
		double hold2;
		double hold3;
		int index;
		
		while (choice != 1) {

			System.out.println("What's the Employee's first name?");
			first = input.next();
			System.out.println("What's the Employee's last name?");
			last = input.next();
			System.out.println("What's the Employee's social security?");
			sSN = input.nextInt();
			System.out.println("What type of employee is it? press 1 for Commission,");
			System.out.println("2 for Hourly, 3 for Salared 4 for BasePlusCommission");
			choice1 = input.nextInt();
			while (choice1 < 0 || choice1 > 4) {
				System.out.println("Choose a number beween 1 and 4");
			}
			if (choice1 == 1) {
				System.out.println("What is the employees weekly sales in dollar amount?");
				hold1 = input.nextDouble();
				System.out.println("What percent commission does this employe make?");
				hold2 = input.nextDouble();
				while (hold2 < 0 || hold2 > 1) {
					System.out.println("Choose a number beween 0 and 1");
					hold2 = input.nextDouble();
				}

				payableEmployees.add(new CommissionEmployee(first, last, sSN, hold1, hold2));
				choice = 1;
			} else if (choice1 == 2) {
				System.out.println("What is this employee's hourly rate?");
				hold1 = input.nextDouble();
				System.out.println("How many hold2 did they work this week?");
				hold2 = input.nextDouble();
				payableEmployees.add(new HourlyEmployee(first, last, sSN, hold1, hold2));
			} else if (choice1 == 3) {
				System.out.println("What is this employee's weekly salary?");
				hold1 = input.nextDouble();
				payableEmployees.add(new SalariedEmployee(first, last, sSN, hold1));
			} else {
				System.out.println("What is the employees weekly sales in dollar amount?");
				hold1 = input.nextDouble();
				System.out.println("What percent commission does this employe make?");
				hold2 = input.nextDouble();
				while (hold2 < 0 || hold2 > 1) {
					System.out.println("Choose a number beween 0 and 1");
					hold2 = input.nextDouble();
				}
				System.out.println("What is this employee's base pay?");
				hold3 = input.nextDouble();
				payableEmployees.add(new BasePlusCommissionEmployee(first, last, sSN, hold1, hold2, hold3));
			}
			System.out.println(
					"Would you like to input another employee? Press a 1 to quit and a number not 1 to continue");
			choice = input.nextInt();
		}
		index = payableEmployees.size();
		index--;
		while (index > -1) {
			if (payableEmployees.get(index) instanceof BasePlusCommissionEmployee)
			{
				hold3 = ((BasePlusCommissionEmployee)payableEmployees.get(index)).getBasePay();
				hold3 = hold3 * 0.1;
				((BasePlusCommissionEmployee)payableEmployees.get(index)).setBasePay(hold3);
//				System.out.println("test");
			}
			printEmployee(payableEmployees.get(index));
			index--;
		}

//		System.out.println(payableEmployees.toString());
//		printEmployeeString(emp1);
//		BasePlusCommissionEmployee payableEmployees.get(index) = (BasePlusCommissionEmployee)Employee;
//		printEmployee(payableEmployees.get(0));
	}

	public static void printEmployeeString(Employee emp) {
		System.out.println(emp.toString());
	}

	public static void printEmployee(Employee emp) {
		System.out.print(emp.firstName + " ");
		System.out.println(emp.lastName);
		System.out.println(emp.sSN);
		System.out.println("$" + emp.payment);
	}
}
