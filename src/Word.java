import java.util.ArrayList;


public class Word {

	private String value;
	private Word head;
	private ArrayList<Word> dependents;
	
	
	public Word(String W)
	{
		value = W;
		dependents = new ArrayList<>();
	}
	
	public void setValue(String w)
	{
		value = w;
	}
	
	public String getValue()
	{
		return value;
	}
	
	public void setHead(Word H)
	{
		head = H;
	}
	
	public Word getHead()
	{
		return head;
	}
	
	public void addDependent(Word D)
	{
		dependents.add(D);
	}
	
	public ArrayList<Word> getDependents()
	{
		return dependents;
	}
	
}
