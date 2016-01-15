import java.util.HashMap;
import java.util.Map;

public class Node 
{
	String fileName;
	Map<String,Node> subfiles= new HashMap<String,Node>();
	
	public Node()
	{
		fileName=null;
	}
	public Node(String s)
	{
		fileName=s;
	}
	public @Override String toString()
	{
		return fileName;
	}
}

