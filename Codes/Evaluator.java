package features;

import java.util.*;
import datatypes.Coreverify;
import services.Precore;

public class Evaluator {
	public Boolean check(String s)// return true if given parameter is string
	{
		int fl = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == (char) 34) {
				return true;// tells that it contains double qoutes
			}
		}
		return false;

	}

	public static String converted(String s)
	{
		String sf="";
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)!=(char)34)
			sf=sf+s.charAt(i);
		}
		return sf;
	}

	public static String evaluate(String expression) {
		expression=Precore.correctString(expression);
		String ans = "";
		Coreverify cv = new Coreverify();
		System.out.println(expression + "@@####%%");
		// s1 , "vidit"
		// expression = cv.verify(expression);

		boolean is1String = true, is2String = true;
		if (expression.contains("$") == true) {

			String[] arrOfStr = expression.split("$");

			for (int i = 0; i < arrOfStr.length; i++) {
				System.out.println("valueeeeeeeeeee=beforeeeeeeee===========" + arrOfStr[i]);
				if (arrOfStr[i].contains(Character.toString((char) 34)) == true) {
					ans = ans + arrOfStr[i].substring(1,arrOfStr[i].length()-1).trim();
				} else {
					System.out.println("valueeeeeeeeeee=befor===========" + arrOfStr[i]);
					arrOfStr[i] = cv.verify(arrOfStr[i]);
					System.out.println("valueeeeeeeeeee=" + arrOfStr[i]);
					if (arrOfStr[i].contains(Character.toString((char) 34)) == true) {
						ans = ans + arrOfStr[i].substring(1,arrOfStr[i].length()-1).trim();
					} else
						ans = ans + evaluation(arrOfStr[i].trim());
				}
			}

			//return ans;
		} else {
			System.out.println("valueeeeeeeeeee=befor===========" + expression);
			expression = cv.verify(expression);
			System.out.println("valueeeeeeeeeee=" + expression);
			if (expression.contains(Character.toString((char) 34)) == true) {
				ans = ans + expression.substring(1,expression.length()-1).trim();
			} else
				ans = ans + evaluation(expression.trim());
		}
		// ans=ans+evaluation(expression);

		return converted(ans);
	}

	public static double evaluation(String expression) {
		Coreverify cv = new Coreverify();
		System.out.println(expression + "@@####%%");
		expression = cv.verify(expression);
		System.out.println("^^^^^^^^^^");
		// String expression="";
		// for(int i=0;i<expression1.length();i++)
		// expression=expression+" "+expression1.charAt(i);

		char[] tokens = expression.toCharArray();

		Stack<Double> values = new Stack<Double>();

		Stack<Character> ops = new Stack<Character>();

		for (int i = 0; i < tokens.length; i++) {

			if (tokens[i] == ' ')
				continue;

			if ((tokens[i] >= '0' && tokens[i] <= '9') || tokens[i] == '.') {
				StringBuffer sbuf = new StringBuffer();

				while (i < tokens.length && ((tokens[i] >= '0' && tokens[i] <= '9') || tokens[i] == '.'))
					sbuf.append(tokens[i++]);
				values.push(Double.parseDouble(sbuf.toString()));
			}

			else if (tokens[i] == '(')
				ops.push(tokens[i]);

			else if (tokens[i] == ')') {
				while (ops.peek() != '(')
					values.push(applyOp(ops.pop(), values.pop(), values.pop()));
				ops.pop();
			}

			else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {

				while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
					values.push(applyOp(ops.pop(), values.pop(), values.pop()));

				ops.push(tokens[i]);
			}
		}

		while (!ops.empty())
			values.push(applyOp(ops.pop(), values.pop(), values.pop()));

		return values.pop();
	}

	public static boolean hasPrecedence(char op1, char op2) {
		if (op2 == '(' || op2 == ')')
			return false;
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true;
	}

	public static double applyOp(char op, double b, double a) {
		switch (op) {
			case '+':
				return a + b;
			case '-':
				return a - b;
			case '*':
				return a * b;
			case '/':
				if (b == 0)
					throw new UnsupportedOperationException("Cannot divide by zero");
				return a / b;	
		}
		return 0;
	}

}
