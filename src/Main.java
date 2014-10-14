import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		/*
		 * 	ini belum handle ambiguity, kalau di grammar-nya ada ambiguity, masih kurang tepat parse tree-nya
		 */
		Grammar g = new Grammar("D:\\Documents\\Workspace\\DependencyParser\\src\\grammar.txt");
		ArrayList<String> inputList = prepareInputList("Makan ubi sambil berenang itu memang aneh, tapi pamanku sering melakukannya");
		DependencyParser dp = new DependencyParser(inputList, g);
		dp.processInput();
		dp.printOutput();
	}
	
	public static ArrayList<String> prepareInputList(String s)
	{
		ArrayList<String> ret = new ArrayList<>();
		String[] soal = s.toLowerCase().split(" ");
		
		for(String token: soal)
		{
			ret.add(token);
		}
		
		return ret;
	}
	

}
