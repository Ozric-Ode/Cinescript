package datatypes;

import java.util.*;
import services.*;

public class Coredeclare {
    public static Map<String, Integer> inttype_map = new HashMap<String, Integer>();
    Set<Character> deli = new HashSet<Character>();
    public void declare(String dec) {
        deli.add(' ');
        deli.add(';');
        deli.add('=');
        Set<String> dt_set = new HashSet<String>(); 
        dt_set.add("ekdoteen"); 
        dt_set.add("lafzonmein");  
        Corescope scope=new Corescope();       
        String datatype="";
        String var="";
        String assign;
        int ind;
        int flag=0;
        dec.trim();
        if(dec.contains("=")) {
            flag=1;
        }
        int i=0;
        while(i<dec.length() &&  !deli.contains(dec.charAt(i))){
            datatype+=dec.charAt(i);
            //System.out.println(deli.contains(dec.charAt(i))+"#"+dec.charAt(i));
            i++;
        }
        
        ind=i;
        assign=dec.substring(ind+1);
        assign = assign.trim();
        i++;
        System.out.println(assign);
        if(dt_set.contains(datatype)) {
            if(datatype.charAt(0)=='e') {
                while(i<dec.length() && !deli.contains(dec.charAt(i))) {
                    var+=dec.charAt(i);
                    i++;
                }
                var = var.trim();
                System.out.println("$$"+var);
                inttype_map.put(var, 0);
                scope.Enterscope(var);
                if(flag==1) {
                    Coreassign.coreassign(assign);
                }
                
            }
        }   
    }
}

