package ex2BinarySearchTree;

/*
Implementation of Binary Search Tree
 */

public class Main {
    public static void main(String[] args) {
        BinaryTree binTree = new BinaryTree();
        /*                  9
                           / \
                          7   19
                         /    /
                        1    14
                            / \
                          12   18
                           \   /
                           13 16
                               \
                                17
         */
        int [] values = {9, 19, 14, 7, 12, 18, 13, 16, 17, 1};

        //Adding to tree
        for (int value : values) {
            binTree.insert(value);
        }

        //Printing tree
        System.out.print("Preorder: ");
        BinaryTree.preorder(binTree.root);
        System.out.println();
        System.out.print("Inorder: ");
        BinaryTree.inorder(binTree.root);
        System.out.println();
        System.out.print("Postorder: ");
        BinaryTree.postorder(binTree.root);
        System.out.println();

        //Searching node
        System.out.println(binTree.search(14)); //found
        System.out.println(binTree.search(30)); //not found

    }
}
