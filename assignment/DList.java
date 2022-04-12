public class DList<E> implements List<E> {
    private DLink<E> head, tail;
    int size;

    public DList() {
        head = tail = new DLink<>(null, null, null);
        size = 0;
    }


    public void clear() {
        head.setNext(null);
        size = 0;
    }
    public void insert(int pos, E item) {
        DLink<E> curr = head;
        for (int i = 0; i < pos; i++) {
            curr = curr.next();
        }

        curr.setNext(new DLink<E>(item, curr, curr.next()));
        curr.next().next().setPrev(curr.next());
        size++;
    }
    public void append(E item) {
        tail = tail.setNext(new DLink<>(item, tail, null));
    }
    public void update(int pos, E item) {
        DLink<E> curr = head;
        for (int i = 0; i < pos; i++) {
            curr = curr.next();
        }
        curr.next().setItem(item);
    }
    public E getValue(int pos) {
        DLink<E> curr = head;
        for (int i = 0; i < pos; i++) {
            curr = curr.next();
        }
        return curr.item();

    }
    public E remove(int pos) {
        DLink<E> curr = head;
        for (int i = 0; i < pos; i++) {
            curr = curr.next();
        }

        E ret = curr.next().item();
        curr.next().next().setPrev(curr);
        curr.setNext(curr.next().next());
        size--;
        return ret;    
    }
    public int length() {
        return size;
    }

    public ListIterator<E> listIterator() {
        return new ListIterator<E>() {
            DLink<E> curr = head;
        
            public boolean hasNext() {
                return curr != tail;
            }

            public E next() {
                curr = curr.next();
                return curr.item();
            }

            public boolean hasPrevious() {
                return curr != head;
            }

            public E previous() {
                DLink<E> tmp = head;
                while (tmp.next() != curr) {
                    tmp = tmp.next();
                }
                curr = tmp;
                return curr.next().item();
            }
        };
    }
}

