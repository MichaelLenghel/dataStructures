//Code by C16434974

// Simple weighted graph representation 
// Uses an Adjacency Linked Lists, suitable for sparse graphs

import java.io.*;
import java.util.*;

class Heap
{
    private int[] a;	   // heap array
    public int[] hPos;	   // hPos[a[k]] == k
    private int[] dist;    // dist[v] = priority of v

    private int N;         // heap size
   
    // The heap constructor gets passed from the Graph:
    //    1. maximum heap size
    //    2. reference to the dist[] array
    //    3. reference to the hPos[] array
    public Heap(int maxSize, int[] _dist) 
    {
        N = 0;
        a = new int[maxSize + 1];
		hPos = new int[maxSize + 1];
        //dist = new int[maxSize + 1];
        dist = Arrays.copyOf(_dist, maxSize + 1);
    }


    public boolean isEmpty() 
    {
        return N == 0;
    }


    public void siftUp( int k) 
    {
       int t = a[k];
       int startDistance = dist[k];
	   a[0] = Integer.MAX_VALUE;
	   dist[0] = Integer.MAX_VALUE;
	   //while( a[k] > a[k / 2]) 
       while( startDistance > dist[k / 2]) 
	   {
        dist[k] = dist[k / 2];
		a[k] = a[k/2];
		//Saying hPos[numberDealingWith] = Postion in heap
		hPos[a[k]] = k;
		k = k/2;
	   }
       //Assign a[k] that we are on the element we originally started inserting
	   a[k] = t;
       //Set position of original element to element on
	   hPos[t] = k; 
       //Set distance of element on to originalk distance
       dist[t] = startDistance;
    }


    public void siftDown( int k) 
    {
       //Assign element we will be shifting top v
		int v = a[k];
        int startDistance = dist[k];
		dist[v] = Integer.MAX_VALUE;
		if((k * 2) + 1 < N)
		{
    		//While node at pos k, has a left child node
    		while(startDistance < dist[k * 2] || startDistance < dist[k * 2 + 1])
    		{
                if((k * 2) + 1 < N)
                {
                    if (dist[k * 2] > dist[k * 2 + 1]) {
                         dist[k] = dist[k * 2];
                         a[k] = a[k * 2];
                         hPos[a[k]] = k;
                         k = k * 2;
                    }
                    else
                    {
                        dist[k] = dist[k * 2 + 1];
                        a[k] = a[(k * 2) + 1];
                        hPos[a[k]] = k;
                        k = (k * 2) + 1;
                    }
                    
        			k = k * 2;
                }
    		}//end while
    		//Finally assig the node we are sifting to its correct position
    		a[k] = v;
            hPos[v] = k; 
            dist[v] = startDistance; // chance from v to k at end
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
        //a[N+1] = 0;  // put null node into empty spot
        
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

    void setDistance(int index, int priority)
    {
        dist[index] = priority;
    }

}


   

public class HeapTest {
    public static void main(String[] args) throws IOException
    {
        int d[] = {0, 100, 70, 120, 20, 60 , 50, 130, 90, 60, 11, 154, 43, 114, 52, 76};
        int i, u;
        double x;
        
        Heap h = new Heap(15, d);
        h.insert(1);
		h.display();
        for(i = 0; i < 10; ++i) {
            // pick a heap random value between 1 and 15 and 
            // insert into heap if not already there
            x = Math.random()*15.0;
            u = (int) x + 1;

            if(h.hPos[u] == 0)
            {
                h.insert(u);
            }
        }
        
        h.display();
		
        //h.setDistance(1, 3); h.insert(h.hPos[1]); h.display(); 
         
        h.remove(); h.display();
            
    }
    
    
}