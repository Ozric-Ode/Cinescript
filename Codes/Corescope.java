package Cinescript.Datatypes;
import java.util.*;

public class Corescope {
   static Stack<Integer> scope_variables = new Stack<Integer>();
   static Stack<Integer> current_scope = new Stack<Integer>();
   static Stack<Integer> scope_stack= new Stack<Integer>();

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
        for(int i=0;i<num;i++)
        {
            scope_variables.pop();
        }
        current_scope.pop();
    }

}
