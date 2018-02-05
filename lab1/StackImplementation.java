public class StackImplementation
{
	private Node top;

	class Node
	{
		int data;
		Node next;
	}//end class Node

	StackImplementation()
	{
		top = null;
	}

	void push(int x)
	{
		Node t = new Node();
		t.data = x;
		t.next = top;
		top = t;
	}

	public int pop()
	{
		if (this.IsEmpty()) 
		{
			System.out.println("Stack is empty and cannot be popped");
			return 0;		
		}
		else
		{
			Node temp = new Node();
			temp.data = top.data;
			top = top.next;
			//Garbage collection auto gets rid of the previous element. No need to free after top = top.next;
			return temp.data;
		}
	}

	public boolean IsEmpty()
	{
		return (top == null);
	}

	void display()
	{
			Node t = top;
			System.out.println("Stack contents are: \n");

			while(t != null)
			{
				System.out.println(t.data + ", ");
				t = t.next;
			}

			System.out.println("\n");
	}

	int size()
	{
		int c = 0;
		Node t = this.top;
		while(t != null)
		{
			t = t.next;
			c++;
		}
		return c;
	}
}