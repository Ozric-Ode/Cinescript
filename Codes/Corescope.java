package datatypes;
import java.util.*;
import services.*;


public class Corescope {
  public static Stack<Integer> scope_variables = new Stack<Integer>();
  public static Stack<Integer> current_scope = new Stack<Integer>();
  public static Stack<Integer> scope_stack= new Stack<Integer>();

    public void Enterscope(char ch)
    {
        int chh=ch;
        scope_variables.push(chh);
      //  scope_stack.push(scope);

        if(!(scope_stack.isEmpty()) && Precore.scope==(Integer)scope_stack.peek())
        {
            current_scope.pop();
            current_scope.push(Precore.scope+1);
        }
        else
        {
            current_scope.push(Precore.scope);
        }
        scope_stack.push(Precore.scope);
    }

    public void Removescope()
    {
        int num = (Integer)current_scope.peek();
        // System.out.println("nummm");
        // System.out.println((Integer)scope_variables.peek());

        for(int i=0;i<num;i++)
        {
            scope_variables.pop(); scope_stack.pop();
        }
        current_scope.pop();
       

    }

}