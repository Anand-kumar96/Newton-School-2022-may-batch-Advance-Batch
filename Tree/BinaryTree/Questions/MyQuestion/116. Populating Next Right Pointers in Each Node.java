//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/


// method 01
class Solution {
    public Node connect(Node root) {
        if(root!=null){
    Node leftNode=root.left;
    Node rightNode=root.right;
    Node nextNode=root.next;
        if(leftNode!=null && rightNode!=null){
            leftNode.next=rightNode;    
        if(nextNode!=null){
            rightNode.next=nextNode.left;
        }
        connect(leftNode);  
        connect(rightNode);       
    }
    }
        return root;
    }
          
// method 02
class Solution {
    public Node connect(Node root) {
        if(root!=null){
        if(root.left!=null && root.right!=null){
            root.left.next=root.right;    
        if(root.next!=null){
            root.right.next=root.next.left;
        }
        connect(root.left);  
        connect(root.right);       
    }
    }
        return root;
    }
}
