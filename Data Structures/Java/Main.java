public class Main{

     public static void main(String[] args)
     {
          llTest();
          stackTest();
          BSTTest();
     }

     private static void BSTTest()
     {
          BST bst = new BST();

          bst.add(5);
          bst.add(8);
          bst.add(6);
          bst.add(3);
          bst.add(0);
          bst.add(2);
          bst.add(9);
          bst.add(-2);

          //contains test
          if(bst.contains(-1))
          {
               System.out.println("BST contains() failed");
               return;
          }

          if(!bst.contains(3))
          {
               System.out.println("BST contains() failed");
               return;
          }

          bst.delete(5);

          if(bst.contains(5))
          {
               System.out.println("BST delete() failed");
               return;
          }

          bst.delete(8);

          if(!bst.contains(9))
          {
               System.out.println("BST delete() failed");
               return;
          }

          bst.delete(-2);

          System.out.println("*** BST TESTS PASSED ***");
     }

     private static void stackTest()
     {
          Stack s = new Stack();

          s.push(1);
          s.push(2);
          s.push(3);

          if(s.peek() != 3)
          {
               System.out.println("Stack peek() fail");
               return;
          }

          s.pop();

          if(s.pop() != 2)
          {
               System.out.println("Stack pop() fail");
          }

          s.pop();

          s.pop(); //Print Stack is empty.

          System.out.println("*** STACK TESTS PASSED ***");


     }

     private static void llTest()
     {
          LinkedList ll = new LinkedList();

          //Test deletes on empty list
          ll.delete(1);
          if(ll.deletePosition(0) != 0)
          {
               System.out.println("LL deletePosition() failed");
               return;
          }

          if(ll.size() != 0)
          {
               System.out.println("LL size() failed");
               return;
          }

          //Test get on empty List
          if(ll.get(0) != 0)
          {
               System.out.println("LL empty get() failed");
               return;
          }

          //Test adding
          ll.add(0);
          ll.add(1);
          ll.add(2);
          ll.add(3);

          if(ll.size() != 4)
          {
               System.out.println("LL size() failed");
               return;
          }

          //Test get
          if(ll.get(1) != 1)
          {
               System.out.println("LL get() failed");
               return;
          }

          if(ll.get(-1) != 0)
          {
               System.out.println("LL get() failed");
               return;
          }

          //Test deletes
          //no element exists
          if(ll.delete(4))
          {
               System.out.println("LL delete() failed");
               return;
          }

          if(!ll.delete(3))
          {
               System.out.println("LL delete() failed");
               return;
          }

          ll.delete(3);

          if(ll.deletePosition(0) != 0)
          {
               System.out.println("LL deletePos() failed");
               return;
          }

          System.out.println("*** LL TESTS PASSED ***");

     }

}
