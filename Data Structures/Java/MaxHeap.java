public class MaxHeap{

     //using an array to represent heap
     private int[] heap;
     private int size = 0;

     //default size 16
     public MaxHeap()
     {
          heap = new int[16];
     }

     public MaxHeap(int size)
     {
          heap = new int[size];
     }

     //return root if it exists
     public int getMax()
     {
          if(size == 0)
          {
               System.out.println("Heap is empty");
               return Integer.MIN_VALUE;
          }
          return heap[0];
     }

     //Delete the root and return it.
     public int deleteMax()
     {
          if(size <= 0) return Integer.MIN_VALUE;

          int max = heap[0];

          swap(0, size - 1);     //swap root with last item in heap
          size--;   //decrease the size before shifting down
          siftDown(0);   //put the root item at its proper place

          return max;
     }

     //change the value at specified index to new value. Returns the old value.
     public int changeKey(int index, int newVal)
     {
          if(index >= size)
          {
               System.out.println("Index Out of Bounds");
               return Integer.MIN_VALUE;
          }

          //keep track of the old item.
          int old = heap[index];
          heap[index] = newVal;
          if(newVal < old) siftDown(index);  //if new value is smaller, shift it down
          else if(newVal > old) siftUp(index);    //if new value is greater than the old value, shift it up.

          return old;
     }

     //insert a value into the heap
     public void insert(int val)
     {
          if(size == heap.length)
          {
               heap = expand(heap);
          }

          //temporarily put it at the end of the heap.
          heap[size] = val;

          //shift it up to proper place.
          siftUp(size);

          size++;
     }

     public int size()
     {
          return size;
     }

     //Helper function to swap two indices in heap
     private void swap(int ind1, int ind2)
     {
          int temp = heap[ind1];
          heap[ind1] = heap[ind2];
          heap[ind2] = temp;
     }

     //putting an element at ind in the right place above.
     private void siftUp(int ind)
     {
          //stop if at root or smaller than its parent
          if(ind <= 0 || heap[ind] <= heap[parentInd(ind)]) return;
          swap(ind, parentInd(ind));    //swap with parent if not in the right place
          siftUp(parentInd(ind));  //element is at its parent position, so shift it up using parent ind
     }

     //putting a top element at ind in the right place below.
     private void siftDown(int ind)
     {
          int left = leftInd(ind);
          int right = rightInd(ind);
          int maxi = ind;

          //first compare left child. If it is in bounds and bigger than current element, set max index to left child index.
          if(left < size && heap[left] > heap[ind])
          {
               maxi = left;
          }

          //next compare right child with max element. If right is bigger, set max index to right child.
          if(right < size && heap[right] > heap[maxi])
          {
               maxi = right;
          }

          //if current index isn't the max, swap with the appropriate max child that we established above. Recursively shift down the current element
          if(maxi != ind)
          {
               swap(maxi, ind);
               siftDown(maxi);
          }
     }

     public void printHeap()
     {
          for(int i = 0; i < size; i++)
          {
               System.out.print(heap[i] + " ");
          }
     }

     //The following 3 methods get the indices of left and right child, and parent.
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

     //copies over original array to bigger array. Also can use array copy.
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
