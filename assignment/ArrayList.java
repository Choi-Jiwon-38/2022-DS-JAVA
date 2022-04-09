// 국민대학교 2022-1 자료구조
// 소프트웨어학부 20213091 최지원

import java.util.Arrays;

public class ArrayList<E> implements List<E> {
    static int defaultSize = 10;
    E[] data;
    int listSize;

    public ArrayList() {
        this(defaultSize);
    }

    public ArrayList(int size) {
        listSize = 0;
        data = (E[]) new Object[size];
    }

    public void clear() {
        listSize = 0;
    }

    public void insert(int pos, E item) {
        for (int i = listSize; i > pos; i--) {
            data[i] = data[i - 1];
        }
        data[pos] = item;
        listSize += 1;
        resize();
    } 

    public void append(E item) {
        data[listSize ++] = item;
        resize();
    } 

    public void update(int pos, E item) {
        data[pos] = item;
    } 

    public E getValue(int pos) {
        return data[pos];
    } 

    public E remove(int pos) {
        E ret = data[pos];
        listSize -= 1;
        for (int i = pos; i < listSize; i++) {
            data[i] = data[i + 1];
        }
        resize();
        return ret;
    } 

    public int length() {
        return listSize;
    } 

    public void resize() {

        int arrayCapacity = data.length;
    
        if (listSize == arrayCapacity) {
            arrayCapacity *= 2;
            data = Arrays.copyOf(data, arrayCapacity);
        }
    
        else if (listSize < (arrayCapacity / 2)) {
            arrayCapacity /= 2;
            data = Arrays.copyOf(data, arrayCapacity);
        }
        System.out.println(" current arrayCapacity is " + arrayCapacity);
    }

    public static void main(String args[]) {
        ArrayList<Integer> myList = new ArrayList<>();

        myList.append(5);
        myList.append(11);
        myList.insert(1, 2);
        System.out.println(Arrays.toString(myList.data));

        myList.remove(2);
        System.out.println(Arrays.toString(myList.data));
        
        myList.update(1, 99);
        System.out.println(Arrays.toString(myList.data));

        // doubling test
        myList.clear();
        for (int i = 0; i < 15; i ++) {
            myList.append(3);
            System.out.print(myList.length());
        }
        
        for (int i = 0; i < 15; i --) {
            myList.remove(0);
            System.out.print(myList.length());
        }
        
    }

    public ListIterator<E> listIterator() {
        return new ListIterator<E>() {

            int pos = 0;

            public boolean hasNext() {
                return pos < listSize;
            }
            public E next() {
                return data[pos++];
            }
            public boolean hasPrevious() {
                return pos > 0;
            }
            public E previous() {
                return data[--pos];
            }
        };
    } 
}


