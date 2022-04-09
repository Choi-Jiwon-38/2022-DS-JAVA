public class LinkedList<E> implements List<E> {
    private Link<E> head, tail;
    int size;

    public LinkedList() {
        head = tail = Link.get(null, null);
        size = 0;
    }

    @Override
    public void clear() {
        head.setNext(null);
        size = 0;
    }

    @Override
    public void update(int pos, E item) {
        Link<E> curr = head;
        for (int i = 0; i < pos; i++) {
            curr = curr.next();
        }
        curr.next().setItem(item);
    }

    @Override
    public E getValue(int pos) {
        Link<E> curr = head;
        for (int i = 0; i < pos; i++) {
            curr = curr.next();
        }
        return curr.next().item();
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public void append(E item) {
        tail = tail.setNext(Link.get(item, null));
        size ++;
    }

    public void insert(int pos, E item) {
        Link<E> curr = head;
        for (int i = 0; i < pos; i++) {
            curr = curr.next();
        }
        curr.setNext(Link.get(item, curr.next()));

        if (curr == tail) {
            tail = curr.next();
        }
        size ++;
    }

    @Override
    public E remove(int pos) {
        Link<E> curr = head;
        for (int i = 0; i < pos; i++) {
            curr = curr.next();
        }
        E ret = curr.next().item();
        
        if (curr.next() == tail) {
            tail = curr;
        }

        Link<E> tmp = curr.next();
        curr.setNext(curr.next().next());
        tmp.release();

        size --;

        return ret;
    }

    public String toString() {
        String prt = "";
        Link<E> curr = head;
        for (int i = 0; i < size; i++) {
            prt += curr.next().item() + ", ";
            curr = curr.next();
        }

        return prt;
    }

    public static void main(String args[]) {
        LinkedList<Integer> myList = new LinkedList<>();
        ListIterator<Integer> itr = myList.listIterator();

        for (int i = 0; i < 3; i++)
            myList.append(i);
        
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        
    }

    public ListIterator<E> listIterator() {
        return new LinkedListIterator();
    }

    class LinkedListIterator implements ListIterator<E> {
        Link<E> curr = head;
        
        public boolean hasNext() {
            return curr != tail; // curr가 head가 아니면 next가 존재
        }

        public E next() {
            curr = curr.next();
            return curr.item();
        }

        public boolean hasPrevious() {
            return curr != head;
        }

        public E previous() {
            Link<E> tmp = head;
            while (tmp.next() != curr) {
                tmp = tmp.next();
            }
            curr = tmp;
            return curr.next().item();
        }
    }
}
