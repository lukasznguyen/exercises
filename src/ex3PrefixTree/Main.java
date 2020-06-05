package ex3PrefixTree;

public class Main {

    public static void main(String[] args) {
        PrefixTreeNode root = new PrefixTreeNode('.');
        root.insert("rice");
        root.insert("rode");
        root.insert("ride");
        root.insert("rock");
        String word = "rulll";
        System.out.println(root.check(word));
    }
}
