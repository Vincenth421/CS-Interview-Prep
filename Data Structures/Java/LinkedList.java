public class LinkedList
{
     private Node head;
     private int size;

     public LinkedList()
     {
          head = null;
          size = 0;
     }

     //Append item to linked list
     public void add(int item)
     {

          Node n = new Node(item);

          //if linked list is empty, make initialize the head
          if(size == 0) head = n;
          else
          {
               Node curr = head;

               //iterate until last node
               while(curr.next != null)
               {
                    curr = curr.next;
               }

               //set the next of the last node to new node
               curr.next = n;
          }

          size++;
     }

     //get the item at the index ind
     public int get(int ind)
     {
          Node curr = head;
          int count = 0;
          int item = 0;

          //exit if index is out of bounds
          if(ind >= size || ind < 0)
          {
               System.out.println("No such index exists.");
               return item;
          }

          //iterate through whole list
          while(curr != null)
          {
               //end loop when we hit the index
               if(count == ind)
               {
                    item = curr.item;
                    break;
               } else {
                    curr = curr.next;
                    count++;
               }
          }

          return item;
     }

     //Given item e, delete the first occurence. True if deleted, false otherwise;
     public boolean delete(int item)
     {
          if(size == 0)
          {
               System.out.println("List is empty.");
               return false;
          }

          Node curr = head;
          Node prev = null;

          if(curr.item == item)
          {
               head = curr.next;
               size--;
               return true;
          }

          while(curr != null)
          {
               if(curr.item == item)
               {
                    prev.next = curr.next;
                    size--;
                    return true;
               }
               prev = curr;
               curr = curr.next;
          }

          System.out.println("Element not found.");
          return false;
     }

     //Given index ind, delete item at that index. Return deleted item.
     public int deletePosition(int ind)
     {
          Node curr = head;
          Node prev = null;
          int item = 0;

          if(ind >= size)
          {
               System.out.println("No such index exists.");
               return item;
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
                    item = curr.item;
                    break;
               } else {
                    prev = curr;
                    curr = curr.next;
                    count++;
               }
          }

          return item;
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
          private int item;
          private Node next;

          public Node(int item)
          {
               this.item = item;
               next = null;
          }

          public Node(int item, Node next)
          {
               this.item = item;
               this.next = next;
          }
     }
}
