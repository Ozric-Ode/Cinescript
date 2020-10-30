package filehandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import services.Core;

public class Input {
    public static void main(String[] args) {
        Core core = new Core();
        try {
            File myObj = new File("..\\Test\\TestCode2.txt");
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
            core.command(code);

        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();

        }

    }

}
