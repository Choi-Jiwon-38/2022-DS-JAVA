package BinaryTree;

public class TreeTest {
    public static void main(String[] args) {
        BinNode<String> D = new INode<String>("D", null, null);
        BinNode<String> G = new INode<String>("G", null, null);
        BinNode<String> H = new INode<String>("H", null, null);
        BinNode<String> I = new INode<String>("I", null, null);
        BinNode<String> B = new INode<String>("B", null, D);
        BinNode<String> E = new INode<String>("E", G, null);
        BinNode<String> F = new INode<String>("F", H, I);
        BinNode<String> C = new INode<String>("C", E, F);
        BinNode<String> A = new INode<String>("A", B, C);

        System.out.println(A.right().left().left().element()); // A -> C -> E -> G
        System.out.println(A.right().right().left().element()); // A -> C -> F -> H
    
        preorder(A); // A B D C E G F H I
        System.out.println();
        inorder(A); // B D A G E C H F I
        System.out.println();
        postorder(A); // D B G E H I F C A
        System.out.println();
    }

    public static <E> void preorder(BinNode<E> rt) {
        if (rt == null) return;
        System.out.print(rt.element()); // visit
        System.out.print(" ");
        preorder(rt.left());
        preorder(rt.right());
    }

    public static <E> void inorder(BinNode<E> rt) {
        if (rt == null) return;        
        inorder(rt.left());
        System.out.print(rt.element()); // visit
        System.out.print(" ");
        inorder(rt.right());
    }

    public static <E> void postorder(BinNode<E> rt) {
        if (rt == null) return;        
        postorder(rt.left());
        postorder(rt.right());
        System.out.print(rt.element()); // visit
        System.out.print(" ");
    }
}
