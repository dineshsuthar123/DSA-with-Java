package Trees;

class node {
    int key;
    node left;
    node right;

    public node(int item) {
        key = item;
        left = right = null;
    }
    
}
public class Trees {
    node root;
    
    public void insert(int key){
         root =  insertrec(root,key);
    }
    private node insertrec(node root ,int key) {
        if(root == null){
            root = new node(key);
            return root;
        }
        if(key < root.key){
            root.left = insertrec(root.left,key);
        }else if (key > root.key){
            root.right = insertrec(root.right,key);
        }

        return root;
    }

    public void inorder(){
        inorderrec(root);
    }
    private void inorderrec(node root) {
        if(root != null){
            inorderrec(root.left);
            System.out.print(root.key + " ");
            inorderrec(root.right);
        }
    }

    public void preorder(){
        preorderrec(root);
    }
    private void preorderrec(node root) {
        if(root != null){
            System.out.print(root.key + " ");
            preorderrec(root.left);
            preorderrec(root.right);
        }
    }
    public static void main(String[] args) {
        Trees tree = new Trees();
        tree.insert(15);
        tree.insert(12);
        tree.insert(10);
        tree.insert(17);
        tree.insert(19);
        tree.insert(21);
        tree.insert(25);
        tree.insert(22);
        tree.insert(20);
        tree.insert(27);
        tree.insert(29);
        tree.insert(31);

        tree.inorder();
        System.out.println();
        tree.preorder();
    }

    public Trees() {
        root = null;
    }

}
