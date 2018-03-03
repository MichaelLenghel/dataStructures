class Stack 
{
	//Node can only be used for stacks
	private class Node 
	{
		int data;
		Node next;
	}//end Node
	private Node top;

	//Don't need public as default
	public Stack()
	{
		top = NULL;
	}//end Stack constructor

	boolean isEmpty()
	{
		return (top == NULL);
	}

	public void push(int x)
	{
		//Create new node
		Node temp = new Node();
		//Error handling - A new node may not be created so we use error checking
		// try {

		// } catch(exception e) {

		// }
		temp.data = x;
		//Initialise to the first element or NULL
		temp.next = top;
		top = temp;
	}

	public int pop(int x)
	{
		Node temp = new Node();
		temp = top;
		top = top.next;
		return(temp);
	}

	//Array Impleentation of a stack
	// class Stack 
	// {
	// 	int[] a;
	// 	int top;
	// 	public void push(int a)
	// 	{
	// 		a[top++] = x;
	// 	}//end 
	// }
	// //Constructor
	// Stack() 
	// {
	// 	a = new int[100];
	// 	top = 0;
	// }
}//end Stack