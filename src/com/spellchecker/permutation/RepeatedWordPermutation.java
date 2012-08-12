package com.spellchecker.permutation;

import java.util.*;

public class RepeatedWordPermutation implements WordPermutation{

    //Get all the repeated permutations for the given String. eg: 
    //jjoob -> jjoob, jjob, joob, job.
    public List<String> getWordPermutation(String word){
	List<Integer> frequency = new ArrayList<Integer>();
	List<Character> characters = new ArrayList<Character>();
	int counter = 0;
	char currentChar = word.charAt(0);
	for(int i = 0; i < word.length(); ++i){
	    if(word.charAt(i) == currentChar){
		++counter;
	    }else{
		frequency.add(counter);
		characters.add(currentChar);
		counter = 1;
		currentChar = word.charAt(i);
	    }
	}
	//to add the last character which would have been missed. 
	frequency.add(counter);
	characters.add(currentChar);
	
	List<List<Integer>> permutations = Permutation.permute(frequency, 0);
	List<String> strPermutes = new ArrayList<String>();
	for(List<Integer> permutes : permutations ){
	    StringBuilder strPermute = new StringBuilder();
	    for(int i = 0; i < permutes.size(); ++i){
		for(int j = 0; j < permutes.get(i); ++j){
		    strPermute.append(characters.get(i));
		}
	    }
	    strPermutes.add(strPermute.toString());
	}
	return strPermutes;
    }
}