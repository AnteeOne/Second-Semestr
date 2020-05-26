package Algorithmes.HW7.AWLTREE;

import java.util.ArrayList;

public class AVLTree <K extends Comparable<K>>{

    private class Node {
        public K key;
        public Node left;
        public Node right;
        public int height; //выстота нода

        public Node(K key) {
            this.key = key;
            left = null;
            right = null;
            height = 1;
        }
    }

    private Node root;
    private int size;

    public AVLTree(){
        root = null;
        size = 0;
    }




    public boolean isBST(){
        ArrayList<K> keys = new ArrayList<>();
        midOrder(root,keys);
        for (int i = 1; i < keys.size(); i++) {

            if(keys.get(i-1).compareTo(keys.get(i))>0 ){
                return false;
            }
        }
        return true;
    }

    private void midOrder(Node node,ArrayList<K> keys){
        if(node == null) return;
        midOrder(node.left,keys);
        keys.add(node.key);
        midOrder(node.right,keys);
    }

//    private void midOrder(Node node){ //
//        if(node == null) return;
//        midOrder(node.left,keys);
//        keys.add(node.key);
//        midOrder(node.right,keys);
//    }


    public boolean isBalance(){
        return isBalance(root);
    }


    private boolean isBalance(Node node){
        if(node == null) return true;   //

        int balanceFactor = getBalanceFactor(node);
        if(Math.abs(balanceFactor) > 1){
            return false;
        }
        return isBalance(node.left) && isBalance(node.right);

    }

    private int getHeight(Node node){
        if(node == null) return 0;
        return node.height;
    }

    public void add(K key){
        root = add(root,key);
    }


    private int getBalanceFactor( Node node){
        if(node ==null) return 0;
        return getHeight(node.left) - getHeight(node.right);
    }


    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T3 = x.right;


        x.right = y;
        y.left = T3;


        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }


    private Node leftRotate(Node y) {
        Node x = y.right;
        Node T2 = x.left;

        x.left = y;
        y.right = T2;

        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }


    private Node add(Node node , K key){
        if(node == null){
            size++;
            return new Node(key);
        }


        if(key.compareTo(node.key) < 0){
            node.left = add(node.left,key);
        }else if(key.compareTo(node.key) > 0){
            node.right = add(node.right,key);
        }


        node.height = 1 + Math.max(getHeight(node.left),getHeight(node.right));

        int balanceFactor = getBalanceFactor(node);

        if(balanceFactor > 1 && getBalanceFactor(node.left) >= 0){
            return rightRotate(node);
        }

        if(balanceFactor < -1 && getBalanceFactor(node.right) <= 0){   //
            return leftRotate(node);
        }

        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node ;
    }

    public static void main(String[] args) {
        AVLTree avl = new AVLTree<>();
        avl.add(3);
        avl.add(2);
    }


}
