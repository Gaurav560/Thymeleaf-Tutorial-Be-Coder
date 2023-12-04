package StreamApiTelusko;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// way of adding integer elements in the list of Integers called nums
		List<Integer> nums = Arrays.asList(3, 5, 9, 2, 8, 11);

		// we have created a stream of integers from the list we had i.e,nums
	//	Stream<Integer> str = nums.stream();
		// str.forEach(n->System.out.println(n));

		// long l1=str.count();

		// System.out.println(l1);

		// parallelStream() -when u have huge amount of data ,and we want to do the
		// processing
		// of data using multiple threads,we call parallelStream() method.

		// now we have a stream of data, we can process the data based on our
		// requirements

		// sorted() method returns a new stream
		// Stream<Integer> data=str.sorted();
		// data.forEach(n->System.out.println(n));

		// double the value inside the list using normal for loop
		for (int n : nums) {
			System.out.println(n * 2);

			// but in this case,we are modifying the original data


		}
		
//		Stream<Integer> mappedStream=str.map(n->n*2);
//		mappedStream.forEach(n->System.out.println(n));
		
		
		//or
		//also called builder pattern
		//we are using 4 stream here  
		//1st stream is created by nums.stream which is converting 
		//the list into stream ,then we are applying filter method on 
		//1st stream which filters all the odd values and creates a new stream 
		//which is our 2nd stream ,then we apply sorted() on 2nd stream which sorts the
		//value by default in ascending order.thus creating a 3rd stream on which we apply
		//map and performs a function that double the values present in 3rd stream.
		//thus resulting in 4th stream which is then consumed by forEach() for printing the values.
		//every time ,the previous stream gets destroyed,so no memory overhead.
//		 nums.stream()
//		 .filter(n->n%2==1)
//		 .sorted()
//		 .map(n->n*2)
//		 .forEach
//		 (n->System.out.println(n));
		
		
		//using reduce()
		//it takes two parameter.first one is single parameter 
	//second one is binary parameter
		//this method reduces the stream in single value
		
		
	Integer sum= nums.stream()
		 .filter(n->n%2==1)
		 .sorted()
		 .map(n->n*2)
		 .reduce(0,(c,e)->c+e);
	System.out.println(sum);
	
	
		// map says ,i will give the value but you want to tell what u have to with the
		// data
		//map itself gives u a new Stream which u can use further
		
		

	}

}
