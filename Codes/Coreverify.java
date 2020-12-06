package datatypes;

import java.util.*;
import java.util.regex.*;
import datatypes.Corescope;
import exceptionhandle.FinalException;

public class Coreverify {
    static boolean checkDigit(String data) {
		boolean numeric = true;

		numeric = data.matches("-?\\d+(\\.\\d+)?");
		return numeric;
	}

    public static void PrintStack(Stack<String> s) {
        Stack<String> temp = new Stack<String>();

        while (s.empty() == false) {
            temp.push(s.peek());
            s.pop();
        }

        while (temp.empty() == false) {
            String t = temp.peek();
            System.out.print(t + " ");
            temp.pop();

            // To restore contents of
            // the original stack.
            s.push(t);
        }
    }

    public static boolean onlyDigits(String str) {
        // Regex to check string
        // contains only digits
        String regex = "[0-9]+";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the string is empty
        // return false
        if (str == null) {
            return false;
        }

        // Find match between given string
        // and regular expression
        // using Pattern.matcher()
        Matcher m = p.matcher(str);

        // Return if the string
        // matched the ReGex
        return m.matches();
    }

    // Map<String, Integer> hm = new HashMap<String, Integer>();
    // Stack<String> scopevariable = new Stack<String>();
    Set<String> set = new HashSet<String>();

    public String verify(String data) {
        data = data.trim();
        System.out.println(data + " %%");
        data += " ";
        // scopevariable.push("a");
        // StackLeaOp.push("b");
        // hm.put("a", 10);
        // hm.put("b", 20);
        set.add("<");
        set.add(">");
        set.add("<=");
        set.add(">=");
        set.add("==");
        set.add("!=");
        set.add("+");
        set.add("-");
        set.add("/");
        set.add("*");
        set.add("%");
        set.add("(");
        set.add(")");
        set.add("$");
        String newdata = "";

        for (int i = 0; i < data.length(); i++) {
            String word = "";
            while (data.charAt(i) != ' ') {
                word += data.charAt(i);
                i++;
            }

            //////////////////////////
         //   

            PrintStack(Corescope.scope_variables);
            System.out.println(Corescope.scope_variables.size()+"===========");

            if (!checkDigit(word) && !set.contains(word)) {

               
                try{
                  //    System.out.println("hhhhhhhhhhhhhhhhhhhhhhhh"+word);
                    if(FinalException.compat(word)==4)
                   FinalException.checkScope(word);
                   }
                   catch(Exception e)
                   {
                       System.out.println(word + "*");
                       System.out.println("---------------------------------++++++++++++++---------------"+e.toString());
                       System.exit(0);
                   }
                 
                if (Corescope.scope_variables.contains(word)) {

                    if (Coredeclare.inttype_map.containsKey(word)) {
                        newdata += Coredeclare.inttype_map.get(word) + " ";
                    } else if (Coredeclare.stringtype_map.containsKey(word)) {
                        newdata += (char) 34 + Coredeclare.stringtype_map.get(word) + (char) 34 + " ";
                    } else if (Coredeclare.doubletype_map.containsKey(word)) {
                        newdata += Coredeclare.doubletype_map.get(word) + " ";
                    }
                    System.out.println(" ################# " + newdata);
                    // System.out.println(" ################# "+ Coredeclare.inttype_map.get(word)
                    // );
                } else {
                   
                }
            } else {
              //  System.out.println("hhhhhhhhhhhhhhvvvvvvvvvvvvv"+word);
                newdata += word + " ";

            }

        }
   //     newdata = " " + newdata;
        System.out.println(" @@@@@@@@@@@@@" + newdata);
        return newdata;

    }

}
