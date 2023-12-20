package Trees;

class AVLTree<T extends Comparable<T>> {

    private static class Node<T> {
        T data;
        Node<T> left, right;
        int height;

        Node(T data) {
            this.data = data;
            this.height = 1;
        }
    }

    private Node<T> root;

    private int height(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private int balanceFactor(Node<T> node) {
        return height(node.left) - height(node.right);
    }

    private Node<T> rightRotate(Node<T> y) {
        Node<T> x = y.left;
        Node<T> T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    private Node<T> leftRotate(Node<T> x) {
        Node<T> y = x.right;
        Node<T> T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    private Node<T> insert(Node<T> node, T data) {
        // Perform standard BST insert
        if (node == null) {
            return new Node<>(data);
        }

        if (data.compareTo(node.data) < 0) {
            node.left = insert(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insert(node.right, data);
        } else {
            // Duplicate data not allowed
            return node;
        }

        // Update height of current node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get the balance factor
        int balance = balanceFactor(node);

        // Left Left Case
        if (balance > 1 && data.compareTo(node.left.data) < 0) {
            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && data.compareTo(node.right.data) > 0) {
            return leftRotate(node);
        }

        // Left Right Case
        if (balance > 1 && data.compareTo(node.left.data) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && data.compareTo(node.right.data) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // No rotation needed
        return node;
    }

    public void insert(T data) {
        root = insert(root, data);
    }
    private Node<T> minValueNode(Node<T> node) {
        Node<T> current = node;

        // Find the leftmost leaf node
        while (current.left != null) {
            current = current.left;
        }

        return current;
    }
    private Node<T> delete(Node<T> root, T data) {
        // Perform standard BST delete
        if (root == null) {
            return root;
        }

        if (data.compareTo(root.data) < 0) {
            root.left = delete(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = delete(root.right, data);
        } else {
            // Node with only one child or no child
            if ((root.left == null) || (root.right == null)) {
                Node<T> temp = null;
                if (temp == root.left) {
                    temp = root.right;
                } else {
                    temp = root.left;
                }

                // No child case
                if (temp == null) {
                    temp = root;
                    root = null;
                } else {
                    // One child case
                    root = temp; // Copy the contents of the non-empty child
                }
            } else {
                // Node with two children
                Node<T> temp = minValueNode(root.right);

                // Copy the in-order successor's data to this node
                root.data = temp.data;

                // Delete the in-order successor
                root.right = delete(root.right, temp.data);
            }
        }

        // If the tree had only one node, then return
        if (root == null) {
            return root;
        }

        // Update height of current node
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // Get the balance factor
        int balance = balanceFactor(root);

        // Left Left Case
        if (balance > 1 && balanceFactor(root.left) >= 0) {
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && balanceFactor(root.right) <= 0) {
            return leftRotate(root);
        }

        // Left Right Case
        if (balance > 1 && balanceFactor(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Left Case
        if (balance < -1 && balanceFactor(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    public void delete(T data) {
        root = delete(root, data);
    }

    // Other methods (traversal, deletion, etc.) can be added as needed
}
