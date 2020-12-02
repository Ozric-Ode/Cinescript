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

    public static int compat(String var1)
    {
        int fl=0;int fl2=0;
        for(int i=0;i<var1.length();i++)
        {
            if(var1.charAt(i)>='0'&var1.charAt(i)<='9')
            fl++;
            else if(var1.charAt(i)=='.')
            fl2++;
        }
        if(fl==var1.length()-1&&fl2==1)
        return 1;
        ////////////////////////////////

        int fl1=0;
        for(int i=0;i<var1.length();i++)
        {
            if(var1.charAt(i)>='0'&&var1.charAt(i)<='9')
            fl1++;
        }
        if(fl1==var1.length())
        return 2;

        ////////////////////////////////
        if((var1.charAt(0)==var1.charAt(var1.length()-1) && var1.charAt(0)==(char)34))
        return 3;
        else return 4;
    }
    
    public static void checkConditionType(String var1,String var2)throws CheckCompatibility
    {
        //System.out.println("var2=="+var2);
        
        
      //  System.out.println("compatibilityyyyyyyyyyyyyy "+var1+ " "+var2+compat(var1)+ " "+compat(var2) );
        if((compat(var1)!=compat(var2))||compat(var1)==4)
        throw new CheckCompatibility(var1,var2);
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

    public static void checkCondition(String s)throws CheckCondition
    {
        System.out.println("hellllllllllllllllllllllllllllllllllllllll");
        Set<String> st = new HashSet<String>();
        Set<String> st1 = new HashSet<String>();
         // st.add("+");st.add("-");st.add("*");st.add("/");
        st.add("<=");st.add(">=");st.add("!=");st.add("==");
        st1.add(">");st1.add("<");

        

int fl=0;   int g=0;
String l1="",l2="";
        for(int i=0;i<s.length()-1;i++)
        {
            String ab="";
             ab=ab+s.charAt(i)+s.charAt(i+1);
             if(st.contains(ab))
             {
                 l2=ab;
                 fl++;
             }

        }
        for(int i=0;i<s.length();i++)
        {
            String ab="";
             ab=ab+s.charAt(i);
             if(st1.contains(ab))
             {
                 l1=ab;
                 System.out.println("s-->>>"+s);
                 g++;
             }

        } 

        System.out.println("fl==="+fl+"g==="+g);

        if(fl+g!=1)
        {
            System.out.println("l1==="+l1+"l2==="+l2+"###");
            if(!((l1.equals("<")&&l2.equals("<="))||(l1.equals(">")&&l2.equals(">="))))
            {
                // if(l1.equals("<")&&l2.equals("<="))
                // System.out.println("BRAVO");
                throw new CheckCondition(s);
            }

        }
        // {
        // }
        // !(l2.contains(l1)))
        
        
    }

    
}
