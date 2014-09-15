/*
 * Viraj Bhalala
 * 
 */
public class ExpandableArray extends ExpandableIntArray{
	public static void main(String[] args) {
		ExpandableIntArray x= new ExpandableIntArray();
		//add few things in array
		x.addToEnd(9);
		x.addToEnd(10);
		x.addToEnd(14);
		x.addToEnd(11);
		x.addToEnd(9);
		x.add(20,99);
		x.remove(1);
		//numbers array points to expandableIntArray's array
		int numbers [] = new int [x.size()];
		for(int i =0; i < x.size(); i++)
		{
			numbers[i] = x.get(i);
		}
		//uses generic.java to determine what is stored in array
		generic<Integer> p = new generic<Integer>(numbers);
		//this line prints the nums
		p.get(numbers);
	}

}
