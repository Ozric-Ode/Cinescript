package exceptionhandle;
import java.util.*;
import java.io.*;

public class CheckSemicolon extends Exception {
    

    /**
	 *
	 */
    private static final long serialVersionUID = 1L;
	String exp="";
   
    CheckSemicolon(String exp)
    {
		this.exp=exp;
    }
    public String toString()
    {
    return("SemiColon error in the following line: "+exp+" <---------");
    
    }
    
// checkscope(String exceptionText)
// {
//    // super(exceptionText);
// }
    
}
//lIKE this, rest of the exception classes will be created in different java files. 
//then there will be a parent final exception class in which we will make various functions which will throw various exceptions
//then from various files we will call functions from that parent exception classes.
//THATS IT!!!!l