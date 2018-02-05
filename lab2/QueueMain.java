//Error 1: doesnt print first element entered
//Error 3: dequeue null pointer exception

public class QueueMain
{
	public static void main( String[] arg)
	{
		Queue q = new Queue();
		int i = 0;
	    System.out.println("Queue is created\n");

	    //Test s.pop ability
	    i = q.dequeue();

	    q.enqueue(10); q.enqueue(3); q.enqueue(11); q.enqueue(7);
	    q.display();

	    System.out.println("Queue size is " + q.size());

	    i = q.dequeue();
	    System.out.println("Just popped " + i);
	    q.display();
	    
	}
}

class Queue
{
	class Node
	{
		int data;
		Node next;
	}
	private Node tail, head, z;

	public void queue()
	{
		head = null;
		tail = null;
	}

	public void enqueue(int x)
	{
		Node t = new Node();
		t.data = x;
		t.next = t;

		//Normally when we add an elemtn we point head to the new element, but when its empty, we beed to add tail to it as well
		if(this.isEmpty())
		{
			tail = t;
			//Make self referencing
			// tail.next = tail;
		}//end if

		//Point towards head as we have just added a new element and it will be at the bottom of the queue (Will be the new head)
		t.next = head;
		head = t;
	}//end enqueue

	public int dequeue()
	{
		int i = 0;
		if(this.isEmpty())
		{
			System.out.println("\n Queue is empty");
			return(0);
		}//end if

		//Will return the element we delte, so index here as would need to do in conditional statements otherwise
		i = tail.data;

		//If both are pointing to the same element this means that there is only one element in the queue
		if(tail == head)
		{
			//Assign head to element 1 (z); (AKA sentinal variable)
			head = null;
			//Assign tail to null (list is empty)
			tail = null;
		}
		else
		{
				//Make temp and print after deletion
				System.out.println("Node to be deleted: " + tail.data);
				Node current = this.head;
				Node previous = null;

				//It is self referencing, so the last element will reference itself
				while(current.next != null)
				{
					previous = current;
					current = current.next;
				}//end while
				//cut off the link to currrent (element which we deleted).
				previous.next = null;
				//Now we only need to work with tail since there is more than one element, so change tail to pre element and z;
				current = previous;
		}//end else
		return(i);
	}//end dequeue

	public boolean isEmpty()
	{
		return (tail == null);
	}

	int size()
	{
		int c = 0;
		Node t = this.head;
		while(t != null)
		{
			t = t.next;
			c++;
		}
		return c;
	}

	public void display()
	{
			Node t = head;
			System.out.println("Queue contents are: \n");
			System.out.println("(Head)" + "\n");
			while(t != null)
			{
				System.out.println(t.data + "\n");
				t = t.next;
			}
			System.out.println("(Tail)");
			System.out.println("\n");
	}
}













