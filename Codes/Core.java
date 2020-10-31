package services;

import java.util.*;
import features.*;
import datatypes.*;

public class Core {
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

        deli.add(' ');
        deli.add('(');

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

                }
                if (keyword.charAt(0) == 'a') {
                    data2 += keyword;
                    while (data.charAt(i) != ')') {
                        data2 += data.charAt(i);
                        i++;
                    }
                    data2 += ')';
                    i++;
                    data2 += '{';
                    String str2 = data.substring(i);
                    String ext_str2 = Precore.extract(str2);
                    Precore.scope = Precore.scope - 1;
                    /////////////////////////
                    int len2 = ext_str2.length();
                    data2 += ext_str2;
                    i += len2 + 2;
                    data2 += '}';
                    if (i < data.length() && data.charAt(i) == 'w') {

                        keyword = "";
                        while (i < data.length() && data.charAt(i) != '{') {
                            keyword += data.charAt(i);
                            i++;

                        }
                        // System.out.println(keyword + "^");
                        if (set.contains(keyword)) {
                            data2 += keyword;

                            data2 += '{';
                            str2 = data.substring(i);
                            String ext_str = Precore.extract(str2);
                            Precore.scope = Precore.scope - 1;

                            ///////////////////
                            len2 = ext_str.length();
                            data2 += ext_str;
                            i += len2 + 2;
                            data2 += '}';
                        }
                    }
                    // System.out.println(data2 + " $$$");

                    Coreif cf = new Coreif();
                    Corescope cs = new Corescope();
                    int previous = Precore.scope;
                    cf.process(data2);
                    System.out.println("the currscope is" + Precore.scope);

                    if (previous != Precore.scope) {
                        cs.Removescope();
                        Precore.scope--;
                    }
                    // System.out.println(i+" "+data.length());

                }
                if (keyword.equals("ekdoteen")) {
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

                }

            } else {
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
            // System.out.println(i+" "+data.length());

        }

    }

}