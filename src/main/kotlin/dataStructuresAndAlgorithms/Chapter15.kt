package dataStructuresAndAlgorithms

private fun main() {
    buildTree()
    buildBinarySearchTree()
}

private fun buildTree() {
    val node1 = TreeNode(25)
    val node2 = TreeNode(75)
    val rootNode = TreeNode(value = 50, left = node1, right = node2)
}

fun buildBinarySearchTree() {
    TODO("Not yet implemented")
}

private class TreeNode(var value: Int, var left: TreeNode? = null, var right: TreeNode? = null)

private class BinarySearchTree(var rootNode: TreeNode) {
    /**
     * 1. Imagine the function already exists.
     * 2. Identify the sub-problem.
     *      [25, 50, 75]
     *      [50, 75]
     * 3. Call the function on that sub-problem and watch what happens.
     *
     * @param searchValue the value we're looking for
     * @param node either null or the node that holds the value which is assigned through recursion
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
     *
     * @param value is the value we are inserting
     * @param node is the ancestor node for which our value will become through recursion
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

    fun delete(valueToDelete: Int, node: TreeNode?): TreeNode? {
        if (node == null) {
            return node
        } else if (valueToDelete < node.value) {
            node.left = delete(valueToDelete, node.left)
            return node
        } else if (valueToDelete > node.value) {
            node.right = delete(valueToDelete, node.right)
            return node
        } else if (valueToDelete == node.value) {
            return if (node.left == null) {
                node.right
            } else if (node.right == null) {
                node.left
            } else {
                node.right?.let { rightValue ->
                    node.right = lift(rightValue, node)
                }
                null
            }
        } else {
            return null
        }
    }

    private fun lift(node: TreeNode, nodeToDelete: TreeNode): TreeNode? {
        node.left?.let { leftNode ->
            node.left = lift(leftNode, nodeToDelete)
            return node
        } ?: run {
            nodeToDelete.value = node.value
            return node.right
        }
    }

    private fun findGreatestNumber(): Int? {
        var currentNode: TreeNode? = rootNode
        while (currentNode != null) {
            currentNode = currentNode.right
        }
        return currentNode?.value
    }
}