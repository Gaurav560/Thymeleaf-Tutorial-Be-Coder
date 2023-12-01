package enumPractice;

import java.util.Arrays;

enum MyMessage {
	//MyMessage is a class and kil,deploy,bhaag these are objects of enum class
	kill,deploy,bhaag;
}
public class EnumClassExample {

	public static void main(String[] args) {
		
		//values gives all the constant values in the enum class
		//enum is a class in which we store constant values that can be used again and again
		//throughout the project such as http response codes etc
		
		MyMessage[] m=MyMessage.values();
		MyMessage m1=MyMessage.bhaag;
		System.out.println(m1.ordinal());
		
		//ordinal gives u index of the objects or properties in enum 
		System.out.println(Arrays.toString(m));
		
		
		
		
		
		//working with if -else
		
		if (m1==MyMessage.kill) {
			System.out.println("just kill ");
			
		}else if (m1==MyMessage.deploy) {
			System.out.println("just deploy");
			
		}else {
			System.out.println("just bhaag");
		}
		
		
		
		//working with switch case
		
		switch (m1) {
		case kill:System.out.println("just kill yaar in switch case ");
		break;
		case bhaag:System.out.println("just bhaag  in switch case");
		break;
		case deploy:System.out.println("just deploy in switch case");
		default:System.out.println("nothing to do ");
		}
	
		
		
	}

}
