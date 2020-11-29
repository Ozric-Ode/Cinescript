package features;

import filehandling.*;
import services.*;

import java.util.Stack;

import datatypes.Corescope;

public class Corewhile {

    public boolean extract_condition(String s) {
        int ind = 0;
        // System.out.println(s);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                ind = i;
                break;
            }
        }
        // System.out.println("ind=="+ ind);
        String sfinal = "";
        int k = 1;
        for (int i = ind + 1; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                k++;
            else if (s.charAt(i) == ')')
                k--;

            if (k == 0)
                break;
            else
                sfinal = sfinal + s.charAt(i);
        }
        k = 0;
        boolean cnd = false;
        // System.out.println(sfinal);
        cnd = Condition.checkCondition(sfinal);
        return cnd;
    }

    public void process(String data) {
        int ind = 0;
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == '{') {
                ind = i;
                break;
            }
        }

        String sdata = Precore.extract(data.substring(ind));
        Core cr = new Core();
        Corescope cs = new Corescope();
        while(extract_condition(data))
        {
            System.out.println("the condition is " + cnd + "scoppp==" + Precore.scope);
            cs.Enterscope("0");
            cr.command(sdata);
        }

    }

}
