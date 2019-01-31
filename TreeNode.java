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
}
