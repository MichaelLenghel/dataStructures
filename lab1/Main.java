public class Main
{
	public static void main( String[] arg)
	{
		StackImplementation s = new StackImplementation();
	    System.out.println("Stack is created\n");

	    //Test s.pop ability
	    s.pop();

	    s.push(10); s.push(3); s.push(11); s.push(7);
	    s.display();

	    System.out.println("Stack sixe is " + s.size());

	    int i = s.pop();
	    System.out.println("Just popped " + i);
	    s.display();
	    
	}
}