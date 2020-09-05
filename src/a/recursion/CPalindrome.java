package a.recursion;

public class CPalindrome {
	public boolean isPalindrome(String str) {
		if (str.length() == 1 || str.length() == 0) {
			return true;
		}

		boolean result = (str.charAt(0) == str.charAt(str.length() - 1)) && isPalindrome(str.substring(1, str.length() - 1));
		return result;
	}

	public static void main(String[] args) {
		CPalindrome palindrome = new CPalindrome();
		System.out.println("bcacd: " + palindrome.isPalindrome("bcacd"));
		System.out.println("bcacb: " + palindrome.isPalindrome("bcacb"));
		System.out.println("a: " + palindrome.isPalindrome("a"));
		System.out.println("bcacbb: " + palindrome.isPalindrome("bcacbb"));
		System.out.println("bcaacb: " + palindrome.isPalindrome("bcaacb"));
	}
}
