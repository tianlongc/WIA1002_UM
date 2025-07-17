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
        return top == size-1;
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
        System.out.println("Push: " + e);
        stack[++top] = e;
    }
    
    // stack1 and stack2 argument passing using "" indicates String data type
    public void pushMany(String elements){
        String[] element = elements.split(",");
        for (String elem : element) {
            push((E)elem);
        }
    }
    
    public E pop(){
        if (isEmpty()) {
            throw new IllegalStateException("Stack underflow");
        }
        System.out.println("Pop the top of stack...");
        E temp = stack[top];
        stack[top--] = null; // dereference
        return temp;
    }
    
    public void popAll(){
        System.out.println("There are " + (top+1) + " items in the stack. Removing all...");
        while (!isEmpty()) {
            System.out.println("Removing " + stack[top--] + " ..");
        }
    }
    
    public void display(){
        if (isEmpty()) {
            System.out.println("\nStack is empty, nothing to display...\n\n");
        }else{
            System.out.println("\nThere are " + (top+1) + " items in the stack. Displaying...");
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
            System.out.println("");
        }
    }
    
    public static void main(String[] args) {
        
        GenericStack<String> stack1 = new GenericStack<String>(5);
        stack1.push("one");
        stack1.display();
        stack1.pushMany("two,three four,five,six seven");
        stack1.display();
        stack1.pop();
        stack1.pop();
        stack1.display();
        System.out.println("-------------------------");
        GenericStack<Integer> stack2 = new GenericStack<Integer>(5);
        stack2.push(1);
        stack2.push(2);
        stack2.pushMany("3 4,5,6 7");
        stack2.display();
        stack2.popAll();
        stack2.display();
    }
}
