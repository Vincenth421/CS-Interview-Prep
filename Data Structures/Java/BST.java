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

     private boolean containsHelp(int item, Node root)
     {
          if(root == null)
          {
               return false;
          } else if(root.item == item) {
               return true;
          } else if(item < root.item) {
               return containsHelp(item, root.left);
          } else {
               return containsHelp(item, root.right);
          }
     }

     //Delete an item from the tree.
     public void delete(int item)
     {
          root = deleteHelp(item, root);
     }

     public Node deleteHelp(int item, Node root)
     {
          if(root == null) return root;

          if(item < root.item)
          {
               root.left = deleteHelp(item, root.left);
          } else if(item > root.item) {
               root.right = deleteHelp(item, root.right);
          } else {
               if(root.right == null)
               {
                    return root.left;
               } else if(root.left == null) {
                    return root.right;
               } else {
                    root.item = min(root.right);
                    deleteHelp(root.item, root.right);
               }
          }

          return root;
     }

     private int min(Node root)
     {
          if(root.left == null)
          {
               return root.item;
          } else if(root.left.left == null) {
               return root.left.item ;
          } else {
               return min(root.left);
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
