package datatypes;

import java.util.*;
import java.util.regex.*;
import datatypes.Corescope;

public class Coreverify {

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
        String newdata = "";

        for (int i = 0; i < data.length(); i++) {
            String word = "";
            while (data.charAt(i) != ' ') {
                word += data.charAt(i);
                i++;
            }

            if (!onlyDigits(word) && !set.contains(word)) {
                System.out.println(word + " *");
                if (Corescope.scope_variables.contains(word)) {

                    newdata += Coredeclare.inttype_map.get(word) + " ";
                    System.out.println(" ################# "+ Coredeclare.inttype_map.get(word) );
                } else if (Corescope.scope_variables.contains(word)) {

                    newdata += Coredeclare.stringtype_map.get(word) + " ";
                } else if (Corescope.scope_variables.contains(word)) {

                    newdata += Coredeclare.doubletype_map.get(word) + " ";
                } else {
                    System.out.println("Variable Not found "+ word);
                }
            } else {
                newdata += word + " ";

            }

        }
        newdata = " " + newdata;
        return newdata;

    }

}
