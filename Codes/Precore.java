package services;

import java.util.HashSet;
import java.util.Set;

public class Precore {
    public static int scope = 0;

    public static String correctString(String exp) {
        String corrected = "";
        String[] words = exp.split("(?<=[-+*/?%,$\")(><=!)])|(?=[-+*/?%,$\")(><=!)])");
      
        String characters = "<>!=-+*/?%,$)(\"";
        // for (int i = 0; i < words.length; i++) {
        //     if (words[i].length() == 1) {
        //         if (characters.contains(words[i])) {

        //             corrected += " " + words[i];
        //             // if(words[i]==">"||words[i]=="<")

        //             // if (i+1<words.length && characters.contains(words[i + 1])) {
        //                 if (i+1<words.length && words[i+1].equals("=")) {
        //                 corrected += words[i + 1]+" ";
        //                 i++;
        //                 continue;
        //             }

        //             if (i + 1 != words.length) {
        //                 corrected += " " + words[i + 1];
        //                 i++;
        //                 continue;
        //             }
        //             // i++;
        //         } else {
        //             corrected += words[i] + " ";
        //         }
        //     } else {
        //         corrected += words[i] + " ";
        //     }
        // }
        // System.out.println(corrected);
        // return corrected;
        String scorrected = "";
        for(int i=0;i<exp.length();i++){
            // System.out.println(exp.charAt(i));
            if(characters.contains(Character.toString(exp.charAt(i)))){
                if(exp.charAt(i)=='(')
                scorrected+=exp.charAt(i);
                else
              scorrected+=" "+ exp.charAt(i);
               if(i+1<exp.length() && exp.charAt(i+1)=='='){
                   scorrected+=exp.charAt(i+1)+" ";
                   i++;
               }
               if(exp.charAt(i)!=')')
               scorrected+=" ";
               
            }
            else{
                scorrected+=exp.charAt(i);
            }
        }

        System.out.println(scorrected);
        return scorrected;
    }

    public static String extract(String s) {
        int k = 1;
        String sfinal = "";
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '{')
                k++;
            else if (s.charAt(i) == '}')
                k--;

            if (k == 0) {
                scope++;
                return sfinal;
            } else
                sfinal = sfinal + s.charAt(i);

        }

        return sfinal;

    }

}