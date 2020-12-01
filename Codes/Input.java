package filehandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import datatypes.*;

//import services.Core;
import services.*;

public class Input {
    public static void main(String[] args) {
        Core core = new Core();
        try {
            File myObj = new File("..\\Test\\TestCode3.txt");
            // try {
			// 	FileWriter writer = new FileWriter("..\\Test\\OutputFile.txt",true);
			// 	writer.write("");
			// 	writer.close();
			// } catch (Exception e) {
			// 	System.out.println("An error occurred.");
			// }
            Scanner myReader = new Scanner(myObj);
            boolean isBracketed = false, isIf = false;
            boolean result = false;
            String data;
            String code = "";
            while (myReader.hasNextLine()) {

                data = myReader.nextLine();
                //  System.out.println("###"+data);
                String data1 = data.trim();
                code = code + data1;

            }
            myReader.close();
            // System.out.println(code);
        //    String ccode = Precore.extract(code);
         //   Corescope cs=new Corescope();
        //   cs.Enterscope("0");
            core.command(code);
          //  cs.Removescope();
          //  

        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();

        }

    }

}
