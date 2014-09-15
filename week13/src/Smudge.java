import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.util.Arrays;

public class Smudge {

  public static void main(String[] args) throws IOException {
    int pics = 17;
    File[] file = new File[pics];
    for (int p = 1; p <= pics; ++p) {
      String suff = String.valueOf(p);
      String filename = "birds" + suff + ".ppm";
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

    BufferedWriter output = new BufferedWriter(new FileWriter("clean.ppm"));
    output.write(String.format("%s\n", "P3"));
    output.write(String.format("%d  %d\n", cols, rows));
    output.write(String.format("%d\n", mx));
    System.out.println(rows + ", " + cols + ", " + mx);

    

    for (int i = 0; i < cols; ++i) {
        for (int j = 0; j < rows; ++j) {
  		int high =0;
  		int temp=0;
          // read in red, green, blue
          for (int c = 0; c < 3; ++c) {
  		  	
            int avg = 0;
            for (int k = 0; k < pics; ++k){

                  avg += high;
      		if(temp>high)
  			 {
  			 	high =temp;
  			 }
  			 
  			 }
           //avg = avg/pics;
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
