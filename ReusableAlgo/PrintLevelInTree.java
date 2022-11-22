void printGivenLevel(TreeNode root, int level) {
    if (root == null)
        return;
    if (level == 1) {
        System.out.print(root.val + " ");
    }
    else if (level > 1) {
        if(level == 2) System.out.print("|| Parent: " + root.val + " -> ");
        printGivenLevel(root.left, level - 1);
        printGivenLevel(root.right, level - 1);
    }
}
