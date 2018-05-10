/**
 *
 * @author Asad Anwer
 */
import java.util.Scanner;
 
public class CircularBuffer
{
  public static void main (String [] args) {
    Scanner myscan = new Scanner(System.in);
    
    System.out.print("Enter max queue size: ");
    int qSize = myscan.nextInt(), choice;
    
    Queue queue = new Queue(qSize);
    
    do {
      queue.print();
      System.out.print("Enter Case(zero stops):\n  1. Enqueue\n  2. Dequeue\n\nChoose: ");
      choice = myscan.nextInt();
      switch(choice) {
        case 1: queue.enqueue((int)(Math.random()*50)); break; //enqueue with random integer
        case 2: queue.dequeue(); break;
      }
    } while (choice != 0);
     queue.print();
    
  }
  
  static class Queue 
  {
    int front, rear;
    int [] Q;
    
    public Queue(int size)
    {
      Q = new int[size+1];
      front = 0;
      rear = 0;
    }
    
    public void enqueue(int val) 
    {
      rear = (rear + 1) % Q.length;
      if (rear == front)
      { //if full
        System.out.println("Queue is full."); 
        if (rear == 0) rear = Q.length - 1; else rear = rear - 1; 
        return; 
      }
      Q[rear] = val;
    }
    public int dequeue() 
    {
      if (rear == front) 
      {//if empty
        System.out.println("Queue is Empty.");
        return -1;
      }
      int tmp = Q[front];
      front = (front+1) % Q.length;
      return tmp;
    }
    public void print() 
    {
      int curr = front;
      System.out.print("Queue Element(s): ");
      if (curr == rear) { System.out.print("Queue is Empty."); 
      }
      else while (curr != rear) 
      {
        curr = (curr + 1) % Q.length;
        System.out.print(Q[curr] + " ");
      }
      System.out.println();
    }
  }
}