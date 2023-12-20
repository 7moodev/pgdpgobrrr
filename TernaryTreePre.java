package Trees;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TernaryTreePre<T> implements Iterable<T> {
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
        } else {
            node.setMiddle(insert(node.getMiddle(), data));
        }

        return node;
    }

    public void printLevelOrder() {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode<T> current = queue.poll();
            System.out.print(current.getData() + " ");

            if (current.getLeft() != null) queue.offer(current.getLeft());
            if (current.getMiddle() != null) queue.offer(current.getMiddle());
            if (current.getRight() != null) queue.offer(current.getRight());
        }

        System.out.println();
    }
    public void inOrderTraversal() {
        inOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(TreeNode<T> node) {
        if (node != null) {
            inOrderTraversal(node.getLeft());
            System.out.print(node.getData() + " ");
            inOrderTraversal(node.getMiddle());
            if (node.getMiddle() != null) {
                // Visit the current node again for ternary tree
                System.out.print(node.getData() + " ");
            }
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
            preOrderTraversal(node.getMiddle());
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
            postOrderTraversal(node.getMiddle());
            postOrderTraversal(node.getRight());
            System.out.print(node.getData() + " ");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new TernaryTreeIterator<>(root);

    }


    public class TernaryTreeIterator<T> implements Iterator<T> {
        private Stack<TreeNode<T>> stack;

        public TernaryTreeIterator(TreeNode<T> root) {
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
            if (current.getMiddle() != null) {
                stack.push(current.getMiddle());
            }
            if (current.getLeft() != null) {
                stack.push(current.getLeft());
            }

            return current.getData();
        }
    }

    private static class TreeNode<T> {
        private T data;
        private TreeNode<T> left;
        private TreeNode<T> middle;
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

        public TreeNode<T> getMiddle() {
            return middle;
        }

        public void setMiddle(TreeNode<T> middle) {
            this.middle = middle;
        }

        public TreeNode<T> getRight() {
            return right;
        }

        public void setRight(TreeNode<T> right) {
            this.right = right;
        }
    }


    public static void main(String[] args) {
        TernaryTreePre<Integer> tree = new TernaryTreePre<>();
        tree.insert(5);
        tree.insert(3);
        tree.insert(8);
        tree.insert(2);
        tree.insert(4);
        tree.insert(7);
        tree.insert(9);

        System.out.println("Level Order Traversal:");
        // tree.printLevelOrder();
        // tree.inOrderTraversal(tree.root);
       // tree.postOrderTraversal(tree.root);
        tree.preOrderTraversal();

        System.out.println("Tree Traversal using Iterator:");
        for (Integer value : tree) {
            System.out.print(value + " ");
        }

    }
}
