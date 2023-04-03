
public class Toy {

	public static void main(String[] args) {
		Factorial(60);
	}
	
	public static double Factorial (double n) {
		if (n == 0)
		{
			System.out.println("Starting");
			return 1;
		}
		double product = n * Factorial(n-1);
		System.out.println(product);
		return product;
	}
}
