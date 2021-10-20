package dataStructuresAndAlgorithms

private fun main() {
    println(bubbleSortAndReturnGreatestProduct(mutableListOf(4, 6, 2, 5, 7, 6, 3, 7, 6, 9)))
}

/* Given an array of positive numbers, return the greatest product
 * of three numbers. Use sorting to implement the function in a way
 * that it computes at O(N log N)
 * Input: mutableListOf(4, 6, 2, 5, 7, 6, 3, 7, 6, 9)
 *
 * Initial setup
 * unsortedUntilIndex (uui) = 9
 * sorted (s) = false
 *
 * First Cycle
 * sorted = true
 * i = 0
 * while (0 < 9) {
 *   startValue = 4
 *   swapValue = 6
 *   if (startValue > swapValue) {
 *
 *   }
 * }
 * i++
 *
 *  while (1 < 9) {
 *   startValue = 6
 *   swapValue = 2
 *   if (startValue > swapValue) {
 *     list[1] = swapValue
 *     list[2] = startValue
 *     since we completed a swap we set sorted back to false,
 *     we need to complete an entire traversal without swapping first
 *   }
 * }
 * i++
 *
 * ........continue til 9
 */
private fun bubbleSortAndReturnGreatestProduct(listOfNumbers: MutableList<Int>): Int {
    var unsortedUntilIndex = listOfNumbers.size - 1
    var sorted = false

    while (!sorted) {
        sorted = true
        var i = 0
        while (i < unsortedUntilIndex) {
            listOfNumbers.getOrNull(i)?.let { startValue ->
                listOfNumbers.getOrNull(i + 1)?.let { swapValue ->
                    if (startValue > swapValue) {
                        listOfNumbers[i] = swapValue
                        listOfNumbers[i + 1] = startValue
                        sorted = false
                    }
                }
            }
            i++
        }
        unsortedUntilIndex -= 1
    }

    val thirdLargest = listOfNumbers.getOrNull(listOfNumbers.size - 3) ?: 1
    val secondLargest = listOfNumbers.getOrNull(listOfNumbers.size - 2) ?: 1
    val largest = listOfNumbers.getOrNull(listOfNumbers.size - 1) ?: 0
    return largest * secondLargest * thirdLargest
}

