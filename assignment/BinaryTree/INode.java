package BinaryTree;

public class INode<E> implements BinNode<E> {
    
    private E data;
    private BinNode<E> left, right;

    public INode(E data, BinNode<E> left, BinNode<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
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
        return this.left;
    }

    @Override
    public BinNode<E> right() {
        return this.right;
    }

    @Override
    public boolean isLeaf() {        
        return left == null && right == null;
    }

    @Override
    public void setLeft(BinNode<E> n) {
        this.left = n;
    }

    @Override
    public void setRight(BinNode<E> n) {
        this.right = n;
    }
    
    public String toString() {
        return "INode: " + this.element();
    }
}
