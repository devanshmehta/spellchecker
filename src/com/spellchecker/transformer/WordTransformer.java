package com.spellchecker.transformer;

import java.util.List;

//This interface provides method to transform a given word 
//to a list of simple words which can be easily understood 
//by the corrector.
public interface WordTransformer{
    
    public List<String> getTransformedWords(String word);

}