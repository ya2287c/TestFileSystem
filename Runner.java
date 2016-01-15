import java.util.Scanner;


public class Runner {

	public static void main(String[] args) 
	{
		Tree tree= new Tree();
		Scanner s=new Scanner(System.in);
		System.out.println("enter file path");
		tree.makeNode(s.next());
		System.out.println("enter file path");
		tree.makeNode(s.next());
		s.close();
		System.out.println(tree);

	}

}

