package a.recursion;

public class FConvertBinary {
	// result has to be reversed here
	public static String convertBinary1(int number, String binary) {
		if (number != 0) {
			int remainder = number % 2;
			binary = binary + remainder;
			number = number/2;
			return convertBinary1(number, binary);
		}
		return binary;
	}

	// Correct result will be printed but not returned
	public static void convertBinary2(int number) {
		if (number != 0) {
			char remainder = (char) ((number % 2) + '0');
			number = number/2;
			convertBinary2(number);
			System.out.print(remainder);
		}
	}

	// returns the result and don't need to reverse it also
	public static String convertBinary3(int number, String result) {
		if (number != 0) {
			char remainder = (char) ((number % 2) + '0');
			number = number/2;
			return convertBinary3(number, remainder + result);
		}
		return result;
	}
	
	public static void main(String[] args) {
		String binary = convertBinary1(19, "");
		System.out.println("binary: " + binary);		
		System.out.println("---------");
		
		convertBinary2(19);
		System.out.println("---------");
		
		String result = convertBinary3(19, "");
		System.out.println("result: " + result);
	}
}
