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
    private int q[], back, front;
    private int qmax;

 
    public QueueCB() 
    {
        qmax = 4;
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
            if ((back + 1) % qmax == 0) 
            {
                back = (back + 1) % qmax;
                q[back] = x;
            }
            else
            {
                back++;
                q[back] = x;
            }
        }//end else
      
    }
  
    public int deQueue()  throws QueueException 
    {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return (Integer.MIN_VALUE);
        }
        else
        {
            int temp = q[back];
            q[back] = Integer.MIN_VALUE;
            //This means tail is at the last element in the queue
            if ((back + 1) == qmax)
            {
                back--;
            }
            //where both elements are at the first position, doesnt count -1, -1 since isEmpty is first
            //Only brings back to empty, if no extra elements in the circular buffer
            else if (front == back && q[back + 1] != Integer.MIN_VALUE) 
            {
                back--;
                front--;
            }
            //Now - Since circular buffer, we must move tail up through array
            else
            {
                back++;
            }
            
            return temp;
        }
    }

    public void display()
    {
        for (int i = 0; i < q.length ;i++ ) {
            //If this value is reached, means we have finished all valid elements, since all aelements after have been popped
            if (q[i] == Integer.MIN_VALUE) 
            {
                break;
            }
            System.out.println(" " + q[i] + ", ");
        }
    }

    public boolean isEmpty() {
        return (front == -1 && back == -1);
    }
}



// here we test both implementations
class CircularQueue {
    public static void main(String[] arg) {
        Queue q1;
        q1 = new QueueCB();
        
        for(int i = 1; i < 6; ++i)
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
        

        //Popping doesn't work -> and not sure if we pop in a CB from start of array or back of array?
        while(!(q1.isEmpty()))
        {
            try 
            { 
                q1.deQueue();
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

