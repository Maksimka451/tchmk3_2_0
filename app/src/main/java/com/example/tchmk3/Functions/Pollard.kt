package com.example.tchmk3.Functions

import java.math.BigInteger

fun pollardPMinusOneFactorization(n: BigInteger, pMinusOne: BigInteger): BigInteger {
    var a = BigInteger.valueOf(2) // Начальное значение a
    var g = a.modPow(pMinusOne, n) // Вычисляем a в степени (p-1) по модулю n
    g = a.subtract((BigInteger.ONE).gcd(n))

    while (g == BigInteger.ONE) {
        a = a.modPow(pMinusOne, n) // Вычисляем a в степени (p-1) по модулю n
        g = a.subtract(BigInteger.ONE).gcd(n) // Находим НОД(a-1, n)
    }

    return when {
        g != BigInteger.ONE && g != n -> g // Найден множитель
        else -> BigInteger.ONE.negate() // Множитель не найден
    }
}