package services;

import java.util.*;
import features.*;
import datatypes.*;
import exceptionhandle.FinalException;
public class Core {
    /////////////////////////////////////////////////////////////////////////////////////////////
    public static void PrintStackint(Stack<Integer> s) {
        Stack<Integer> temp = new Stack<Integer>();

        while (s.empty() == false) {
            temp.push(s.peek());
            s.pop();
        }

        while (temp.empty() == false) {
            int t = temp.peek();
            System.out.print(t + " ");
            temp.pop();

            // To restore contents of
            // the original stack.
            s.push(t);
        }
    }

    public static void PrintStack(Stack<String> s) {
        Stack<String> temp = new Stack<String>();

        while (s.empty() == false) {
            temp.push(s.peek());
            s.pop();
        }

        while (temp.empty() == false) {
            String t = temp.peek();
            System.out.print(t + " ");
            temp.pop();

            // To restore contents of
            // the original stack.
            s.push(t);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    Set<String> set = new HashSet<String>();
    Set<Character> deli = new HashSet<Character>();

    public void command(String data) {
        Coredeclare cdl = new Coredeclare();
        data = data.trim();
        System.out.println("@@@@-->" + data);
        set.add("elaan");
        set.add("agartummiljao");
        set.add("warna");
        set.add("ekdoteen");
        set.add("jabtakhaijaan");
        set.add("lafzonmein");
        set.add("dhaiaksharpremke");
        deli.add(' ');
        deli.add('(');
        deli.add(';');
        // System.out.println(data);
        String keyword = "";
        String data2;
        int indd;
        int idd3;
        System.out.println(data.length());
        for (int i = 0; i < data.length();) {

            keyword = "";
            idd3 = i;

            while (i < data.length() && !deli.contains(data.charAt(i))) {
                keyword += data.charAt(i);
                // System.out.println(deli.contains(data.charAt(i))+"#"+data.charAt(i));
                i++;

            }
            System.out.println(keyword + "!");
            data2 = "";
            if (set.contains(keyword)) {
                if (keyword.equals("elaan")) {
                    indd = i;
                    while (data.charAt(i) != ';') {
                        data2 += data.charAt(i);
                        i++;
                    }
                    int length = data2.length();
                    String data1 = data2.substring(1, length - 1);
                    // System.out.println(data1+"%%%");
                    PrintInfo.print(data1);
                    // System.out.println(data1);
                    i++;

                } else if (keyword.charAt(0) == 'a') {
                    int k =1;
                    data2 += keyword;
                    data2 += '(';
                    i++;
                    while (k!=0) {
                        System.out.println("k == "+ k);
                        if(data.charAt(i) == ')')
                        {
                            k--;
                        }else if(data.charAt(i) == '(')
                        {
                            k++;
                        }
                        
                        data2 += data.charAt(i);
                        i++;
                    }
                    System.out.println("dataaaaaa 2 ====="+data2);
                    //data2 += ')';
                   // i++;
                    data2 += '{';
                    String str2 = data.substring(i);
                    String ext_str2 = Precore.extract(str2);
                    Precore.scope = Precore.scope - 1;
                    /////////////////////////
                    int len2 = ext_str2.length();
                    data2 += ext_str2;
                    i += len2 + 2;
                    data2 += '}';
                    System.out.println("the if condition===>"+data2);
                    if (i < data.length() && data.charAt(i) == 'w') {

                        keyword = "";
                        while (i < data.length() && data.charAt(i) != '{') {
                            keyword += data.charAt(i);
                            i++;

                        }
                        // System.out.println(keyword + "^");
                        if (set.contains(keyword)) {
                            data2 += keyword;

                            data2 += '{';//here it is commented by vidit
                            str2 = data.substring(i);
                            String ext_str = Precore.extract(str2);
                            Precore.scope = Precore.scope - 1;

                            ///////////////////
                            len2 = ext_str.length();
                            data2 += ext_str;
                            i += len2 + 2;
                            data2 += '}';//here it is commented by vidit
                        }
                    }
                    // System.out.println(data2 + " $$$");

                    Coreif cf = new Coreif();
                    Corescope cs = new Corescope();
                    int previous = Precore.scope;
                    cf.process(data2);
                    // PrintStack(Corescope.scope_variables);
                    // System.out.println("===========");

                    // PrintStackint(Corescope.current_scope);
                    // System.out.println("===========");
                    // PrintStackint(Corescope.scope_stack);
                    // System.out.println("===========");

                    //////////////////////////////////////////////////////////////////////////////////////
                    if (previous != Precore.scope) {
                        System.out.println("the removescope");
                        cs.Removescope();
                        Precore.scope--;
                    }
                    System.out.println("the currscope is" + Precore.scope);

                    // System.out.println(i+" "+data.length());

                } else if (keyword.equals("ekdoteen")) {
                    String data3 = "";
                    data3 += "ekdoteen";
                    while (data.charAt(i) != ';') {
                        data3 += data.charAt(i);
                        i++;
                    }
                    data3 += ";";
                    i++;
                    System.out.println(data3 + "@@@@");
                    cdl.declare(data3);

                } else if (keyword.equals("jabtakhaijaan")) 
                {
                    System.out.println("In while");
                    int k =1;
                    data2 += keyword;
                    data2 += '(';
                    i++;
                    while (k!=0) {
                        System.out.println("k == "+ k);
                        if(data.charAt(i) == ')')
                        {
                            k--;
                        }else if(data.charAt(i) == '(')
                        {
                            k++;
                        }
                        
                        data2 += data.charAt(i);
                        i++;
                    }
                    System.out.println("dataaaaaa 2 ====="+data2);
                    // data2 += ')';
                    // i++;
                    data2 += '{';
                    String str2 = data.substring(i);
                    String ext_str2 = Precore.extract(str2);
                    Precore.scope = Precore.scope - 1;
                    /////////////////////////
                    int len2 = ext_str2.length();
                    data2 += ext_str2;
                    i += len2 + 2;
                    data2 += '}';

                    Corewhile cw = new Corewhile();
                    cw.process(data2);

                    Corescope cs = new Corescope();
                    int previous = Precore.scope;

                    // PrintStack(Corescope.scope_variables);
                    // System.out.println("===========");

                    // PrintStackint(Corescope.current_scope);
                    // System.out.println("===========");
                    // PrintStackint(Corescope.scope_stack);
                    // System.out.println("===========");

                    //////////////////////////////////////////////////////////////////////////////////////
                    if (previous != Precore.scope) {
                        System.out.println("the removescope");
                        cs.Removescope();
                        Precore.scope--;
                    }
                    System.out.println("the currscope is" + Precore.scope);

                }else if (keyword.equals("lafzonmein")) {
                    String data3 = "";
                    data3 += "lafzonmein";
                    while (data.charAt(i) != ';') {
                        data3 += data.charAt(i);
                        i++;
                    }
                    data3 += ";";
                    i++;
                    System.out.println(data3 + "@@@@");
                    cdl.declare(data3);

                }else if (keyword.equals("dhaiaksharpremke")) {
                    String data3 = "";
                    data3 += "dhaiaksharpremke";
                    while (data.charAt(i) != ';') {
                        data3 += data.charAt(i);
                        i++;
                    }
                    data3 += ";";
                    i++;
                    System.out.println(data3 + "@@@@");
                    cdl.declare(data3);

                }

            }
            

            else {

                int flg=0;
                System.out.println("-0987654321`1234567890-=-09876=============DATA=============="+keyword.substring(flg));
                String strr="";
                while(keyword.charAt(flg)!='=')
                {strr=strr+keyword.charAt(flg);flg++;}
                System.out.println("-0987654321`1234567890-=-09876==========================="+strr);
                strr=strr.trim();

                if(strr.split(" ").length!=1)
                {
                    System.out.println("KEYWORD ERROR FOUND!!");
                    System.exit(0);
                }//for keyword error.
//
                else
                {
                /////////////////////////////////

                String data3 = "";
                data3 += keyword;
                while (data.charAt(i) != ';') {
                    data3 += data.charAt(i);
                    i++;
                }
                data3 += ";";
                i++;
                System.out.println(data3 + "$$$$");
                Coreassign.coreassign(data3);
            }
            }
            // System.out.println(i+" "+data.length());

        }

    }

}