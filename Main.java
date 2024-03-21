import java.util.Scanner;

class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        root = null;
    }

    private void preOrderTraversal(TreeNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    private void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);
        }
    }

    private void postOrderTraversal(TreeNode node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }

    public void preOrder() {
        System.out.println("Preorder traversal:");
        preOrderTraversal(root);
        System.out.println();
    }

    public void inOrder() {
        System.out.println("Inorder traversal:");
        inOrderTraversal(root);
        System.out.println();
    }

    public void postOrder() {
        System.out.println("Postorder traversal:");
        postOrderTraversal(root);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();

        System.out.println("Ingrese los nodos del árbol binario separados por comas (terminar con Enter):");
        String[] nodesInput = scanner.nextLine().split(",");
        for (String node : nodesInput) {
            if (node.isEmpty()) continue; // Ignorar entradas vacías
            tree.root = insert(tree.root, Integer.parseInt(node.trim()));
        }

        System.out.println("Árbol creado. ¿Qué recorrido desea realizar?");
        System.out.println("1. Preorden");
        System.out.println("2. Inorden");
        System.out.println("3. Postorden");
        System.out.println("4. Salir");

        while (true) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    tree.preOrder();
                    break;
                case 2:
                    tree.inOrder();
                    break;
                case 3:
                    tree.postOrder();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    System.exit(0);
                default:
                       System.out.println("Opción inválida. Por favor, ingrese nuevamente.");
            }
        }
    }

    private static TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }
}
