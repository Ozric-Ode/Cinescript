package exceptionhandle;
import java.util.*;
import java.io.*;
import datatypes.Coredeclare;

public class CheckCompatibility  extends Exception 
{
    

    /**
	 *
	 */
    private static final long serialVersionUID = 1L;
	String var1="";
	String var2="";
   
    CheckCompatibility(String var1,String var2)
    {
		this.var1=var1;
		this.var2=var2;
    }
    public String toString()
    {
    
       return("Both "+var1+" and "+var2+" are not compatible together");
        
    }

// checkscope(String exceptionText)
// {
//    // super(exceptionText);
// }
    
}
//lIKE this, rest of the exception classes will be created in different java files. 
//then there will be a parent final exception class in which we will make various functions which will throw various exceptions
//then from various files we will call functions from that parent exception classes.
//THATS IT!!!!
