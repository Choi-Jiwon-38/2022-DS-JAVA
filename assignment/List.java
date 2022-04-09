public interface List<E> {
    public void clear(); // 배열 비우기
    public void insert(int pos, E item); // 주어진 위치에 아이템을 삽입
    public void append(E item); // 배열에 아이템 추가
    public void update(int pos, E item); // 주어진 위치의 아이템을 변경
    public E getValue(int pos); // 주어진 위치의 아이템을 읽음
    public E remove(int pos); // 주어진 위치의 아이템을 삭제
    public int length(); // 리스트 내 아이템의 개수를 출력
    public ListIterator<E> listIterator();
}
