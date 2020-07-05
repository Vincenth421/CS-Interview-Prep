/**Using my linked list implementation to make a queue**/
public class Queue{
     private LinkedList queue;
     private int dequeue = 0;
     private int enqueue = 0;

     public Queue()
     {
          queue = new LinkedList();
     }

     public void enqueue(int i)
     {
          queue.add(i);
     }

     public int dequeue(){
          return queue.deletePosition(0);
     }

     public int peek()
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
