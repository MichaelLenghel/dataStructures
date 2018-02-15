// Sorted linked list with a sentinel node
import java.util.*;

public class SortedLL implements insertRemove 
{
    public static void main(String args[])   
    {
        //Create a new variable of the abstract object SortedLL
        SortedLL list = new SortedLL();
        list.display();

        double x;
        int i, r;

        for(i = 1; i <= 5; ++i)  
        {
           x =  (Math.random()*100.0);
           r = (int) x; 
           System.out.println("Inserting " + r);
           list.insert(r);
           list.display();            
        }

        //Will continue to iterate through the list until it is empty
        while(!list.isEmpty())  
        {
            System.out.println("\nInput a value to remove: ");
            Scanner in = new Scanner(System.in);
            r = in.nextInt();
            if(list.remove(r)) 
            {
                System.out.println("\nSuccessfully removed: " + r);
            list.display(); 
            }//end if
            else 
            {
                System.out.println("\nValue not in list");  
            }//end else                      
        }
    }

    // internal data structure and a constructor
    Node head;
    Node tail;

    // list constructor 
    public void SortedLL()
    {
        Node head = null;
        Node tail = null;
    }

    // Node class
    public class Node
    {
        int data;
        Node next;

        // constructor node class
        public Node()
        {
            data = 0;
            next = null;
        }
    }

    // this is the insert method to add ints to the list
    public void insert(int x)
    {
        Node prev, curr, tail;
        
        // making new tail node to insert into list
        tail = new Node();
        tail.data = x;
        tail.next = null;

        prev = null;
        curr = head;

        // interate through the list to insert int a proper place
        while(curr != null && x > curr.data)
        {
            prev = curr;
            curr = curr.next;
        }       

        // insert at the head of llist
        if(prev == null)
        {
            tail.next = head;
            head = tail;
        }
        // insert anywhere else
        else
        {
            prev.next = tail;
            tail.next = curr;
        }
    }

    // check if the list empty
    public boolean isEmpty()
    {
        return (head == null);
    }    
    
    // removing ints from the list
    public boolean remove(int x) 
    {
        Node prev, curr;

        prev = null;
        curr = head;

        // intetrating through the list to find the node needed to delete
        while(curr != null && x != curr.data)
        {
            prev = curr;
            curr = curr.next;
        }

        //loop wasn't entered, meaning empty
        if(curr == null)
        {
            return false;
        }
        else
        {
            // removing head
            if (prev == null) 
            {
                head = curr.next;
                return true;    
            }
            // removing middle or tail
            else
            {
                prev.next = curr.next;
                return true;
            }
        }
    }

    // displaying the list
    public void display()
    {
        Node t = head;
        System.out.print("\nHead -> ");
        while( t != null) {
            System.out.print(t.data + " -> ");
            t = t.next;
        }
        System.out.println("Z\n");
    }
    
}