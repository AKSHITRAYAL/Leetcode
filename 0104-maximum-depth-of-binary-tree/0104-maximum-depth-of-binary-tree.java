// class Solution {
//     public int maxDepth(TreeNode root) {
//         if (root == null) return 0;

//         Queue<TreeNode> elementQueue = new LinkedList<>();
//         elementQueue.add(root);
//         int numberOfLevels = 0;

//         while (!elementQueue.isEmpty()) {
//             int nodeCountAtLevel = elementQueue.size();

//             while (nodeCountAtLevel > 0) {
//                 TreeNode element = elementQueue.poll();

//                 if (element.left != null)
//                     elementQueue.add(element.left);
//                 if (element.right != null)
//                     elementQueue.add(element.right);

//                 nodeCountAtLevel--;
//             }
//             numberOfLevels++;
//         }

//         return numberOfLevels;
//     }
// }

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}