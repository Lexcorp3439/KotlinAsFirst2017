@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import lesson1.task1.sqr
import java.lang.Math.*
import java.sql.SQLRecoverableException

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (m in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
        when {
            n == m -> 1
            n < 10 -> 0
            else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
        }

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 */
fun digitNumber(n: Int): Int {
    var x = n / 10
    var result = 1

    while (x != 0) {
        x /= 10
        result += 1
    }
    return result
}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {//= if (n > 2) fib(n - 1) + fib(n - 2) else 1
    var now = 1
    var last = 1

    for (i in 2 until n){
        val x = now
        now += last
        last = x
    }
    return now
}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var n1 = n
    var m1 = m

    while (n1 != m1)
        if (n1 > m1) m1 += m
        else n1 += n
    return n1
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    for (i in 2 until n)
        if (n % i == 0) return i
    return n
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    for (i in n - 1 downTo 2)
        if (n % i == 0) return i
    return 1
}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    val end = min(m, n)

    for (i in 2..end)
        if (m % i == 0 && n % i == 0) return false
    return true
}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    for (k in m..n) {
        val floorK = floor(sqrt(k.toDouble()))
        if (sqr(floorK) >= m) return true
    }
    return false
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun sin(x: Double, eps: Double): Double {
    val sqrX = normalize(x)
    var reply = sqrX
    var digit = 2
    var divider = sqrX

    while (abs(divider) >= eps) {
        divider *= sqrX * sqrX / (digit * (digit + 1))
        if (digit / 2 % 2 == 1) reply -= divider
        else reply += divider
        digit += 2
    }
    return reply
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun normalize(x: Double): Double {
    var x1 = x

    while (abs(x1) > 2 * PI)
        if (x1 < 0) x1 += 2 * PI else x1 -= 2 * PI
    return x1
}

fun cos(x: Double, eps: Double): Double {
    val sqrX = sqr(normalize(x))
    var reply = 1.0
    var divider = reply
    var i = 0
    var digit = 1

    while (abs(divider) >= eps) {
        i++
        divider *= sqrX / (digit * (digit + 1))
        if (i % 2 == 1) reply -= divider
        else reply += divider
        digit += 2
    }
    return reply
}

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 * Не использовать строки при решении задачи.
 */
fun revert(n: Int): Int {
    var new = 0
    var n1 = n

    while (n1 > 0) {
        new = new * 10 + n1 % 10
        n1 /= 10
    }
    return new
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 */
fun isPalindrome(n: Int): Boolean {
    val all = digitNumber(n) / 2
    val ten = pow(10.0, all.toDouble()).toInt()
    val nPart = n % ten
    val nReversed = revert(n / ten) % ten

    return nPart == nReversed
}

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 */
fun hasDifferentDigits(n: Int): Boolean {
    val size = digitNumber(n)
    var found = 0
    val firstDig = n % 10

    for (i in 0 until size)
        found = found * 10 + firstDig
    return found != n
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 */
fun squareSequenceDigit(n: Int): Int {
    var k = 2
    var num = 1

    while (num < n) {
        val sqr = (k * k).toString()
        val size = sqr.length
        if (num + size >= n) return sqr[n - num - 1] - '0'
        else num += size
        k++
    }
    return 1
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 */
fun fibSequenceDigit(n: Int): Int {
    var finNext = 1
    var fibNow = 1
    var num = 2

    while (num < n) {
        val fib = (finNext + fibNow).toString()
        val size = fib.length
        if (num + size >= n) return fib[n - num - 1] - '0'
        else num += size
        fibNow = finNext
        finNext = fib.toInt()
    }
    return 1
}
