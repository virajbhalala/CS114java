/*
 * Viraj Bhalala
 * CS 114-002
 * In class excersise
 * 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class wordFinder {
	public static void main(String[] args)  throws FileNotFoundException {
		//you have to change the address of the file
		File file = new File("/Users/virajbhalala/Documents/cs114eclipse/week7/src/words.txt");
		Scanner scan = new Scanner(file);	
		Scanner input =new Scanner (System.in);
		System.out.println("Enter line of string ");
		String s= input.nextLine();
		//make 2 lists
		ArrayList<String> list1 = new ArrayList<String>(113813);
		ArrayList<String> list2 = new ArrayList<String>();
		//put all words in list1
		while(scan.hasNext())
			{
				String line;
				line = scan.nextLine();
				list1.add(line);       
			}
		//add to list2 if words contains character of word entered
		for(int i=0; i<list1.size(); i++){
				if(list1.get(i).contains(s)){
					list2.add(list1.get(i));
				}
		}
		//sort it by length of words
		for(int p=0; p<list2.size(); p++){
			String key= list2.get(p);
			int i=p-1;
			while((i>-1)&&(list2.get(i).length()>key.length())){
				list2.set(i+1, list2.get(i));
				i--;
			}
			list2.set(i+1, key);
	}
		//print first word in list2
		 System.out.println(list2.get(0));
	}	
}
