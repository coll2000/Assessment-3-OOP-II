package Ass3;

import java.io.*;
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

    private static void takeSuggestion() {
        System.out.println("Enter a suggestion: ");
        String suggestion = new Scanner(System.in).nextLine();

        System.out.println("Enter a question for the suggestion: ");
        String question = new Scanner(System.in).nextLine();

        System.out.println("Enter an answer that is *wrong* for this given suggestion.");
        String wrong = new Scanner(System.in).nextLine();

        questionOrAnswer = question;
        currentNode.setLeft(new TreeNode(suggestion));
        currentNode.setRight(new TreeNode(wrong));
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
            //System.out.println(questionOrAnswer);
            if(wantsSuggestion()){
                //code to get suggestion
                //or create a method and call it here
                takeSuggestion();
            } else {
                askAgain();
            }

            System.out.println("Would you like to save the tree? [y/N]");
            String save = new Scanner(System.in).nextLine();
            if(save.equals("y")){
                saveTree();
            }
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
            //System.out.println(questionOrAnswer);
            if(wantsSuggestion()){
                //code to get suggestion
                //or create a method and call it here
                takeSuggestion();
            } else {
                askAgain();
            }

            System.out.println("Would you like to save the tree? [y/N]");
            String save = new Scanner(System.in).nextLine();
            if(save.equals("y")){
                saveTree();
            }
        }
    }

    public static boolean wantsSuggestion(){
        if(!askYesNo("Is " + currentNode.value + " suitable? ")){
            return true;
        } else {
            return false;
        }
    }

    public static void saveTree() {
        TreeNode head = captains;
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("src/Ass3/suggestions.txt")));
            head.print(bw);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fromPreorder(){
    }

}
