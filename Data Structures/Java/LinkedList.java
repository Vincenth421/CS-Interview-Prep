
public class LinkedList<E>
{
     private Node head;
     private int size = 0;

     //Append item to linked list
     public void add(E e)
     {
          Node n = new Node(e);
          n.next = null;

          if(size == 0) head = n;
          else
          {
               Node curr = head;
               while(curr.next != null)
               {
                    curr = curr.next;
               }
               curr.next = n;
          }

          size++;
     }

     public E get(int ind)
     {
          Node curr = head;
          int count = 0;

          if(ind >= size)
          {
               System.out.println("No such index exists.");
               return null;
          }

          while(curr != null)
          {
               if(count == ind)
               {
                    return curr.item;
               } else {
                    curr = curr.next;
                    count++;
               }
          }

          return null;
     }

     //Given item e, delete the first occurence. Returns the deleted item.
     public E delete(E e)
     {
          if(size == 0)
          {
               System.out.println("List is empty.");
               return null;
          }


          Node curr = head;

          if(curr.item.equals(e))
          {
               if(size == 1) head = null;
               head = curr.next;
               size--;
               return e;
          }

          while(curr.next != null)
          {
               if(curr.next.item.equals(e))
               {
                    if(curr.next.next == null) curr.next = null;
                    else curr.next = curr.next.next;

                    size--;
                    return e;
               }

               curr = curr.next;
          }

          System.out.println("Element not found.");
          return null;
     }

     //Given index ind, delete item at that index.
     public E deletePosition(int ind)
     {
          Node curr = head;
          Node prev = null;

          if(ind >= size)
          {
               System.out.println("No such index exists.");
               return null;
          }

          if(ind == 0)
          {
               head = curr.next;
               size--;
               return curr.item;
          }

          int count = 0;

          while(curr != null)
          {
               if(count == ind)
               {
                    prev.next = curr.next;
                    size--;
                    return curr.item;
               } else {
                    prev = curr;
                    curr = curr.next;
                    count++;
               }
          }

          return null;
     }

     //Print the linked list.
     public void printList()
     {
          if(size == 0)
          {
               System.out.println("List is empty.");
               return;
          }

          Node curr = head;
          while(curr.next != null)
          {
               System.out.print(curr.item + " -> ");
               curr = curr.next;
          }

          System.out.println(curr.item);
     }

     public int size()
     {
          return size;
     }


     /**Private Node class for Linked List**/
     private class Node
     {
          private E item;
          private Node next;

          public Node(E obj)
          {
               item = obj;
               next = null;
          }
     }
}
