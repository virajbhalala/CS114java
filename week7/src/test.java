
import java.util.*;
public class test extends DLinkedList {

	public static void main(String[] args) {
		Scanner scanner =new Scanner (System.in);
		System.out.println("Enter line of string to be reversed ");
		String s= scanner.nextLine();
		DLinkedList p= new DLinkedList();
		int temp=0;
		//This for loop finds blank space and as it finds the space it takes substring from temp to i and add it to list 
		//using add last. temp is changed to i every time space is found so previous i cannot be lost.
		for (int i=0; i<s.length()-1;i++){
			char c = s.charAt(i);
			if(s.substring(i,i+1).equals(" "))
			{
				p.addLast(s.substring(temp,i));
				temp=i;
			}
			
			
		}
		//this calls addLast because last word in not added in for loop above (because users doesnot put space when he 
		//finishes line/sentence
		p.addLast(s.substring(temp));
		
		System.out.println("before reverse() called: " + p.toString());
		//calling reverse method
		p.reverse();
		System.out.println("after reverse() called: " + p.toString());

	}

}
