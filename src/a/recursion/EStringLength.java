package a.recursion;

public class EStringLength {
	public static int stringLength(String str, int length) {
		if ("".equals(str)) {
			return length;
		}
		return stringLength(str.substring(1), ++length);
	}
	
	public static void main(String[] args) {
		int length = stringLength("Ankur", 0);
		System.out.println("length: " + length);
	}
}
