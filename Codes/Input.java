package filehandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Input {
    public static void main(String[] args) {
		try {
			File myObj = new File("..\\Test\\TestCode2.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
                if (data.charAt(0) == 'p') {
					Print printObj = new Print();
					//calling Print class from filehandling package 
					printObj.print(data);
                }
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();

        }

    }

}
