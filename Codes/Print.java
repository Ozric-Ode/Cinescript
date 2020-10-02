package filehandling;

import java.util.*;
import java.io.FileWriter; // Import the FileWriter class
import java.io.IOException; // Import the IOException class to handle errors

import features.*;

class Print {
    public void print(String s1) {
        
        //+ ====> Concatenation
		//'' ===> String in print function
		String s=s1.substring(6,s1.length()-2);
		Stack<Character> mainStack = new Stack<Character>();
		String s_cnc=" ";
		String s_exp=" ";
		String s_final=" ";


       
      
        boolean isStarted = false;
            for (int j = 0; j < s.length(); j++) {

				if(s.charAt(j)==(char)34)
				{
					if(mainStack.empty())
					{mainStack.push((Character) s.charAt(j));}

					else
					{

						s_final=s_final+s_cnc;
						s_cnc="";
						mainStack.pop();
					}
				continue;
				}

				if(!mainStack.empty())
				{
					s_cnc=s_cnc+s.charAt(j);
				}
				else
				{
					if(s.charAt(j)==',')
					{
						s_final=s_final+Evaluator.evaluate(s_exp);
						s_exp="";
					}
					else
					s_exp=s_exp+s.charAt(j);

				}


            }
        
        try {
            FileWriter writer = new FileWriter("..\\Print\\OutputFile.txt");
            writer.write(s_final);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}