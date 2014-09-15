import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class inClass10 {
	
	  public static void main(String[] args) {
		  
	    UALDictionary<String, Pronunciation> PDict = new UALDictionary<String, Pronunciation>();
	    int count = 0;
	    File file = new File("/Users/virajbhalala/Documents/cs114eclipse/week10/src/pron");
	    final int len = 5;
	  
	    try {
	      Scanner scanner = new Scanner(file);
	      while (scanner.hasNextLine()) {
	        String line = scanner.nextLine();
	        Pronunciation p = new Pronunciation(line);
	        if ((p.getWord().length() == len - 1) || (p.getWord().length() == len))
	          PDict.insert(p.getWord(), p);
	      }
	      scanner.close();
	    } catch (FileNotFoundException e) {
	      e.printStackTrace();
	    }
	      
    
	    for(int i =0; i<PDict.size();i++){
	    	String s= PDict.list.get(i).key();
	    	String firstRemoved = s.substring(1);
	    	String last= "";
	    	last += s.charAt(0);
	    	last += s.substring(2);
	    	
	    	if(PDict.find(firstRemoved) != null  && PDict.find(last) != null){
	    		String a = PDict.find(s).getPhonemes();
	    		String b = PDict.find(firstRemoved).getPhonemes();
	    		String c = PDict.find(last).getPhonemes();
	    		
	    		if(a.equals(b) && a.equals(c) ){
		    		
		    		System.out.println(s);
		    		
		    	}
	    	}
	    	
	    	
	    }
	    
//	    System.out.println(PDict.findAll());
//	    System.out.println(PDict.find("BLACK"));
//	    System.out.println(PDict.find("BLUE"));
//	    System.out.println("size= " + PDict.size());
	  }
}
