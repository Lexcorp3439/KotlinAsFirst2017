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
    var C = 0.0 //Переменная с заглавной буквы по условию

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

    for (i in 0 until p.size) {
        pX += p[i] * powX
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

fun convertIn(x: Int): String {
    val list = listOf("a","b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z")
    return list[x - 10]
}

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

fun convertOut(x: Char): Int  {
    val list = listOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y')
    for (element in list)
        if (x == element) return list.indexOf(element) + 10
    return 35
}

/**
 * Сложная
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String {
    val I = "I"
    val V = "V"
    val X = "X"
    val L = "L"
    val C = "C"
    val D = "D"
    val M = "M"
    var all = n.toString().length
    var n1 = n
    var string = ""
    var count = pow(10.0, (all - 1).toDouble()).toInt()
    if (all >= 4) {
        for (i in 1..n1 / 1000) string += M
        count = 1000; n1 %= count; count /= 10; all = 3
    }
    if (all == 3) {
        when (n1 / count) { 1 -> string += C; 2 -> string += C + C; 3 -> string += C + C + C; 4 -> string += C + D; 5 -> string += D; 6 -> string += D + C; 7 -> string += D + C + C; 8 -> string += D + C + C + C; 9 -> string += C + M
        }
        n1 %= count; count /= 10; all -= 1
    }
    if (all == 2) {
        when (n1 / count) { 1 -> string += X; 2 -> string += X + X; 3 -> string += X + X + X; 4 -> string += X + L; 5 -> string += L; 6 -> string += L + X; 7 -> string += L + X + X; 8 -> string += L + X + X + X; 9 -> string += X + C
        }
        n1 %= count; count /= 10; all -= 1
    }
    if (all == 1) {
        when (n1 / count) { 1 -> string += I; 2 -> string += I + I; 3 -> string += I + I + I; 4 -> string += I + V; 5 -> string += V; 6 -> string += V + I; 7 -> string += V + I + I; 8 -> string += V + I + I + I; 9 -> string += I + X
        }
    }
    return string
}

/**
 * Очень сложная
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String {
    val all = n.toString().length
    var result = ""
    result += if (all <= 3) strNumber(all, n, 1) // mod -- показатель порядка. к примеру для числа 123456 "123" - второй порядок (mod 2) , а 456 - первый порядок (mod 1)
    else strNumber(all - 3, n / 1000, 2) + strNumber(3, n % 1000, 1)
    return result.trim()
}

fun strNumber(count: Int, digit: Int, mod: Int): String {
    var string = ""
    var num = count
    var digit1 = digit
    if (num == 3) {
        when (digit1 / 100) {
            1 -> string += "сто "; 2 -> string += "двести "; 3 -> string += "триста "; 4 -> string += "четыреста "; 5 -> string += "пятьсот "
            6 -> string += "шестьсот "; 7 -> string += "семьсот "; 8 -> string += "восемьсот "; 9 -> string += "девятьсот "
        }
        num -= 1; digit1 %= 100 //; if (digit1 == 0) string+="тысяч "
    }
    if ((digit1 >= 20 || digit1 <= 9) && digit1 > 0) {
        if (num == 2) {
            when (digit1 / 10) {
                2 -> string += "двадцать "; 3 -> string += "тридцать "; 4 -> string += "сорок "; 5 -> string += "пятьдесят "
                6 -> string += "шестьдесят "; 7 -> string += "семьдесят "; 8 -> string += "восемьдесят "; 9 -> string += "девяносто "
            }
            num -= 1; digit1 %= 10; if (digit1 == 0 && mod == 2) string += "тысяч "
        }
        if (num == 1 && mod == 2) {
            when (digit1) { 1 -> string += "одна тысяча "; 2 -> string += "две тысячи "
                5 -> string += "пять тысяч "; 3 -> string += "три тысячи "; 4 -> string += "четыре тысячи "
                6 -> string += "шесть тысяч "; 7 -> string += "семь тысяч "; 8 -> string += "восемь тысяч "; 9 -> string += "девять тысяч "
            }
        } else
            if (num == 1 && mod == 1) {
                when (digit1) { 1 -> string += "один"; 2 -> string += "два"
                    5 -> string += "пять "; 3 -> string += "три "; 4 -> string += "четыре "
                    6 -> string += "шесть "; 7 -> string += "семь "; 8 -> string += "восемь "; 9 -> string += "девять "
                }
            }
    } else {
        when (digit1) {
            10 -> string += "десять "; 11 -> string += "одиннадцать "; 12 -> string += "двенадцать "; 13 -> string += "тринадцать "; 14 -> string += "четырнадцать "; 15 -> string += "пятнадцать "
            16 -> string += "шестнадцать "; 17 -> string += "семнадцать "; 18 -> string += "восемнадцать "; 19 -> string += "девятнадцать "
        }
        if (mod == 2) string += "тысяч "
    }
    return string
}