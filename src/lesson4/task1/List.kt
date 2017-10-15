@file:Suppress("UNUSED_PARAMETER")

package lesson4.task1

import lesson1.task1.discriminant
import lesson1.task1.sqr
import java.lang.Math.pow
import java.lang.Math.sqrt

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
        when {
            y < 0 -> listOf()
            y == 0.0 -> listOf(0.0)
            else -> {
                val root = Math.sqrt(y)
                // Результат!
                listOf(-root, root)
            }
        }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double {
    var absV = 0.0

    for (element in v)
        absV += sqr(element)
    return sqrt(absV)
}

/**
 * Простая
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double =
        if (list.isNotEmpty()) list.sum() / list.size
        else 0.0

/**
 * Средняя
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> {
    val center = list.sum() / list.size

    for (i in 0 until list.size)
        list[i] -= center
    return list
}

/**
 * Средняя
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.0.
 */
fun times(a: List<Double>, b: List<Double>): Double {
    var C = 0.0

    for (i in 0 until a.size)
        C += a[i] * b[i]
    return C
}

/**
 * Средняя
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0.0 при любом x.
 */
fun polynom(p: List<Double>, x: Double): Double {
    var pX = 0.0
    var powX = 1.0

    for (element in p) {
        pX += element * powX
        powX *= x
    }
    return pX
}

/**
 * Средняя
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Double>): MutableList<Double> {
    var sum = 0.0

    for (i in 0 until list.size) {
        sum += list[i]
        list[i] = sum
    }
    return list
}

/**
 * Средняя
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> {
    val result = mutableListOf<Int>()
    var n1 = n
    var multi = 2

    while (n1 > 1) {
        if (n1 % multi == 0) {
            result.add(multi)
            n1 /= multi
        } else multi++
    }
    return result
}

/**
 * Сложная
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 */
fun factorizeToString(n: Int): String = factorize(n).joinToString(separator = "*")


/**
 * Средняя
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> {
    val result = mutableListOf<Int>()
    var n1 = n

    while (n1 > 0) {
        result.add(n1 % base)
        n1 /= base
    }
    if (n == 0) result.add(0)
    return result.reversed()
}

/**
 * Сложная
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 */
fun convertToString(n: Int, base: Int): String {
    val result = mutableListOf<String>()
    var n1 = n

    while (n1 > 0) {
        val nBase = n1 % base
        if (nBase < 10) result.add(nBase.toString())
        else result.add(convertIn(nBase))
        n1 /= base
    }
    if (n == 0) result.add("0")
    return result.joinToString(separator = "").reversed()
}

fun convertIn(x: Int): String = (x + 'a'.toInt() - 10).toChar().toString()


/**
 * Средняя
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int {
    var result = 0
    var powBase = pow(base.toDouble(), digits.size - 1.0).toInt()

    for (element in digits) {
        result += element * powBase
        powBase /= base
    }
    return result
}

/**
 * Сложная
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 */
fun decimalFromString(str: String, base: Int): Int {
    var result = 0
    var powBase = pow(base.toDouble(), str.length - 1.0).toInt()

    for (char in str) {
        val conv = if (char - '0' > 9) convertOut(char)
        else char - '0'
        result += conv * powBase
        powBase /= base
    }
    return result
}

fun convertOut(x: Char): Int = x - 'a' + 10

/**
 * Сложная
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
val romanList1 = listOf("C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM")
val romanList2 = listOf("X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC")
val romanList3 = listOf("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX")
val M = "M"

fun roman(n: Int): String {
    val string = mutableListOf<String>()
    val fourthNum = n / 1000
    val thirdNum = n / 100 % 10
    val secondNum = n / 10 % 10
    val firstNum = n % 10

    for (i in 0 until fourthNum)
        string.add(M)
    if (thirdNum != 0) string.add(romanList1[thirdNum - 1])
    if (secondNum  != 0) string.add(romanList2[secondNum - 1])
    if (firstNum != 0) string.add(romanList3[firstNum - 1])
    return string.joinToString("")
}


/**
 * Очень сложная
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String {
    var result = listOf<String>()
    val result1:List<String>
    if (n > 999)  {
        result1 = strNumber1( n / 1000, 2)
        result += result1
    }
    result += strNumber1( n % 1000, 1)
    return result.joinToString(" ")
}


val hundreds = listOf("сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот")
val dozens1  = listOf("десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать")
val dozens2  = listOf("двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто")
val units1 = listOf("три", "четыре", "пять", "шесть", "семь", "восемь", "девять")
val units2 = listOf("одна", "две")
val units3 = listOf("один", "два")

fun strNumber1 (digit: Int, part: Int): MutableList<String> {
    val result = mutableListOf<String>()
    val thirdNum = digit / 100
    val secondNum = digit / 10 % 10
    val firstNum = digit % 10
    val duoNum = digit % 100

    if (thirdNum > 0) result.add(hundreds[thirdNum - 1])

    if (secondNum > 1) result.add(dozens2[secondNum - 2])

    if (duoNum in 10..19) {
        result.add(dozens1[firstNum])
        if (part == 2) result.add("тысяч")
        return result
    }

    if (firstNum > 2) result.add(units1[firstNum - 3])
    else
        if (firstNum != 0) when (part) {
            2 -> result.add(units2[firstNum - 1])
            1 -> result.add(units3[firstNum - 1])
        }

    if (part == 2)
        when {
            result.last() == "одна" -> result.add("тысяча")
            result.last() == "две" -> result.add("тысячи")
            result.last() == "три" -> result.add("тысячи")
            result.last() == "четыре" -> result.add("тысячи")
            else -> result.add("тысяч")
        }

    return result
}