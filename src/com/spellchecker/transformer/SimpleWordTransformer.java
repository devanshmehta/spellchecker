package com.spellchecker.transformer;

import java.util.List;
import java.util.ArrayList;

//SimpleWordTransformed transforms the given word such that 
//there not more than certain number of occurrences of single character
//simultaneously eg: aaaaaaapple -> aaaaaple. Limits the 
//number of occurrences of single character simultaneously to 5.
public class SimpleWordTransformer implements WordTransformer{
    
    //Creates a SimpleWordTransformer which limits the 
    //max simultaneous repeated occurence of a single character 
    //to 5.
    public SimpleWordTransformer(){
	this(5);
    }

    //Creates a SimpleWordTransformer which limits the 
    //max simultaneous repeated occurence of a single character 
    //to given int.
    public SimpleWordTransformer(int i){
	maxRepeatedOccurences = i;
    }

    public List<String> getTransformedWords(String word){
	int numOccurences = 0;
	char currentChar = word.charAt(0);
	StringBuilder newWord = new StringBuilder();
	for(int i = 0; i < word.length(); ++i){
	    if(currentChar == word.charAt(i)){
		++numOccurences;
		if(numOccurences <= maxRepeatedOccurences){
		    newWord.append(currentChar);
		}
	    }else{
		numOccurences = 1;
		currentChar = word.charAt(i);
		newWord.append(currentChar);
	    }
	}
	List<String> transformedWords = new ArrayList<String>(1);
	transformedWords.add(newWord.toString());
	return transformedWords;
    }

    private int maxRepeatedOccurences;

}