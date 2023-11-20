package StreamApiTelusko;

import java.util.Arrays;
import java.util.List;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//a new way of adding arrays in the list
		List<Integer> nums=Arrays.asList(4,6,4,3,2,2,6,7);
		//System.out.println(nums);
		
		int sum=0;
		//using enhanced for loop
		for(int n:nums) {
			if (n%2==0) {
				n=n*2;
				sum=sum+n;
			}
		}
	
		
	//	System.out.println(sum);
		
		
		
		//this is one way of performing operation on your list.
		//but in this process,original value gets changed.
		//instead of this ,we use stream API to perform operations on our collections api
		
		
		
		
		
		//Different types of for loop(normal,enhanced,forEach)
		//in the enhanced for loop,the array returns every time
		//a value and it go and sits in the variable which we define in the parameter
		//section of for loop
		
		
		//we are going to use for Each in the below example
		nums.forEach(n->System.out.println(n));
		
	}

}
