
import java.util.*; 
import java.io.*; 
public class MostHomophones {
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
		int len = wordList.get(i).getPhonemes().length();
		//stores all word with same lenght in this list
		ArrayList<Pronunciation> temp = (ArrayList<Pronunciation>) tree.findAll(len);
		ArrayList list =  new ArrayList();
		String find = wordList.get(i).getPhonemes();
		for(int p = 0; p < temp.size(); p++) {
			//if same put it in list
				if(temp.get(p).getPhonemes().equals(find)) {
					list.add(temp.get(p).getWord());
					p++;
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