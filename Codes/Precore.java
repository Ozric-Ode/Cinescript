package services;

import java.util.HashSet;
import java.util.Set;

public class Precore {
    public static int scope = 0;

    public static String correctString(String exp) {
        String corrected = "";
        String[] words = exp.split("(?<=[-+*/?%,$\")(><=!)])|(?=[-+*/?%,$\")(><=!)])");
      
        String characters = "<>!=-+*/?%,$)(\"";
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == 1) {
                if (characters.contains(words[i])) {

                    corrected += " " + words[i];
                    // if(words[i]==">"||words[i]=="<")

                    if (i+1<words.length && characters.contains(words[i + 1])) {
                        corrected += words[i + 1]+" ";
                        i++;
                        continue;
                    }

                    if (i + 1 != words.length) {
                        corrected += " " + words[i + 1];
                        i++;
                        continue;
                    }
                    // i++;
                } else {
                    corrected += words[i] + " ";
                }
            } else {
                corrected += words[i] + " ";
            }
        }
        System.out.println(corrected);
        return corrected;
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