@file:Suppress("UNUSED_PARAMETER")
package lesson2.task1

import lesson1.task1.discriminant
import lesson1.task1.sqr
import java.lang.Math.abs

/**
 * Пример
 *
 * Найти наименьший корень биквадратного уравнения ax^4 + bx^2 + c = 0
 */
fun minBiRoot(a: Double, b: Double, c: Double): Double {
    // 1: в главной ветке if выполняется НЕСКОЛЬКО операторов
    if (a == 0.0) {
        if (b == 0.0) return Double.NaN // ... и ничего больше не делать
        val bc = -c / b
        if (bc < 0.0) return Double.NaN // ... и ничего больше не делать
        return -Math.sqrt(bc)
        // Дальше функция при a == 0.0 не идёт
    }
    val d = discriminant(a, b, c)   // 2
    if (d < 0.0) return Double.NaN  // 3
    // 4
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    val y3 = Math.max(y1, y2)       // 5
    if (y3 < 0.0) return Double.NaN // 6
    return -Math.sqrt(y3)           // 7
}

/**
 * Простая
 *
 * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
 * вернуть строку вида: «21 год», «32 года», «12 лет».
 */
fun ageDescription(age: Int): String = when ((age%100)/10){
    1 -> "$age лет"
    else -> when (age%10){
        2, 3, 4-> "$age года"
        5, 6, 7, 8, 9, 0-> "$age лет"
       else -> "$age год"
    }
}

   /* if (age/10 == 1) return ("$age лет ") else {
        if (age % 10 == 1) return ("$age год ")
        else if ((age % 10<5)&&(age % 10>1)) return ("$age года ")
        else return ("$age лет ")
    }
}*/

/**
 * Простая
 *
 * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
 * и t3 часов — со скоростью v3 км/час.
 * Определить, за какое время он одолел первую половину пути?
 */
fun timeForHalfWay(t1: Double, v1: Double,
                   t2: Double, v2: Double,
                   t3: Double, v3: Double): Double {
    val S = (t1*v1+t2*v2+t3*v3)/2.0
    return when {
        t1*v1>=S -> S/v1
        (t1*v1+t2*v2)>=S -> (S-v1*t1)/v2+t1
        else -> (S-v1*t1-v2*t2)/v3+t1+t2
    }
}

/**
 * Простая
 *
 * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
 * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
 * и 3, если угроза от обеих ладей.
 * Считать, что ладьи не могут загораживать друг друга
 */
fun whichRookThreatens(kingX: Int, kingY: Int,
                       rookX1: Int, rookY1: Int,
                       rookX2: Int, rookY2: Int): Int {
    return if( ((kingX==rookX1)||(kingY==rookY1))&& ((kingX!=rookX2&&(kingY!=rookY2))) )1
    else if( ((kingX==rookX2)||(kingY==rookY2))&&(kingX!=rookX1&&(kingY!=rookY1)) ) 2
    else if((kingX!=rookX1)&&(kingX!=rookX2)&&(kingY!=rookY1)&&(kingY!=rookY2)) 0
    else 3
}

/**
 * Простая
 *
 * На шахматной доске стоят черный король и белые ладья и слон
 * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
 * Проверить, есть ли угроза королю и если есть, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
 * и 3, если угроза есть и от ладьи и от слона.
 * Считать, что ладья и слон не могут загораживать друг друга.
 */
fun rookOrBishopThreatens(kingX: Int, kingY: Int,
                          rookX: Int, rookY: Int,
                          bishopX: Int, bishopY: Int): Int {
    var result = 0
    if (kingX==rookX || kingY==rookY) result = result + 1
    if (abs(kingX-bishopX ) == abs (kingY-bishopY)) result +=2
    return result
}

/**
 * Простая
 *
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 */
fun triangleKind(a: Double, b: Double, c: Double): Int {
    if ( (sqr(a)==sqr(b)+ sqr(c)) || (sqr(b)==sqr(a)+ sqr(c)) || (sqr(c)==sqr(b)+ sqr(c)) ) return 1 else
        if ( (a==b && b==c) || (a==b && b>c) || (a==c && c>b) || (c==b && b>a) ) return 0 else
          if(a!=b && b!=c && a!=c){
          if (a>b && a>c) {return if (c+b<a) -1 else if ((sqr(b)+sqr(c)-sqr(a))/2*b*c<0) 2 else 0} else
          if (c>b && c>a) {return if (b+a<c) -1 else if ((sqr(b)+sqr(a)-sqr(c))/2*b*a<0) 2 else 0} else
          if (b>a && b>c) {return if (c+a<b) -1 else if ((sqr(a)+sqr(c)-sqr(b))/2*a*c<0) 2 else 0}
          }
    return when {
        (a==b && b<c && a+b>c && (sqr(b)+sqr(a)-sqr(c))/2*b*a<0) -> 2
        (c==b && b<a && c+b>a && (sqr(b)+sqr(c)-sqr(a))/2*b*c<0) -> 2
        (a==c && c<b && a+c>b && (sqr(a)+sqr(c)-sqr(b))/2*a*c<0) -> 2
        (a==b && b<c && a+b>c && (sqr(b)+sqr(a)-sqr(c))/2*b*a>0) -> 0
        (c==b && b<a && c+b>a && (sqr(b)+sqr(c)-sqr(a))/2*b*c>0) -> 0
        (a==c && c<b && a+c>b && (sqr(a)+sqr(c)-sqr(b))/2*a*c>0) -> 0
        (a==b && b<c && a+b<c)-> -1
        (c==b && b<a && c+b<a) -> -1
        (a==c && c<b && a+c<b) -> -1
        else -> -1
    }
}

/**
* Средняя
*
* Даны четыре точки на одной прямой: A, B, C и D.
* Координаты точек a, b, c, d соответственно, b >= a, d >= c.
* Найти длину пересечения отрезков AB и CD.
* Если пересечения нет, вернуть -1.
*/
fun segmentLength(a: Int, b: Int, c: Int, d: Int): Int {
    if (a==b && c==d) {
        return if (a==c) 0 else -1
    } else
if (a!=b && c!=d) {
    when {
        c in a..b && d>=b -> return b-c
        c in a..b && d<=b -> return d-c
        c>b -> return -1
        a in c..d && b>=d -> return d-a
        a in c..d && b<=d -> return b-a
        else -> -1
    }
}
return if (a==b && c!=d) {
    when{
        (a in (c)..(d))-> 0
        else -> -1
    }
} else
    if (a!=b && c==d){
        when{
            (c in (a) ..(b))-> 0
            else -> -1
        }
    } else when (a) {
        b -> 1
        else -> -1
    }
}
