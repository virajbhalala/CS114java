import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UseUALDictionary {

  public static void main(String[] args) {
    UALDictionary<String, Pronunciation> PDict = new UALDictionary<String, Pronunciation>();
    int count = 0;
    File file = new File("/Users/virajbhalala/Documents/cs114eclipse/week10/src/pron");
    final int len = 5;

    // Read in entries for words of length 4 or 5 only.

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

    System.out.println("Read in pronunciations.");
    System.out.println(PDict.find("BLACK"));
    System.out.println(PDict.find("BLUE"));
    System.out.println("size= " + PDict.size());
  }
}
