/*Circular buffer queue with array implementation
Also error checking with exception*/

class QueueException extends Exception {
    public QueueException(String s) {
        super(s);
    }
}    

// In Java an interface can often be the best way to 
// describe an Abstract Data Type (ADT) such as Queue or Stack
interface Queue {
    public void enQueue(int x) throws QueueException;
    public int deQueue() throws QueueException;
    public boolean isEmpty();
    public void display();   
}

class QueueCB implements Queue {
    private int q[], back, front, size;
    private int qmax;

 
    public QueueCB() 
    {
        qmax = 4;
        size = 0;
        front = back = -1;
        q = new int[qmax];
        //Initialise all elements of array
        for (int i = 0;i < q.length ;i++ ) {
            q[i] = Integer.MIN_VALUE;
        }
    }

    public void enQueue( int x) throws QueueException  {
        //Need to do this first as in next else, checks (back + 1) % qmax, which returns 0 if empty - not good!
        if (isEmpty()) 
        {
            //Sets to zero (ie has an element)
            front ++;
            back++;
            //Assigns q[0] value
            q[back] = x; 
        }
        //IsEmpty prevents us from ever achieving 0, except when buffer is full
        else
        {
            back = (back + 1) % qmax;
            q[back] = x;
        }//end else
      size++;
    }
  
    public int deQueue()  throws QueueException 
    {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return (Integer.MIN_VALUE);
        }
        else
        {
            int temp = q[front];
            q[front] = Integer.MIN_VALUE;
            front = (front + 1) % qmax;
            size--;
            
            return temp;
        }
    }

    public void display()
    {
        for (int i = 0; i < q.length ;i++ ) {
            if (q[i] == Integer.MIN_VALUE) 
            {
                //Do nothing
            }
            else
            {
                System.out.println(" " + q[i] + ", ");
            }
            
        }
    }

    public boolean isEmpty() {
        return (size == 0);
    }
}



// here we test both implementations
class CircularQueue {
    public static void main(String[] arg) {
        Queue q1;
        int i;
        q1 = new QueueCB();
        System.out.println("Enqueues: ");
        for(i = 1; i < 6; ++i)
        {
            try 
            { 
                q1.enQueue(i);  
                System.out.println("Iteration " + i);
                q1.display();          
            } 
            catch (QueueException e) 
            {
                System.out.println("Exception thrown: " + e); 
            }
        }
        
        System.out.println("Dequeues: ");
        //Popping doesn't work -> and not sure if we pop in a CB from start of array or back of array?
        while(!(q1.isEmpty()))
        {
            try 
            { 
                int temp = q1.deQueue();
                System.out.println("Just deleted: " + temp);
                System.out.println("Iteration " + i); i++;
                q1.display();
            }
            catch (QueueException e) 
            {
                System.out.println("Exception thrown: " + e); 
            }
        }
       
        
        // more test code
    }   
}

