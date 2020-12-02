package filehandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import datatypes.*;

//import services.Core;
import services.*;

public class Input {

    static int extraspace = 0;

    public static String removespace(String data, int index) {
        String newdata = "";
        extraspace = 0;
        newdata = newdata + data.charAt(index);
        int j = index - 1;
        while (j>=0 && data.charAt(j) == ' ') {
            extraspace++;
            j--;
        }
        int k = index + 1;
        while (k<data.length() && data.charAt(k) == ' ') {

            k++;
        }
        for (int i = j; i >= 0; i--) {

            newdata = data.charAt(i) + newdata;
        }
        for (int i = k; i < data.length(); i++) {

            newdata = newdata + data.charAt(i);

        }

        return newdata;
    }

    public static void main(String[] args) {
        Core core = new Core();
        try {
            File myObj = new File("..\\Test\\TestCode3.txt");
            // try {
            // FileWriter writer = new FileWriter("..\\Test\\OutputFile.txt",true);
            // writer.write("");
            // writer.close();
            // } catch (Exception e) {
            // System.out.println("An error occurred.");
            // }
            Scanner myReader = new Scanner(myObj);
            boolean isBracketed = false, isIf = false;
            boolean result = false;
            String data;
            String code = "";
            while (myReader.hasNextLine()) {

                data = myReader.nextLine();
                // System.out.println("###"+data);
                String data1 = data.trim();
                code = code + data1;

            }
            myReader.close();
            // System.out.println(code);
            // String ccode = Precore.extract(code);
            // Corescope cs=new Corescope();
            // cs.Enterscope("0");
            System.out.println(code);
            String newcode = "";
            for (int i = 0; i < code.length(); i++) {
                if (code.charAt(i) == ')' || code.charAt(i) == '}' || code.charAt(i) == '{' || code.charAt(i) == '(' || code.charAt(i) == '=') {
                    code = removespace(code, i);
                    i = i-extraspace;

                }
            }
            System.out.println(code);

            //System.out.println(newcode);
             core.command(code);
            // cs.Removescope();
            //

        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();

        }

    }

}
