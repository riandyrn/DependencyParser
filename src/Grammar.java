import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Grammar {

	private String path;
	private ArrayList<ArrayList<String>> grammar;
	
	public Grammar(String path)
	{
		grammar = new ArrayList<>();
		this.path = path;
		loadGrammar();
		//printGrammar();
	}
	
	private void printGrammar() {
		// TODO Auto-generated method stub
		for(ArrayList<String> token: grammar)
		{
			System.out.println(token.get(0) + ", " + token.get(1));
			
		}
	}

	public void loadGrammar()
	{
		BufferedReader br = null;
		 
		try {
 
			String sCurrentLine;
 
			br = new BufferedReader(new FileReader(path));
 
			while ((sCurrentLine = br.readLine()) != null) {
				String[] tokens = sCurrentLine.split(", ");
				ArrayList<String> tmp = new ArrayList<>();
				for(String token: tokens)
				{
					tmp.add(token);
				}
				
				grammar.add(tmp);
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}		
	}
	
	public boolean canDepend(Word d, Word w)
	{
		boolean ret = false;
		
		for(ArrayList<String> rule: grammar)
		{
			if((d.getValue().equals(rule.get(0))) && (w.getValue().equals(rule.get(1))))
			{
				ret = true;
				break;
			}
		}
		
		System.out.println("canDepend(" + w.getValue() + ", " + d.getValue()  + "): " + ret);
		
		return ret;
	}
	
}
