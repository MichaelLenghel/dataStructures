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
        int v = a[k];
        a[0] = 0;
        dist[0] = 0;

        while( dist[v] < dist[a[k / 2]]) 
        {
            //System.out.println("a[k / 2] inside loop = " + a[k / 2]);
            a[k] = a[k / 2];
            //Saying hPos[numberDealingWith] = Postion in heap
            hPos[a[k]] = k;
            k = k /  2;
        }
        a[k] = v;
        hPos[v] = k;
    }


    public void siftDown( int k) 
    {
        //Assign element we will be shifting top v
		int v = a[k];

		//dist[v] = Integer.MAX_VALUE;
		//While node at pos k, has a left child node
		while(dist[v] > dist[a[k * 2]] && N >= (k * 2))
		{
            a[k] = a[k * 2];
            k = k * 2;
		}//end while
		//Finally assig the node we are sifting to its correct position
		a[k] = v;
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
            System.out.println("Variable input = " + u);

            if(h.hPos[u] == 0)
            {
                h.insert(u);
            }
        }
        
        h.display();
		
        //change dist[1] = 3; (from 100 -> 3, then check if it went up)
        h.setDistance(1, 3); 
        System.out.println(" hPos[1] = " + h.hPos[1]);
        // //Will insert whatever element is at position 1
        h.insert(h.hPos[1]); h.display(); 
         
        int check = h.remove(); System.out.println("just removed " + check); h.display();
            
    }
    
    
}