package features;


public class Condition extends Exception{
	public static boolean checkCondition(String data){

		Coreverify cv=new Coreverify();
		data = cv.verify(data);
		String var1="";
		String symbol="";
		String var2="";
		int j=0;
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
		int result1,result2;
		boolean isBothInt=false;
		try {
			Integer.parseInt( var1 );		
			Integer.parseInt( var2 );		
			isBothInt=true;
		}
		catch( Exception e ) {
			isBothInt=false;
		}

		if(isBothInt){
			result1=Evaluator.evaluate(var1);
			result2=Evaluator.evaluate(var2);
			switch(symbol){
				case  "<": return (result1<result2);
				case ">":return (result1>result2);
				case "==":return (result1==result2);
				case "!=":return (result1!=result2);
				case ">=":return (result1>=result2);
				case "<=":return (result1<=result2);
				default: return false;
			}
		}
		else{
			if(symbol.compareTo("==")==0 && var1.compareTo(var2)==0)
				return true;
			return false;
		}
	}
}
