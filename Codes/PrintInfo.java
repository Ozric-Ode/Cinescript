package features;

import java.util.*;
import java.io.FileWriter; // Import the FileWriter class
import java.io.IOException; // Import the IOException class to handle errors

import features.*;
import services.Precore;

public class PrintInfo {

	static boolean checkDigit(String data) {
		boolean numeric = true;

		numeric = data.matches("-?\\d+(\\.\\d+)?");
		return numeric;
	}

	static boolean checkInt(String data) {
		double d = Double.parseDouble(data);
		if (Math.ceil(d) == Math.floor(d)) {
			return true;
		} else {
			return false;
		}
	}

	public static void print(String s) {
		System.out.println(s + "###");

		// , ====> Concatenation
		// " " ===> String in print function

		Stack<Character> mainStack = new Stack<Character>();
		String s_cnc = "";
		String s_exp = "";
		String s_final = "";

		for (int j = 0; j < s.length(); j++) {

			if (s.charAt(j) == (char) 34) {
				if (mainStack.empty()) {
					mainStack.push((Character) s.charAt(j));
				}

				else {

					s_final = s_final + s_cnc;
					s_cnc = "";
					mainStack.pop();
				}
				continue;
			}

			if (!mainStack.empty()) {
				s_cnc = s_cnc + s.charAt(j);
			} else {
				if (s.charAt(j) == ',') {
					if (s_exp.length() != 0) {
						if (checkDigit(Evaluator.evaluate(s_exp))) {
							if (checkInt(Evaluator.evaluate(s_exp))) {
								s_final = s_final + (int)Double.parseDouble(Evaluator.evaluate(s_exp));
							} else {
								s_final = s_final + Double.parseDouble(Evaluator.evaluate(s_exp));
							}

						} else {
							s_final = s_final + Evaluator.evaluate(s_exp);
						}

					}

					s_exp = "";
				} else if(s.charAt(j) == ' ')
				continue;
				else
					s_exp = s_exp + s.charAt(j);

			}

		}
		if (s_exp.length() != 0) {
			if (checkDigit(Evaluator.evaluate(s_exp))) {
				if (checkInt(Evaluator.evaluate(s_exp))) {
					s_final = s_final + (int)Double.parseDouble(Evaluator.evaluate(s_exp));
				} else {
					s_final = s_final + Double.parseDouble(Evaluator.evaluate(s_exp));
				}

			} else {
				s_final = s_final + Evaluator.evaluate(s_exp);
			}
		}
		s_exp = "";
		try {
			FileWriter writer = new FileWriter("..\\Test\\OutputFile.txt", true);
			writer.write(s_final + "\n");
			writer.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
		}
	}
}