package dataStructuresAndAlgorithms

private fun main() {
    buildTree()
}

private fun buildTree() {
    val node1 = TreeNode(25)
    val node2 = TreeNode(75)
    val rootNode = TreeNode(value = 50, left = node1, right = node2)
}

private class TreeNode(val value: Int, var left: TreeNode? = null, var right: TreeNode? = null)

private class BinarySearchTree() {
    /**
     * 1. Imagine the function already exists.
     * 2. Identify the sub-problem.
     *      [25, 50, 75]
     *      [50, 75]
     * 3. Call the function on that sub-problem and watch what happens.
     */
    fun search(searchValue: Int, node: TreeNode? = null): TreeNode? {
        return if (node == null || node.value == searchValue) {
            node
        } else if (searchValue > node.value) {
            node.right
        } else /*searchValue < node.value*/ {
            node.left
        }
    }

    /**
     * 1. Imagine the function already exists.
     * 2. Identify the sub-problem.
     *      [25, 50, 75]
     *      [75]
     * 3. Call the function on the sub-problem and watch what happens.
     */
    fun insert(value: Int, node: TreeNode) {
        if (value < node.value) {
            node.left?.let { leftNode ->
                insert(value, leftNode)
            } ?: run {
                node.left = TreeNode(value)
            }
        } else if (value > node.value) {
            node.right?.let { rightNode ->
                insert(value, rightNode)
            } ?: run {
                node.right = TreeNode(value)
            }
        }
    }
}