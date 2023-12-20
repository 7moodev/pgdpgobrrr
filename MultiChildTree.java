package Trees;

import java.util.*;

public class MultiChildTree<T> implements Iterable<T> {
    private TreeNode<T> root;
    public void insert(T data) {
        root = insert(root, data);
    }

    private TreeNode<T> insert(TreeNode<T> node, T data) {
        if (node == null) {
            return new TreeNode<>(data);
        }

        // Always add the new data as a new child
        node.getChildren().add(new TreeNode<>(data));

        return node;
    }
    public int getTreeLength() {
        return getTreeLength(root);
    }

    private int getTreeLength(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }

        int maxLength = 0;

        for (TreeNode<T> child : node.getChildren()) {
            int childLength = getTreeLength(child);
            maxLength = Math.max(maxLength, childLength);
        }

        return maxLength + 1; // Add 1 for the current node
    }

    // ... (rest of the code remains the same)



    public void inOrderTraversal() {
        inOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(TreeNode<T> node) {
        if (node != null) {
            for (TreeNode<T> child : node.getChildren()) {
                inOrderTraversal(child);
                System.out.print(node.getData() + " ");
            }
        }
    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
        System.out.println();
    }

    private void preOrderTraversal(TreeNode<T> node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            for (TreeNode<T> child : node.getChildren()) {
                preOrderTraversal(child);
            }
        }
    }

    public void postOrderTraversal() {
        postOrderTraversal(root);
        System.out.println();
    }

    private void postOrderTraversal(TreeNode<T> node) {
        if (node != null) {
            for (TreeNode<T> child : node.getChildren()) {
                postOrderTraversal(child);
            }
            System.out.print(node.getData() + " ");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new TreeIterator();
    }

    private static class TreeNode<T> {
        private T data;
        private List<TreeNode<T>> children;

        public TreeNode(T data) {
            this.data = data;
            this.children = new ArrayList<>();
        }

        public T getData() {
            return data;
        }

        public List<TreeNode<T>> getChildren() {
            return children;
        }
    }
    private class TreeIterator implements Iterator<T> {
        private Queue<TreeNode<T>> queue;

        public TreeIterator() {
            queue = new LinkedList<>();
            if (root != null) {
                queue.add(root);
            }
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }

            TreeNode<T> current = queue.poll();
            for (TreeNode<T> child : current.getChildren()) {
                queue.add(child);
            }

            return current.getData();
        }
    }


    public static void main(String[] args) {
        MultiChildTree<Integer> tree = new MultiChildTree<>();
        tree.insert(5);
        tree.insert(3);
        tree.insert(8);
        tree.insert(2);
        tree.insert(4);
        tree.insert(7);
        tree.insert(9);
        System.out.println(tree.getTreeLength());

//        System.out.println("In-Order Traversal:");
//        tree.inOrderTraversal();
//
        System.out.println("Pre-Order Traversal:");
        tree.preOrderTraversal();
//
//        System.out.println("Post-Order Traversal:");
//        tree.postOrderTraversal();
        System.out.println("Tree Traversal using Pre Order Iterator:");
        for (Integer value : tree) {
            System.out.print(value + " ");
        }
    }
}
