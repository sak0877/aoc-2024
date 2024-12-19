package day4

import ReadInput

fun ArrayList<String>.getMatrixTraversals(traversalType: String): ArrayList<String> {
    val rowSize = this.size
    val colSize = this[0].length
    val traversals = ArrayList<String>()

    when (traversalType) {
        "horizontal" -> {
            for (i in 0..<rowSize) {
                var str = ""
                for (j in 0..<colSize) {
                    str += this[i][j]
                }
                traversals.add(str)
            }
        }
        "vertical" -> {
            for (i in 0..<colSize) {
                var str = ""
                for (j in 0..<rowSize) {
                    str += this[j][i]
                }
                traversals.add(str)
            }
        }
        "topDiagonal" -> {
            for (c in 0..<colSize) {
                var str = ""
                for (r in 0..<rowSize) {
                    if (r + c < colSize) {
                        str += this[r][r + c]
                    }
                }
                traversals.add(str)
            }
        }
        "bottomDiagonal" -> {
            for (c in 1..<colSize) {
                var str = ""
                for (r in 0..<rowSize) {
                    if (r + c < rowSize) {
                        str += this[r + c][r]
                    }
                }
                traversals.add(str)
            }
        }
        "topAntiDiagonal" -> {
            for (c in 0..<colSize) {
                var str = ""
                for (r in 0..<rowSize) {
                    if (r + c < colSize) {
                        str += this[r][colSize - 1 - (r + c)]
                    }
                }
                traversals.add(str)
            }
        }
        "bottomAntiDiagonal" -> {
            for (r in 1..<rowSize) {
                var str = ""
                var col = colSize - 1
                for (row in r..<rowSize) {
                    if (col < colSize) {
                        str += this[row][col]
                    }
                    col--
                }
                traversals.add(str)
            }
        }
    }
    return traversals
}

fun countXmas(searchStr: String): Int {
    return when {
        searchStr.isEmpty() -> 0
        searchStr.startsWith("XMAS") || searchStr.startsWith("SAMX") ->
            1 + countXmas(searchStr.substring(1))
        else -> countXmas(searchStr.substring(1))
    }
}

fun ArrayList<String>.countXmasShape(): Int {
    val rowSize = this.size
    val colSize = this[0].length
    val getCondition: (Int, Int, Char, Char, Int) -> Boolean = { i, j, c1, c2, type ->
        if (type == 1)
            this[i][j] == 'A' && this[i-1][j-1] == c1 && this[i-1][j+1] == c1 && this[i+1][j-1] == c2 && this[i+1][j+1] == c2
        else
            this[i][j] == 'A' && this[i-1][j-1] == c1 && this[i-1][j+1] == c2 && this[i+1][j-1] == c1 && this[i+1][j+1] == c2
    }
    var count = 0
    for (i in 1..<rowSize - 1) {
        for (j in 1..<colSize - 1) {
            val condition1 = getCondition(i, j, 'M', 'S', 1) /* M.M
                                                                .A.
                                                                S.S */
            val condition2 = getCondition(i, j, 'S', 'M', 1) /* S.S
                                                                .A.
                                                                M.M */
            val condition3 = getCondition(i, j, 'M', 'S', 2) /* M.S
                                                                .A.
                                                                M.S */
            val condition4 = getCondition(i, j, 'S', 'M', 2) /* S.M
                                                                .A.
                                                                S.M */
            if (condition1 || condition2 || condition3 || condition4) {
                count++
            }
        }
    }
    return count
}

fun main() {
    val input = ReadInput.getInput("inputs/input.txt")
    var count = 0
    arrayOf(
        "horizontal", "vertical", "topDiagonal",
        "bottomDiagonal", "topAntiDiagonal", "bottomAntiDiagonal"
    ).forEach { traversalType ->
        input.getMatrixTraversals(traversalType).forEach { traversalStr ->
            count += countXmas(traversalStr)
        }
    }
    println(count)
    println(input.countXmasShape())
}