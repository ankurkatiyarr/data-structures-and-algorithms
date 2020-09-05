package a.recursion;

public class BFibonacci {
	public static int fibonacci(int number) {
		if (number == 0) {
			return 0;
		}
		if (number == 1) {
			return 1;
		}
		return fibonacci(number - 1) + fibonacci(number - 2);
	}
	
	public static void main(String[] args) {
		System.out.println("fibonacci1: " + fibonacci(1));
		System.out.println("fibonacci5: " + fibonacci(5));
		System.out.println("fibonacci8: " + fibonacci(8));
	}
}
