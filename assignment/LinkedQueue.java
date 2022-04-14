public class LinkedQueue<E> implements Queue<E> {
    private Link<E> front, rear;
    private int size;
    
    public LinkedQueue() {
        front = rear = Link.get(null, null);
        size = 0;
    }

    /** Reinitialize the queue. The user is responsible for
    reclaiming the storage used by the queue elements. */
    public void clear() {
        front.setNext(null);
        size = 0;
    }

    /** Place an element at the rear of the queue.
    @param it The element being enqueued. */
    public void enqueue(E it) {
        rear = rear.setNext(new Link<>(it, null));
        size++;
    }

    /** Remove and return element at the front of the queue.
    @return The element at the front of the queue. */
    public E dequeue() {
        E ret = front.next().item();
        front = front.next();
        size--;
        return ret;
    }

    /** @return The front element. */
    public E frontValue() {
        return front.next().item();
    }

    /** @return The number of elements in the queue. */
    public int length() {
        return size;
    }
}
