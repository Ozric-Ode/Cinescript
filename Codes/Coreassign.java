package datatypes;

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

		var=var.trim();
		expression=expression.trim();
		
		if(Coredeclare.inttype_map.containsKey(var)==true){
			if(Corescope.scope_variables.contains(var)==true){
				if(Math.floor(Evaluator.evaluate(expression))==Math.ceil(Evaluator.evaluate(expression))){
					int result=(int)Evaluator.evaluate(expression);
					Coredeclare.inttype_map.replace(var, result); 
				}
				else{
					//throw of error of providing a suitable type casting to convert double to int
				}
			}
			else{
				//throw error of scope
			}
		}
		else if(Coredeclare.doubletype_map.containsKey(var)==true){//check the name of double type map in coredeclare.java
			if(Corescope.scope_variables.contains(var)==true){
				double dresult=Evaluator.evaluate(expression);
				Coredeclare.doubletype_map.replace(var, dresult); 
			}
			else{
				//throw error of scope
			}
		}
		else if(Coredeclare.stringtype_map.containsKey(var)==true){//check the name of string type map in coredeclare.java
			if(Corescope.scope_variables.contains(var)==true){
				String sresult=getConcatenatedString(expression);
				Coredeclare.stringtype_map.replace(var, sresult); 
			}
			else{
				//throw error of scope
			}
		}
		else{
			//throw error of non-availability of variable
		}

	}
	public static String getConcatenatedString(String s){
		Stack<Character> mainStack = new Stack<Character>();
		String s_final="";
		String s_cnc="";
		String s_exp="";		
		for (int j = 0; j < s.length(); j++) {

			//Stack<String> mainStack;
			if (s.charAt(j) == (char) 34)
			{
				if(mainStack.empty())
				{mainStack.push((Character) s.charAt(j));}

				else
				{

					s_final=s_final+s_cnc;
					s_cnc="";
					mainStack.pop();
				}
			continue;
			}

			if(!mainStack.empty())
			{
				s_cnc=s_cnc+s.charAt(j);
			}
			else
			{
				if(s.charAt(j)=='$')
				{
					if(s_exp.length()!=0)
					s_final=s_final+Evaluator.evaluate(s_exp);
					s_exp="";
				}
				else
				s_exp=s_exp+s.charAt(j);

			}
		}
		if(s_exp.length()!=0)
		s_final=s_final+Evaluator.evaluate(s_exp);
		return s_final;
	}
}
