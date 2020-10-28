import java.util.Scanner;

public class Coreif {
    public boolean extract_condition(String s)
    {
        int ind=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                ind=i;break;
            }
        }
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
        cnd=Condition.checkCondition(sfinal);
        return cnd;
    }

    public void process(String data)
    { 
        boolean cnd=extract_condition(data);
        int ind=0;
        for(int i=0;i<data.length();i++) {if(data.charAt(i)=='{'){ind=i;break;}}

        String sdata=Precore.extract(data.substring(ind));
        int ind2=ind+sdata.length()+1;

        for(int i=ind2;i<data.length();i++) {if(data.charAt(i)=='{'){ind=i;break;}}

        String sdata2=Precore.extract(data.substring(ind));


        if(cnd)
        {
            Core.command(sdata);
        }
        else
        {
         Core.command(sdata2);
        }

    }    
}
