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
    }
}
