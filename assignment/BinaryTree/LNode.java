package BinaryTree;

public class LNode<E> implements BinNode<E> {
    private E data;

    public LNode(E element) {
        this.data = element;
    }

    @Override
    public E element() {
        return data;
    }

    @Override
    public E setElement(E item) {
        return this.data = item;
    }

    @Override
    public BinNode<E> left() {
        return null;
    }

    @Override
    public BinNode<E> right() {
        return null;
    }

    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public void setLeft(BinNode<E> n) { }

    @Override
    public void setRight(BinNode<E> n) { }

    public String toString() {
        return "LNode: " + this.element();
    }
}
