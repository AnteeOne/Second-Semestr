package Algorithmes.HW6;

public class TreeTest {

    public static void run(){

        Node n1 = new Node(1);
        Node n2 = new Node(23);
        Node n3 = new Node(2);
        Node n4 = new Node(11);
        Node n5 = new Node(312);
        Node n6 = new Node(61);

        BinaryTree binaryTree = new BinaryTree(34);
        binaryTree.add(binaryTree.head,n1,"left");
        binaryTree.add(binaryTree.head,n2,"right");
        binaryTree.add(n1,n3,"left");
        binaryTree.add(n1,n4,"right");
        binaryTree.add(n2,n5,"left");
        binaryTree.add(n5,n6,"right");

        binaryTree.dfs();
        System.out.print("\n");
        binaryTree.bfs();
    }

}
