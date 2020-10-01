
import java.util.Stack; 

public class evaluator 
{ 
	public static int evaluate(String expression) 
	{ 
        char[] tokens = expression.toCharArray(); 
        evaluator obj= new evaluator();

		Stack<Integer> values = new Stack<Integer>(); 

		Stack<Character> ops = new Stack<Character>(); 

		for (int i = 0; i < tokens.length; i++) 
		{ 
			
			if (tokens[i] == ' ') 
				continue; 

			if (tokens[i] >= '0' && tokens[i] <= '9') 
			{ 
				StringBuffer sbuf = new StringBuffer(); 
				
				while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') 
					sbuf.append(tokens[i++]); 
				values.push(Integer.parseInt(sbuf.toString())); 
			} 

		
			else if (tokens[i] == '(') 
				ops.push(tokens[i]); 

			else if (tokens[i] == ')') 
			{ 
				while (ops.peek() != '(') 
				values.push(obj.operationss(ops.pop(), values.pop(), values.pop())); 
				ops.pop(); 
			} 

		
			else if (tokens[i] == '+' || tokens[i] == '-' || 
					tokens[i] == '*' || tokens[i] == '/') 
			{ 
				
				while (!ops.empty() && obj.hasPrecedence(tokens[i], ops.peek())) 
				values.push(obj.operationss(ops.pop(), values.pop(), values.pop())); 

				ops.push(tokens[i]); 
			} 
		} 

	
		while (!ops.empty()) 
			values.push(obj.operationss(ops.pop(), values.pop(), values.pop())); 

		return values.pop(); 
	} 

	public  boolean hasPrecedence(char op1, char op2) 
	{ 
		if (op2 == '(' || op2 == ')') 
			return false; 
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) 
			return false; 
		else
			return true; 
	} 

	public  int operationss(char op, int b, int a) 
	{ 
       
         if(op == '*')
        return a*b;
        else if(op == '-')
        return a-b;
        else if(op == '/')
        {
            if(b==0)
            throw new UnsupportedOperationException("Cannot divide by zero"); 
        return a/b;
        }
        else if(op =='+')
        return a+b;
       
		return 0; 
	} 

	
}
