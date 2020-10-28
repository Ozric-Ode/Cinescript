package filehandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Input {
    public static void main(String[] args) {
        Core core = new Core();
		try {
			File myObj = new File("..\\Test\\TestCode4.txt");
            Scanner myReader = new Scanner(myObj);
			boolean isBracketed=false,isIf=false;
			boolean result=false;
			String data;
            while (myReader.hasNextLine()) {

	//---MONIKINDERJITSINGH-SAURAVGUPTA----- IF-ELSE PART-----STARTING-
				data = myReader.nextLine().trim();
			forIf: {
						if(data.charAt(0)=='i' ){
							isIf=true;
						if(data.charAt(data.length()-1)=='{'){
							result=core.command(data);
							System.out.println(result);
							while(data.charAt(data.length()-1)!='}'){
								data=myReader.nextLine().trim();
								if(result)
									core.command(data);
							}
							// System.out.println("ko");
							try{
								data=myReader.nextLine().trim();
							}
							catch(Exception e){}
							// isBracketed=true;
						}
						if(isIf==true && result==false && data.charAt(0)=='w'){
							data=data.trim();
							
							System.out.println(data);
						if(result==false && data.charAt(data.length()-1)=='{'){
							while( data.charAt(data.length()-1)!='}'){
								data=myReader.nextLine().trim();
								if(result==false)
									core.command(data);
							}
						}
					}
				}
			}
	//---MONIKINDERJITSINGH-SAURAVGUPTA----- IF-ELSE PART----------------END
				
				if(isIf==false && data.charAt(0)=='e' ){
					core.command(data);
				}

            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();

        }

    }

}
