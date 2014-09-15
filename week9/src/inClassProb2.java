import java.util.*;
public class inClassProb2 {

	public static void main(String[] args) {
    
		ArrayList<String> al = new ArrayList<String>();
		al.add("b");
		al.add("a");
		al.add("t");
		System.out.print("All subsets of ");
		print(al);
		
		allSubsets(new ArrayList<String>(), al);
	}
	
	static void allSubsets(ArrayList<String> prefix, ArrayList<String> suffix)
	{
		if(!suffix.isEmpty()){
			ArrayList<String> newPrefix = new ArrayList<String>(prefix);
			newPrefix.add(suffix.get(0));
			ArrayList<String> newSuffix = new ArrayList<String>(suffix);
			newSuffix.remove(0);
			print(newPrefix);
			allSubsets(newPrefix,newSuffix);
			allSubsets(prefix,newSuffix);
		}
		
	}
	
	static void print(ArrayList<String> l)
	{
		for(String s:l)
			System.out.print(s);
		System.out.println();
	}
      
            
    }

