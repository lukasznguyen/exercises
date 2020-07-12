package ex6BreakingStringWithGivenDictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    // Dynamic programming: catch
    //
    //  I LEARN JAVA
    // ILEARNJAVA
    // Shortpathfromnode
    // Dictionary: dic.containkey(word): true or false
    // to break the given (input) into word. Everyworld exists in the dictionary.
    // Short path from node
    // SHO RTPA THFROM NODE


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



    // HELLOLDMAN
    // word: HELLO, newS = LDMAN. We cannot break LDMAN into words. tmp=""
    // word: HELL, newS = OLDMAN --> OLDMAN = OLD and MAN

    // s = "HelloWordTATA"
    // first word: Hello -> news = WorldTATA
    // second: World -> newS = TATA
    // third~: Tata.

    // S = `HELLODL<.....>
    // word HELLO + DL -->  HELLOLD. Both to call newS = <.....>
    // words HELL + ODL --> HELLOLD  Both to call newS = <.....>
}
