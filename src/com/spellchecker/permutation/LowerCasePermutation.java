package com.spellchecker.permutation;

import java.util.List;
import java.util.ArrayList;

public class LowerCasePermutation implements WordPermutation{

    public List<String> getWordPermutation(String word){
	List<String> words = new ArrayList<String>(1);
	words.add(word.toLowerCase());
	return words;
    }
}