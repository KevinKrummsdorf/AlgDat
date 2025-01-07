public class BinarySearchTree {

    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    public void inorder() {
        System.out.println(printTreeRec(root));
    }

    public void preorder() {
        System.out.println(printTreeRecPreOrder(root));
    }

    public void postorder() {
        System.out.println(printTreeRecPostOrder(root));    
    }

    private String printTreeRec(Node root) {
        if (root == null) {
            return "{}";
        }

        String left = printTreeRec(root.left);
        String right = printTreeRec(root.right);

        //return left + "{" + root.key + "}" + right;
        return "{" + left + root.key + right + "}";
    }

    private String printTreeRecPostOrder(Node root) {
        if (root == null) {
            return "{}";
        }

        String left = printTreeRecPostOrder(root.left);
        String right = printTreeRecPostOrder(root.right);

        return left + right + "{" + root.key + "}";
    }

    private String printTreeRecPreOrder(Node root) {
        if (root == null) {
            return "{}";
        }

        String left = printTreeRecPreOrder(root.left);
        String right = printTreeRecPreOrder(root.right);

        return "{" + root.key + "}" + left + right;
    }

    public boolean search(int key) {
        return searchRec(root, key);
    }

    private boolean searchRec(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (key == root.key) {
            return true;
        }

        if (key < root.key) {
            return searchRec(root.left, key);
        }

        return searchRec(root.right, key);
    }

    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.key = minValue(root.right);

            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    private int minValue(Node root) {
        int minv = root.key;

        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }

        return minv;
    }
}
