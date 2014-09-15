
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class jaga {
	public static void main(String[] args) {
		
		File file = new File("/Users/virajbhalala/Documents/cs114eclipse/week10/src/pron");
		BST tree = new BST();
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				Pronunciation p = new Pronunciation(line);
				//insert everyhting in the tree first
				tree.insert(p.getPhonemes().length(), p);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList<Pronunciation> wordList = (ArrayList<Pronunciation>) tree.values();
		int max = 0;
		ArrayList homophonesList = new ArrayList();
		
		for(int i = 0; i < wordList.size(); i++) {
			int num = wordList.get(i).getPhonemes().length();
			ArrayList<Pronunciation> temp = (ArrayList<Pronunciation>) tree.findAll(num);
			ArrayList list =  new ArrayList();
			String find = wordList.get(i).getPhonemes();
			for(int q = 0; q < temp.size(); q++) {
					if(temp.get(q).getPhonemes().equals(find)) {
						list.add(temp.get(q).getWord());
					}
			}
			int ctr = list.size();
			if(ctr > max) {
				homophonesList = list;
				max = ctr;
			}
		}
		for(int k = 0; k < homophonesList.size(); k++) {
			System.out.println(homophonesList.get(k));
		}
		
	}
}