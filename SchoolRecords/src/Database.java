import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {

	private static final String FILENAME = "PersonDatabase";
	private PrintWriter addText;
	private Scanner readText;

	public Database() throws Exception {
		File file = new File(FILENAME);

		if (!file.exists()) {
			file.createNewFile();
			System.out.println("New File Created");
		}
		readText = new Scanner(file);
		addText = new PrintWriter(new FileOutputStream(file.getName(), false));
	}

	public void writePerson(Person p) {
		if (p instanceof Student) {
			addText.println("Student");
		} else if (p instanceof Staff) {
			addText.println("Staff");
		} else {
			addText.println("Faculty");
		}
		addText.println(p.getName());
		addText.println(p.getAdress());
		addText.println(p.getPhoneNum());
		addText.println(p.getEmail());
		if (p instanceof Student) {
			addText.println(((Student) p).getStat());

		} else {
			addText.println(((Employee) p).getOffice());
			addText.println(((Employee) p).getSalary());
			addText.println(((Employee) p).getdHire());
			if (p instanceof Staff) {
				addText.println(((Staff) p).getTitle());
			} else {
				addText.println(((Faculty) p).getRank());
				addText.println(((Faculty) p).getOfficeH());
			}
		}
		addText.println();
		addText.flush();
	}

	public ArrayList<Person> readDatabase() {
		String className;
		String name;
		String address;
		String phoneNum;
		String email;
		String stat;
		String office;
		String salary;
		String hire;
		String title;
		String rank;
		String officeH;

		ArrayList<Person> people = new ArrayList<Person>();
		while(readText.hasNextLine()) {
			className = readText.nextLine();
			name = readText.nextLine();
			address = readText.nextLine();
			phoneNum = readText.nextLine();
			email = readText.nextLine();
			if (className.equals("Student")) {
				stat = readText.nextLine();
				people.add(new Student(name, address, phoneNum, email, stat));
			} else {
				office = readText.nextLine();
				salary = readText.nextLine();
				hire = readText.nextLine();
				if (className.equals("Staff")) {
					title = readText.nextLine();
					people.add(new Staff(name, address, phoneNum, email, office, salary, hire, title));
				} else {
					rank = readText.nextLine();
					officeH = readText.nextLine();
					people.add(new Faculty(name, address, phoneNum, email, office, salary, hire, rank, officeH));
				}
			}
			readText.nextLine();

		}

		return people;
	}
}
