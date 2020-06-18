
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

     //Given item e, delete the first occurence. Return true if deleted, false otherwise.
     public boolean delete(E e)
     {
          if(size == 0)
          {
               System.out.println("List is empty.");
               return false;
          }


          Node curr = head;

          if(curr.item.equals(e))
          {
               if(size == 1) head = null;
               head = curr.next;
               size--;
               return true;
          }

          while(curr.next != null)
          {
               if(curr.next.item.equals(e))
               {
                    if(curr.next.next == null) curr.next = null;
                    else curr.next = curr.next.next;

                    size--;
                    return true;
               }

               curr = curr.next;
          }

          System.out.println("Element not found.");
          return false;
     }

     //Given index ind, delete item at that index.
     public boolean deletePosition(int ind)
     {
          Node curr = head;
          Node prev = null;

          if(ind >= size)
          {
               System.out.println("No such index exists.");
               return false;
          }

          if(ind == 0)
          {
               head = curr.next;
               size--;
               return true;
          }

          int count = 0;

          while(curr != null)
          {
               if(count == ind)
               {
                    prev.next = curr.next;
                    size--;
                    return true;
               } else {
                    prev = curr;
                    curr = curr.next;
                    count++;
               }
          }

          return false;
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
