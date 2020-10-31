package features;

import filehandling.*;
import services.*;
import datatypes.Corescope;

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
        cnd=Condition.checkCondition(sfinal);
        return cnd;
    }

    public void process(String data)
    { 
      //  System.out.println(data);
        boolean cnd=extract_condition(data);
        int ind=0;
        for(int i=0;i<data.length();i++) {if(data.charAt(i)=='{'){ind=i;break;}}

        String sdata=Precore.extract(data.substring(ind));
        Precore.scope--;
        int ind2=ind+sdata.length()+1;

       
        Core cr=new Core();
        Corescope cs=new Corescope();
       System.out.println("the condition is "+cnd+"scoppp=="+Precore.scope);
       System.out.println("THE ind2"+ind2+" "+data.length());
        if(cnd)
        {
            Precore.scope++;
            cs.Enterscope("0");
            cr.command(sdata);
        }
      
        
            else if(ind2+1<data.length())
            {
            for(int i=ind2;i<data.length();i++) {if(data.charAt(i)=='{'){ind=i;break;}}
    
            String sdata2=Precore.extract(data.substring(ind));
    
         //   Precore.scope--;
            
    
           // Precore.scope++;
            cs.Enterscope("0");
         cr.command(sdata2);
            }
        

    }    
}