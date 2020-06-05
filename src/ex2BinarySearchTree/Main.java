package ex2BinarySearchTree;

/*
Implementation of Binary Search Tree
 */

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Node root = new Node(12);
        /*
                                12
                                /\
                               5  15
                              /\   /\
                             3  7 13 17
                            /    \     \
                           1      9     19
         */
        int[] values = {5, 15, 3, 7, 13, 17, 1, 9, 19};
        List<Node> nodes = new ArrayList<>();
        for (int value: values) {nodes.add(new Node(value)); }
        //adding to tree
        for(Node node : nodes) { root.insert(node); }

        //printing tree
        System.out.print("Preorder: ");
        root.preorder(root);
        System.out.println();
        System.out.print("Inorder: ");
        root.inorder();
        System.out.println();
        System.out.print("Postorder: ");
        root.postorder(root);
        System.out.println();

        //search node
        //System.out.println(root.search(nodes.get(3))); //searching 7
        //System.out.println(root.search(nodes.get(1))); //searching 15

        //delete leaf(9)
        //root.search(nodes.get(7)).delete(root.findParent(nodes.get(7)));
        //System.out.println(root.search(nodes.get(3)));

        //delete node with one child(7)
        //root.search(nodes.get(3)).delete(root.findParent(nodes.get(3)));
        //System.out.println(root.search(nodes.get(0)));

        //delete node with one child(3)
        //root.search(nodes.get(2)).delete(root.findParent(nodes.get(2)));
        //System.out.println(root.search(nodes.get(0)));

        //delete node with two children(5) - exception
        root.left.delete(root);
        System.out.println("----");
        root.inorder();
        //System.out.println(root);

        List<Integer> inorder = List.of(1,3,5,7,9,12,13,15,17,19);
        List<Integer> postorder = List.of(1,3,9,7,5,13,19,17,15,12);
        Node nroot = Node.build(inorder, postorder);
        //nroot.inorder(nroot);
        System.out.println();
        nroot.postorder(nroot);
        System.out.println();
        System.out.println(nroot);

    }
}
