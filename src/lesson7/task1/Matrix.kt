@file:Suppress("UNUSED_PARAMETER", "unused")
package lesson7.task1

import lesson3.task1.squareBetweenExists

/**
 * Ячейка матрицы: row = ряд, column = колонка
 */
data class Cell(val row: Int, val column: Int)

/**
 * Интерфейс, описывающий возможности матрицы. E = тип элемента матрицы
 */
interface Matrix<E> {
    /** Высота */
    val height: Int

    /** Ширина */
    val width: Int

    /**
     * Доступ к ячейке.
     * Методы могут бросить исключение, если ячейка не существует или пуста
     */
    operator fun get(row: Int, column: Int): E
    operator fun get(cell: Cell): E

    /**
     * Запись в ячейку.
     * Методы могут бросить исключение, если ячейка не существует
     */
    operator fun set(row: Int, column: Int, value: E)
    operator fun set(cell: Cell, value: E)
}

/**
 * Простая
 *
 * Метод для создания матрицы, должен вернуть РЕАЛИЗАЦИЮ Matrix<E>.
 * height = высота, width = ширина, e = чем заполнить элементы.
 * Бросить исключение IllegalArgumentException, если height или width <= 0.
 */
fun <E> createMatrix(height: Int, width: Int, e: E): Matrix<E> = MatrixImpl(height, width, e)

/**
 * Средняя сложность
 *
 * Реализация интерфейса "матрица"
 */
class MatrixImpl<E>(h: Int, w: Int, e: E) : Matrix<E> {
    val matrix = mutableListOf<E>()

    init {
        require(h > 0 && w > 0)
        for (i in 0 until h * w) {
            matrix.add(e)
        }
    }

    override val height: Int = h

    override val width: Int = w

    override fun get(row: Int, column: Int): E =
            matrix[row * width + column]

    override fun get(cell: Cell): E =
            matrix[cell.row * width + cell.column]

    override fun set(row: Int, column: Int, value: E) {
        matrix[row * width + column] = value
    }

    override fun set(cell: Cell, value: E) {
        matrix[cell.row * width + cell.column] = value
    }

    fun similarity(other: Matrix<*>): Boolean{
        if (height != other.height && width != other.width) return false
        for (i in 0 until height)
            for (j in 0 until width)
                if (get(i, j) != other[i, j]) return false
        return true
    }

    override fun equals(other: Any?) =
            other is MatrixImpl<*> && similarity(other)

    override fun toString(): String = TODO()
}

