

public class Problem1DriverClass{

	 public static void main (String[] args)
	   {

			Problem1[] numbers =new Problem1[10];
			numbers[0] = new Problem1(8);
			numbers[1] = new Problem1(4);
			numbers[2] = new Problem1(2);
			numbers[3] = new Problem1(7);
			numbers[4] = new Problem1(16);
			numbers[5] = new Problem1(1);
			numbers[6] = new Problem1(3);
			numbers[7] = new Problem1(9);
			numbers[8] = new Problem1(11);
			numbers[9] = new Problem1(13);
			
			Problem1.selectionSort(numbers);
			for(Problem1 primes1: numbers)
			{
				System.out.println(primes1);
			}
		}
	}

	


