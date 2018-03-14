//Adapted from: https://www.geeksforgeeks.org/heap-sort/

// Java program for implementation of Heap Sort
public class HeapSort
{
    public static int iteration;
    public HeapSort()
    {
        System.out.println("Created heap object");
    }
    public void sort(int arr[])
    {
        //To keep track of each iteration of the array
        iteration = 1;
        //Assigns length
        int n = arr.length;
        int printTemp = 0;
        // Build heap (rearrange array)
        for (int i = (n / 2) - 1; i >= 0; i--)
            heapify(arr, n, i);

        //Actual sorting portion of the heap
 
        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
 
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int arr[], int n, int i)
    {
        //System.out.println("i = " + i);
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2
 
        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;
 
        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;
 
        // If largest is not root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
        System.out.println("Iteration " + iteration + " of array is: ");
        iteration++;
        printArray(arr);
    }
 
    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
 
    // Driver program
    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};
 
        HeapSort ob = new HeapSort();
        ob.sort(arr);
 
        System.out.println("Sorted array is");
        printArray(arr);
    }
}