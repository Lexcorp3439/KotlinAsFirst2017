package lesson3.task1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

class Tests {
    @Test
    @Tag("Example")
    fun factorial() {
        assertEquals(1.0, factorial(0), 1e-5)
        assertEquals(1.0, factorial(1), 1e-5)
        assertEquals(6.0, factorial(3), 1e-5)
        assertEquals(120.0, factorial(5), 1e-5)
        assertEquals(3628800.0, factorial(10), 1e-5)
        assertEquals(2.43290200817664E18, factorial(20), 1E10)
    }

    @Test
    @Tag("Example")
    fun isPrime() {
        assertTrue(isPrime(2))
        assertTrue(isPrime(3))
        assertTrue(isPrime(19))
        assertTrue(isPrime(53))
        assertFalse(isPrime(1))
        assertFalse(isPrime(9))
        var count = 0
        for (n in 2..7919) {
            if (isPrime(n)) {
                count++
            }
        }
        assertEquals(1000, count)
        for (n in 2..1000000) {
            if (isPrime(n)) {
                count++
            }
        }
        assertEquals(79498, count)
    }

    @Test
    @Tag("Example")
    fun isPerfect() {
        assertTrue(isPerfect(6))
        assertTrue(isPerfect(28))
        assertFalse(isPerfect(100))
    }

    @Test
    @Tag("Example")
    fun digitCountInNumber() {
        assertEquals(4, digitCountInNumber(5373393, 3))
        assertEquals(2, digitCountInNumber(100, 0))
        assertEquals(1, digitCountInNumber(0, 0))
    }

    @Test
    @Tag("Trivial")
    fun digitNumber() {
        assertEquals(1, digitNumber(0))
        assertEquals(1, digitNumber(7))
        assertEquals(2, digitNumber(10))
        assertEquals(2, digitNumber(99))
        assertEquals(3, digitNumber(123))
        assertEquals(10, digitNumber(Int.MAX_VALUE))
    }

    @Test
    @Tag("Easy")
    fun fib() {
        assertEquals(1, fib(1))
        assertEquals(1, fib(2))
        assertEquals(2, fib(3))
        assertEquals(5, fib(5))
        assertEquals(21, fib(8))
        assertEquals(102334155, fib(40))
        assertEquals(1134903170, fib(45))
        assertEquals(1836311903, fib(46))
        // Just to calculate it
        fib(50)
    }

    @Test
    @Tag("Easy")
    fun lcm() {
        assertEquals(13, lcm(13, 13))
        assertEquals(8, lcm(2, 8))
        assertEquals(24, lcm(6, 8))
        assertEquals(975, lcm(39, 75))
        assertEquals(13384091, lcm(1357, 9863))
        assertEquals(1339310349, lcm(13579, 98631))
        assertEquals(2089830349, lcm(23579, 88631))
        assertEquals(2022222222, lcm(2, 1011111111))
        assertEquals(2022222222, lcm(1011111111, 2))
    }

    @Test
    @Tag("Easy")
    fun minDivisor() {
        assertEquals(2, minDivisor(2))
        assertEquals(3, minDivisor(75))
        assertEquals(5, minDivisor(75 / 3))
        assertEquals(97, minDivisor(97))
        assertEquals(7, minDivisor(49))
        assertEquals(17, minDivisor(8653))
        assertEquals(2124679 , minDivisor(2124679 ))
        assertEquals(1073676287, minDivisor(1073676287))
        assertEquals(Int.MAX_VALUE, minDivisor(Int.MAX_VALUE))
    }

    @Test
    @Tag("Easy")
    fun maxDivisor() {
        assertEquals(1, maxDivisor(17))
        assertEquals(12, maxDivisor(24))
        assertEquals(59, maxDivisor(177))
        assertEquals(17, maxDivisor(34))
        assertEquals(7, maxDivisor(49))
        assertEquals(509, maxDivisor(8653))
        assertEquals(1 , maxDivisor(2124679 ))
        assertEquals(1, maxDivisor(1073676287))
        assertEquals(1, maxDivisor(Int.MAX_VALUE))
    }

    @Test
    @Tag("Easy")
    fun isCoPrime() {
        assertTrue(isCoPrime(25, 49))
        assertFalse(isCoPrime(6, 8))
        assertTrue(isCoPrime(17, 97))
        assertFalse(isCoPrime(37, 111))
        assertTrue(isCoPrime(1234567890, 908765431))
        assertTrue(isCoPrime(2109876543, 1234567891))
    }

    @Test
    @Tag("Easy")
    fun squareBetweenExists() {
        assertTrue(squareBetweenExists(1, 1))
        assertTrue(squareBetweenExists(21, 28))
        assertFalse(squareBetweenExists(51, 61))
        assertFalse(squareBetweenExists(999, 1001))
        assertTrue(squareBetweenExists(152374337, 152423715))
        assertFalse(squareBetweenExists(2147395601, Int.MAX_VALUE))
    }

    @Test
    @Tag("Normal")
    fun sin() {
        assertEquals(0.0, sin(0.0, 1e-5), 1e-5)
        assertEquals(1.0, sin(Math.PI / 2.0, 1e-5), 1e-5)
        assertEquals(0.0, sin(Math.PI, 1e-5), 1e-5)
        assertEquals(-1.0, sin(3.0 * Math.PI / 2.0, 1e-5), 1e-5)
        assertEquals(0.0, sin(100 * Math.PI, 1e-5), 1e-5)
    }

    @Test
    @Tag("Normal")
    fun cos() {
        assertEquals(1.0, cos(0.0, 1e-5), 1e-5)
        assertEquals(0.0, cos(Math.PI / 2.0, 1e-5), 1e-5)
        assertEquals(-1.0, cos(Math.PI, 1e-5), 1e-5)
        assertEquals(0.0, cos(3.0 * Math.PI / 2.0, 1e-5), 1e-5)
        assertEquals(1.0, cos(100 * Math.PI, 1e-5), 1e-5)
    }

    @Test
    @Tag("Normal")
    fun revert() {
        assertEquals(87431, revert(13478))
        assertEquals(0, revert(0))
        assertEquals(3, revert(3))
        assertEquals(111, revert(111))
        assertEquals(17571, revert(17571))
        assertEquals(123456789, revert(987654321))
    }

    @Test
    @Tag("Normal")
    fun isPalindrome() {
        assertTrue(isPalindrome(3))
        assertFalse(isPalindrome(3653))
        assertTrue(isPalindrome(15751))
        assertTrue(isPalindrome(24688642))
        assertTrue(isPalindrome(902040209)) // ошибка из-за нулей
        assertFalse(isPalindrome(2147483647)) //слишком большое число
    }

    @Test
    @Tag("Normal")
    fun hasDifferentDigits() {
        assertTrue(hasDifferentDigits(323))
        assertTrue(hasDifferentDigits(54))
        assertTrue(hasDifferentDigits(222266666))
        assertFalse(hasDifferentDigits(0))
        assertFalse(hasDifferentDigits(777)) //Реши вопрос с одинаковыми числами
        assertTrue(hasDifferentDigits(55514376)) // сделай проверку только по первой цифре, а не по всем
    }

    @Test
    @Tag("Hard")
    fun squareSequenceDigit() {
        assertEquals(1, squareSequenceDigit(1))
        assertEquals(4, squareSequenceDigit(2))
        assertEquals(5, squareSequenceDigit(7))
        assertEquals(6, squareSequenceDigit(12))
        assertEquals(0, squareSequenceDigit(17))
        assertEquals(9, squareSequenceDigit(27))
    }

    @Test
    @Tag("Hard")
    fun fibSequenceDigit() {
        assertEquals(1, fibSequenceDigit(1))
        assertEquals(1, fibSequenceDigit(2))
        assertEquals(2, fibSequenceDigit(3))
        assertEquals(3, fibSequenceDigit(4))
        assertEquals(2, fibSequenceDigit(9))
        assertEquals(5, fibSequenceDigit(14))
        assertEquals(2, fibSequenceDigit(20)) //233
        assertEquals(0, fibSequenceDigit(233))
    }
}