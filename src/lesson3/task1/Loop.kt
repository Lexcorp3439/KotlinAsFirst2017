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
    if (n==0) return 1 else
    while (abs(x)>0) {x/=10 ; result +=1}
    return result
}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int = if (n>2)  fib(n-1)+ fib (n-2)  else 1

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var nod=0
    for (k in 1.. n * m) {
        if (k % m == 0 && k % n == 0){ nod=k; break}
    }
    return nod
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var num = 0
    for (i in 2..n)
      if (n % i == 0) { num = i ; break}
    return num
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var num = 0
    for (i in n-1 downTo 1)
        if (n % i == 0) { num = i ; break}
    return num
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
    for (i in 2..m) {if (m % i ==0 && n % i == 0) bool= false}
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
    var  bool = false
    for (i in 0..sqrt(n.toDouble()).toInt()) if (i*i in m..n) bool = true
    return bool
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun sin(x: Double, eps: Double): Double = TODO()

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double = TODO()

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 * Не использовать строки при решении задачи.
 */
fun revert(n: Int): Int {
    var new= 0
    var n1:Int = n
    var all = -1
    var allrever = 1

    while (n1>0) {
        n1 /= 10
        all+=1
    }
    n1 =n
    while (all>=0) {
        new += (n1/ pow(10.0,all.toDouble()).toInt())*allrever
        n1 %= pow(10.0, all.toDouble()).toInt()
        all-=1
        allrever*=10
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
    var n1 = n
    var all = 0

    var ten = 1
    val bool:Boolean

    if (abs(n)<10) bool = true
    else {
        while (n1 > 0) {
            n1 /= 10
            all += 1
        }
        val num= all
        all /= 2
        n1=n
        for (i in 1..all) ten *= 10
        bool = if (num % 2 == 0) {
           /* (n1 / ten) == (n1.toString().reversed().toInt()/ten) */( (n1/ten).toString().reversed().toInt() == n1 % ten   )
        } else {
            (n1 / (ten * 10)) == (n1.toString().reversed().toInt()/(ten*10))
        }
    }
    return bool
}

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 */
fun hasDifferentDigits(n: Int): Boolean {
    var n1:Int = n
    var all = 0
    //val charN:String = n.toString() ...
    val bool:Boolean
    var b = 0

    if (n<10) bool = false
  //  else {if (n%(n%10)==0) bool=false
        else {
        while (n1 > 0) {
            n1 /= 10
            all += 1
        }
        n1 = n
        for (i in 2..all) {
            if (n1 % 10.0 == (n1 % pow(10.0, i.toDouble())) / pow(10.0, (i - 1).toDouble()))  b+=1
        }
        /*if (charN[i]==charN[j]) {bool = false ; break}*/
       // bool = (k > 0)
        bool = b != all
    }
    return bool
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 */
fun squareSequenceDigit(n: Int): Int {

    var k = 1 //счетчик
    var dig:Int  // число в квадрате
    var num = 0    // номер числа
    var all = 0   //чисел в числе
    var ret = 0.0 //число, которое нужно вывести

    while (num<n) {
        dig = k*k
        while (dig>0) {dig /= 10 ; all+=1}
        dig = k*k
        for (j in all downTo 1) {
            ret = dig / pow(10.0 , j.toDouble() - 1)
            num+=1
            dig %= pow(10.0 , j.toDouble() - 1).toInt()
            if (num==n) break
        }
        all=0
        k+=1
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

 //   var k = 3 //счетчик
    var k1 = 1
    var k2 = 1
    var dig:Int  // число в квадрате
    var dig1:Int
    var digk:Int
    var num = 2    // номер числа
    var all = 0   //чисел в числе
    var ret = 0.0 //число, которое нужно вывести


    if (n==1 || n ==2 ) ret=1.0 else
    while (num<n) {
        //dig = fib(k)
        dig = k1+k2
        dig1 = dig
        digk = dig
        while (dig1>0) {dig1 /= 10 ; all+=1}
        for (j in all downTo 1) {
            ret = dig / pow(10.0 , j.toDouble() - 1)
            num+=1
            dig %= pow(10.0 , j.toDouble() - 1).toInt()
            if (num==n) break
        }
        all=0
 //       k+=1
        k2=k1
        k1=digk
    }
    return ret.toInt()
}
