package dataStructuresAndAlgorithms

private fun main() {
    println(sortAndReturnGreatestProduct(mutableListOf(4, 6, 2, 5, 7, 6, 3, 7, 6, 9)))

    val bubbleSortedList = mutableListOf(4, 6, 2, 5, 7, 6, 3, 7, 6, 9)
    bubbleSort(bubbleSortedList)
    println(bubbleSortedList)

    val selectionSortedList = mutableListOf(4, 6, 2, 5, 7, 6, 3, 7, 6, 9)
    selectionSort(selectionSortedList)
    println(selectionSortedList)

    val insertionSortedList = mutableListOf(4, 6, 2, 5, 7, 6, 3, 7, 6, 9)
    insertionSort(insertionSortedList)
    println(insertionSortedList)
}

private fun sortAndReturnGreatestProduct(listOfNumbers: MutableList<Int>): Int {
    listOfNumbers.sort()
    val thirdLargest = listOfNumbers.getOrNull(listOfNumbers.size - 3) ?: 1
    val secondLargest = listOfNumbers.getOrNull(listOfNumbers.size - 2) ?: 1
    val largest = listOfNumbers.getOrNull(listOfNumbers.size - 1) ?: 0
    return largest * secondLargest * thirdLargest
}

/**
 * Time Complexity of O(N²)
 */
private fun bubbleSort(listOfNumbers: MutableList<Int>) {
    var unsortedUntilIndex = listOfNumbers.size - 1
    var sorted = false
    while (!sorted) {
        sorted = true
        var i = 0
        while (i < unsortedUntilIndex) {
            listOfNumbers.getOrNull(i)?.let { currentValue ->
                listOfNumbers.getOrNull(i + 1)?.let { nextValue ->
                    if (nextValue < currentValue) {
                        listOfNumbers[i] = nextValue
                        listOfNumbers[i + 1] = currentValue
                        sorted = false
                    }
                }
            }
            i++
        }
        unsortedUntilIndex -= 1
    }
}

/**
 * Time Complexity of O(N²)
 */
private fun selectionSort(listOfNumbers: MutableList<Int>) {
    listOfNumbers.forEachIndexed { i, _ ->
        var lowestNumberIndex = i
        var j = i + 1

        while (j < listOfNumbers.size) {
            if (listOfNumbers[j] < listOfNumbers[lowestNumberIndex]) {
                lowestNumberIndex = j
            }
            j++
        }

        if (lowestNumberIndex != i) {
            val temp = listOfNumbers[i]
            listOfNumbers[i] = listOfNumbers[lowestNumberIndex]
            listOfNumbers[lowestNumberIndex] = temp
        }
    }
}

/**
 * Time Complexity of O(n²)
 */
private fun insertionSort(listOfNumbers: MutableList<Int>) {
    var index = 1
    while (index < listOfNumbers.size) {
        val tempValue = listOfNumbers[index]
        var position = index - 1

        while (position >= 0) {
            if (listOfNumbers[position] > tempValue) {
                listOfNumbers[position + 1] = listOfNumbers[position]
                position -= 1
            } else {
                break
            }
            listOfNumbers[position + 1] = tempValue
        }
        index++
    }
}