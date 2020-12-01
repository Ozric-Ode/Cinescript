package exceptionhandle;
import java.util.*;
import java.io.*;
import datatypes.Coredeclare;

public class CheckDataType extends Exception {
    

    /**
	 *
	 */
    private static final long serialVersionUID = 1L;
	String var="";
	String exp="";
   
    CheckDataType(String var,String exp)
    {
		this.var=var;
		this.exp=exp;
    }
    public String toString()
    {
    
       String str="The variable \""+var+"\" is not compatible to hold  expression\""+exp+"\".\n";
     //  System.out.println(str);
        if(Coredeclare.inttype_map.containsKey(var)){
            return(str+"Expression \""+exp+"\" can't be stored in int type data type.");
        }
        else if(Coredeclare.doubletype_map.containsKey(var)){
            return(str+"Expression \""+exp+"\" can't be stored in double type data type.");
        }
        else {
            str="The variable \""+var+"\" is not compatible to hold  expression "+exp+".\n";
            return(str+"Expression "+exp+" can't be stored in String type data type. Use double quotes in expression.");
        }
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