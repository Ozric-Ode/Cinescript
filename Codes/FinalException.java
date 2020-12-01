package exceptionhandle;

import java.util.*;
import datatypes.Coredeclare;
import exceptionhandle.CheckDataType;
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
    public static void checkDatatype(String var,String exp)throws CheckDataType
    {
         if(Coredeclare.doubletype_map.containsKey(var) == true)
        {
            int fl=0;int fl2=0;
            for(int i=0;i<exp.length();i++)
            {
                if(exp.charAt(i)>='0'&exp.charAt(i)<='9')
                fl++;
                else if(exp.charAt(i)=='.')
                fl2++;
            }
            if(fl!=exp.length()-1&&fl2!=1)
            throw new CheckDataType(var,exp);
        }

        else if(Coredeclare.inttype_map.containsKey(var) == true )
        {
           
            int fl=0;
            for(int i=0;i<exp.length();i++)
            {
                if(exp.charAt(i)>='0'&&exp.charAt(i)<='9')
                fl++;
            }
            if(fl!=exp.length())
            {
               // System.out.println("the expresssss=="+exp);
            throw new CheckDataType(var,exp);
            }
        }
        else
        {
            if(!(exp.charAt(0)==exp.charAt(exp.length()-1) && exp.charAt(0)==(char)34))
            throw new CheckDataType(var,exp);

        }
        
    }

    public static void checkSemicolon(String str)throws CheckSemicolon 
    {
        int fl=0;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)==';')
            fl++;
        }
        if(fl!=1||str.charAt(str.length()-1)!=';')
        {
          
        throw new CheckSemicolon(str);
        }
    }
    public static void checkOperator(String s)throws CheckOperator
    {
        Set<String>st=new HashSet<String>();
        // st.add("+");st.add("-");st.add("*");st.add("/");
        // st.add("<=");st.add(">=");st.add("!=");st.add("==");
        // st.add(">");st.add("<");
        int fl=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='=')fl++;
        }
        if(fl!=1)
        {
            throw new CheckOperator(s);
        }
        else
        {
            String arr[]=s.split("=");
            if(arr.length!=2)
            throw new CheckOperator(s);
            // else
            // checkDatatype( arr[0], arr[1]);



            

        }
    }

    
}
