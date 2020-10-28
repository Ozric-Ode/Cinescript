package filehandling;

import features.Conditon;

public class Core {
    public boolean command(String data) {
        if (data.charAt(0) == 'e') {
            //PrintInfo.print(data);
            int length = data.length();
            String data1 = data.substring(6,length-2);
            PrintInfo.print(data1);
            System.out.println(data1);
        }
		if(data.charAt(0)=='i'){
			int length = data.length();
			if(data.charAt(length-1)=='{'){
				length--;
			}
			String data1=data.substring(3, length);
			Conditon con=new Conditon();
			return con.checkCondition(data1.trim()); 
		}
		return false;
    }

}
