import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Q2 {

    public static TreeNode buildTree(String[] values) {
        if (values.length == 0 || values[0].equals("null")) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);

        int index = 1;
        while (!queue.isEmpty() && index < values.length) {
            TreeNode current = queue.poll();

            if (index < values.length && !values[index].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(values[index]));
                queue.add(current.left);
            }
            index++;

            if (index < values.length && !values[index].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(values[index]));
                queue.add(current.right);
            }
            index++;
        }

        return root;
    }

    public static int maxPathSum(TreeNode root) {
        int[] maxSum = new int[] { Integer.MIN_VALUE };
        dfs(root, maxSum);
        return maxSum[0];
    }

    private static int dfs(TreeNode node, int[] maxSum) {
        if (node == null) {
            return 0;
        }

        int leftMax = Math.max(0, dfs(node.left, maxSum));
        int rightMax = Math.max(0, dfs(node.right, maxSum));

        int currentMax = node.val + leftMax + rightMax;
        maxSum[0] = Math.max(maxSum[0], currentMax);

        return node.val + Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] values = input.split(" ");

        TreeNode root = buildTree(values);
        int result = maxPathSum(root);
        System.out.println(result);

        scanner.close();
    }
}