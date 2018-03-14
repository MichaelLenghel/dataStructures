//Adapted from https://techpuzzl.wordpress.com/2010/01/24/maxheap-and-minheap-implementations-in-java/

//package bst;
import java.util.*;
public class BinaryHeap {
    //ArrayList to hold the heap
    List h = new ArrayList();
    public BinaryHeap(){

    }
    //Constructs the heap - heapify
    public BinaryHeap(int[] e) {
        for(int i=0; i<e.length;i++)
        {
            add(e[i]);
        }
    }
    private int intGet(int key){
        return new Integer(h.get(key).toString()).intValue();
    }
    public void add(int key){
        h.add(null);
        int k = h.size()-1;
        while (k>0){
            int parent = (k-1)/2;
            int parentValue = new Integer(h.get(parent).toString()).intValue();
            //MaxHeap -
            //for minheap - if(key > parentValue)
            if(key <= parentValue){
                break;
            }
            h.set(k,parentValue);
            k=parent;
        }
        h.set(k,key);
    }
    public int getMax()
    {
        return new Integer(h.get(0).toString()).intValue();
    }
    public void percolateUp(int k, int key){
        if(h.isEmpty())
            return ;

        while(k < h.size() /2){
            int child = 2*k + 1; //left child
            if(child < h.size() -1 &&
               (new Integer(h.get(child).toString()).intValue() <
                new Integer(h.get(child+1).toString()).intValue()    )){
                child++;
            }
            if(key >= new Integer(h.get(child).toString()).intValue()){
                break;
            }
            h.set(k,new Integer(h.get(child).toString()).intValue());
            k=child;
        }
        h.set(k,key);
    }
    public int remove()
    {
        int removeNode = new Integer(h.get(0).toString()).intValue();
        int lastNode = new Integer(h.remove(h.size()-1).toString()).intValue();
        percolateUp(0,lastNode);
        return removeNode;
    }
    public boolean isEmpty()
    {
        return h.isEmpty();
    }
    

    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap(new int[] {2,5,1, 9, 52, 77, 3});
        while(!heap.isEmpty()){
            System.out.println(heap.remove());
        }

    }
}