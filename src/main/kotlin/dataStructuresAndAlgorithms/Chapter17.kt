package dataStructuresAndAlgorithms

private fun main() {
    val trie = Trie()
    trie.insert("cat")
    trie.insert("catnip")
    trie.insert("catnap")
    trie.autocorrect("catnar")
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

    fun collectAllWords(
        node: TrieNode? = null,
        word: String = "",
        words: MutableList<String> = mutableListOf()
    ): MutableList<String> {
        val currentNode = node ?: root
        currentNode?.children?.values?.let { children ->
            children.forEachIndexed { index, childNode ->
                val keys = currentNode.children.keys.toMutableList()
                if (keys[index] == "*") {
                    words.add(word)
                } else {
                    collectAllWords(childNode, word + keys[index], words)
                }
            }
        }
        return words
    }

    /**
     * 1. Imagine the function already exists.
     * 2. Identify the base case.
     *    Identify the sub-problem.
     *    catnar
     *    catna
     * 3. Call the function on that sub-problem and watch what happens.
     */
    fun autocorrect(word: String): String {
        var currentNode = root
        var wordsFoundSoFar = ""
        for (char in word) {
            if (currentNode?.children?.get(char.toString()) != null) {
                wordsFoundSoFar += char.toString()
                currentNode = currentNode.children[char.toString()]
            } else {
                return wordsFoundSoFar + collectAllWords(currentNode)[0]
            }
        }
        return word
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