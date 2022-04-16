package BinaryTree;

public class AssignmentTree_LNode {
    public static void main(String args[]) {
        BinNode<String> Maplestory = new LNode<String>("Maplestory");
        BinNode<String> Overwatch = new LNode<String>("Overwatch");
        BinNode<String> Overwatch2 = new LNode<String>("Overwatch2");
        BinNode<String> LeagueOfLegends = new LNode<String>("LeagueOfLegends");
        BinNode<String> Valorant = new LNode<String>("Valorant");
        BinNode<String> Nexon = new INode<String>("Nexon", Maplestory, null);
        BinNode<String> Blizzard = new INode<String>("Blizzard", Overwatch, Overwatch2);
        BinNode<String> RiotGames = new INode<String>("RiotGames", LeagueOfLegends, Valorant);
        BinNode<String> GodGame = new INode<String>("GodGame", Nexon, null);
        BinNode<String> MangGame = new INode<String>("MangGame", Blizzard, RiotGames);
        BinNode<String> Game = new INode<>("Game", GodGame, MangGame);
    
        inorder(Game);
        System.out.println();
        preorder(Game);
        System.out.println();
        postorder(Game);
        System.out.println();
    }
    public static <E> void inorder(BinNode<E> rt) {
        if (rt == null) return;        
        inorder(rt.left());
        System.out.print(rt.element()); // visit
        System.out.print(" - ");
        inorder(rt.right());
    }

    public static <E> void preorder(BinNode<E> rt) {
        if (rt == null) return;
        System.out.print(rt.element()); // visit
        System.out.print(" - ");
        preorder(rt.left());
        preorder(rt.right());
    }

    public static <E> void postorder(BinNode<E> rt) {
        if (rt == null) return;        
        postorder(rt.left());
        postorder(rt.right());
        System.out.print(rt.element()); // visit
        System.out.print(" - ");
    }
}
