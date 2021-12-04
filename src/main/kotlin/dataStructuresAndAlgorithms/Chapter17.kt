package dataStructuresAndAlgorithms

private fun main() {
    val trie = Trie()
    trie.insert("hustling")
    trie.insert("can")
    trie.insert("cat")
    trie.insert("guap")
    trie.insert("chea")
    trie.traverse(trie.root)
}

private class TrieNode(val children: MutableMap<String, TrieNode?> = mutableMapOf())

private class Trie(val root: TrieNode? = TrieNode()) {

    fun traverse(rootNode: TrieNode?) {
        val currentNode = rootNode ?: root
        currentNode?.children?.values?.let { children ->
            children.forEachIndexed { index, trieNode ->
                val key = currentNode.children.keys.toMutableList()[index]
                println(key)
                if (key != "*") {
                    traverse(trieNode)
                }
            }
        }
    }

    fun insert(insertString: String) {
        var currentNode = root
        for (char in insertString) {
            currentNode?.children?.get(char.toString())?.let { nextNode ->
                currentNode = nextNode
            } ?: run {
                val newNode = TrieNode()
                currentNode?.children?.getOrPut(char.toString()) { newNode }
                currentNode = newNode
            }
        }
        currentNode?.children?.set("*", null)
    }

    fun search(searchString: String): TrieNode? {
        var currentNode = root
        for (char in searchString) {
            currentNode?.children?.get(char.toString())?.let { nextNode ->
                currentNode = nextNode
            } ?: run {
                currentNode = null
            }
        }
        return currentNode
    }
}