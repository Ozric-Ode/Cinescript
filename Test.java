import java.util.*;

class Test {
	public static void main(String[] args) {
		// predefined functions
		List<String> list = new ArrayList<String>();
		list.add("print");
		list.add("scan");

		//+ ====> Concatenation
		//'' ===> String in print function
		
		String s = "print('hello, there'+' (Myself)Monik '+'hye there')";
		Stack<Character> mainStack = new Stack<Character>();
		// Stack<Character> tempStack = new Stack<Character>();
		String s1 = "";
		String s2 = "";
		int i;
		for (i = 0; i < s.length(); i++) {
			while (s.charAt(i) != '(') {
				s1 = s1.concat(Character.toString(s.charAt(i)));
				i++;
			}
			if (s.charAt(i) == '(') {
				break;
			}
		}
		if (list.indexOf(s1) == -1) {
			System.out.println("Undefined Function: " + s1);
		} else {
			boolean isStarted = false;
			for (int j = i; j < s.length(); j++) {
				if (s.charAt(j) == '(' && isStarted == false) {
					mainStack.push((Character) s.charAt(j));
					// System.out.println(s.charAt(j) + " " + isStarted + " " + j);
					isStarted = true;
					j++;
					continue;
				}
				if (s.charAt(j) == (char) 39) {
					if (isStarted == false) {
						isStarted = true;
						continue;
					} else if (isStarted == true) {
						// System.out.println(j);
						isStarted = false;
					}
				}
				if (s.charAt(j) == '+' && isStarted==false) {
					continue;
				}
				if (s.charAt(j) == ')' && isStarted == false) {
					mainStack.pop();
					break;
				}
				if (s.charAt(j) != (char) 39 && isStarted==true) {
					s2 = s2.concat(Character.toString(s.charAt(j)));
				}
			}
		}
		if(mainStack.isEmpty()){
			System.out.println(s2);
		}
		else
			System.out.println(") bracked missing in one of the functions");
	}
}