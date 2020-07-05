public class BST{

     private Node root;

     public BST(){
          root = null;
     }

     public void add(int item)
     {
          root = addHelp(root, item);
     }

     public Node addHelp(Node root, int item)
     {
          if(root == null)
          {
               root = new Node(item);
          } else if(item < root.item) {
               root.left = addHelp(root.left, item);
          } else {
               root.right = addHelp(root.right, item);
          }

          return root;
     }

     public void printTree(Node root)
     {
          if(root == null) return;

          System.out.println(root.item + " ");
          printTree(root.left);
          printTree(root.right);

     }

     public Node getRoot()
     {
          return root;
     }

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
