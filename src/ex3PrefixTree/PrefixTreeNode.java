package ex3PrefixTree;

import java.util.ArrayList;
import java.util.List;

public class PrefixTreeNode {
    char value;
    boolean endWord;
    List<PrefixTreeNode> children;

    public PrefixTreeNode(char value){
        this.value = value;
        endWord = false;
        children = new ArrayList<>();
    }

    public char getValue(){
        return value;
    }

    public PrefixTreeNode insert(String word) {
        if (word.isEmpty()) {
            endWord = true;
            return this;
        }

        for (PrefixTreeNode tree : children) {
            if(tree.getValue() == word.charAt(0)){
                return tree.insert(word.substring(1));
            }
        }

        children.add(new PrefixTreeNode(word.charAt(0)));
        return insert(word);
    }

    public boolean check(String word){
        if(word.isEmpty()){
            return this.endWord;
        }
        for (PrefixTreeNode tree : children) {
            if(tree.getValue() == word.charAt(0)){
                return tree.check(word.substring(1));
            }
        }
        return false;
    }

    public String toString (){
        return "Value: "+getValue();
    }

}
