package filehandling;

//import filehandling.*;

public class Core {
    public void command(String data) {
        if (data.charAt(0) == 'e') {
            //PrintInfo.print(data);
            int length = data.length();
            String data1 = data.substring(6,length-2);
            PrintInfo.print(data1);
            System.out.println(data1);

        }
    }

}
