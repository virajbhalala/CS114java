import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.util.Arrays;
import java.util.*;
public class Clean {

  public static void main(String[] args) throws IOException {
    int pics = 17;
    File[] file = new File[pics];
    for (int p = 1; p <= pics; ++p) {
      String suff = String.valueOf(p);
      
    //you have to change the file address as in PC. I was using mac
      String filename = "/Users/virajbhalala/Documents/cs114eclipse/week13/src/birds" + suff + ".ppm";
      System.out.println("Opening "+filename);
      file[p-1] = new File(filename);
    }

    long start = System.currentTimeMillis();

    Scanner[] scnr = new Scanner[pics];

    int rows = 0, cols = 0, mx = 0;
    for (int i = 0; i < pics; ++i) {
      try {
        scnr[i] = new Scanner(file[i]);
        String line = scnr[i].nextLine();
        cols = Integer.parseInt(scnr[i].next());
        rows = Integer.parseInt(scnr[i].next());
        mx = Integer.parseInt(scnr[i].next());
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    }
  //you have to change the file address as in PC. I was using mac
    BufferedWriter output = new BufferedWriter(new FileWriter("/Users/virajbhalala/Documents/cs114eclipse/week13/src/newpic2.ppm"));
    output.write(String.format("%s\n", "P3"));
    output.write(String.format("%d  %d\n", cols, rows));
    output.write(String.format("%d\n", mx));
    System.out.println(rows + ", " + cols + ", " + mx);

    int[] val = new int[pics];  

    for (int i = 0; i < cols; ++i) {
      for (int j = 0; j < rows; ++j) {
		int high =0;
		int temp=0;
        // read in red, green, blue
        for (int c = 0; c < 3; ++c) {
		  	
          int avg = 0;
          for (int k = 0; k < pics; ++k){
			 	temp= Integer.parseInt(scnr[k].next());
				val[k] = temp; 
				Arrays.sort(val); 
				
				high = val[(val.length*9) /10]; 

			 }

			           output.write(String.format("%d ", high));
        }
      }
      output.write(String.format("\n"));
    }
    
    for (int i = 0; i < pics; ++i) {
      scnr[i].close();
    }
    output.close();
  }
}
