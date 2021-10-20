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

 * mutableListOf(4, 6, 2, 5, 7, 6, 3, 7, 6, 9)
 * index = 1
 * tempValue = 6
 * position = 0


 * if 4 > 6
 * break
 * index = 2


 * tempValue = 2
 * position = 1
 * if 6 > 2
 * list[2] = list[1] (4, 6, 2, 5, 7, 6, 3, 7, 6, 9)
 *                   (4, 6, 6, 5, 7, 6, 3, 7, 6, 9)
 *                   position = 0
 * list[1] = 2      (4, 6, 6, 5, 7, 6, 3, 7, 6, 9)
 *                  (4, 2, 6, 5, 7, 6, 3, 7, 6, 9)
 *
 * if (4 > 2)
 * list[1] = list[0] (4, 2, 6, 5, 7, 6, 3, 7, 6, 9)
 *                   (4, 4, 6, 5, 7, 6, 3, 7, 6, 9)
 *                   position = -1
 * list[0] = 2       (4, 4, 6, 5, 7, 6, 3, 7, 6, 9)
 *                   (2, 4, 6, 5, 7, 6, 3, 7, 6, 9)
 * index = 3


 * tempValue = 5
 * position = 2
 *
 * if 6 > 5
 * list[3] = list[2]    (2, 4, 6, 5, 7, 6, 3, 7, 6, 9)
 *                      (2, 4, 6, 6, 7, 6, 3, 7, 6, 9)
 *                      position = 1
 * list[2] = 5          (2, 4, 6, 6, 7, 6, 3, 7, 6, 9)
 *                      (2, 4, 5, 6, 7, 6, 3, 7, 6, 9)
 *
 * while 1 > 0
 * if 4 > 5
 * break
 * index = 4


 * tempValue = 7
 * position = 3
 * if 6 > 7
 * break
 * index = 5


 * tempValue = 6
 * position = 4
 * if 7 > 6
 * list[5] = list[4]
 * (2, 4, 5, 6, 7, 6, 3, 7, 6, 9)
 * (2, 4, 5, 6, 7, 7, 3, 7, 6, 9)
 * position = 3
 * end if
 * list[4] = 6
 * (2, 4, 5, 6, 7, 7, 3, 7, 6, 9)
 * (2, 4, 5, 6, 6, 7, 3, 7, 6, 9)
 * index = 6
 *
 * Data: traversingEndIndex (TEI), currentValue (CV), and comparingLeftIndex (CLI)
 *
 * Initialization:
 * TEI = 1
 * while 1 > list.size, so if the list is 1, it is already sorted and we don't sort.
 *
 * Loop for every step forward:
 * CV = value at TEI
 * CLI = begins immediately left at TEI
 * Inner loop beginning at CLI:
 * if CLI is greater than our CV we change the CLI + 1 to CLI
 * we then decrement CLI
 * we then set CLI plus one to the CV
 */
private fun insertionSort(listOfNumbers: MutableList<Int>) {
    var traversingEndIndex = 1
    while (traversingEndIndex < listOfNumbers.size) {
        val currentValue = listOfNumbers[traversingEndIndex]
        var comparingLeftIndex = traversingEndIndex - 1

        while (comparingLeftIndex >= 0) {
            if (listOfNumbers[comparingLeftIndex] > currentValue) {
                listOfNumbers[comparingLeftIndex + 1] = listOfNumbers[comparingLeftIndex]
                comparingLeftIndex -= 1
            } else {
                break
            }
            listOfNumbers[comparingLeftIndex + 1] = currentValue
        }
        traversingEndIndex++
    }
}