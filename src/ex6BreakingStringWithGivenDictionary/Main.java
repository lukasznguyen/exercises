package ex6BreakingStringWithGivenDictionary;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        StringBreak stringBreak = new StringBreak();
        Set<String> dictionary = createDictionary();
        String word1 = "ILEARNJAVA";
        String result1 = stringBreak.breakWord(word1, dictionary);
        String word2 = "Shortpathfromnode";
        String result2 = stringBreak.breakWord(word2, dictionary);
        String word3 = "HELLOLDMAN";
        String result3 = stringBreak.breakWord(word3, dictionary);

        System.out.println("Result1: \t"+result1);
        System.out.println("Result2: \t"+result2);
        System.out.println("Result3: \t"+result3);
    }

    public static Set<String> createDictionary(){
        Set<String> dictionary = new HashSet<>();
        dictionary.add("ILE");
        dictionary.add("I");
        dictionary.add("LEARN");
        dictionary.add("JAVA");
        dictionary.add("Short");
        dictionary.add("path");
        dictionary.add("from");
        dictionary.add("node");
        dictionary.add("HELL");
        dictionary.add("HELLO");
        dictionary.add("OLD");
        dictionary.add("MAN");
        return dictionary;
    }

}
