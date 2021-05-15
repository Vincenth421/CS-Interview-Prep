public class Stack{
     private int[] stack;
     private int top = -1;
     private int size = 0;

     public Stack()
     {
          stack = new int[4];
     }

     public Stack(int size)
     {
          stack = new int[size];
     }


     public void push(int item)
     {
          if(top >= stack.length - 1)
          {
               stack = expand(stack);
          }

          stack[top + 1] = item;
          top++;
          size++;
     }

     public int pop()
     {
          if(size == 0)
          {
               System.out.println("Stack is empty.");
               return 0;
          }

          int ret = stack[top];
          top--;
          size--;

          return ret;
     }

     public int peek()
     {
          if(size == 0)
          {
               System.out.println("Stack is empty.");
               return 0;
          }

          return stack[top];
     }

     public int size()
     {
          return size;
     }

     public void printStack()
     {
          if(size == 0)
          {
               System.out.println("Stack is empty.");
               return;
          }

          for(int i = 0; i < top + 1; i++)
          {
               System.out.print(stack[i] + " ");
          }

          System.out.println();

     }

     private int[] expand(int[] original)
     {
          int[] newStack = new int[original.length * 2];
          for(int i = 0; i < original.length; i++)
          {
               newStack[i] = original[i];
          }

          return newStack;
     }

}
