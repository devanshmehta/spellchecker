package com.spellchecker.corrector;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import com.spellchecker.permutation.*;
import com.spellchecker.transformer.*;
import com.spellchecker.dictionary.Dictionary;

//Corrector as outlined by in the question.
//AUTHOR : Devansh Mehta
public class MyCorrector extends Corrector{

    public MyCorrector(Dictionary dict){
	super(dict);
	wordTransformer = new SimpleWordTransformer();
	lowerCase = new LowerCasePermutation();
	repeatedPermutation = new RepeatedWordPermutation();
	vowelPermutation = new VowelPermutation();
    }

    @Override
	public Set<String> getCorrection(String wordToCorrect){
	String word = wordTransformer.
	    getTransformedWords(wordToCorrect).get(0);
	Set<String> correctedSet = new HashSet<String>();
	if(word.equals(word.toLowerCase())){
	    if(dict.isWordInDictionary(word)){
		return null;
	    }
	}else{
	    correctedSet = checkForLowerCase(word);
	    if(!correctedSet.isEmpty()){
		return correctedSet;
	    }
	}
	correctedSet = checkForRepeatedPermutation(word.toLowerCase());
	if(!correctedSet.isEmpty()){
	    return correctedSet;
	}
	correctedSet = checkForVowelPermutation(word.toLowerCase());
	permutations.clear();
	return correctedSet;
    }

    //Check if the lower case permutation works. Returns a set
    //with the corrected lower case suggestion if it exists or an
    //empty set.
    private Set<String> checkForLowerCase(String word){
	Set<String> correctedSet = new HashSet<String>();
	List<String> lowerWord = lowerCase.getWordPermutation(word);
	if(dict.isWordInDictionary(lowerWord.get(0))){
	    correctedSet.add(lowerWord.get(0));
	}
	return correctedSet;
    }

    //Check if the repeated permutation works. Returns a set
    //with the suggestion if it exists or an empty set.
    private Set<String> checkForRepeatedPermutation(String word){
	Set<String> correctedSet = new HashSet<String>();
	permutations = repeatedPermutation.getWordPermutation(word);
	for(String permutedWord : permutations){
	    if(dict.isWordInDictionary(permutedWord)){
		correctedSet.add(permutedWord);
		return correctedSet;
	    }
	}
	return correctedSet;
    }

    //Returns the suggestions from the vowel permutation.
    //Returns a set with suggestion if it exists or an empty set.
    private Set<String> checkForVowelPermutation(String word){
	int numOfPermutations = 0;
	Set<String> correctedSet = new HashSet<String>();
	permutations = repeatedPermutation.getWordPermutation(word);
	for(String repeatedWord : permutations){
	    for(String vowelWord : vowelPermutation.
		    getWordPermutation(repeatedWord)){
		if(++numOfPermutations > 4000000){
		    return correctedSet;
		}
		if(dict.isWordInDictionary(vowelWord)){
		    correctedSet.add(vowelWord);
		    return correctedSet;
		}
	    }
	}
	return correctedSet;
    }
   
    private List<String> permutations;
    private WordPermutation lowerCase;
    private WordPermutation vowelPermutation;
    private WordPermutation repeatedPermutation;
    private WordTransformer wordTransformer;
}