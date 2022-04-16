import java.util.Arrays;

public class ArrayList<E> implements List<E> {

    public E[] data; // 클래스 변수가 되어 다른 함수에서도 접근이 가능하게 됨
    int listSize;
    static int DefaultSize = 10;

    public ArrayList() { // 생성할 때 실행되는 함수
        this(DefaultSize);
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
            data[i] = data[i-1]; // 데이터를 한 칸씩 땡겨옴
        }
        data[pos] = item;
        listSize++; 
    }
    public void append(E item) {
        data[listSize] = item;
        listSize += 1;
        // data[listSize++] = item; <- data[listSize]에 item을 넣은 뒤, listSize의 값을 1 증가시킴
    }
    public void update(int pos, E item) {
        data[pos] = item;
    }
    public E getValue(int pos) {
        return data[pos];
    }
    public E remove(int pos) {
        E ret = data[pos];
        
        listSize--;

        for (int i = pos; i < listSize; i++) {
            data[i] = data[i+1]; // 데이터를 한 칸씩 땡겨옴
        }
        return ret;
    }
    public int length() {
        return listSize;
    }

    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();
        myList.append(3);
        System.out.println(Arrays.toString(myList.data));
        myList.append(5);
        System.out.println(Arrays.toString(myList.data));
        myList.insert(0, 10);
        System.out.println(Arrays.toString(myList.data));
        myList.remove(2);
        System.out.println(Arrays.toString(myList.data));
        
        System.out.println(myList.length());
    
    }
}

ArrayList<Integer> myTodoList = new ArrayList<Integer>(10);