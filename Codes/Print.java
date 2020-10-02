package filehandling;

import java.util.*;
import java.io.FileWriter; // Import the FileWriter class
import java.io.IOException; // Import the IOException class to handle errors

import features.*;

class Print {
    public void print(String s) {
        
        //+ ====> Concatenation
        //'' ===> String in print function
        Stack<Character> mainStack = new Stack<Character>();
        String s1 = "";
        String s2 = "";
        int i=6;
        boolean isStarted = false;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == '(' && isStarted == false) {
                    mainStack.push((Character) s.charAt(j));
                    isStarted = true;
                    j++;
                    continue;
                }
                if (s.charAt(j) == (char) 34) {
                    if (isStarted == false) {
                        isStarted = true;
                        continue;
                    } else if (isStarted == true) {
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
                if (s.charAt(j) != (char) 34 && isStarted==true) {
                    s2 = s2.concat(Character.toString(s.charAt(j)));
                }
            }
        
        try {
            FileWriter writer = new FileWriter("..\\Print\\OutputFile.txt");
            writer.write(s2);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}