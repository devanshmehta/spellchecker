package com.spellchecker.permutation;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

//Given a word this class puts repeated characters at random positions
//AUTHOR : Devansh Mehta
public class RandomRepeatedPermutation implements WordPermutation{
    
    public RandomRepeatedPermutation(){
	random = new Random();
    }

    public List<String> getWordPermutation(String word){
	//num of characters to repeat.
	int numOfCharactersToRepeat = random.nextInt(word.length() / 2);
	//position of characters in the word which will be repeated.
	int[] positionOfCharacters = new int[numOfCharactersToRepeat];
	for(int i = 0; i < numOfCharactersToRepeat; ++i){
	    int randPos = random.nextInt(word.length());
	    positionOfCharacters[i] = randPos;
	}
	Arrays.sort(positionOfCharacters);
	StringBuilder randomWord = new StringBuilder();
	for(int i = 0, j = 0; i < word.length(); ++i){
	    if(j < positionOfCharacters.length && 
	       i == positionOfCharacters[j]){
		//max num of repeats = 5
		int numRepeats = random.nextInt(4) + 1;
		for(int k = 1; k <= numRepeats; ++k){
		    randomWord.append(word.charAt(i));
		}
		++j;
		continue;
	    }
	    randomWord.append(word.charAt(i));
	}
	List<String> words = new ArrayList<String>(1);
	words.add(randomWord.toString());
	return words;
    }

    private Random random;
}
