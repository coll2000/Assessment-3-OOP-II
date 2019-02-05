package Ass3;

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
