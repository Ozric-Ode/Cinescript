package filehandling;

import features.*;
import java.util.Scanner;

public class Coreif {
    public boolean extract_condition(String s)
    {
        int ind=0;
    //    System.out.println(s);
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                ind=i;break;
            }
        }
      //  System.out.println("ind=="+ ind);
        String sfinal="";int k=1;
        for(int i=ind+1;i<s.length();i++)
        {
            if(s.charAt(i)=='(')k++;
            else if(s.charAt(i)==')')k--;
            
            if(k==0)
            break;
            else sfinal=sfinal+s.charAt(i);
        }
        k=0;
        boolean cnd=false;
  //      System.out.println(sfinal);
        cnd=Conditon.checkCondition(sfinal);
        return cnd;
    }

    public void process(String data)
    { 
      //  System.out.println(data);
        boolean cnd=extract_condition(data);
        int ind=0;
        for(int i=0;i<data.length();i++) {if(data.charAt(i)=='{'){ind=i;break;}}

        String sdata=Precore.extract(data.substring(ind));
        int ind2=ind+sdata.length()+1;

        for(int i=ind2;i<data.length();i++) {if(data.charAt(i)=='{'){ind=i;break;}}

        String sdata2=Precore.extract(data.substring(ind));

        Core cr=new Core();
       // System.out.println("the condition is "+cnd);
        if(cnd)
        {
          
            cr.command(sdata);
        }
        else
        {
         cr.command(sdata2);
        }

    }    
}