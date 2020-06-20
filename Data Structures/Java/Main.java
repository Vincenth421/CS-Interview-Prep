public class Main{

     public static void main(String[] args)
     {
          //llTest();
          stackTest();
     }

     private static void stackTest()
     {
          Stack<Integer> s = new Stack<>();

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
          LinkedList<Integer> ll = new LinkedList<>();

          ll.add(1);
          ll.add(2);
          ll.add(3);
          ll.add(3);
          ll.add(4);
          ll.add(5);

          ll.printList();

          ll.delete(1);
          ll.delete(5);
          ll.delete(3);
          ll.delete(4);
          ll.delete(1);

          ll.printList();

          ll.deletePosition(3);
          ll.deletePosition(0);

          ll.printList();

          ll.add(1);
          ll.add(2);
          ll.add(3);
          ll.add(4);
          ll.add(5);

          ll.deletePosition(0);

          ll.printList();

          ll.deletePosition(5);
          ll.deletePosition(4);
          ll.deletePosition(1);
          ll.deletePosition(2);

          ll.printList();
     }

}
