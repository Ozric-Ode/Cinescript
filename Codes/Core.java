//package filehandling;

import java.util.*;
import features.Conditon;
//import filehandling.Precore;

public class Core {
    Set<String> set = new HashSet<String>();

     String  extract(String s) {
        int k = 1;
        String sfinal = "";
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '{')
                k++;
            else if (s.charAt(i) == '}')
                k--;

            if (k == 0)
                return sfinal;
            else
                sfinal = sfinal + s.charAt(i);

        }

        return sfinal;

    }

    public   void command(String data) {
     //   System.out.println("@@@@-->"+data);
        set.add("elaan");
        set.add("agartummiljao");
        set.add("warna");

     //   System.out.println(data);
        String keyword = "";
        String data2;
        int indd;

        for (int i = 0; i < data.length();) {

            keyword = "";
            while (i < data.length() && data.charAt(i) != '(') {
                keyword += data.charAt(i);
                i++;

            }
            //System.out.println(keyword + "!");
            data2 = "";
            if (set.contains(keyword)) {
                if (keyword.charAt(0) == 'e') {
                    indd = i;
                    while (data.charAt(i) != ';') {
                        data2 += data.charAt(i);
                        i++;
                    }
                    int length = data2.length();
                    String data1 = data2.substring(1, length - 1);
                    // System.out.println(data1+"%%%");
                    PrintInfo.print(data1);
                 //   System.out.println(data1);
                    i++;

                }
                if (keyword.charAt(0) == 'a') {
                    data2 += keyword ;
                    while (data.charAt(i) != ')') {
                        data2 += data.charAt(i);
                        i++;
                    }
                    data2 += ')';
                    i++;
                    data2 += '{';
                    String str2 = data.substring(i);
                    int len2 = extract(str2).length();
                    data2 += extract(str2);
                    i += len2 + 2;
                    data2 += '}';
                    if (i < data.length() && data.charAt(i) == 'w') {

                        keyword = "";
                        while (i < data.length() && data.charAt(i) != '{') {
                            keyword += data.charAt(i);
                            i++;

                        }
                        //System.out.println(keyword + "^");
                        if (set.contains(keyword)) {
                            data2 += keyword;

                            data2 += '{';
                            str2 = data.substring(i);
                            len2 = extract(str2).length();
                            data2 += extract(str2);
                            i += len2+2;
                            data2 += '}';
                        }
                    }
                  //  System.out.println(data2 + " $$$");
                  Coreif cf=new Coreif();
                    cf.process(data2);
                 //   System.out.println(i+" "+data.length());

                }

            }
            //System.out.println(i+" "+data.length());
           

        }

    }

}
