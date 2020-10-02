package filehandling;

import java.util.*;
import java.io.FileWriter; // Import the FileWriter class
import java.io.IOException; // Import the IOException class to handle errors

import features.*;

public class Print {
	public void print(String s) {
		// predefined functions
		List<String> list = new ArrayList<String>();
		list.add("print");
		list.add("scan");

		// , ====> Concatenation
		// "" ===> String in print function
		Stack<Character> mainStack = new Stack<Character>();
		String s1 = "";
		String s2 = "";
		String s3 = "";
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
			boolean isStarted = false, isEquation = false;
			for (int j = i; j < s.length(); j++) {
				if (isEquation == true && isStarted == false && s.charAt(j) != ',') {
					s3.concat(Character.toString(s.charAt(j)));
					continue;
				}
				if (s.charAt(j) == '(' && isStarted == false) {
					mainStack.push((Character) s.charAt(j));
					isStarted = true;
					j++;
					continue;
				}
				if (s.charAt(j) == (char) 34)
				// here we are using "" for string in function.Only accepting string with " "
				// if (s.charAt(j) == (char) 39)//if we want to use '' for string in function
				// Example: Here print("abc") will give abc as output but print('abc') will not
				// any output
				{
					if (isStarted == false) {
						isStarted = true;
						continue;
					} else if (isStarted == true) {
						isStarted = false;
					}
				}
				if (s.charAt(j) == ',' && isStarted == false) {
					if (isEquation == true) {
						features.Evaluator exp = new features.Evaluator();
						int result = exp.evaluate(s3);
						s3 = Integer.toString(result);
						s2 = s2.concat(s3);
						isEquation = false;
						continue;
					}
					if (isEquation == false && j + 1 < s.length() && s.charAt(j + 1) != (char) 34
							&& s.charAt(j + 1) != ')') {
						isEquation = true;
					}
					continue;
				}

				if (s.charAt(j) == ')' && isStarted == false && isEquation == false) {
					mainStack.pop();
					break;
				}
				if (s.charAt(j) != (char) 34 && isStarted == true)
				// if (s.charAt(j) != (char) 39 && isStarted == true): if "," is used as
				// concatenator
				{
					s2 = s2.concat(Character.toString(s.charAt(j)));
				}
			}
		}
		try {
			FileWriter writer = new FileWriter("..\\Test\\OutputFile.txt");
			writer.write(s2);
			writer.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
		}
		if (mainStack.isEmpty()) {
			System.out.println(s2);
		} else
			System.out.println(") bracket missing in one of the functions");
	}
}
