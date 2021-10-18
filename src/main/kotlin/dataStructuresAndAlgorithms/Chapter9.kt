package dataStructuresAndAlgorithms

private fun main() {
    val reversedInput = reverseString("abcde")
    println(reversedInput)
}

/* Use a stack to reverse a string.
 * Input: "abcde"
 * Output: "edcba"
 */
private fun reverseString(input: String): String {
    val stack = Stack(input)
    val reversedString = StringBuilder()
    while (stack.read() != null) {
        reversedString.append(stack.pop())
    }
    return reversedString.toString()
}

private class Stack(private val input: String) {
    private val listOfCharacters = mutableListOf<Char>()

    init {
        for (char in input) {
            push(char)
        }
    }

    private fun push(char: Char) {
        listOfCharacters.add(char)
    }

    fun pop(): Char? {
        val lastCharacter = read()
        if (listOfCharacters.isNotEmpty()) {
            listOfCharacters.removeLast()
        }
        return lastCharacter
    }

    fun read(): Char? {
        return if (listOfCharacters.isEmpty()) {
            null
        } else {
            listOfCharacters.last()
        }
    }
}