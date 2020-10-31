package Datatypes;

import java.util.*;

import features.Evaluator;

public class Coreassign {
	public static void coreassign(String str){
		String var="";
		String expression="";
		boolean isEquality=false;
		int j=0;
		str=str.trim();
		while(j!=str.length()-1 && str.charAt(j)!=';'){
			if(str.charAt(j)=='='){
				isEquality=true;
				j++;
				continue;
			}
			if(isEquality==false){
				var+=str.charAt(j++);
			}
			else{
				expression+=str.charAt(j++);
			}
		}
		//assuming class name to be Coredeclare
		//assuming map of ints name to be intmap
		var=var.trim();
		expression=expression.trim();
		if(Coredeclare.intmap.containsKey(var)==true){
			int result=Evaluator.evaluate(expression);
			Coredeclare.intmap.replace(var, result); 
		}
		else{
			//throw error
		}

	}
}
