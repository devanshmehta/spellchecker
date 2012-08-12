package com.spellchecker.permutation;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

//Given a word changes its some random characters to upper case.
//AUTHOR : Devansh Mehta
public class UpperCasePermutation implements WordPermutation{

    public UpperCasePermutation(){
	random = new Random();
    }

    public List<String> getWordPermutation(String word){
	int numCharactersToChange = random.nextInt(word.length() - 1);
	int[] posOfCharacters = new int[numCharactersToChange];
	for(int i = 0; i < numCharactersToChange; ++i){
	    posOfCharacters[i] = random.nextInt(word.length() - 1);
	}
	StringBuilder upperCaseWord = new StringBuilder(word);
	for(int i = 0; i < posOfCharacters.length; ++i){
	    int charPos = posOfCharacters[i];
	    upperCaseWord.replace(charPos, charPos + 1, 
	            String.valueOf(Character.toUpperCase(word.charAt(charPos))));
	}
	List<String> words = new ArrayList<String>(1);
	words.add(upperCaseWord.toString());
	return words;
    }

    private Random random;
}
