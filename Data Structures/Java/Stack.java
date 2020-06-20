public class Stack<E>{
     private Object[] stack;
     private int top = -1;
     private int size = 0;

     public Stack()
     {
          stack = new Object[4];
     }

     public Stack(int size)
     {
          stack = new Object[size];
     }


     public void push(E e)
     {
          if(top >= stack.length - 1)
          {
               stack = expand(stack);
          }

          stack[top + 1] = e;
          top++;
          size++;
     }

     public E pop()
     {
          if(size == 0)
          {
               System.out.println("Stack is empty.");
               return null;
          }

          E ret = (E) stack[top];
          top--;
          size--;

          return ret;
     }

     public E peek()
     {
          if(size == 0)
          {
               System.out.println("Stack is empty.");
               return null;
          }

          return (E) stack[top];
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

     private Object[] expand(Object[] original)
     {
          Object[] newStack = new Object[original.length * 2];
          for(int i = 0; i < original.length; i++)
          {
               newStack[i] = original[i];
          }

          return newStack;
     }

}
