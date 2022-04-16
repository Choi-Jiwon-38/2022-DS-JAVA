public class ArrayStack<E> implements Stack<E> {
    private int maxSize; // Max size of stack
    private int top; // 
    private E [] listArray;

    public ArrayStack(int size) {
        maxSize = size;
        top = 0;
        listArray = (E[]) new Object[maxSize];
    }

    public void clear() {
        top = 0;
    }

    /** Push an element onto the top of the stack
    @param it The element being pushed onto the stack */
    public void push(E it) {
        listArray[++top] = it;
    }

    /** Remove and return the element at the top of the stack.
    @return The element at the top of the stack */
    public E pop() {
        return listArray[top--];
    }

    /** @return A copy of the top element */
    public E topValue() {
        return listArray[top];
    }

    /** @return The number of elements in the stack */
    public int length() {
        return top;
    }
}
