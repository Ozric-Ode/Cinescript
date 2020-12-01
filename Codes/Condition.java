package features;
import java.util.*;
import datatypes.Coreverify;
import services.Precore;
import exceptionhandle.*;

public class Condition extends Exception{


	static boolean checkDigit(String data) {
		boolean numeric = true;

		numeric = data.matches("-?\\d+(\\.\\d+)?");
		return numeric;
	}

	static boolean checkInt(String data) {
		double d = Double.parseDouble(data);
		if (Math.ceil(d) == Math.floor(d)) {
			return true;
		} else {
			return false;
		}
	}


	public static boolean checkCondition(String data){
		System.out.println("dataaaaaaaaaaaaadaaaaaaaaaaaaaaaaataaaaaaaaaa"+data);
		data=Precore.correctString(data);
		try{
			FinalException.checkCondition(data);
		}
		catch(Exception e){
			System.out.println(e.toString());
			System.exit(0);
		}
		Coreverify cv=new Coreverify();
		//data = cv.verify(data);
		String var1="";
		String symbol="";
		String var2="";
		int j=0;
		Set<String> set = new HashSet<String>();
		set.add("==");
		set.add("!=");
		set.add(">");
		set.add("<=");
		set.add(">=");
		set.add("<");
		//////////////////////
		System.out.println("dataaaaaaaaaaaaa"+data);
		while(j!=data.length()-1){
			if(data.charAt(j)!='>'&& data.charAt(j)!='<' && data.charAt(j)!='='&& data.charAt(j)!='!' )
				{
					if(symbol.length()==0 )
						var1+=data.charAt(j++);
					else
						var2+=data.charAt(j++);
				}
			else {
				symbol+=data.charAt(j++);
				if(data.charAt(j)=='='){
					symbol+=data.charAt(j++);
				}
			}			
		}

		var1=var1.trim();
		var2=var2.trim();

		if(FinalException.compat(var1)!=3)
		var1=cv.verify(var1);
		if(FinalException.compat(var2)!=3)
		var2=cv.verify(var2);
		
		
	//	System.out.println("ddddddd+++"+var1+"---------ddddddd++"+var2+"!!!!!!"+FinalException.compat(var2));
		///////////////////////////////////////
		try {
			FinalException.checkConditionType(var1,var2);
		} catch (Exception e) {
			System.out
					.println("--0987654321qwertyuioplkjhgfdsazxy[;.p;/8o.987234985--=-=-=-=-=-=-=-=-=-1-1-`--`-`--`-`-"
							+ e.toString());
			System.exit(0);
		}
		double result1 = 0.0,result2=0.0;
		boolean notString=false;
		try {
			Double.parseDouble( var1 );		
			Double.parseDouble( var2 );		
			notString=true;
		}
		catch( Exception e ) {
			notString=false;
		}

		if(notString){
			
			if (checkDigit(Evaluator.evaluate(var1))) {
				if (checkInt(Evaluator.evaluate(var1))) {
					result1 =  (int)Double.parseDouble(Evaluator.evaluate(var1));
				} else {
					result1 =  Double.parseDouble(Evaluator.evaluate(var1));
				}

			} else {
				//result1=Evaluator.evaluate(var1);
				System.out.println("String found");
			}
			
			if (checkDigit(Evaluator.evaluate(var1))) {
				if (checkInt(Evaluator.evaluate(var1))) {
					result2 =  (int)Double.parseDouble(Evaluator.evaluate(var2));
				} else {
					result2 =  Double.parseDouble(Evaluator.evaluate(var2));
				}

			} else {
				//result1=Evaluator.evaluate(var1);
				System.out.println("String found");
			}
			if(set.contains(symbol)){
			switch(symbol){
				case  "<": return (result1<result2);
				case ">":return (result1>result2);
				case "==":return (result1==result2);
				case "!=":return (result1!=result2);
				case ">=":return (result1>=result2);
				case "<=":return (result1<=result2);
			}}
			else{
				System.out.println(symbol+"->operand undefined");
				System.exit(0);
			}
		}
		else{
			if(symbol.compareTo("==")==0 && var1.compareTo(var2)==0)
				return true;
			}
			return false;
		}
}
