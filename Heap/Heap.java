// Heap.java

//Note program breaks if size < 100 due to richards array method of looking up numbers
class Heap {
  private
	int[] a, hPos;
	int N;
	static int maxH = 100;

// two constructors
public Heap() {
   N = 0;
   int temp = maxH;
   a = new int[maxH+1];
   hPos = new int[maxH+1];
   //Initialise hPos with 0s
   while(temp != 0)
   {
      hPos[temp] = 0;
      temp--;
   }//end while
}


public Heap(int size) {
  if (size < 100) 
  {
    System.out.println("Size must be 100 or greater");
  }
  else
  {
    N = 0;
    int temp = maxH;
    a = new int[size + 1];
    hPos = new int[size + 1];
    //Initialise hPos with 0s
    while(temp != 0)
    {
      hPos[temp] = 0;
      temp--;
    }//end while 
  }//end else
}//end Heap constructor

public int getN()
{
  return N;
}


public void insert( int x) {
  a[++N] = x;
  siftUp( N);
}


public void siftUp( int k) {
   int v = a[k];
   a[0] = Integer.MAX_VALUE;

   while( v > a[k/2] ) 
   {
      a[k] = a[k/2];
      //Saying hPos[numberDealingWith] = Postion in heap
      hPos[a[k]] = k;
      k = k/2;
   }
   a[k] = v;
   hPos[v] = k;
}


public void siftDown( int k) 
{
	//Assign element we will be shifting top v
	int v = a[k];
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
      }
      else 
      {
         a[k] = a[(k * 2) + 1];
          k = (k * 2) + 1;
      }
    }
    else
    {
      break;
    }
   
	}
	//Finally assig the node we are sifting to its correct position
	a[k] = v;
}


public int remove() throws HeapException
{
  //Assigns element we are deleting
  int v = a[1];
  //Assign the last element to the top of the heap (Removing the biggest element and decrementing 1)
  a[1] = a[N--]; 

  //Sift from position 1 in the array
  siftDown( 1);
  return v;
}


public void display() {
   System.out.println("\n\nThe tree structure of the heaps is:");
   System.out.println( a[1] );
   for(int i = 1; i<= N/2; i = i * 2) {
      for(int j = 2*i; j < 4*i && j <= N; ++j)
         System.out.print( a[j] + "  ");
       System.out.println();
   }
}

public boolean isEmpty()
{
  //Gets a big number at the end as a[0] is the biggest no.
    return (N == 0);
}

public void printPos()
{
  int counter = 1;
  while((counter - 1) != N)
  {
    System.out.println("position of element " + a[counter] + " " + hPos[a[counter]]);
    counter++;
  }
}    


public static void main(String args[]) 
{
   Heap h = new Heap();
   int r; double x;

   // insert random numbers between 0 and 99 into heap
   for(int i = 1; i <= 10; ++i) 
   {
	  x =  (Math.random()*100.0);
    r = (int) x; 
    System.out.println("Inserting " + r);
    h.insert(r);
	  h.display();
   }
   System.out.println("");
   System.out.println("Largest element is:  " + h.a[1]);

   h.printPos();

  //Will continue to iterate through the list until it is empty
    while(!h.isEmpty())  
    {
      try
      {
        r = h.remove(); 
        h.display();
        System.out.println("Successfully removed: " + r); 
      }
      catch(HeapException e)
      {
        System.out.println(e);
        e.printStackTrace();
      }         
    }//end while	  
}//end main

} // end of Heap class