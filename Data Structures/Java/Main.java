public class Main{

     public static void main(String[] args)
     {
          llTest();
          //stackTest();
          //queueTest();
     }

     private static void queueTest()
     {
          Queue q = new Queue();

          q.enqueue(1);
          q.enqueue(2);
          q.enqueue(3);
          q.enqueue(4);
          q.enqueue(5);

          q.printQueue();

          System.out.println(q.peek());

          q.dequeue();

          System.out.println(q.dequeue());

          q.printQueue();

     }

     private static void stackTest()
     {
          Stack s = new Stack();

          s.push(1);
          s.push(2);
          s.push(3);

          s.printStack();

          System.out.println(s.peek());

          s.pop();

          System.out.println(s.pop());
          s.printStack();

          s.pop();

          s.printStack();

          s.push(1);
          s.push(2);
          s.push(3);
          s.push(1);
          s.push(2);
          s.push(3);

          s.printStack();
     }

     private static void llTest()
     {
          LinkedList ll = new LinkedList();

          //Test deletes on empty list
          ll.delete(1);
          if(ll.deletePosition(0) != 0) {System.out.println("LL deletePosition() failed."); return;}
          if(ll.size() != 0) {System.out.println("LL size() failed."); return;}

          //Test get on empty List
          if(ll.get(0) != 0) {System.out.println("LL empty get() failed."); return;}
          if(ll.get(1) != 0) {System.out.println("LL empty get() failed."); return;}

          //Test adding
          ll.add(0);
          ll.add(1);
          ll.add(2);
          ll.add(3);
          ll.printList();
          if(ll.size() != 4) {System.out.println("LL size() fail."); return;}

          //Test get
          if(ll.get(1) != 1) {System.out.println("LL get() fail."); return;}
          if(ll.get(0) != 0) {System.out.println("LL get() fail."); return;}
          if(ll.get(3) != 3) {System.out.println("LL get() fail."); return;}
          if(ll.get(4) != 0) {System.out.println("LL get() fail."); return;}
          if(ll.get(-1) != 0) {System.out.println("LL get() fail."); return;}

          //Test deletes
          ll.delete(4); //no element exists
          ll.delete(3);
          ll.delete(0);

          ll.deletePosition(0);

          ll.printList();

          System.out.println("*** LL TESTS PASSED. ***");

     }

}
