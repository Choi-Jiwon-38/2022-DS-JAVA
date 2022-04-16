public class LinkedList<E> implements List<E> {
    Link<E> head, tail;
    int size;
    
    public LinkedList() {
        head = tail = new Link<>(null, null);
        size = 0;
    }

    public void clear(){
        head.next = null;
        tail = head;
        size = 0;
    }

    public void insert(int pos, E item) {
        Link<E> curr = head;
        for (int i = 0; i < pos; i++) {
            curr = curr.next;
        }
        Link<E> n = new Link<>(item, curr.next);
        curr.next = n;
        
        if (curr == tail) {
            tail = curr.next;
        }

        size++;
    }
    public void append(E item) {
        Link<E> n = new Link<>(item, null);
        tail.next = n;
        tail = n;
        size++;
    }

    public void update(int pos, E item) {
        Link<E> curr = head;
        for (int i = 0; i < pos; i++) {
            curr = curr.next;
        }

        curr.next.item = item;
    }

    public E getValue(int pos) {
        Link<E> curr = head;
        for (int i = 0; i < pos; i++) {
            curr = curr.next;
        }

        return curr.item;
    };
    
    public E remove(int pos) {
        Link<E> curr = head;
        for (int i = 0; i < pos; i++) {
            curr = curr.next;
        }

        if (curr.next == tail) {
            tail = curr;
        }
        size--;
    };

    public int length() {
        return size;
    };


    public String toString() {
        String a = "";
        Link<E> curr = head;
        for (int i = 0; i < size; i++) {
            a += curr.next.item + " ";
            curr = curr.next;
        }

        return a;
    }


    public static void main(String args[]) {
        List<Integer> myList = new LinkedList<>();

        myList.append(3);
        myList.insert(0, 1);
        myList.insert(0, 4);
        myList.append(10);
        myList.insert(1, 5);
        System.out.println(myList);
    }

    public ListIterator<E> listIterator() {}

    class LinkedListIterator<E> implements ListIterator<E> {
        Link<E> curr = head;

        public boolean hasNext() {

        }
        public E next() {

        }
        public 
    }
}
