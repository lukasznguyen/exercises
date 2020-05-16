package ex2BinarySearchTree;

public class BinaryTree {

    Node root;

    public BinaryTree(){
        System.out.println("Tree created");
        root = null;
    }

    public Node insert(int value){
        Node newNode = new Node(value);

        if(root == null){
            root = newNode;
            System.out.println("Value added ("+newNode.value+")");
        }else{
            Node focusNode = root;
            Node parent;
            while(true){
                parent = focusNode;
                if(value < parent.value){
                    focusNode = focusNode.left;
                    if(focusNode == null){
                        parent.left = newNode;
                        System.out.println("Value added ("+newNode.value+")");
                        return root;
                    }
                } else if(value > parent.value) {
                    focusNode = focusNode.right;
                    if(focusNode == null){
                        parent.right = newNode;
                        System.out.println("Value added ("+newNode.value+")");
                        return root;
                    }
                } else {
                    System.out.println("Invalid value - tree already contains that key");
                    return root;
                }
            }
        }
        return root;
    }

    public Node search(int value){
        Node focusNode = root;
        while(focusNode.value != value){
            if(value < focusNode.value){
                focusNode = focusNode.left;
            } else {
                focusNode = focusNode.right;
            }
            if(focusNode == null){
                return null;
            }
        }
        return focusNode;
    }

    public boolean delete(int value){
        Node focusNode = root;
        Node parent = root;
        boolean isItLeft = true;
        while(focusNode.value != value){
            parent = focusNode;
            if(value<focusNode.value){
                isItLeft = true;
                focusNode = focusNode.left;
            } else{
                isItLeft = false;
                focusNode = focusNode.right;
            }
            if(focusNode == null){
                return false;
            }
        }

        if(focusNode.left == null && focusNode.right == null){ //0 child
            if(focusNode == root){
                root = null;
            } else if(isItLeft){
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if(focusNode.right == null){  //only left child
            if(focusNode == root){
                root = focusNode.left;
            } else if(isItLeft){
                parent.left = focusNode.left;
            } else {
                parent.right = focusNode.left;
            }
        } else if(focusNode.left == null){  //only right child
            if(focusNode == root){
                root = focusNode.right;
            } else if(isItLeft){
                parent.left = focusNode.right;
            } else {
                parent.right = focusNode.right;
            }
        } else {  //2 children

        }
        return true;
    }


    // Parent - Left - Right
    public static void preorder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.value+" ");
        preorder(node.left);
        preorder(node.right);
    }

    // Left - Parent - Right
    public static void inorder(Node node){
        if(node == null){
            return;
        }
        inorder(node.left);
        System.out.print(node.value+" ");
        inorder(node.right);
    }

    // Left - Right - Parent
    public static void postorder(Node node){
        if(node == null){
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value+" ");
    }
}
