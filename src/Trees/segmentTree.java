public class segmentTree {

    private static class Node{
        int data;
        int start;
        int end;
        Node left;
        Node right;
        Node(int data, int start, int end) {
            this.data = data;
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
        }
    }
    Node root;
    public segmentTree(int[] arr) {
        this.root = buildTree(arr, 0, arr.length - 1);
    }
    private Node buildTree(int[] arr, int start, int end) {
        if (start == end) {
            return new Node(arr[start], start, end);
        }
        int mid = (start + end) / 2;
        Node leftChild = buildTree(arr, start, mid);
        Node rightChild = buildTree(arr, mid + 1, end);
        Node node = new Node(leftChild.data + rightChild.data, start, end);
        node.left = leftChild;
        node.right = rightChild;
        return node;
    }
    public int query(int start, int end) {
        return query(root, start, end);
    }
    private int query(Node node, int start, int end) {
        if (node.start > end || node.end < start) {
            return 0; // Out of range
        }
        if (node.start >= start && node.end <= end) {
            return node.data; // Current segment is completely within the range
        }
        // Partial overlap case
        return query(node.left, start, end) + query(node.right, start, end);
    }
    public void update(int index, int value) {
        update(root, index, value);
    }
    private void update(Node node, int index, int value) {
        if (node.start == node.end) {
            node.data = value; // Update the leaf node
            return;
        }
        int mid = (node.start + node.end) / 2;
        if (index <= mid) {
            update(node.left, index, value);
        } else {
            update(node.right, index, value);
        }
        // Update the current node's data after updating the child
        node.data = node.left.data + node.right.data;
    }
    private void printTree(Node node) {
        if (node == null) return;
        System.out.println("Node: [" + node.start + ", " + node.end + "] = " + node.data);
        printTree(node.left);
        printTree(node.right);
    }
    public void print() {
        printTree(root);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        segmentTree st = new segmentTree(arr);
        System.out.println("Sum of values in range (1, 3): " + st.query(1, 3)); // Output: 15
        st.update(1, 10); // Update index 1 to value 10
        st.print(); // Print the segment tree structure
    }
}
