package dataStructuresAndAlgorithms

private fun main() {
    val count = countCharacters(mutableListOf("ab", "c", "def", "ghij"))
    println(count.toString())

    val evenNumbers = findEvenNumbers(mutableListOf(9, 2, 4, 7, 4, 2, 9, 3))
    println(evenNumbers.toString())
}

/* Use recursion to return the total number of characters.
 * Input: ["ab", "c", "def", "ghij"]
 * Output: 10
 * 1. Imagine the function exists.
 * 2. Identify the base case: [], 0
 * 3. Identify the sub-problem: ["ab", "c", "def"], 4 *because subList(0, list.size - 1)
 * 5. See what happens when we call the function on the sub-problem.
 *
 * WALK THROUGH
 * ["ab", "c", "def", "ghij"], 0
 * Last index is non-inclusive in the sublist.
 * list.subListOf(0, length - 1) []
 * countCharacters(["ab", "c", "def"], 4)
 *
 * ["ab", "c", "def"], 4
 * countCharacters(["ab", "c"], 7)
 *
 * ["ab", "c"], 7
 * countCharacters(["ab"], 8)
 *
 * ["ab", 8]
 * countCharacters([], 10)
 *
 * []
 * return 10
 */
private fun countCharacters(listOfStrings: MutableList<String>, count: Int = 0): Int {
    return if (listOfStrings.isEmpty()) {
        count
    } else {
        countCharacters(
            listOfStrings = listOfStrings.subList(0, listOfStrings.size - 1),
            count = count + listOfStrings.last().length
        )
    }
}

/* Use recursion to return an array with even numbers present in a given list.
 * Input: [9, 2, 4, 7, 4, 2, 9, 3]
 * Output: [2, 4, 4, 2]
 * 1. Imagine the function exists.
 * 2. Identify the base case: [], []
 * 3. Identify the sub-problem: [9, 2, 4, 7, 4, 2, 9], [] *because list.subList(0, list.size - 1) && 3 % 2 == 1
 * 4. See what happens when we call the function on the sub-problem.
 */
private fun findEvenNumbers(
    listOfNumbers: MutableList<Int>,
    listOfEvens: MutableList<Int> = mutableListOf()
): MutableList<Int> {
    return if (listOfNumbers.isEmpty()) {
        listOfEvens
    } else {
        if (listOfNumbers.last() % 2 == 0) {
            listOfEvens.add(listOfNumbers.last())
        }
        findEvenNumbers(
            listOfNumbers = listOfNumbers.subList(0, listOfNumbers.size - 1),
            listOfEvens = listOfEvens
        )
    }
}