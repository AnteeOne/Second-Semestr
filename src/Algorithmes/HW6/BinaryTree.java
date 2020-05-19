package Algorithmes.HW6;


import java.util.LinkedList;

public class BinaryTree {

    Node head;

    public BinaryTree(Integer data) {
        this.head = new Node(data);
    }

    public void add(Node parent,Node newnode,String orientation){
        if(orientation.equals("left")){
            parent.left = newnode;
        }
        else if(orientation.equals("right")){
            parent.right = newnode;
        }
        else{
            System.out.println("Incorrect orientation");
        }
    }

    private void dfs(Node node){
        System.out.print(node.data + " ");
        if(node.left != null){
            dfs(node.left);
        }
        if(node.right != null){
            dfs(node.right);
        }

    }

    public void dfs(){
        dfs(this.head);
    }

    public void bfs(){
        LinkedList<Node> list = new LinkedList<>();
        list.add(this.head);
        while(list.size() != 0){
            Node node = list.get(0);
            System.out.print(list.getFirst() + " ");
            list.removeFirst();
            if(node.left != null){
                list.add(node.left);
            }
            if(node.right != null){
                list.add(node.right);
            }
        }
        System.out.println("\n");


    }




}
