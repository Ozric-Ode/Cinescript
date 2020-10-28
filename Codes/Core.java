package filehandling;

import java.util.*;
import features.Conditon;
import filehandling.Precore;

public class Core {
    Set<String> set = new HashSet<String>();

    public void command(String data) {
        set.add("elaan");
        set.add("agartummiljao");
        set.add("warna");

        System.out.println(data);
        String keyword = "";
        String data2;
        int indd;

        for (int i = 0; i < data.length();) {

            keyword = "";
            while (data.charAt(i) != '(') {
                keyword += data.charAt(i);
                i++;

            }
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
                    // PrintInfo.print(data1);
                    System.out.println(data1);

                }
                if (keyword.charAt(0) == 'a') {
                    data2 += keyword + '(';
                    while (data.charAt(i) != ')') {
                        data2 += data.charAt(i);
                        i++;
                    }
                    data2 += ')';
                    i++;
                    data2+='{';
                    String str2 = data.substring(i);
                    int len2 = Precore.extract(str2).length();
                    data2 += Precore.extract(str2);
                    i += len2;
                    data2+='}';

                    keyword = "";
                    while (data.charAt(i) != '(') {
                        keyword += data.charAt(i);
                        i++;

                    }
                    if (set.contains(keyword)) {
                        data2 += keyword + '(';
                        while (data.charAt(i) != ')') {
                            data2 += data.charAt(i);
                            i++;
                        }
                        data2 += ')';
                        i++;
                        data2+='{';
                        str2 = data.substring(i);
                        len2 = Precore.extract(str2).length();
                        data2 += Precore.extract(str2);
                        i += len2;
                        data2+='}';
                    }

                }
                
            }
            i++;

        }

        // if (data.charAt(0) == 'e') {
        // //PrintInfo.print(data);
        // int length = data.length();
        // String data1 = data.substring(6,length-2);
        // PrintInfo.print(data1);
        // System.out.println(data1);
        // }
        // if(data.charAt(0)=='i'){
        // int length = data.length();
        // if(data.charAt(length-1)=='{'){
        // length--;
        // }
        // String data1=data.substring(3, length);
        // Conditon con=new Conditon();
        // return con.checkCondition(data1.trim());
        // }
        // return false;
    }

}
