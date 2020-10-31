package datatypes;

import java.util.*;
import services.*;

public class Coredeclare {
    public static Map<String, Integer> inttype_map = new HashMap<String, Integer>();
    public void declare(String dec) {
        Set<String> dt_set = new HashSet<String>(); 
        dt_set.add("ekdoteen"); 
        dt_set.add("lafzonmein"); 
        Coreassign ass=new Coreassign();         
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
        while(i<dec.length() && dec.charAt(i)!=' '){
            datatype+=dec.charAt(i);
            i++;
        }
        ind=i;
        assign=dec.substring(ind+1);
        assign.trim();
        if(dt_set.contains(datatype)) {
            if(datatype.charAt(0)=='e') {
                while(i<dec.length() && (dec.charAt(i)!=' ' ||dec.charAt(i)!=';' ||dec.charAt(i)!='=')) {
                    var+=dec.charAt(i);
                    i++;
                }
                var.trim();
                if(flag==0){
                    inttype_map.put(var, 0);
                }
                else if(flag==1) {
                    inttype_map.put(var, 0);
                    ass.assign(assign);
                }
                
            }
        }   
    }
}
