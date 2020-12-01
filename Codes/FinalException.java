package exceptionhandle;

import java.util.*;
import datatypes.Coredeclare;
//import various things.
public class FinalException {

    public static void checkScope(String a)throws Checkscope
    {
        if(Coredeclare.inttype_map.containsKey(a) == false && Coredeclare.doubletype_map.containsKey(a) == false && Coredeclare.stringtype_map.containsKey(a) ==false)
        throw new Checkscope(a);
        
    }
    public static void checkDeclare(String a)throws CheckDeclare
    {
        if(Coredeclare.inttype_map.containsKey(a) == true || Coredeclare.doubletype_map.containsKey(a) == true || Coredeclare.stringtype_map.containsKey(a) ==true)
        throw new CheckDeclare(a);
        
    }
}
