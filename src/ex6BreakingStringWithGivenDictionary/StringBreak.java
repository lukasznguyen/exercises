package ex6BreakingStringWithGivenDictionary;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StringBreak {

    public Map<String, Boolean> cannotbreak;

    public StringBreak(){
        cannotbreak = new HashMap<>();
    }

    public String breakWord(String s, Set<String> dictionary){
        if (cannotbreak.containsKey(s)) {
            return "";
        }
        for (String word : dictionary) {
            if(s.lastIndexOf(word) == 0) {
                if(s.equals(word)) {
                    return word;
                }
                String newS = s.substring(word.length());
                String tmp = breakWord(newS, dictionary);
                if(!tmp.equals("")) {
                    return word+" "+tmp;
                }
            }
        }
        cannotbreak.put(s, true);
        return "";
    }
}
