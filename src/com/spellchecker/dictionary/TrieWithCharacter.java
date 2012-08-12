package com.spellchecker.dictionary;

import java.util.Scanner;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;

//An implement of trie which which allows to insert new words and
//search if the word is present or not. This trie has a simple implementation
//in which it stores the word in lower case and has two types of node.
//1) BranchNode  stores other nodes. 
//2) ElementNode stores the actual word.
//AUTHOR: DEVANSH MEHTA

public class TrieWithCharacter{

    //Creates an empty trie.
    public TrieWithCharacter(){
	root =  new BranchNode();
    }

    //This operation will insert a work in the trie. It will not insert
    //if the word is already present.
    public void insert(String word){
	if(contains(word)){
	    return;
	}
	String insertWord = word.toLowerCase() + END_CHARACTER;
	Node child = root;
	Node parent = null; //root has null as parent
	for(int i = 0; i < insertWord.length(); ++i){
	    if(child == null){
		int index = getIndex(insertWord.charAt(i - 1));
		BranchNode parentBranchNode = (BranchNode) parent;
		parentBranchNode.nodes[index] = new BranchNode();
		child = parentBranchNode.nodes[index];
	    }
	    parent = child;
	    child = child.getNodeFor(insertWord.charAt(i));
	}
	BranchNode parentBranchNode = (BranchNode) parent;
	ElementNode elementNode = new ElementNode(insertWord);
	int index = getIndex(insertWord.charAt(insertWord.length() - 1));
	parentBranchNode.nodes[index] = elementNode;
    }

    // Checks if the word is present in the current state of the trie.
    //Returns true if it is present and false otherwise. There two ways 
    //in which we cannot find a word 1) If the reach an element node with 
    //different word than we are searching for 2) If we reach a branch node
    //which doesnot have a children for the character we are searching.
    public boolean contains(String wordToCheck){
	String word = wordToCheck.toLowerCase() +  END_CHARACTER;
	//Adds a space at the end.
	Node node = root;
	int currentIndex = -1;
	char currentChar = word.charAt(0);
	while(node.getValue() == null){
	    currentChar = word.charAt(++currentIndex);
	    node = node.getNodeFor(currentChar);
	    if(node == null){
		return false;
	    }
	}
	return word.equals(node.getValue());
    }

    //Returns the index for char c in the array of nodes
    private int getIndex(char c){
	if(c == END_CHARACTER){
	    return 26;
	}
	return c - 'a';
    }

    private Node root;
    private static final char END_CHARACTER = ' ';

    //Represents a node in trie. It can be branch node or element node.
    public abstract static class Node{

	//Gets the node which stores the words for the given char in the 
	//trie. If the node is branch node then it should override to return
	//the node otherwise null.
	public Node getNodeFor(char c){
	    return null;
	}

	//Gets the value of this node if the node is element node.
	//If the node is branch node then it should return null
	//otherwise it should return the word.
	public String getValue(){
	    return null;
	}
    }

    //Represents a branch node in trie. This node contains pointers to 
    //other nodes in trie.
    public static class BranchNode extends Node{
	
	public BranchNode(){
	    //one extra from 26 for END_CHARACTER
	    nodes = new Node[27];
	}
	
	@Override
	    public Node getNodeFor(char c){
	    if(c == END_CHARACTER){
		return nodes[26];
	    }
	    int index = c - 'a';
	    return nodes[index];
	}

	private Node[] nodes;
    }

    //Represents an element node in trie. This node contains the value 
    //or the word.
    public static class ElementNode extends Node{

	public ElementNode(String word){
	    this.word = word;
	}

	@Override
	    public String getValue(){
	    return word;
	}
    
	//The word has END_CHARACTER at its last index
	private String word;
    }
}

