/* 국민대학교 2022-1 자료구조
소프트웨어학부 20213091 최지원 */

public class TestAll {
    public static void main(String args[]) {
        // Test Code :: Doubly Linked List
        System.out.println("test | Doubly Linked List");
        DList<Integer> myList = new DList<>();
        ListIterator<Integer> itr = myList.listIterator();
        
        for (int i = 0; i < 5; i++) {
            myList.append(i);
        }
        System.out.println(myList.getValue(3));
        myList.update(3, 10);
        System.out.println(myList.getValue(3));
        myList.append(0);
        myList.insert(myList.size, 15);

        while (itr.hasNext()) {
            System.out.print(itr.next());
            System.out.print(" ");
        }
        System.out.println();

        while (itr.hasPrevious()) {
            System.out.print(itr.previous());
            System.out.print(" ");
        }
        System.out.println();



        // Test Code :: ArrayStack
        ArrayStack<Integer> myStack = new ArrayStack<>(10); // maxSize 를 10으로 설정
        System.out.println("test | Array Stack");
        myStack.push(5);
        myStack.push(4);
        myStack.push(3);
        myStack.push(2);
        myStack.push(1);
        System.out.println(myStack.length());
        System.out.println(myStack.topValue());

        System.out.println(myStack.pop());
        System.out.println(myStack.length());

        myStack.clear();
        System.out.println(myStack.length());

        // Test Code :: LinkedQueue
        System.out.println("test | Linked Queue");
        LinkedQueue<Integer> myQueue = new LinkedQueue<>();
        myQueue.enqueue(3);
        myQueue.enqueue(0);
        myQueue.enqueue(8);
        System.out.println(myQueue.length());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.frontValue());
        myQueue.enqueue(1);
        myQueue.enqueue(2);

        System.out.println(myQueue.length());

        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());

        for (int i = 0; i < 10; i++) {
            myQueue.enqueue(i);
        }
        System.out.println(myQueue.length());
        myQueue.clear();
        System.out.println(myQueue.length());
    }
}

