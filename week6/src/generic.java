/*
 * Viraj Bhalala
 * 
 */
public class generic<T> {
	private T s;
	private int numArray[];
	public generic(int[] numbers){
		numArray = numbers;
	}
	public T get(int[] numbers){
		for(Comparable temp: numbers){
			System.out.print(temp + " ");
		}
		return (T) numbers;
	}
}
