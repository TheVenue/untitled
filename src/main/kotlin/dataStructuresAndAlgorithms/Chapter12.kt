package dataStructuresAndAlgorithms

/*
 * Improve the Unique Paths from Chapter 11 using memoization.
 */
private fun main() {
    val uniquePaths = uniquePaths(7,3)
    println(uniquePaths.toString())
}

/* Given a grid represented by a number of rows and columns.
 * Calculate the number of possible "shortest" paths from
 * the upper leftmost square to the bottom rightmost square.
 * For example: [S][][][][][][]
 *              [][][][ ][][][]
 *              [][][][][][][F]
 *
 * 1. Imagine the function already exists.
 * 2. Identify the base case: 0, 0
 * 3. Identify the sub-problem: [S][][][][][]
 *                              [][][][][][F]
 *                                   or
 *                                  6,2
 * 4. See what happens when we call the function on our sub-problem.
 */
private fun uniquePaths(rows: Int, columns: Int, memo: MutableMap<Pair<Int, Int>, Int> = mutableMapOf()): Int {
    return if (rows == 1 || columns == 1) {
        1
    } else if (memo[Pair(rows, columns)] != null) {
        memo[Pair(rows, columns)]!!
    } else {
        memo[Pair(rows, columns)] = uniquePaths(rows - 1, columns) + uniquePaths(rows, columns - 1)
        memo[Pair(rows, columns)]!!
    }
}