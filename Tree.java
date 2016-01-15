import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Tree 
{
	private Node root=new Node("root");
	List <Queue<Node>> allPaths=new ArrayList<Queue<Node>>();
	int mkNewDir=0;
	public Tree() 
	{
	}
	public int newDirNum()
	{
		return mkNewDir;
	}
	public void makeNode(String s)
	{
		Node currentNode=root;
		String fileSet[]=s.split("/|\\\\");
		for(String t:fileSet)
		{
			if(!currentNode.subfiles.containsKey(t))
			{
				Node newNode=new Node(t);
				currentNode.subfiles.put(t, newNode);
			}
			currentNode=currentNode.subfiles.get(t);
		}

	}
	
	private void getPaths()
	{
		for(Map.Entry<String, Node>entry:root.subfiles.entrySet())
		{
			Queue<Node> paths= new LinkedList<Node>();
			paths.add(root);
			getNext(root.subfiles.get(entry.getKey()),paths);
		}
		
	}

	private void getNext(Node n, Queue<Node> p) 
	{	
		for(Map.Entry<String, Node>entry:n.subfiles.entrySet())
		{	
			Queue<Node> q=new LinkedList<Node>();
			q.addAll(p);
			q.add(n);
			getNext(n.subfiles.get(entry.getKey()),q);
		}
		if(n.subfiles.isEmpty())
		{
			p.add(n);
			allPaths.add(p);
		}
	}
	private void printPaths(List<Queue<Node>> list) 
	{
		getPaths();
		for(Queue<Node> path:list)
		{
			int count=0;
			for(Node n:path)
			{
				System.out.print(n);
				count++;
				if(count!=path.size())
				{
					System.out.print("/");
				}
			}
			System.out.println("");
		}
		
	}
	public @Override String toString()
	{
		
		printPaths(allPaths);
		
		return "";
	}
}

