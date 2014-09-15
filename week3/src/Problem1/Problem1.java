/*
 * Viraj Bhalala
 * CS 114-002
 * Spring 2014
 * 
 * */	
				
package Problem1;
import java.util.*;
class Problem1 extends Progression {
	//main method
	public static void main(String[] args) {
			
		//instruction
		System.out.println("Press enter each time when you input each int value");
		Scanner scanner =new Scanner (System.in);
		
		//user inputs each values
		long value1 = scanner.nextLong();
		long value2 = scanner.nextLong();
		int n = scanner.nextInt();
		
		
		//creates progression type object 
		Progression prog;
		prog = new Problem1(value1, value2);
		
		//prints progression
		prog.printProgression(n);
		
	}
	
	long prev;   
	 //default constructor with 2 and 200
	  Problem1() {
	    this(2, 200);
	  }
	  //constructor with parameter containing entered value
	  Problem1(long value1, long value2) {
	      first = value1;
	      prev = value2 + value1; // fictitious value preceding the first
	  }

	  //does progression by subtracting the previous value to the current value and taking absolute value of it and returning it.
	  protected long nextValue() {
	    long temp = prev;
	    prev = cur;
	    cur -= temp;
	    cur=Math.abs(cur);
	    return cur;
	  }
	  
	}