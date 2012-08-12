package com.spellchecker.corrector;

import java.util.Set;
import com.spellchecker.dictionary.Dictionary;

//Abstract class Corrector.
public abstract class Corrector{

    //Corrector which takes in a dictionary from which it will give 
    //suggestion for the corrections.
    public Corrector(Dictionary dict){
	this.dict = dict;
    }

    //abstract method which returns a set of corrected words. Returns 
    //an empty if there are no corrections
    public abstract Set<String> getCorrection(String word);

    protected Dictionary dict;
}
