import java.util.ArrayList;


public class DependencyParser {

	public ArrayList<String> InputList;
	
	public ArrayList<Word> HeadList;
	public ArrayList<Word> WordList;
	
	private Grammar grammar;
	
	public DependencyParser(ArrayList<String> InputList, Grammar g)
	{
		this.InputList = InputList;
		HeadList = new ArrayList<>();
		WordList = new ArrayList<>();
		grammar = g;
	}
	
	public void processInput()
	{
		Word prevWord = null;
		
		for(int i = 0; i < InputList.size(); i++)
		{
			Word W = new Word(InputList.get(i));
			WordList.add(W);
			
			for(int j = 0; j < HeadList.size(); j++)
			{
				Word D = HeadList.get(j);
				if(canDepend(D, W))
				{
					link(D, W);
					HeadList.remove(j);
				}
				else
				{
					break;
				}
			}
			
			if(i > 0)
			{
				//Word H = new Word(InputList.get(i-1));
				System.out.println();
				System.out.println("Session PrevWord");
				Word H = prevWord; // utk ngambil precedent word
				while(true)
				{
					if(canDepend(W, H))
					{
						link(W, H);
						break;
					}
					
					if(isIndependent(H))
					{
						break;
					}
					else
					{
						H = getHeadOf(H);
					}
				}
			}	
			
			if(isStillHeadless(W))
			{
				HeadList.add(W);
			}
			
			prevWord = WordList.get(WordList.size()-1);
		}
	}

	private boolean isStillHeadless(Word w) {
		return (w.getHead() == null);
	}

	private Word getHeadOf(Word h) {
		return h.getHead();
	}

	private boolean isIndependent(Word h) {
		return isStillHeadless(h);
	}

	private void link(Word d, Word w) {
		w.addDependent(d);
		d.setHead(w);
	}

	private boolean canDepend(Word d, Word w) {
		return grammar.canDepend(d, w);
	}

	public void printOutput()
	{
		for(Word w: WordList)
		{
			System.out.println("value: " + w.getValue());
			
			Word H = w.getHead();
			if(H != null)
			{
				
				System.out.println("head: " + w.getHead().getValue());
			}
			else
			{
				System.out.println("head: not present");
			}
			
			System.out.print("{");
			
			for(Word s: w.getDependents())
			{
				System.out.print(s.getValue() + ", ");
			}
			
			System.out.println("}");
			System.out.println();
		}
	}
}
