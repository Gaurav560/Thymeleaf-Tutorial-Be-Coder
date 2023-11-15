package com.ineuron.ai;

@FunctionalInterface
interface A {

	void show();
}

//what if we have to use class b object only once.
//we know object creation is a heavy weight process and
//also we have to maintain extra class files which is not a good idea 
//so anonymous inner class and  lambda expression comes in picture.

//class B implements A {
//	public void show() {
//		System.out.println("my name is Gaurav and i am learning fn interface->anonymous inner class "
//				+ "and lambda expressions and forEach loop");
//	}
//}

public class Demo {

	public static void main(String[] args) {
		// new A and method name is redundant as in functional interface there is only
		// one method
		// and compiler write it for us.we just have to write the logic.
		A obj = ()->System.out.println("hi my name is gaurav");
		obj.show();
	}
}
