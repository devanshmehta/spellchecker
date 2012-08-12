package com.spellchecker.dictionary;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

//A Dictionary which checks whether the word is available in it or not.
//NOTE: We can make dictionary an abstract class with isWordInDictionary as
//abstract method to provide different implementation.
//AUTHOR : Devansh Mehta
public class Dictionary {

    //Takes in a file which stores the word of the dictionary. 
    //The file should store each word in its own line.
    public Dictionary(String file) throws FileNotFoundException{
	this.fileName = file;
	Scanner scanner = new Scanner(new File(file));
	try{
	    System.out.println("Loading Dictionary...");
	    trie = new TrieWithCharacter();
	    while(scanner.hasNextLine()){
		String word = scanner.nextLine();
		boolean shouldEnter = true;
		for(int i = 0; i < word.length(); ++i){
		    if(!Character.isLetter(word.charAt(i))){
			shouldEnter = false;
		    }
		}
		if(shouldEnter){
		    trie.insert(word);
		}
	    }
	}finally{
	    if(scanner != null){
		scanner.close();
	    }
	}
    }

    //Returns true if the word is in the dictionary otherwise false.
    public boolean isWordInDictionary(String word){
	return trie.contains(word);
    }

    //Returns the name of the file.
    public String getFileName(){
	return fileName;
    }
    private String fileName;
    private TrieWithCharacter trie;
}