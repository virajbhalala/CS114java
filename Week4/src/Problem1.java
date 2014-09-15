

public class Problem1  extends Sorting implements Comparable<Object>{

	private int PrimaryInt;
	
//constructor
	public Problem1(int DecimalInt) {
		String temp= Integer.toBinaryString(DecimalInt);
		PrimaryInt= Integer.parseInt(temp);
		
		
	}
//get method	
	public int get()
	{
		return PrimaryInt;
	}
//prints
	public String toString()
	{
		return ""+PrimaryInt;
	}
//compareTo method
	@Override
	public int compareTo(Object o) {
		Integer temp = PrimaryInt;
		Integer result;
		int otherInt = (((Problem1)o).get());
		result = temp.compareTo(otherInt);
		return result;
	}
	
	
	
}

