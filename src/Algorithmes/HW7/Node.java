package Algorithmes.HW7;

public class Node {

    Node left;
    Node right;
    Integer data;

    public Node(Integer data) {
        this.left = null;
        this.right = null;
        this.data = data;
    }

    @Override
    public String toString() {
        return "" + this.data;

    }


}
