package com.ai;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Author:Abhishek Srivastava
 * Class DecisionTree : Builds the decision tree of the IssueNode(s) using existing information available
 * and used for having a chatbot(sort of) to walks the user through troubleshooting issues with the car.
 */

public class DecisionTree {

    public boolean exit;
    private IssueNode root;
    private Scanner userFeedback;

    //Initialize issue node and user input
    public DecisionTree(String issue) {
        root = new IssueNode(issue);
        userFeedback = new Scanner(System.in);
    }

    //Load existing available information on the issues.
    public void buildIssueNodes(LinkedList<String> troubleShootingInputs) {
        root = buildExistingIssueDetails(troubleShootingInputs);
    }

    //Responsible for building decision tree with existing information available
    private IssueNode buildExistingIssueDetails(LinkedList<String> troubleShootingInputs) {
        IssueNode node = null; // Initialise a null node.
        Iterator<String> iterator = troubleShootingInputs.iterator();
        if (iterator.hasNext()) {
            String retrieveVal = iterator.next();
            if (!retrieveVal.startsWith("Question:")) { //build response node
                node = new IssueNode(retrieveVal);
                troubleShootingInputs.removeFirst();
            } else { //build issue node
                troubleShootingInputs.removeFirst(); //To point to next information available
                //Make recursive calls two time to fetch yes and no subtree in case of IssueNode
                node = new IssueNode(retrieveVal, buildExistingIssueDetails(troubleShootingInputs), buildExistingIssueDetails(troubleShootingInputs));
            }
        }
        return node;
    }

    public void chatBot() {
        root = walksThroughIssues(root);
    }

    private IssueNode walksThroughIssues(IssueNode node) {
        if (node.YES != null || node.NO != null) {
            String userInput = getResponse(node.toString() + " y/n? ");

            switch (userInput) {
                case "y":
                    node.YES = walksThroughIssues(node.YES);
                    break;
                case "n":
                    node.NO = walksThroughIssues(node.NO);
            }

        } else {
            System.out.println(node.toString());
        }
        return node;
    }

    private String getResponse(String consoleMessage) {
        System.out.print(consoleMessage);
        String userInput = userFeedback.
                nextLine().
                trim().
                toLowerCase();
        if (!userInput.equals("y") && !userInput.equals("n")) {
            System.out.println("Please answer y or n.\n");
            return getResponse(consoleMessage);
        }
        return userInput;
    }

}
