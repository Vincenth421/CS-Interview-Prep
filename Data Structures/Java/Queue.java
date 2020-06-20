/**Using my linked list implementation to make a queue**/
public class Queue<E>{
     private LinkedList<E> queue;
     private int dequeue = 0;
     private int enqueue = 0;

     public Queue()
     {
          queue = new LinkedList<>();
     }

     public void enqueue(E e)
     {
          queue.add(e);
     }

     public E dequeue(){
          return queue.deletePosition(0);
     }

     public E peek()
     {
          return queue.get(0);
     }

     public void printQueue()
     {
          if(queue.size() == 0)
          {
               System.out.println("Queue is empty.");
               return;
          }

          for(int i = 0; i < queue.size(); i++)
          {
               System.out.print(queue.get(i) + " ");
          }

          System.out.println();
     }

}
