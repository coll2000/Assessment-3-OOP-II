package Ass3;

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
    static String questionOrAnswer;
    static boolean goAgain = true;



    public static void main(String[] args){
        System.out.println("Welcome to the Marvel Movie Selector");

        currentNode = captains;
        questionOrAnswer = currentNode.value;

        do{
            //the value of questionOrAnswer will change depending if the current node is a leaf or not
            if(askYesNo(questionOrAnswer)){
                //branch to the left side of the tree
                branchToLeft();
                //check if the node is a lesf
                //if its a leaf, call the method askAgain
            } else {
                //branch to the right side of the tree
                branchToRight();
                //check if the current node is a leaf
                //if its a leaf, call the method askAgain
            }
        }while(goAgain);



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
    }

    public static void branchToLeft(){
        currentNode = currentNode.left;
        questionOrAnswer = currentNode.value;
        if(currentNode.isLeaf()){
            System.out.println(questionOrAnswer);
            askAgain();
        }
    }

    public static void askAgain(){
        System.out.println("That is the end of the quiz! Would you like to go again? [y/N]");
        String answer = new Scanner(System.in).nextLine();
        if(!answer.equals("y")){
            goAgain = false;
        } else {
            currentNode = captains;
            questionOrAnswer = currentNode.value;
        }
    }

    public static void branchToRight(){
        currentNode = currentNode.right;
        questionOrAnswer = currentNode.value;
        if(currentNode.isLeaf()){
            System.out.println(questionOrAnswer);
            askAgain();
        }
    }

    public static void askForSuggestion(String current, String suggestion, String question, TreeNode currentNode){
        if(askYesNo("Maybe you would enjoy: " + current + ". Is this satisfactory?")){
            System.out.println("Suggestion: ");
            suggestion = new Scanner(System.in).nextLine();

            System.out.println("Question for Suggestion: ");
            question = new Scanner(System.in).nextLine();

            currentNode.value = question;
            currentNode.left.setValue(suggestion);
        }
    }
}
