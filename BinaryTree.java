package Trees;

import java.util.Iterator;
import java.util.Stack;

public class BinaryTree<T> implements Iterable<T> {
    private TreeNode<T> root;

    public void insert(T data) {
        root = insert(root, data);
    }

    private TreeNode<T> insert(TreeNode<T> node, T data) {
        if (node == null) {
            return new TreeNode<>(data);
        }

        Comparable<T> comparableData = (Comparable<T>) data;

        if (comparableData.compareTo(node.getData()) < 0) {
            node.setLeft(insert(node.getLeft(), data));
        } else if (comparableData.compareTo(node.getData()) > 0) {
            node.setRight(insert(node.getRight(), data));
        }

        return node;
    }
    public int getTreeLength() {
        return getTreeLength(root);
    }

    private int getTreeLength(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }

        int leftLength = getTreeLength(node.getLeft());
        int rightLength = getTreeLength(node.getRight());

        // Return the length of the longest path through the current node
        return Math.max(leftLength, rightLength) + 1;
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(TreeNode<T> node) {
        if (node != null) {
            inOrderTraversal(node.getLeft());
            System.out.print(node.getData() + " ");
            inOrderTraversal(node.getRight());
        }
    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
        System.out.println();
    }

    private void preOrderTraversal(TreeNode<T> node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            preOrderTraversal(node.getLeft());
            preOrderTraversal(node.getRight());
        }
    }

    public void postOrderTraversal() {
        postOrderTraversal(root);
        System.out.println();
    }

    private void postOrderTraversal(TreeNode<T> node) {
        if (node != null) {
            postOrderTraversal(node.getLeft());
            postOrderTraversal(node.getRight());
            System.out.print(node.getData() + " ");
        }
    }

    public Iterator<T> getInOrderIterator() {
        return new InOrderIterator();
    }

    public Iterator<T> getPreOrderIterator() {
        return new PreOrderIterator();
    }

    public Iterator<T> getPostOrderIterator() {
        return new PostOrderIterator();
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private class InOrderIterator implements Iterator<T> {
        private Stack<TreeNode<T>> stack;

        public InOrderIterator() {
            stack = new Stack<>();
            pushLeftChildren(root);
        }

        private void pushLeftChildren(TreeNode<T> node) {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new IllegalStateException("No more elements in the tree");
            }

            TreeNode<T> current = stack.pop();
            pushLeftChildren(current.getRight());

            return current.getData();
        }
    }

    private class PreOrderIterator implements Iterator<T> {
        private Stack<TreeNode<T>> stack;

        public PreOrderIterator() {
            stack = new Stack<>();
            if (root != null) {
                stack.push(root);
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new IllegalStateException("No more elements in the tree");
            }

            TreeNode<T> current = stack.pop();
            if (current.getRight() != null) {
                stack.push(current.getRight());
            }
            if (current.getLeft() != null) {
                stack.push(current.getLeft());
            }

            return current.getData();
        }
    }

    private class PostOrderIterator implements Iterator<T> {
        private Stack<TreeNode<T>> stack;
        private TreeNode<T> lastVisited;

        public PostOrderIterator() {
            stack = new Stack<>();
            lastVisited = null;
            pushPostOrderNodes(root);
        }

        private void pushPostOrderNodes(TreeNode<T> node) {
            while (node != null) {
                stack.push(node);
                lastVisited = node;
                node = node.getLeft();
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new IllegalStateException("No more elements in the tree");
            }

            while (true) {
                TreeNode<T> current = stack.peek();
                if (current.getRight() != null && current.getRight() != lastVisited) {
                    pushPostOrderNodes(current.getRight());
                } else {
                    lastVisited = stack.pop();
                    return lastVisited.getData();
                }
            }
        }
    }


    private static class TreeNode<T> {
        private T data;
        private TreeNode<T> left;
        private TreeNode<T> right;

        public TreeNode(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public TreeNode<T> getLeft() {
            return left;
        }

        public void setLeft(TreeNode<T> left) {
            this.left = left;
        }

        public TreeNode<T> getRight() {
            return right;
        }

        public void setRight(TreeNode<T> right) {
            this.right = right;
        }
    }


    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(5);
        tree.insert(3);
        tree.insert(8);
        tree.insert(2);
        tree.insert(4);
        tree.insert(7);
        tree.insert(9);

        System.out.println("In-Order Traversal:");
        tree.inOrderTraversal();

        System.out.println("Pre-Order Traversal:");
        tree.preOrderTraversal();

        System.out.println("Post-Order Traversal:");
        tree.postOrderTraversal();
        // Assuming you have a BinaryTree instance named 'binaryTree'

        Iterator<Integer> inOrderIterator = tree.getInOrderIterator();
        Iterator<Integer> preOrderIterator = tree.getPreOrderIterator();
        Iterator<Integer> postOrderIterator = tree.getPostOrderIterator();

// Iterate through the elements
        while (inOrderIterator.hasNext()) {
            int element = inOrderIterator.next();
            System.out.print(element + " ");
        }
        System.out.println();

        while (preOrderIterator.hasNext()) {
            int element = preOrderIterator.next();
            System.out.print(element + " ");
        }
        System.out.println();

        while (postOrderIterator.hasNext()) {
            int element = postOrderIterator.next();
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println(tree.getTreeLength());
    }
}
