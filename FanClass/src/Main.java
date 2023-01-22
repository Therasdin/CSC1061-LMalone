
public class Main {
	

	public static void main(String[] args) {
		
		int fanID = 0; 
		Fan fan1 = new Fan(3, true, 10, "Yellow");
		fanID++;
		System.out.println("FanID is " + fanID);
		System.out.println(fan1.toString());
		Fan fan2 = new Fan(2, false, 5, "blue");
		fanID++;
		System.out.println("FanID is " + fanID);
		System.out.println(fan2.toString());
		
	}

}
