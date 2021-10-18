package dataStructuresAndAlgorithms

private fun main() {
    val intersectedArray = intersection(mutableListOf(0, 2, 4, 6, 8, 1, 3, 23, 100, 20, 30, 80, 90), mutableListOf(1, 2, 3, 4))
    println(intersectedArray)

    val duplicatedString = checkForDuplicates(mutableListOf("a", "b", "c", "d", "c", "e", "f"))
    println(duplicatedString)

    val stringOfCharacters = checkForMissingCharacter("the quick brown box jumps over a lazy dog")
    println(stringOfCharacters)

    val uniqueCharacter = findUniqueCharacter("minimum")
    println(uniqueCharacter)
}

/* Return the intersection of two given arrays
 * input [1, 2, 3, 4, 5] [0, 2, 4, 6, 8]
 * output [2, 4]
 * Must be O(N)
 */
private fun intersection(listOne: MutableList<Int>, listTwo: MutableList<Int>) : MutableList<Int> {
    val mapOfFirstList = mutableMapOf<Int, Boolean>()
    for (num in listOne) {
        mapOfFirstList[num] = true
    }

    val result = mutableListOf<Int>()
    for (num in listTwo) {
        if (mapOfFirstList[num] == true) {
            result.add(num)
        }
    }

    return result
}

/* Return the first character that is repeated
 * input ["a", "b", "c", "d", "c", "e", "f"]
 * output "c"
 * Must be O(N)
 */
private fun checkForDuplicates(listOfCharacters: MutableList<String>) : String {
    val hashTableOfExistingCharacters = mutableMapOf<String, Boolean>()
    for (character in listOfCharacters) {
        if (hashTableOfExistingCharacters[character] == true) {
            return character
        } else {
            hashTableOfExistingCharacters[character] = true
        }
    }
    return "No Duplicates"
}

/* Return the missing character
 * input: "the quick brown box jumps over a lazy dog"
 * output: "f"
 * Must be O(N)
 */
private fun checkForMissingCharacter(input: String) : String {
    val charactersPresent = mutableMapOf<Char, Boolean>()
    for (char in input) {
        charactersPresent[char] = true
    }

    val alphabet = "abcdefghijklmnopqrstuvwxyz"
    for (char in alphabet) {
        if (charactersPresent[char] != true) {
            return char.toString()
        }
    }

    return "No missing characters"
}

/* Return the first unique character
 * Input: "minimum"
 * Output: "n"
 * Must be O(N)
 */
private fun findUniqueCharacter(input: String) : String {
    val characterCount = mutableMapOf<Char, Int>()
    for (char in input) {
        characterCount[char] = characterCount[char]?.plus(1) ?: 1
    }

    for (char in input) {
        characterCount[char]?.let { count ->
            if (count == 1) {
                return char.toString()
            }
        }
    }

    return "No unique characters"
}