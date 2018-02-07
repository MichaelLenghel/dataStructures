import java.util.Random;

    public class SortedList
    {
        public static void main( String[] arg)
        {
            SortedLL list = new SortedLL();
            list.display();
            //int a[] = new int[5];
            int[] a = {8, 2, 3, 7, 8, 1, 6, 0, 2, 9, 3, 4};
            int i, x, temp;
            temp = 1;

            Random r = new Random();
            
            for(i=0; i<10; ++i) {
                //x = r.nextInt();

                list.insert(a[i]);
                temp = i + 1;
                System.out.println("List iteration "+ temp + ": ");
                list.display();            
            }//end for 
            list.remove(6); 
            list.display();  
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
    public void insert(int value)
    {
        Node t = new Node();
        t.data = value;
        t.next = null;
        Node prev = null;
        Node curr = head;
        
        while(curr != null && value > curr.data)
        {
            prev = curr;
            curr = curr.next;
            //he doesn't have curr != null, he has last ele pointing to itself, as will never move passed it
        }

        //loop wasn't entered, meaning empty
        if (prev == null)
        {
            t.next = head;
            head = t;
        }
        else
        {
            prev.next = t;
            t.next = curr;
        }
        tail = t;
    }//end insert    

    public void remove(int value)
    {
        Node prev = null;
        Node curr = head;
        
        while(curr != null && value > curr.data)
        {
            prev = curr;
            curr = curr.next;
            //he doesn't have curr != null, he has last ele pointing to itself, as will never move passed it
        }

        //loop wasn't entered, meaning empty
        if (prev == null)
        {
           System.out.println("List is empty");
        }

        //Account for only one element in the list
        else if(head == tail)
        {
            head = null;
            tail = null;
        }
        else
        {
            //Curr will be the element we are dealing with, so get element b4, to point to element after curr.
            prev.next = curr.next;
        }
    }
    public void display()
    {
        Node t = head;
        int i = 1;
        while( t != null) {
            System.out.println(i + ": " + t.data);
            t = t.next;
            i++;
        }
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