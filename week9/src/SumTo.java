import java.util.Stack;
import java.util.ArrayList;
import java.util.*;

public class SumTo {

public static void main(String[] args)  {
	Scanner scan = new Scanner(System.in);
	Integer s=scan.nextInt();
	
	ArrayList<String> list1=new ArrayList<String>();
	ArrayList<Integer> list2=new ArrayList<Integer>();
	
    String digits = "1234567890";
    String operators = "+-";
    String number = "";
    Stack<String> numberStack = new Stack<String>();
    
    for (int i = 0; i < 2 << digits.length(); i += 2) {
        number = "" + digits.charAt(0);
        for (int k = 0; k < digits.length() - 1; k++) {
            int j = (2 << k) & i;
            if (j > 0) {
                numberStack.push(number);
                number = "";
            }
            number += digits.charAt(k + 1);
        }
        
        numberStack.push(number);
        String expression = "";
        Integer sum = 0;
        final int base = operators.length();
        for (int k = 0; k < Math.pow(base, numberStack.size() - 1); k++) {
            expression = numberStack.get(0);
            sum = Integer.parseInt(expression);
            for (int pos = 0; pos < numberStack.size() - 1; pos++) {
                int operatorsPos = k;
                for (int j = numberStack.size() - 1; j >= pos + 1; j--) {
                    if (operatorsPos >= Math.pow(base, j)) {
                        operatorsPos = (int) (operatorsPos - (operatorsPos / (int)Math.pow(base, j)) * (int)Math.pow(base, j));
                    }
                }
                if (pos > 0) {
                    operatorsPos = (int) (operatorsPos - Math.pow(base, (pos - 1)));
                    operatorsPos = (int) (operatorsPos / Math.pow(base, pos));
                }
                expression += operators.charAt(operatorsPos);
                
                if (operators.charAt(operatorsPos) == '+') {
                    sum += Integer.parseInt(numberStack.get(pos + 1));
                } else
                if (operators.charAt(operatorsPos) == '-') {
                    sum -= Integer.parseInt(numberStack.get(pos + 1));
                }
                
                expression += numberStack.get(pos + 1);
            }
            list1.add(expression);
            list2.add(sum);
        }
        
       numberStack.clear();
    }

    for (int i=0;i<list2.size();i++){
    	if(s.equals(list2.get(i))){
    		System.out.println("True");
    		System.out.println(list1.get(i) + " = " + s);
    		break;

    	}
    	else
    		if(i==list2.size()-1){
    			System.out.println("False");	
    		}
    } 
}
}
