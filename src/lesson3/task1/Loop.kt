@file:Suppress("UNUSED_PARAMETER")
package lesson3.task1

import java.lang.Math.*

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
    for (m in 2..n/2) {
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
    var x = n
    var result = 0

    if (n == 0) return 1 else
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
fun fib(n: Int): Int = if (n > 2)  fib(n - 1) + fib(n - 2)  else 1

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    for (k in 1 until  n*m)
        if (k % m == 0 && k % n == 0) return k
    return n*m
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
    for (i in n-1 downTo 2)
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
    var bool = true
    val end = min(m,n)

    for (i in 2..end) if (m % i ==0 && n % i == 0) bool = false
    return bool
}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    var bool = false
    val end = round(sqrt(n.toDouble()))
    val range = (m..n)

    for (i in 0..end) if (i*i in range) bool = true
    return bool
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun sin(x: Double, eps: Double): Double {
    val sqrX = notmalize(x)
    var ret = sqrX
    var i = 0
    var digit = 2
    var divider = sqrX

    while (abs(divider) >= eps) {
        i++
        divider *= sqrX * sqrX / (digit * (digit + 1))
        if (i % 2 == 1) ret -= divider else ret += divider
        digit += 2
    }
    return ret
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun notmalize (x:Double): Double{
    var x1 = x

    while (abs(x1) > 2 * PI)
        if (x1 < 0) x1 += 2 * PI else x1-= 2 * PI
    return x1
}

fun cos(x: Double, eps: Double): Double {
    val sqrX = notmalize(x)*notmalize(x)
    var ret = 1.0
    var divider = ret
    var i = 0
    var digit = 1

    while (abs(divider) >= eps) {
        i++
        divider *= sqrX / (digit * (digit + 1))
        if (i % 2 == 1) ret -= divider else ret += divider
        digit += 2
    }
    return ret
}

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 * Не использовать строки при решении задачи.
 */
fun revert(n: Int): Int {
    var new= 0
    var n1 = n
    val all = n.toString().length

    for (i in 0 until all){
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
    val all = n.toString().length / 2
    val ten = pow(10.0, all.toDouble()).toInt()
    val nReversed = (n / 10).toString().reversed().toInt()

    return if (abs(n) < 10) true
    else n % ten == nReversed % ten
}

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 */
fun hasDifferentDigits(n: Int): Boolean {
    var n1 = n
    var found = 0
    val firstDig = n % 10

    while (n1 > 0){
        found = found * 10 + firstDig
        n1 /= 10
    }
    return (found != n)
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 */
fun squareSequenceDigit(n: Int): Int {
    var k = 1
    var sqr:Int
    var num = 0
    var size:Int
    var ret = 0.0

    while (num < n) {
        sqr = k * k
        size = sqr.toString().length
        var ten = pow(10.0, (size - 1).toDouble()).toInt()
        for (i in 0 until size) {
            ret = sqr / ten.toDouble()
            num ++
            sqr %= ten
            ten /= 10
            if (num == n) break
        }
        k += 1
    }
    return ret.toInt()
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 */
fun fibSequenceDigit(n: Int): Int  {
    var finNext = 1
    var fibNow = 1
    var num = 2
    var ret = 0.0

    if (n in 1..2 ) return 1 else
    while (num < n) {
        var fib = finNext + fibNow
        val size = fib.toString().length
        var ten = pow(10.0, (size - 1).toDouble()).toInt()
        fibNow = finNext
        finNext = fib
        for (i in 0 until size){
            ret = fib / ten.toDouble()
            num ++
            fib %= ten
            ten /= 10
            if (num == n) break
        }

    }
    return ret.toInt()
}
