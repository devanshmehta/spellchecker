package com.spellchecker.main;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import com.spellchecker.permutation.MyPermutor;

//This main generates faulty words from good words and outputs it to 
//the std out. The file passed as an argument to the program should 
//contain only word per line and also there should be only english
//characters in the file. It should not include punctuation and similar
//characters.
public class RandomizerMain{
    
    public static void main(String[] args){
	if(args.length < 1){
	    printUsage();
	    System.exit(1);
	}
	String file = args[0];
	goodWords = new ArrayList<String>();
	Scanner scanner = null;
	try{
	    scanner = new Scanner(new File(file));
	    while(scanner.hasNextLine()){
		goodWords.add(scanner.nextLine());
	    }
	}catch(FileNotFoundException e){
	    System.out.println("File Not Found " + file);
	}finally{
	    if(scanner != null){
		scanner.close();
	    }
	}
	MyPermutor t = new MyPermutor();
	for(String goodWord : goodWords){
	    for(String incorrectWord : t.getWordPermutation(goodWord)){
		System.out.println(incorrectWord);
	    }
	}
    }

    public static void printUsage(){
	System.out.println("java - cp . com.spellchecker.main.Main2 <file>");
    }

    private static List<String> goodWords;
}