package com.spellchecker.permutation;

import java.util.*;

public class VowelPermutation implements WordPermutation{

    //Gets all the permutations for vowel. eg: job -> jeb,
    //jab, jib, jub, job(redundant)
    public List<String> getWordPermutation(String word){
	int vowelCount = 0;
	List<Integer> permutationList = new ArrayList<Integer>();
	for(int i = 0; i < word.length(); ++i){
	    if(checkIfVowel(word.charAt(i))){
		++vowelCount;
		//5 is number of vowels
		permutationList.add(5);
	    }
	}
	if(permutationList.isEmpty()){
	    return new ArrayList<String>();
	}
	List<List<Integer>> permutations = Permutation.
	    permute(permutationList, 0);
	List<String> returnList = new ArrayList<String>();
	StringBuilder sb = new StringBuilder(word);
	for(List<Integer> permutes : permutations){
	    int index = 0;
	    for(int i : permutes){
		index = getIndexOfFirstVowelAfter(word, index);
		char replaceChar = vowelIndexToVowel(i);
		sb.replace(index, index + 1, String.valueOf(replaceChar));
		index += 1;
	    }
	    returnList.add(sb.toString());
	}
	return returnList;
    }

    //Converts the given integer i into a vowel. The argument i 
    //is the index of the vowel in the vowel list. i is 1 based.
    private char vowelIndexToVowel(int i){
	return VOWEL_LIST[i - 1];
    }

    //Gets the first vowel index after the given index in the word.
    //Both the argument and return int are zero based.
    private int getIndexOfFirstVowelAfter(String word, int index){
	for(int i = index ; i < word.length(); ++i){
	    if(checkIfVowel(word.charAt(i))){
		return i;
	    }
	}
	return -1;
    }

    //Checks if the given character is a vowel or not.
    private boolean checkIfVowel(char c){
	for(char v : VOWEL_LIST){
	    if(c == v){
		return true;
	    }
	}
	return false;
    }

    private static char[] VOWEL_LIST = {'a', 'e', 'i', 'o', 'u'};
}