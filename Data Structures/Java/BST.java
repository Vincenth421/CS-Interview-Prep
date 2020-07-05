public class BST{


     private class Node{
          int item;
          Node left;
          Node right;

          public Node(int item)
          {
               this.item = item;
               left = null;
               right = null;
          }

          public Node(int item, Node left, Node right)
          {
               this.item = item;
               this.left = left;
               this.right = right;
          }
     }
}
