package com.spellchecker.permutation;

import java.util.*;

public class Permutation{

    //Returns all the permutations of the given list. The permutations are 
    //like follows eg: 1,1,2 -> 1,1,2 and 1,1,1.
    public static List<List<Integer>> permute(List<Integer> integers, int i){
	if(i == integers.size() - 1){
	    List<List<Integer>> returnList = new ArrayList<List<Integer>>();
	    for(int counter = 1; counter <= integers.get(i); ++counter){
		List<Integer> list = new ArrayList<Integer>();
		list.add(counter);
		returnList.add(list);
	    }
	    return returnList;
	}
	int first = integers.get(i);
	List<List<Integer>> returnList = new ArrayList<List<Integer>>();
	for(int counter = 1; counter <= first; ++counter){
	    List<List<Integer>> permutations = permute(integers, i + 1);
	    for(List<Integer> permutes : permutations){
		permutes.add(0, counter);
		returnList.add(permutes);
	    }
	}
	return returnList;
    }
}