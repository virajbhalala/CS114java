import java.util.ArrayList;

public class AllSubsets {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		//for(int i=0;i<3;++i)
		//al.add(new Integer(i));
		al.add("a");
		al.add("b");
		al.add("c");
		System.out.println("All subsets of:");
		print(al);
		System.out.println("are as follows:");
		printAllSubsets(new ArrayList<String>(), al);
	}
	
	static void printAllSubsets(ArrayList<String> prefix, ArrayList<String> suffix)
	{
		if(!suffix.isEmpty()){
			ArrayList<String> newPrefix = new ArrayList<String>(prefix);
			newPrefix.add(suffix.get(0));
			ArrayList<String> newSuffix = new ArrayList<String>(suffix);
			newSuffix.remove(0);
			print(newPrefix);
			printAllSubsets(newPrefix,newSuffix);
			printAllSubsets(prefix,newSuffix);
		}
		
	}
	
	static void print(ArrayList<String> l)
	{
		for(String s:l)
			System.out.print(s);
		System.out.println();
	}

}
