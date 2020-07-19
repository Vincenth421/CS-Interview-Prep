public class MaxHeap{

     private int[] heap;
     private int size = 0;

     public MaxHeap()
     {
          heap = new int[16];
     }

     public MaxHeap(int size)
     {
          heap = new int[size];
     }

     public int getMax()
     {
          if(size == 0)
          {
               System.out.println("Heap is empty");
               return Integer.MIN_VALUE;
          }
          return heap[0];
     }

     public int deleteMax()
     {
          if(size <= 0) return Integer.MIN_VALUE;
     }

     public void decreaseKey(int index, int newVal)
     {

     }

     public void insert(int val)
     {
          if(size == heap.length)
          {
               heap = expand(heap);
          }


     }

     public void delete(int val)
     {

     }

     public int size()
     {
          return size;
     }

     private void swap(int ind1, int ind2)
     {
          int temp = heap[ind1];
          heap[ind1] = heap[ind2];
          heap[ind2] = temp;
     }

     private void siftUp(int ind)
     {
          if(ind <= 0 || heap[ind] <= heap[parentInd(ind)]) return;
          swap(ind, parentInd(ind));
          siftUp(parentInd(ind));
     }

     private void siftDown(int ind)
     {

     }

     private int leftInd(int ind)
     {
          return 2 * ind + 1;
     }

     private int rightInd(int ind)
     {
          return 2 * ind + 2;
     }

     private int parentInd(int ind)
     {
          return (ind - 1) / 2;
     }

     private int[] expand(int[] original)
     {
          int[] newStack = new int[original.length * 2];
          for(int i = 0; i < original.length; i++)
          {
               newStack[i] = original[i];
          }

          return newStack;
     }
}
