public class BST{

     private Node root;

     public BST(){
          root = null;
     }

     public void add(int item)
     {
          root = addHelp(root, item);
     }

     private Node addHelp(Node root, int item)
     {
          //if root is null, set to a new node with item
          if(root == null)
          {
               root = new Node(item);
          } else if(item < root.item) {
               root.left = addHelp(root.left, item);
          } else {
               root.right = addHelp(root.right, item);
          }

          //return finished tree
          return root;
     }

     public boolean contains(int item)
     {
          return containsHelp(item, root);
     }

     private boolean containsHelp(int item, Node node)
     {
          if(node == null)
          {
               return false;
          } else if(node.item == item) {
               return true;
          } else if(item < node.item) {
               return containsHelp(item, node.left);
          } else {
               return containsHelp(item, node.right);
          }
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