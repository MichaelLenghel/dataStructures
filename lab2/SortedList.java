import java.util.Random;

    public class SortedList
    {
        public static void main( String[] arg)
        {
            SortedLL list = new SortedLL();
            list.display();
            
            int i, x, temp;
            temp = 1;
            Random r = new Random();
            
            for(i=0; i<10; ++i) {
                x = r.nextInt();
                list.insert(x);
                temp = i + 1;
                System.out.println("Element " + temp);
                list.display();            
            }//end for  
        }//end main
    }//end class SortedList

class SortedLL
{
    Node head, tail;
    class Node
    {
        int data;
        Node next;
    }
    // internal data structure and
    // constructor code to be added here
    SortedLL()
    {
        head = null;
        tail = null;
    }//end constructor SortedLL
    
    // this is the crucial method
    public void insert(int x)
    {
        Node prev, curr;
        Node t = new Node();
        t.data = x;
        t.next = null;

        prev = curr;
        curr = this.head.next;
        

        //No need to conern ourselves with prev and curr if list is empty
        if (isEmpty()) 
        {
            head = t;
            tail = t;
        }

        //Only one element in the list, still cant sayprevious
        else if(tail == head)
        {
            tail = t;
        }

        //prev.data is null when only one element in the list or when no val for it,
        // therefore null.data gives null pointer execption
        while(curr.next != null && t.data > prev.data)
        {
            prev = curr;
            curr = curr.next;
        }
        //Make link with pre element point to new element and
        //new element to point the element in front of it
        prev.next = t;
        t = curr;
    }    

    public int remove(int x)
    {
        int val = 0;

        if (isEmpty() == false) 
        {
            Node prev, curr;
            Node t = new Node();
            t.data = x;
            t.next = null;

            curr = this.head;
            prev = null;

            while(curr.next != null)
            {
                if (t.data == curr.data) 
                {
                    //Sets the element b4 current(element we are deleting) to the elemen3t afetr current
                    //This cuts the link
                    val = curr.data;
                    prev = curr.next;
                    break;
                }
                prev = curr;
                curr = curr.next;
            }
        }//end if
        else
        {
            System.out.println("Queue is empty");
            val = 0;
        }//end else
        return(val);
    }//end remove

    public void display()
    {
        Node t = head;
        System.out.println("Head -> ");
        while( t != null) {
            System.out.println("{0} -> " + t.data);
            t = t.next;
        }
        System.out.println("Tail");
    }

    public boolean isEmpty()
    {
        return (head == null);
    }
    
    // public static void SortedList()
    // {
    //     SortedLL list = new SortedLL();
    //     list.display();
        
    //     int i, x, temp;
    //     temp = 1;
    //     Random r = new Random();
        
    //     for(i=0; i<10; ++i) {
    //         x = r.nextInt();
    //         list.insert(x);
    //         temp = i + 1;
    //         System.out.println("Element " + temp);
    //         list.display();            
    //     }//end for
    // }//end sortedList
}