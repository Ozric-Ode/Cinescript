package exceptionhandle;
import java.util.*;
import java.io.*;

public class Checkscope extends Exception {
    

    /**
	 *
	 */
    private static final long serialVersionUID = 1L;
    String s="";
   
    Checkscope(String s)
    {
        this.s=s;
    }
    public String toString()
    {
       
        return("variable \""+s+"\" is not declared");
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