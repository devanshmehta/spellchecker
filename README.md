This is a spell checker program.

It takes a large list of English words(eg: from a file) into memory and reads
into memory and then reads word from stdin and print either the best spelling 
suggestion or "NO Suggestion" if no suggestion can be found. 

The data structure used in storing the words in memory is Trie. The trie data
structure helps in finding a solution in O(n) per word checked where n is the
length of the dictionary. 

eg: 
> sheeeeeeeeep
sheep
>peeepple
people
>sheeeple
NO Suggestion

The class of spelling mistakes corrected

a) Case (upper/lower) errors: "inSIDE" -> inside
b) Repeated letters "jjoobbb" -> job
c) Incorrect vowels: "weke" -> wake

Any combination of above error can be corrected eg: Cunspirrecy -> conspiracy.

The program is flexible enough so that you can add your class of mistakes also.

After running the ant file. There will be a dist directory created. 

You can run the corrector as a jar file

java -jar corrector.jar <dictionaryofwords>

One sample dictionary of words is provided in the resource folder.

There is also a Randomizer which generates a random above class of mistake. The
purpose of Randomizer is to generata a random above class of mistakes which 
can be piped to corrector.


