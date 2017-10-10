@file:Suppress("UNUSED_PARAMETER")

package lesson5.task1

import java.lang.Double.NaN

/**
 * Пример
 *
 * Время представлено строкой вида "11:34:45", содержащей часы, минуты и секунды, разделённые двоеточием.
 * Разобрать эту строку и рассчитать количество секунд, прошедшее с начала дня.
 */
fun timeStrToSeconds(str: String): Int {
    val parts = str.split(":")
    var result = 0
    for (part in parts) {
        val number = part.toInt()
        result = result * 60 + number
    }
    return result
}

/**
 * Пример
 *
 * Дано число n от 0 до 99.
 * Вернуть его же в виде двухсимвольной строки, от "00" до "99"
 */
fun twoDigitStr(n: Int) = if (n in 0..9) "0$n" else "$n"

/**
 * Пример
 *
 * Дано seconds -- время в секундах, прошедшее с начала дня.
 * Вернуть текущее время в виде строки в формате "ЧЧ:ММ:СС".
 */
fun timeSecondsToStr(seconds: Int): String {
    val hour = seconds / 3600
    val minute = (seconds % 3600) / 60
    val second = seconds % 60
    return String.format("%02d:%02d:%02d", hour, minute, second)
}

/**
 * Пример: консольный ввод
 */
fun main(args: Array<String>) {
    println("Введите время в формате ЧЧ:ММ:СС")
    val line = readLine()
    if (line != null) {
        val seconds = timeStrToSeconds(line)
        if (seconds == -1) {
            println("Введённая строка $line не соответствует формату ЧЧ:ММ:СС")
        } else {
            println("Прошло секунд с начала суток: $seconds")
        }
    } else {
        println("Достигнут <конец файла> в процессе чтения строки. Программа прервана")
    }
}

private val Digitregex = Regex("^\\d{1,2} [а-я]{3,} \\d+$")

/**
 * Средняя
 *
 * Дата представлена строкой вида "15 июля 2016".
 * Перевести её в цифровой формат "15.07.2016".
 * День иц всегда представлять двумя цифрами, например: 03.04.201 меся1.
 * При неверном формате входной строки вернуть пустую строку
 */
fun dateStrToDigit(str: String): String {
    var string = ""

    if (str matches Digitregex) {
        var (days, month, year) = str.split(" ")
        if (days.toInt() < 10) days = "0" + days.toInt().toString()
        string = days + "." + partconvert(month) + year
        if (partconvert(month) == NaN.toString()) string = ""
    }
    return string
}

fun partconvert(str: String): String = when (str) {
    "декабря" -> "12."; "января" -> "01."; "февраля" -> "02."
    "марта" -> "03."; "апреля" -> "04."; "мая" -> "05."
    "июня" -> "06."; "июля" -> "07."; "августа" -> "08."
    "сентября" -> "09."; "октября" -> "10."; "ноября" -> "11."
    else -> NaN.toString()
}

/**
 * Средняя
 *
 * Дата представлена строкой вида "15.07.2016".
 * Перевести её в строковый формат вида "15 июля 2016".
 * При неверном формате входной строки вернуть пустую строку
 */
fun dateDigitToStr(digital: String): String {
    var string = ""

    if (digital matches Digitregex2) {
        var (days, month, year) = digital.split(".")
        if (days.toInt() < 10) days = days.toInt().toString()
        string = days + " " + partconvert2(month) + year
        if (partconvert2(month) == NaN.toString()) string = ""
    }
    return string
}

private val Digitregex2 = Regex("^\\d{2}\\.\\d{2}\\.\\d+$")

fun partconvert2(str: String): String = when (str) {
    "12" -> "декабря "; "01" -> "января "; "02" -> "февраля "
    "03" -> "марта "; "04" -> "апреля "; "05" -> "мая "
    "06" -> "июня "; "07" -> "июля "; "08" -> "августа "
    "09" -> "сентября "; "10" -> "октября "; "11" -> "ноября "
    else -> NaN.toString()
}

/**
 * Средняя
 *
 * Номер телефона задан строкой вида "+7 (921) 123-45-67".
 * Префикс (+7) может отсутствовать, код города (в скобках) также может отсутствовать.
 * Может присутствовать неограниченное количество пробелов и чёрточек,
 * например, номер 12 --  34- 5 -- 67 -98 тоже следует считать легальным.
 * Перевести номер в формат без скобок, пробелов и чёрточек (но с +), например,
 * "+79211234567" или "123456789" для приведённых примеров.
 * Все символы в номере, кроме цифр, пробелов и +-(), считать недопустимыми.
 * При неверном формате вернуть пустую строку
 */

private val simbol = Regex("\\d+")

fun flattenPhoneNumber(phone: String): String {
    var plus = ""

    if (phone == "") return ""
    if (phone.first() == '+') plus = "+"
    val str = phone.split(" ", "-", "+", "(", ")")
    return if (str.joinToString("") matches simbol) plus + str.joinToString("")
    else ""
}

/**
 * Средняя
 *
 * Результаты спортсмена на соревнованиях в прыжках в длину представлены строкой вида
 * "706 - % 717 % 703".
 * В строке могут присутствовать числа, черточки - и знаки процента %, разделённые пробелами;
 * число соответствует удачному прыжку, - пропущенной попытке, % заступу.
 * Прочитать строку и вернуть максимальное присутствующее в ней число (717 в примере).
 * При нарушении формата входной строки или при отсутствии в ней чисел, вернуть -1.
 */
val regexDigit = Regex("\\d+")

fun bestLongJump(jumps: String): Int {
    var max = 0
    val str = jumps.split(" ", "-", "%")

    if (str.joinToString("") matches regexDigit)
        for (part in str) {
            if (part != "" && part.toInt() > max) max = part.toInt()
        }
    else return -1
    return max
}

/**
 * Сложная
 *
 * Результаты спортсмена на соревнованиях в прыжках в высоту представлены строкой вида
 * "220 + 224 %+ 228 %- 230 + 232 %%- 234 %".
 * Здесь + соответствует удачной попытке, % неудачной, - пропущенной.
 * Высота и соответствующие ей попытки разделяются пробелом.
 * Прочитать строку и вернуть максимальную взятую высоту (230 в примере).
 * При нарушении формата входной строки вернуть -1.
 */
fun bestHighJump(jumps: String): Int = TODO()

/**
 * Сложная
 *
 * В строке представлено выражение вида "2 + 31 - 40 + 13",
 * использующее целые положительные числа, плюсы и минусы, разделённые пробелами.
 * Наличие двух знаков подряд "13 + + 10" или двух чисел подряд "1 2" не допускается.
 * Вернуть значение выражения (6 для примера).
 * Про нарушении формата входной строки бросить исключение IllegalArgumentException
 */
val megaRegex = Regex("\\d+([+-]\\d+)*")

fun plusMinus(expression: String): Int {
    val str = expression.split(" ")
    var sorting = 1
    var result = 0
    var intermediate = ""

    require(str.joinToString("") matches megaRegex)
    for (part in str) {
        if (sorting == 1) result = part.toInt()
        if (sorting % 2 == 1 && sorting != 1) if (intermediate == "+") result += part.toInt()
        else result -= part.toInt()
        if (sorting % 2 == 0) intermediate = part
        sorting++
    }
    return result
}

/**
 * Сложная
 *
 * Строка состоит из набора слов, отделённых друг от друга одним пробелом.
 * Определить, имеются ли в строке повторяющиеся слова, идущие друг за другом.
 * Слова, отличающиеся только регистром, считать совпадающими.
 * Вернуть индекс начала первого повторяющегося слова, или -1, если повторов нет.
 * Пример: "Он пошёл в в школу" => результат 9 (индекс первого 'в')
 */
fun firstDuplicateIndex(str: String): Int {
    val string = str.split(" ")
    var space = 0
    var number = 0
    var answer = 0

    for (i in 1 until string.size) {
        if (string[i - 1].toLowerCase() == string[i].toLowerCase()) {
            number = i - 1
            break
        }
    }
    for (i in 0 until str.length) {
        if (str[i] == ' ') space += 1
        if (space == number - 1) answer = i + 2
    }
    return if (answer == 0) -1 else answer
}

/**
 * Сложная
 *
 * Строка содержит названия товаров и цены на них в формате вида
 * "Хлеб 39.9; Молоко 62.5; Курица 184.0; Конфеты 89.9".
 * То есть, название товара отделено от цены пробелом,
 * а цена отделена от названия следующего товара точкой с запятой и пробелом.
 * Вернуть название самого дорогого товара в списке (в примере это Курица),
 * или пустую строку при нарушении формата строки.
 * Все цены должны быть положительными
 */
val stringRegex = Regex("^(\\S+ \\d+\\.\\d+;? )*(\\S+ \\d+\\.\\d+)$")

fun mostExpensive(description: String): String {
    var max = 0.0
    var maxNum = 1
    val str = description.split(" ", ";")

    return if (description matches stringRegex) {
        for (i in 1 until str.size - 1 step 3)
            if (str[i].toDouble() > max) {
                max = str[i].toDouble()
                maxNum = i
            }
        str[maxNum - 1]
    } else ""
}

/**
 * Сложная
 *
 * Перевести число roman, заданное в римской системе счисления,
 * в десятичную систему и вернуть как результат.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: XXIII = 23, XLIV = 44, C = 100
 *
 * Вернуть -1, если roman не является корректным римским числом
 */
val romanRegex = Regex(pattern = "^[M]*(CM?|(DC{0,3})|CD?|C{0,3})?(XC?|(LX{0,3})|XL?|X{0,3})?(IX?|(VI{0,3})|IV?|I{0,3})?$")

fun fromRoman(roman: String): Int {
    return if (!(roman matches romanRegex) || roman == "") -1
    else convertToRoman(roman)
}

fun convertToRoman(str: String): Int {
    var sum = 0
    for (i in 0 until str.length) {
        if (i > 0) {
            when {
                str[i - 1] == 'I' && str[i] == 'V' -> sum = sum - 1 + 4
                str[i - 1] == 'I' && str[i] == 'X' -> sum = sum - 1 + 9
                str[i - 1] == 'X' && str[i] == 'L' -> sum = sum - 10 + 40
                str[i - 1] == 'X' && str[i] == 'C' -> sum = sum - 10 + 90
                str[i - 1] == 'C' && str[i] == 'D' -> sum = sum - 100 + 400
                str[i - 1] == 'C' && str[i] == 'M' -> sum = sum - 100 + 900
                else -> when (str[i]) {
                    'I' -> sum += 1
                    'V' -> sum += 5
                    'X' -> sum += 10
                    'L' -> sum += 50
                    'C' -> sum += 100
                    'D' -> sum += 500
                    'M' -> sum += 1000
                    else -> -1
                }
            }
        } else when (str[i]) {
            'I' -> sum += 1
            'V' -> sum += 5
            'X' -> sum += 10
            'L' -> sum += 50
            'C' -> sum += 100
            'D' -> sum += 500
            'M' -> sum += 1000
            else -> -1
        }
    }
    return sum
}
//
/**
 * Очень сложная
 *
 * Имеется специальное устройство, представляющее собой
 * конвейер из cells ячеек (нумеруются от 0 до cells - 1 слева направо) и датчик, двигающийся над этим конвейером.
 * Строка commands содержит последовательность команд, выполняемых данным устройством, например +>+>+>+>+
 * Каждая команда кодируется одним специальным символом:
 *	> - сдвиг датчика вправо на 1 ячейку;
 *  < - сдвиг датчика влево на 1 ячейку;
 *	+ - увеличение значения в ячейке под датчиком на 1 ед.;
 *	- - уменьшение значения в ячейке под датчиком на 1 ед.;
 *	[ - если значение под датчиком равно 0, в качестве следующей команды следует воспринимать
 *  	не следующую по порядку, а идущую за соответствующей следующей командой ']' (с учётом вложенности);
 *	] - если значение под датчиком не равно 0, в качестве следующей команды следует воспринимать
 *  	не следующую по порядку, а идущую за соответствующей предыдущей командой '[' (с учётом вложенности);
 *      (комбинация [] имитирует цикл)
 *  пробел - пустая команда
 *
 * Изначально все ячейки заполнены значением 0 и датчик стоит на ячейке с номером N/2 (округлять вниз)
 *
 * После выполнения limit команд или всех команд из commands следует прекратить выполнение последовательности команд.
 * Учитываются все команды, в том числе несостоявшиеся переходы ("[" при значении под датчиком не равном 0 и "]" при
 * значении под датчиком равном 0) и пробелы.
 *
 * Вернуть список размера cells, содержащий элементы ячеек устройства после завершения выполнения последовательности.
 * Например, для 10 ячеек и командной строки +>+>+>+>+ результат должен быть 0,0,0,0,0,1,1,1,1,1
 *
 * Все прочие символы следует считать ошибочными и формировать исключение IllegalArgumentException.
 * То же исключение формируется, если у символов [ ] не оказывается пары.
 * Выход за границу конвейера также следует считать ошибкой и формировать исключение IllegalStateException.
 * Считать, что ошибочные символы и непарные скобки являются более приоритетной ошибкой чем выход за границу ленты,
 * то есть если в программе присутствует некорректный символ или непарная скобка, то должно быть выброшено
 * IllegalArgumentException.
 * IllegalArgumentException должен бросаться даже если ошибочная команда не была достигнута в ходе выполнения.
 *
 */
fun computeDeviceCells(cells: Int, commands: String, limit: Int): List<Int> = TODO() /*{
    val list = MutableList(cells){0}
    var limitdig = 0
    var using = cells/2
    var i = 0
    var next = false
    var last = false

    while (limitdig<limit){
        if (i == commands.length) break else {
            if (next) while (commands[i-1] != ']') {
                i++; if (commands[i-1] == ']') next = false
            }
            if (last) while (commands[i-1] != '[') {
                i--; if (commands[i-1] == '[') last = false
            }

            if (commands[i] == ' ') {
                limitdig++
            }
            if (commands[i] == '>') {
                using++; limitdig++
            }
            if (commands[i] == '<') {
                using--; limitdig++
            }
            if (commands[i] == '+') {
                list[using]++; limitdig++
            }
            if (commands[i] == '-') {
                list[using]--; limitdig++
            }
            if (commands[i] == ']') {
                limitdig++; if (list[using] != 0) last = true
            }
            if (commands[i] == '[') {
                limitdig++; if (list[using] == 0) next = true
            }

            i++
        }
    }
    return list
}
*/