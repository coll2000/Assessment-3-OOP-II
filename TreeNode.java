package Ass3;

import java.io.*;

public class TreeNode {
    String value;
    TreeNode left;
    TreeNode right;

    public TreeNode(String value){
        this.value = value;
    }

    public TreeNode(String value, TreeNode left, TreeNode right){
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public void printTree(){
        System.out.println(value);

        if(this.left != null){this.left.printTree();}

        if (this.right != null){ this.right.printTree();}
    }

    public TreeNode getLeft(){
        return this.left;
    }
    public String getValue(){
        return this.value;
    }

    public void setLeft(TreeNode node){
        this.left = node;
    }
    public void setRight(TreeNode node){
        this.right = node;
    }
    public void setValue(String value){
        this.value = value;
    }

    public TreeNode getRight(){
        return this.right;
    }

    public boolean isLeaf(){
        if(this.left == null && this.right == null){
            return true;
        } else {
            return false;
        }
    }

    public String toString(){
        if(this.isLeaf()){
            return "Value: " +this.value + ", " + this.left + ", " + this.right + " isLeaf: " + this.isLeaf();
        }
        else {
            return "Value: " + this.value;
        }
    }

    public void print(BufferedWriter bw){

        try{
            bw.write(this.value);
            bw.newLine();
        } catch(IOException e){
            e.printStackTrace();
        } finally{
            System.out.println(this.value);
        }

        if (this.left != null) {
            this.left.print(bw);
        }
        if (this.right != null) {
            this.right.print(bw);
        }
    }

    public static void fromPreorder(){
        String current;
        try{
            //Change directory in NoMachine
            BufferedReader br = new BufferedReader(new FileReader(new File("src/Ass3/suggestions.txt")));
            current = br.readLine();
        } catch(IOException e){
            e.printStackTrace();
        }

    }

//    public TreeNode previousNode(){
//        TreeNode previous = null;
//        if(this.isLeaf()){
//
//        }
//    }

//    public boolean isRoot(TreeNode tn){
//        if(tn.){
//
//        }
//    }
}
