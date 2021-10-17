package dataStructuresAndAlgorithms

fun main() {
    val tree = mutableListOf(1, 2, 3,
                            mutableListOf(4, 5, 6), 7,
                            mutableListOf(8),
                            mutableListOf(9, 10, 11, mutableListOf(12, 13, 14)),
                            mutableListOf(15, 16, 17, 18, 19, mutableListOf(20, 21, 22,
                            mutableListOf(23, 24, 25, mutableListOf(26, 27, 28)), 29, 30), 31), 32)

    printListOf(tree)
}
/* Return a list of values from an array containing
 * numbers as well as other arrays, which in turn contains
 * numbers and arrays.
 * Input: [ 1,
 *          2,
 *          3,
 *          [4, 5, 6],
 *          7,
 *          [8]]
 * Output: 1, 2, 3, 4, 5, 6, 7, 8
 */
private fun printListOf(tree: MutableList<*>) {
    tree.forEach { child ->
        if (child is MutableList<*>) {
            printListOf(child)
        } else {
            println(child.toString())
        }
    }
}