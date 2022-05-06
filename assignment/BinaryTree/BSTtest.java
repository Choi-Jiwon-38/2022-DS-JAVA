package BinaryTree;

public class BSTtest {
    public static void main(String args[]){
        Dictionary<Integer, String> bst = new BST<>();

        bst.insert(11, "cat");
        bst.insert(3, "bow bow");
        bst.insert(1, "meow");
        bst.insert(5, "dog");
        bst.insert(2, "hot dog");
        bst.insert(21, "tail");
        bst.insert(17, "java");
        bst.insert(18, "python");
        bst.insert(32, "c++");
        bst.insert(68, "c#");
        
        ((BST<Integer, String>)bst).inorder(((BST<Integer, String>)bst).root);
    }
}