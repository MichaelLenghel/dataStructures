//Code by C16434974

// Simple weighted graph representation 
// Uses an Adjacency Linked Lists, suitable for sparse graphs

import java.io.*;

class Heap
{
    private int[] a;	   // heap array
    private int[] hPos;	   // hPos[a[k]] == k
    private int[] dist;    // dist[v] = priority of v

    private int N;         // heap size
   
    // The heap constructor gets passed from the Graph:
    //    1. maximum heap size
    //    2. reference to the dist[] array
    //    3. reference to the hPos[] array
    public Heap(int maxSize, int[] _dist, int[] _hPos) 
    {
        N = 0;
        a = new int[maxSize + 1];
		hPos = new int[maxSize + 1];
        dist = new int[maxSize + 1];
    }


    public boolean isEmpty() 
    {
        return N == 0;
    }


    public void siftUp( int k) 
    {
       int v = a[k];
	   a[0] = Integer.MAX_VALUE;
	   dist[0] = 0;
	   dist[v] = v - a[k / 2];
	   while( dist[v] > 0 ) 
	   {
		  a[k] = a[k/2];
		  //Saying hPos[numberDealingWith] = Postion in heap
		  hPos[a[k]] = k;
		  k = k/2;
		  dist[v] = v - a[k / 2];
	   }
	   a[k] = v;
	   hPos[v] = k; 
	   dist[v] = v - a[k / 2];
    }


    public void siftDown( int k) 
    {
       //Assign element we will be shifting top v
		int v = a[k];
		dist[v] = v - a[k / 2];
		if((k * 2) + 1 < N)
		{
		//While node at pos k, has a left child node
		while(v < a[k * 2] || v < a[(k * 2) + 1])
		{
			//Ensure we do not go out of bounds
			if((k * 2) + 1 < N)
			{
			  if (a[k * 2] > a[(k * 2) + 1]) 
			  {
				a[k] = a[k * 2];
				k = k * 2;
				dist[v] = v - a[k / 2];
			  }
			  else 
			  {
				 a[k] = a[(k * 2) + 1];
				  k = (k * 2) + 1;
				  dist[v] = v - a[k / 2];
			  }
			}
			else
			{
			  break;
			}
		}//end while
		//Finally assig the node we are sifting to its correct position
		a[k] = v;
		}
    }


    public void insert( int x) 
    {
        a[++N] = x;
        siftUp( N);
    }


    public int remove() 
    {   
        int v = a[1];
        hPos[v] = 0; // v is no longer in heap
        a[N+1] = 0;  // put null node into empty spot
        
        a[1] = a[N--];
        siftDown(1);
        
        return v;
    }
    
    // display heap values and their priorities or distances
    void display() {
        System.out.println("\n\nThe tree structure of the heaps is:");
		
        System.out.println( a[1] + "(" + Math.abs(dist[a[1]]) + ")" );
        for(int i = 1; i<= N/2; i = i * 2) {
            for(int j = 2*i; j < 4*i && j <= N; ++j)
                System.out.print( a[j] + "(" + Math.abs(dist[a[j]]) + ")  ");
            System.out.println();
        }
    }

}


   

public class HeapTest {
    public static void main(String[] args) throws IOException
    {
        int d[] = {0, 100, 70, 120, 20, 60 , 50, 130, 90, 60, 11, 154, 43, 114, 52, 76};
        int i, u;
        double x;
        int heapPos[] = new int[16];
        
        Heap h = new Heap(15, d, heapPos);
        h.insert(1);
		h.display();
        for(i = 0; i < 10; ++i) {
            // pick a heap random value between 1 and 15 and 
            // insert into heap if not already there
            x = Math.random()*15.0;
            u = (int) x + 1;
            if(heapPos[u] == 0)
                h.insert(u);
        }
        
        h.display();
		
		//Ensuring no duplicate values, since collion resolution is difficult to implement in required time.
		//If it was needed would use a hash to find a unique value for the random number generator
		if(heapPos[1] == 0)
		{
			d[1] = 3; h.insert(heapPos[1]); h.display();
		}
         
        h.remove(); h.display();
            
    }
    
    
}