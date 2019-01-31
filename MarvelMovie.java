import java.util.Scanner;

public class MarvelMovie {

//    static TreeNode tree = new TreeNode("Do you like captains",
//            new TreeNode("Would you like a captain who's better than Superman?",
//                    new TreeNode("Captain Marvel", null, null),
//                    new TreeNode("Captain America", null, null)),
//            new TreeNode("Iron Man", null, null));

    static TreeNode marvel = new TreeNode("Captain Marvel");
    static TreeNode america = new TreeNode("Captain America");

    static TreeNode captainsF = new TreeNode("Iron Man");
    static TreeNode captainsT = new TreeNode("Would you like a captain who's better than superman?", marvel, america);
    static TreeNode captains = new TreeNode("Do you like captains?", captainsT, captainsF);



    static TreeNode currentNode = null;

    static String currentQuestion = null;

    public static void main(String[] args){
//        nextNode = tree;
//        String question = tree.value;
//
//        if(askYesNo(question)){
//            question = tree.left.value;
//            if(askYesNo(question)){
//                System.out.println("wporkingish");
//            }
//        } else {
//            question = tree.getRight().value;
//            if(askYesNo(question)){
//                System.out.println("working ish");
//            }
//        }

        String firstQuestion = captains.value;
        Boolean goAgain = true;


        currentNode = captains;

        while(!currentNode.isLeaf() & goAgain){
            if(askYesNo(firstQuestion)){
                currentQuestion = captains.left.value;
                if(askYesNo(currentQuestion)){
                    currentNode = captains.left.left;
                    System.out.println(currentNode.value);
                    if(currentNode.isLeaf()){
                        System.out.println("Would you like to play again? [y/N]");
                        String again = new Scanner(System.in).nextLine();
                        if(again.equals("y")){
                            goAgain = true;
                        } else {
                            goAgain = false;
                        }
                        if(!goAgain)
                            break;

                    }

                } else {
                    currentNode = captains.left.right;
                    System.out.println(currentNode.value);
                    if(currentNode.isLeaf()){
                        System.out.println("Would you like to play again? [y/N]");
                        String again = new Scanner(System.in).nextLine();
                        if(again.equals("y")){
                            goAgain = true;
                        } else {
                            goAgain = false;
                        }
                        if(!goAgain)
                            break;

                    }
                }
            } else {
                currentNode = captains.right;
                System.out.println(currentNode.value);
                if(currentNode.isLeaf()){
                    System.out.println("Would you like to play again? [y/N]");
                    String again = new Scanner(System.in).nextLine();
                    if(again.equals("y")){
                        goAgain = true;
                    } else {
                        goAgain = false;
                    }

                    if(!goAgain)
                        break;

                }
            }
        }




    }

    static boolean askYesNo(String question){

        System.out.println(question + " [y/N]");

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        if(input.equals("y")){
            return true;
        } else {
            return false;
        }


//        nextNode = tree;
//        TreeNode nextQuestionNode;
//
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println(nextNode.value + " [y/N]");
//        String input = scanner.nextLine();
//        if(input.equals("y")){
//            nextQuestionNode = nextNode.getLeft();
//            return true;
//        } else{
//            nextQuestionNode = nextNode.getRight();
//            return false;
//        }
    }
}
