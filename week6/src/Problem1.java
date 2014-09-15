/*
 * Viraj Bhalala
 * 
 */
public class Problem1 extends ExpandableIntArray {

	public static void main(String[] args) {
		ExpandableIntArray x= new ExpandableIntArray();
		x.addToEnd(9);
		x.addToEnd(10);
		x.addToEnd(14);
		x.addToEnd(11);
		x.addToEnd(9);
		x.add(20,99);
		x.remove(1);
		//System.out.println("these are the numbers which are added first 9,10,14,11,9");
		System.out.println(x.toString());
		
		
		

	}

}
