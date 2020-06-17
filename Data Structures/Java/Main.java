public class Main{

     public static void main(String[] args)
     {
          llTest();
     }

     private static void llTest()
     {
          LinkedList ll = new LinkedList();

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
