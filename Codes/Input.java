package filehandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Input {
    public static void main(String[] args) {
        Core core = new Core();
		try {
			File myObj = new File("..\\Test\\TestCode.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
                //Core.command(data);
                //PrintInfo.print(data);
                core.command(data);

            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();

        }

    }

}
