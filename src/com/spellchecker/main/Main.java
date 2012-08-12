package com.spellchecker.main;

import java.util.Scanner;
import java.util.Set;
import java.io.FileNotFoundException;
import com.spellchecker.dictionary.Dictionary;
import com.spellchecker.corrector.*;

public class Main{

    public static void main(String[] args){
	if(args.length < 1){
	    printUsage();
	    System.exit(1);
	}
	String file = args[0];
	try{
	    Dictionary d = new Dictionary(file);
	    Corrector c = new TwitchTVCorrector(d);
	    //System.out.print(ENTER_LINE);
	    Scanner scanner =  new Scanner(System.in);
	    while(scanner.hasNextLine()){
		String word = scanner.nextLine();
		Set<String> suggestions = c.getCorrection(word);
		if(suggestions == null){
		    System.out.println("Correct Word");
		}
		else if(suggestions.isEmpty()){
		    System.out.println("No Suggestions");
		}else{
		    System.out.println(suggestions.toArray()[0]);
		}
		//System.out.print(ENTER_LINE);
	    }
	}catch(FileNotFoundException e){
	    System.out.println("File Not Found: " + file);
	    System.exit(1);
	}

    }
    
    //Prints the usage for this program.
    public static void printUsage(){
	System.out.println("java Main <file>");
    }

    private static final String ENTER_LINE = "Enter a word -> ";
}