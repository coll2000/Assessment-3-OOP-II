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



    public static void main(String[] args){

        System.out.println("Welcome to the Marvel Movie Selector");
        Boolean goAgain = true;


        do {
            String firstQuestion = captains.getValue(), currentQuestion, result;

            currentNode = captains;

            if (askYesNo(firstQuestion)) {
                //branch to the left side of the tree
                //TODO
                currentNode = currentNode.left;
                currentQuestion = currentNode.value;
                if (askYesNo(currentQuestion)) {
                    //branch to the left-left side of the tree
                    currentNode = currentNode.left;
                    result = currentNode.value;

                    currentQuestion = "Perhaps you would like: "+ result + ". Is this satisfactory?";
                    if(!askYesNo(currentQuestion)){
                        String suggestion = new Scanner(System.in).nextLine();
                        currentNode.value = suggestion;
                    }
                    if(currentNode.isLeaf()){
                        System.out.println("Would you like to go again? [y/N]");

                        String answer = new Scanner(System.in).nextLine();

                        if(!answer.equals("y")){
                            goAgain = false;
                        }
                    }

                } else {
                    //ask for suggestion
                    currentNode = currentNode.right;
                    result = currentNode.value;

                    currentQuestion = "Perhaps you would like: "+ result + ". Is this satisfactory?";
                    if(!askYesNo(currentQuestion)){
                        String suggestion = new Scanner(System.in).nextLine();
                        currentNode.value = suggestion;
                    }

                    if(currentNode.isLeaf()){
                        System.out.println("Would you like to go again? [y/N]");
                        String answer = new Scanner(System.in).nextLine();
                        if(!answer.equals("y")){
                            goAgain = false;
                        }
                    }

                }
            } else {
                //branch to the right side of the tree
                currentNode = currentNode.right;
                result = currentNode.value;

                currentQuestion = "Perhaps you would like: "+ result + ". Is this satisfactory?";
                if(!askYesNo(currentQuestion)){
                    String suggestion = new Scanner(System.in).nextLine();
                    currentNode.value = suggestion;
                }

                if(currentNode.isLeaf()){
                    System.out.println("Would you like to go again? [y/N]");
                    String answer = new Scanner(System.in).nextLine();
                    if(!answer.equals("y")){
                        goAgain = false;
                    }
                }
            }
        }while (goAgain);


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
