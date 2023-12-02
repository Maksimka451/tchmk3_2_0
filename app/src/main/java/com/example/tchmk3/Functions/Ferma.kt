package com.example.tchmk3.Functions

import kotlin.math.sqrt

fun fermatFactorization(n: Long): String {
    val a = sqrt(n.toDouble()).toLong() + 1

    for (x in a..n) {
        val ySquare = x * x - n
        val y = sqrt(ySquare.toDouble()).toLong()

        if (y * y == ySquare) {
            val p = x + y
            val q = x - y

            return "$p & $q"
        }
    }

    throw IllegalArgumentException("Не удалось выполнить факторизацию числа $n")
}

