package a.recursion;

public class AFactorial {
	public static int factorial(int number) {
		if (number <= 0) {
			return 1;
		}
		return number * factorial(number - 1);
	}
	
	public static void main(String[] args) {
		System.out.println("factorial0: " + factorial(0));
		System.out.println("factorial1: " + factorial(1));
		System.out.println("factorial4: " + factorial(4));
		System.out.println("factorial5: " + factorial(5));
	}
}
