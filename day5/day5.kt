package day5

import ReadInput

fun List<Int>.checkValid(orders: MutableMap<Int, MutableList<Int>>): Boolean {
    for (i in indices) {
        for (j in indices) {
            if (i != j && orders[this[j]]?.contains(this[i]) == true) {
                if (j > i ) {
                    return false
                }
            }
        }
    }
    return true
}

fun main() {
    val input = ReadInput.getInput("inputs/day5_input.txt")
    val orders = mutableMapOf<Int, MutableList<Int>>()
    val updates = mutableListOf<List<Int>>()
    input.forEach { entry ->
        if ("|" in entry) {
            val split = entry.split("|").map { it.toInt() }
            val pair = Pair(split[0], split[1])
            if (pair.first !in orders.keys) {
                orders[pair.first] = mutableListOf(pair.second)
            } else {
                orders[pair.first]?.add(pair.second)
            }
        }
        if ("," in entry) {
            val split = entry.split(",").map { it.toInt() }
            updates.add(split)
        }
    }
    val middles = mutableListOf<Int>()
    updates.forEach {
        if (it.checkValid(orders)) {
            middles.add(it[it.size / 2])
        }
    }
    println(orders); println(updates)
    println(middles.sum())
}
