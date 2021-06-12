package com.ai;

import java.util.LinkedList;

/**
 * Author:Abhishek Srivastava
 * Class DecisionSystem : Car-Expert-System main module
 */
public class DecisionSystem {
    public static void main(String[] args) throws Exception {

        LinkedList<String> troubleShootingInputs = new LinkedList<String>();
        troubleShootingInputs.add("Question:Is the car silent when you turn the key?");
        troubleShootingInputs.add("Question:Are the battery terminals corroded?");
        troubleShootingInputs.add("Please clean terminals and try starting again.");
        troubleShootingInputs.add("Please replace cables and try again.");
        troubleShootingInputs.add("Question:Does the car make a clicking noise?");
        troubleShootingInputs.add("Replace the battery please.");
        troubleShootingInputs.add("Question:Does the car crank up but fail to start");
        troubleShootingInputs.add("Check Spark plug connections.");
        troubleShootingInputs.add("Question:Does the engine start and then die?");
        troubleShootingInputs.add("Question:Does your car have fuel injection?");
        troubleShootingInputs.add("Please get it in for service.");
        troubleShootingInputs.add("Check to ensure the choke is opening and closing.");

        DecisionTree decisionTree = new DecisionTree("car-expert-system");
        System.out.println("****Welcome to Car Issue Troubleshooting System****");
        decisionTree.buildIssueNodes(troubleShootingInputs);
        System.out.println();

        do {
            decisionTree.chatBot();
        }while (decisionTree.exitChat("Do yo want to continue y/n? "));
    }
}