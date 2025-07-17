/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q1;

/**
 *
 * @author tianlongc
 * @param <E> the generic type parameter named element
 */
public class GenericStack<E>{
    private E[] stack;
    private int top, size;
    private final static int DEFAULT_CAPACITY = 25;
    
    public GenericStack(){
        this(DEFAULT_CAPACITY);
    }
    
    public GenericStack(int size){
        @SuppressWarnings("unchecked")
        E[] temp = (E[]) new Object[size];
        this.stack = temp;
        this.size = size;
        this.top = -1;
    }
    
    public boolean isEmpty(){
        return top == -1;
    }
    
    public boolean isFull(){
        return top >= size;
    }
    
    public E peek(){
        if (isEmpty()) {
            throw new IllegalStateException("Stack underflow");
        }
        return stack[top];
    }
    
    public void push(E e){
        if (isFull()) {
            throw new IllegalStateException("Stack overflow");
        }
        stack[++top] = e;
        System.out.println("Push: " + e);
    }
    
    public void pushMany(String elements){
        System.out.println("Push many into stack....");
        String[] element = elements.split(",");
        for (String e : element) {
            push((E)e);
        }
    }
    
    public E pop(){
        if (isEmpty()) {
            throw new IllegalStateException("Stack underflow");
        }
        E temp = stack[top];
        stack[top--] = null; // dereference
        return temp;
    }
    
    public E popMiddle(){
        if (isEmpty()) {
            throw new IllegalStateException("Stack underflow");
        }
        if (((top+1)%2)==1) {
            E temp = stack[top/2];
            // Traverse to fill the empty space
            for (int i = (top+1)/2; i < top; i++) {
                stack[i] = stack[i+1];
            }
            stack[top--] = null;
            return temp;
        }
        System.out.println("Current count of stack is even number, so no middle index..");
        return null;
    }
    
    public void popAll(){
        System.out.println("There are " + (top+1) + " items in the stack. Pop all...");
        while (!isEmpty()) {
            System.out.println("Removing " + pop() + " ..");
        }
        System.out.println("");
    }
    
    public void display(){
        if (isEmpty()) {
            System.out.println("Stack is empty, nothing to display...");
        }else{
            System.out.println("\nThere are " + (top+1) + " items in the stack. Displaying...");
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
            System.out.println("");
        }
    }
    
    public static void main(String[] args) {
        
        GenericStack<String> stack1 = new GenericStack<String>(7);
        stack1.push("apple");
        stack1.display();
        stack1.pushMany("broccoli,chicken sandwich,donut,french fries,juice,maruku");
        stack1.display();
        System.out.println("Pop the top of the stack: " + stack1.pop());
        System.out.println("Pop the top of the stack: " + stack1.pop());
        stack1.display();
        System.out.println("Pop middle of the stack: " + stack1.popMiddle());
        
        stack1.display();
        System.out.println("Pop middle of the stack: " + stack1.popMiddle());
        stack1.display();
        System.out.println("-------------------------------------------");
        GenericStack<Integer> stack2 = new GenericStack<Integer>(10);
        stack2.push(1);
        stack2.push(2);
        stack2.pushMany("3 4,5,6 7");
        stack2.display();
        stack2.popAll();
        stack2.display();
    }
}
