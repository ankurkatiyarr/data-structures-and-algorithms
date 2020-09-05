package d.d.leet.code.stack.easy;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackEasy {
	// https://leetcode.com/problems/valid-parentheses/
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
			return true;
		}
        
        Stack<Character> stack = new Stack<>();
        boolean result = true;
        char[] arr = s.toCharArray();
        
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i] == '(' || arr[i] == '{' || arr[i] == '[') {
				stack.push(arr[i]);
			}
        	
        	try {
            	if (arr[i] == ')') {
    				char pop = stack.pop();
    				if (pop != '(') {
    					result = false;
    					break;
    				}
    			}
            	if (arr[i] == '}') {
    				char pop = stack.pop();
    				if (pop != '{') {
    					result = false;
    					break;
    				}
    			}
            	if (arr[i] == ']') {
    				char pop = stack.pop();
    				if (pop != '[') {
    					result = false;
    					break;
    				}
    			}
        	} catch (EmptyStackException e) {
				result = false;
				break;
			}
		}
        
        if (!stack.isEmpty()) {
			result = false;
		}
    	return result;
    }

    // https://leetcode.com/problems/backspace-string-compare/
    public boolean backspaceCompare(String S, String T) {
    	System.out.println("S: " + S + " T: " + T);
        if ((S == null || S.isEmpty()) && (T == null || T.isEmpty())) {
			return true;
		}
    	String sFinal = getFinalString(S);
    	String tFinal = getFinalString(T);
    	
    	return sFinal.equals(tFinal);
    }
    
    private String getFinalString(String str) {
    	Stack<Character> stack = new Stack<>();
    	char[] arr = str.toCharArray();
    	
    	for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '#') {
				try {
					stack.pop();
				} catch (EmptyStackException e) {}
			} else {
				stack.push(arr[i]);
			}
		}
    	StringBuilder sb = new StringBuilder("");
    	while (!stack.isEmpty()) {
    		sb.append(stack.pop());
    	}
		return sb.toString();
	}

	public static void main(String[] args) {
		StackEasy impl = new StackEasy();
//		System.out.println(impl.isValid("]"));
//		System.out.println(impl.isValid("["));
//		System.out.println(impl.isValid("()"));
//		System.out.println(impl.isValid("()[]{}"));
//		System.out.println(impl.isValid("(]"));
//		System.out.println(impl.isValid("([)]"));
//		System.out.println(impl.isValid("{[]}"));
		
		System.out.println(impl.backspaceCompare("ab#c", "ad#c"));
		System.out.println(impl.backspaceCompare(null, null));
		System.out.println(impl.backspaceCompare(null, ""));
		System.out.println(impl.backspaceCompare("a#b#", "a#b#"));
		System.out.println(impl.backspaceCompare("a#b#", "x#y#"));
		System.out.println(impl.backspaceCompare("#c", "#c"));
		System.out.println(impl.backspaceCompare("#c", "#d"));
		System.out.println(impl.backspaceCompare("#", "#"));
		System.out.println(impl.backspaceCompare("ab##", "c#d#"));
		System.out.println(impl.backspaceCompare("a##c", "#a#c"));
		System.out.println(impl.backspaceCompare("a#c", "b"));
	}
}
