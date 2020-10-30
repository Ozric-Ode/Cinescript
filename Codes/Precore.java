package services;
public class Precore {
    public  static int scope=0;
    public static String extract(String s) {
        int k = 1;
        String sfinal = "";
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '{')
                k++;
            else if (s.charAt(i) == '}')
                k--;

            if (k == 0)
            {
                scope++;
                return sfinal;
            }
            else
                sfinal = sfinal + s.charAt(i);

        }

        return sfinal;

    }

}