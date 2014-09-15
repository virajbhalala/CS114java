import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class PalindromeFinder {

		public static void main(String[] args) throws FileNotFoundException {
			File file = new File("/Users/virajbhalala/Documents/cs114eclipse/week7/src/words.txt");
			Scanner scan = new Scanner(file);
			
			ArrayList<String> list1 = new ArrayList<String>(113813);
			ArrayList<String> list2 = new ArrayList<String>();
			//while loop- takes each line from words.txt and add that line in list1
			while(scan.hasNext())
			{
				String line;
				line = scan.nextLine();
				list1.add(line);       
			}
			//position
			int pos =0;
			
			//while loop compares specific line string and it's reverse. If they are equal they are 
			//palidrome so add it to list2 which stores all palindrones
			while(list1.size() > pos)
			{
				
				String reversedString = reverse(list1.get(pos));
				String forwardString = list1.get(pos);
				if(reversedString.compareTo(forwardString) == 0)
				{
					//stores palindromes in list2
					list2.add(forwardString);
				}
				pos++;
			}
			int x = list2.size();
			String []wordArray = new String[x];
			wordArray=list2.toArray(wordArray);
			 Sort(wordArray);
			 System.out.println("sorted palindromes strings ");
			 Object String;
			 String word= " ";
			 //prints each word from wordArray
			for(int p=0; p<wordArray.length; p++){
				 word = wordArray[p];
			        System.out.println(word);
		}
		}
	    
			public static String reverse(String str){
		    if ((null == str) || (str.length()  <= 1)) {
		        return str;
		    }
		    
		    
		    return reverse(str.substring(1)) + str.charAt(0);
			}
			 public static void Sort(String[] wordArray) {
			        boolean swapped = false;
			        do {
			            swapped = false;
			            for (int i = 0; i < wordArray.length - 1; i += 1) {
			                if (wordArray[i].length() > wordArray[i + 1].length()) {
			                    swap(wordArray, i, i + 1);
			                    swapped = true;
			                }
			            }
			        } while (swapped);
			    }
			 
			 
			 
			    public static void swap(String[] arr, int index0, int index1) {
			        String temp = arr[index0];
			        arr[index0] = arr[index1];
			        arr[index1] = temp;
			    }
		}
