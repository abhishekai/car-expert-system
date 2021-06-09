package com.ai;

/**
 * Author:Abhishek Srivastava
 * Class IssueNode : Represents the issue a car can have, and way to move further for an appropriate response
 */

public class IssueNode {

    private String issue;

    public IssueNode YES; // To move towards left in the DecisionTree
    public IssueNode NO; // To move towards right in the DecisionTree

    //Constructor for only response
    public IssueNode(String issue){
        this(issue, null, null);
    }

    //Overload constructor for issue and its sub nodes
    public IssueNode(String issue, IssueNode yes, IssueNode no) {
        this.issue = issue;
        this.YES = yes;
        this.NO = no;
    }

    public String toString(){
        return issue;
    }

}
