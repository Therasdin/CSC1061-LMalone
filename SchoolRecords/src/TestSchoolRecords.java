import java.util.ArrayList;

public class TestSchoolRecords {

	public static void main(String[] args) throws Exception {
		Faculty bob = new Faculty("Bob", "123 Main St", "1234567890", "Bob@gmail.com", "101A", "$30000", "2/23/23", "Senior", "1-2pm" );
		Faculty ron = new Faculty("Ron", "124 Main St", "1234567890", "Bob@gmail.com", "101A", "$30000", "2/23/23", "Senior", "1-2pm" );
		Staff rick = new Staff("Rick", "125 Main St", "1234567890", "Bob@gmail.com", "101A", "$30000", "2/23/23", "Principal" );
		Staff alice = new Staff("Alice", "126 Main St", "1234567890", "Bob@gmail.com", "101A", "$30000", "2/23/23", "Principal");
		Student sue = new Student("Sue", "127 Main St", "1234567890", "Bob@gmail.com", "Senior");
		Student tom = new Student("Tom", "128 Main St", "1234567890", "Bob@gmail.com", "Senior");

		Database data = new Database();

		ArrayList<Person> people = new ArrayList<Person>();
		ArrayList<Person> readPeople = new ArrayList<Person>();
		people.add(bob);
		people.add(ron);
		people.add(rick);
		people.add(alice);
		people.add(sue);
		people.add(tom);

		for (Person p : people) {
			data.writePerson(p);
		}

		readPeople = data.readDatabase();
		for (Person p : readPeople) {
			System.out.println(p.toString());
		}
	}

}
