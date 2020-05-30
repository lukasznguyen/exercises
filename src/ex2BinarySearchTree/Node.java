package ex2BinarySearchTree;

import java.util.List;

public class Node {

    int value;
    Node parent;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        parent = null;
        left = null;
        right = null;
    }

    public Node(int value,Node parent, Node left, Node right){
        this.value = value;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public int getValue(){
        return value;
    }

    public void insert(Node node){
        if(node.getValue() < value){
            if(left == null){
                left = node;
                left.parent = this;
            } else {
                left.insert(node);
            }
        } else {
            if(right == null){
                right = node;
                right.parent = this;
            } else {
                right.insert(node);
            }
        }
    }

    public Node search(Node node){
        if(node.getValue() == value){
            return this;
        }
        if(node.getValue() < value){
            return (left != null) ? left.search(node) : null;
        }
        return (right != null) ? right.search(node) : null;
    }

    public Node findParent(Node node){
        if(left == node || right == node){
            return this;
        }

        Node findLeft = (left != null) ? left.findParent(node) : null;

        if(findLeft != null){
            return findLeft;
        }

        return (right != null) ? right.findParent(node) : null;
    }


    public void remove(Node node){
        if(node == left){
            left = null;
        }
        if(node == right){
            right = null;
        }
    }

    public void delete(Node parent){
        parent.remove(this);
        if(left != null) {
            parent.insert(left);
        }
        if(right != null) {
            parent.insert(right);
        }
    }

    // Parent - Left - Right
    public void preorder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.getValue()+" ");
        preorder(node.left);
        preorder(node.right);
    }

    // Left - Parent - Right
    public void inorder(Node node){
        if(node == null){
            return;
        }
        inorder(node.left);
        System.out.print(node.getValue()+" ");
        inorder(node.right);
    }

    // Left - Right - Parent
    public void postorder(Node node){
        if(node == null){
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.getValue()+" ");
    }

    public static Node build(List<Integer> in, List<Integer> post){
        if(post.size()-1<0 || in.size()<1) return null;
        int value = post.get(post.size()-1);
        Node node = new Node(value);
        List<Integer> lefti = in.subList(0, in.indexOf(value));
        List<Integer> leftp = post.subList(0, in.indexOf(value));
        List<Integer> righti = in.subList(in.indexOf(value)+1, in.size());
        List<Integer> rightp = post.subList(in.indexOf(value), post.size()-1);
        //node.left.parent = node;
        node.left = build(lefti, leftp);
        //node.right.parent = node;
        node.right = build(righti, rightp);
        return node;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", parent="+ parent+
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
