
    public static void pathToLeafFromRoot(Node node, String path, int sum, int low, int high) {
        if (node == null) {
            return;
        }
 
        sum += node.data;
        path += node.data + " ";

        if (node.left == null && node.right == null) { // Leaf node
            if (sum >= low && sum <= high) {
                System.out.println(path);
            }
        } else {
            pathToLeafFromRoot(node.left, path, sum, low, high);
            pathToLeafFromRoot(node.right, path, sum, low, high);
        }
    }