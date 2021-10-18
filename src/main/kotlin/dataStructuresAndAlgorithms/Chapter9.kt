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
    private val charactersInString = mutableListOf<Char>()

    init {
        for (char in input) {
            push(char)
        }
    }

    private fun push(char: Char) {
        charactersInString.add(char)
    }

    fun pop(): Char? {
        val lastCharacter = read()
        if (charactersInString.isNotEmpty()) {
            charactersInString.removeLast()
        }
        return lastCharacter
    }

    fun read(): Char? {
        return if (charactersInString.isEmpty()) {
            null
        } else {
            charactersInString.last()
        }
    }
}