package BinaryTree;

public class BST<K extends Comparable<K>, E> implements Dictionary<K, E> {
    class Entry {
        public K key;
        public E element;
        public Entry(K key, E element) {
            this.key = key;
            this.element = element;
        }
    }

    BinNode<Entry> root;
    private int size = 0;

    public BST() {
        root = null;
    }

    @Override
    public void claer() {
        root = null;
        size = 0;
    }

    @Override
    public void insert(K key, E element) {
        root = insert_helper(key, element, root);
    }

    public BinNode<Entry> insert_helper(K key, E element, BinNode<Entry> rt) {
        if (rt == null) { // 도착 지점 <- insert 해주어야 하는 곳
            return new LNode<>(new Entry(key, element));
        }

        if (rt instanceof LNode) {
            rt = new INode<>(new Entry(rt.element().key, rt.element().element), null, null);
        } else if (rt.left() instanceof LNode) { 
            rt.setLeft(new INode<>(new Entry(rt.left().element().key, rt.left().element().element), null, null));
        } else if (rt.right()instanceof LNode) {
            rt.setRight(new INode<>(new Entry(rt.right().element().key, rt.right().element().element), null, null));
        }

        if (rt.element().key.compareTo(key) == 0) {
            rt.element().element = element;
        } else if (rt.element().key.compareTo(key) < 0) {
            BinNode<Entry> newNode = insert_helper(key, element, rt.right());
            rt.setRight(newNode);
        } else {
            BinNode<Entry> newNode = insert_helper(key, element, rt.left());
            rt.setLeft(newNode);
        }
        return rt;
    }

    @Override
    public E remove(K k) {
        E ret = find_helper(k, root);
        
        if (ret != null) {
            root = remove_helper(k, root);
            size --;
        }
        return ret;
    }

    private BinNode<Entry> remove_helper(K k, BinNode<Entry> rt) {

        if (rt.element().key.compareTo(k) > 0) {
            rt.setLeft(remove_helper(k, rt.left()));
        } else if (rt.element().key.compareTo(k) < 0) {
            rt.setRight(remove_helper(k, rt.right()));
        } else { // 지워야할 것을 찾음
            if (rt.left() == null && rt.right() == null) { return null; } // 새끼 없을 때 노 베이비 보이
            else if (rt.left() == null) { return rt.right(); }
            else if (rt.right() == null) { return rt.left(); }
            else { // 양쪽에 응애가 있는 경우
                Entry leftmost =  getLeftMost(rt.right());
                rt.setElement(leftmost);
                rt.setRight(removeLeftMost(rt.right()));
            }
        }
        if (rt.left() == null && rt.right() == null) {
            rt = new LNode<>(new Entry(rt.element().key, rt.element().element));
        }
        return rt;
    }

    private Entry getLeftMost(BinNode<Entry> rt) {
        BinNode<Entry> cur = rt;
        while(cur.left() != null) {
            cur = cur.left();
        }
        return cur.element();
    }

    private BinNode<Entry> removeLeftMost(BinNode<Entry> rt) {
        if (rt.left() == null) { return rt.right(); }
        else { rt.setLeft(removeLeftMost(rt.left())); return rt; }
    }

    @Override
    public E removeAny() { // 최상단 root를 지우기로 함
        if (root != null) {
            if (root.left() == null) {
                root = root.right();
            } else if (root.right() == null) {
                root = root.left();
            } else {
                Entry leftmost =  getLeftMost(root.right());
                root.setElement(leftmost);
                root.setRight(removeLeftMost(root.right()));
            }
            size--;
        } else {
            return null;
        }
        if (root.left() == null && root.right() == null) {
            root = new LNode<>(new Entry(root.element().key, root.element().element));
        }

        return root.element().element;
    }

    @Override
    public E find(K k) {
        if (root == null) return null;
        else {
            return find_helper(k, root);
        }
    }
        
    public E find_helper(K k, BinNode<Entry> rt) {
        if (rt == null) { return null; }
        if (rt.element().key.compareTo(k) == 0) {
            return rt.element().element;
        } else if (rt.element().key.compareTo(k) < 0) {
            return find_helper(k, rt.right());
        } else {
            return find_helper(k, rt.left());
        }
    }

    @Override
    public int size() {
        return size;
    }

    public void inorder(BinNode<Entry> rt) {
        if (rt == null) return;
        inorder(rt.left());
        System.out.println(rt);
        inorder(rt.right());
    }
}
