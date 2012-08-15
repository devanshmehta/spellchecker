package com.spellchecker.permutation;

import java.util.List;
import java.util.ArrayList;

//This permutor does the opposite of the MyCorrector.
//AUTHOR : Devansh Mehta
public class MyPermutor implements WordPermutation{

    public MyPermutor(){
	upperCase = new UpperCasePermutation();
	randomRepeated = new RandomRepeatedPermutation();
	vowelPermutation = new VowelPermutation();
    }

    public List<String> getWordPermutation(String word){
	List<String> vowelPermutations = vowelPermutation.
	    getWordPermutation(word.toLowerCase());
	List<String> upperCasePermutation = new ArrayList<String>();
	for(String s : vowelPermutations){
	    upperCasePermutation.add(upperCase.getWordPermutation(s).get(0));
	}
	List<String> randomWords = new ArrayList<String>();
	for(String s : upperCasePermutation){
	    randomWords.add(randomRepeated.getWordPermutation(s).get(0));
	}
	return randomWords;
    }

    private WordPermutation upperCase;
    private WordPermutation randomRepeated;
    private WordPermutation vowelPermutation;
}