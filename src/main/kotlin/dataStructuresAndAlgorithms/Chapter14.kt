package dataStructuresAndAlgorithms

private fun main() {
    val node1 = Node("One")
    val node2 = Node("Two")
    val node3 = Node("Three")

    node1.nextNode = node2
    node2.nextNode = node3

    val linkedList = LinkedList(node1)
//    linkedList.printNodes()

    node3.prevNode = node2
    node2.prevNode = node1

    val doublyLinkedList = DoublyLinkedList(node1, node3)
//    doublyLinkedList.reversePrintNodes()

//    println(linkedList.getLastNode()?.data)

    val reversedLinkedList = linkedList.reverseList()
    println(reversedLinkedList?.printNodes())
}

private class Node(var data: String?) {
    var nextNode: Node? = null
    var prevNode: Node? = null
}

private class LinkedList(private val firstNode: Node) {

    fun printNodes() {
        var currentNode: Node? = firstNode
        while (currentNode != null) {
            println(currentNode.data)
            currentNode = currentNode.nextNode
        }
    }

    fun getLastNode() : Node? {
        var lastNode: Node? = firstNode
        while (lastNode?.nextNode != null) {
            lastNode = lastNode.nextNode
        }
        return lastNode
    }

    /**
     * [1, 2, 3, 4, 5, 6, 7]
     * 1. Imagine the function already exists.
     * 2. Identify the best case. [1]
     * 3. Identify the sub-problem. [2, 3, 4, 5, 6, 7]
     *
     * previous node was 1
     * 2 nextNode is now 1
     *
     * previous node was 2
     * 3 nextNode is now 2
     *
     * previous node was 3
     * 4 nextNode is now 3
     * 4. Call the function on the sub-problem and watch what happens.
     */
    fun reverseList() : LinkedList? {
        var previousNode: Node? = null
        var currentNode: Node? = firstNode

        while (currentNode != null) {
            val nextNode = currentNode.nextNode
            currentNode.nextNode = previousNode

            previousNode = currentNode
            currentNode = nextNode
        }

        previousNode?.let {
            return LinkedList(previousNode)
        } ?: run {
            return LinkedList(firstNode)
        }
    }

    fun deleteGivenNode(node: Node) {
        node.data = node.nextNode?.data
        node.nextNode = node.nextNode?.nextNode
    }
}

private class DoublyLinkedList(private val firstNode: Node, private val lastNode: Node) {

    fun reversePrintNodes() {
        var currentNode: Node? = lastNode
        while (currentNode != null) {
            println(currentNode.data)
            currentNode = currentNode.prevNode
        }
    }
}