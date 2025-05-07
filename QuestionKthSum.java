import java.util.*;

public class QuestionKthSum {
    static class Node{
        int data;
        Node left, right;

        public Node(int d){
            this.data = d;
        }
    }

    public static void KthLargest(Node root, List<Integer> arr){
    if(root == null) {
        return;
    }

    Queue<Node> q = new LinkedList<>();
   
    q.add(root);

    while(!q.isEmpty()){
        int levelSize = q.size();
        int sum = 0;
        for(int i = 0; i < levelSize; i++){
            Node curr = q.remove();
            sum += curr.data;
            if(curr.left != null){
                q.add(curr.left);
            }

            if(curr.right != null){
                q.add(curr.right);
            }

        }
        arr.add(sum);

    }
    }

    public static int kthLargest(Node root, int k){
        List<Integer> arr = new ArrayList<>();
        KthLargest(root, arr);
        Collections.sort(arr);
        // n-k+1
      
        return arr.get(arr.size()-k);
    }

    public static void main(String[] args) {
        
        Node root = new Node(1);  
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(kthLargest(root, 1));
    }
    
}
