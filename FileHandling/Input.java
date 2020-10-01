package FileHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Input {
    public static void main(String[] args) {
        try {
            File myObj = new File("C:\\Users\\Chirag\\CPPFiles\\CodeBusta-Language\\Test\\TestCode.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.charAt(0) == 'p') {
                    // Call print class from Features Package
                }
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();

        }

    }

}
