package com.ineuron.ai;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ForEachWithLambdaExpressions {
	
	public static void main(String[] a) {

		List<Integer> nums = Arrays.asList(4, 3, 6, 7, 8, 9);

		// forEach takes consumer object of Consumer Interface which is a functional
		// interface
		// and it has a method accept which takes an integer n

		// Consumer<Integer> consumer = new Consumer<Integer>() {
//
//			@Override
//			public void accept(Integer t) {
//				System.out.println(t);
//
//			}
//		};

		Consumer<Integer> consumer = n -> System.out.println(n);

		// nums.foreach gives integer for every iteration which then passes into
		// consumer object
		//
		nums.forEach(consumer);

	}

}
