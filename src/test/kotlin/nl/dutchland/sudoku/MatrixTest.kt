package nl.dutchland.sudoku

import kotlin.test.Test
import kotlin.test.assertEquals

class MatrixTest {

    @Test
    fun testMinimumMatrixSize() {

    }

    @Test
    fun testGetValues() {
        // Test 1
        val matrix = Matrix.of(10,3) { c -> c}

        val actualValue = matrix.valueAt(Coordinate(0,0))

        val expectedValue = Coordinate(0,0)
        assertEquals(expectedValue, actualValue)

        // Test 2
        val actualValue2 = matrix.valueAt(Coordinate(1,2))

        val expectedValue2 = Coordinate(1,2)
        assertEquals(expectedValue2, actualValue2)

        // Test 3
        val actualValue3 = matrix.valueAt(Coordinate(9,2))

        val expectedValue3 = Coordinate(9,2)
        assertEquals(expectedValue3, actualValue3)
    }

    @Test
    fun testGetRow() {
        val matrix = Matrix.of(4,3) { c -> c }
        val actualRow = matrix.getRow(0)

        val expectedRow = arrayListOf(
                Coordinate(0,0),
                Coordinate(1, 0),
                Coordinate(2, 0),
                Coordinate(3,0))

        assertEquals(expectedRow, actualRow)
    }

    @Test
    fun testGetColumn() {
        val matrix = Matrix.of(3,4) { c -> c }
        val actualColumn = matrix.getColumn(1)

        val expectedColumn = arrayListOf(
                Coordinate(1,0),
                Coordinate(1, 1),
                Coordinate(1, 2),
                Coordinate(1,3))
        assertEquals(expectedColumn, actualColumn)
    }

    @Test
    fun testColumns() {
        val matrix = Matrix.of(3,2) { c -> c }
        val actualColumns = matrix.columns

        val expectedColumns = arrayListOf(
                arrayListOf(Coordinate(0,0), Coordinate(0, 1)),
                arrayListOf(Coordinate(1,0), Coordinate(1, 1)),
                arrayListOf(Coordinate(2,0), Coordinate(2, 1)))

        assertEquals(expectedColumns, actualColumns)
    }

    @Test
    fun testRows() {
        val matrix = Matrix.of(2,3) { c -> c }
        val actualRows = matrix.rows

        val expectedRows = arrayListOf(
                arrayListOf(Coordinate(0,0), Coordinate(1, 0)),
                arrayListOf(Coordinate(0,1), Coordinate(1, 1)),
                arrayListOf(Coordinate(0,2), Coordinate(1, 2)))

        assertEquals(expectedRows, actualRows)
    }

    @Test
    fun testSubMatrix() {
        val matrix = Matrix.of(4,4) { c -> c }
        val actualSubMatrix = matrix.subMatrix(Coordinate(1,1), Coordinate(2, 3))

        val expectedRows = arrayListOf(
                arrayListOf(Coordinate(1,1), Coordinate(2, 1)),
                arrayListOf(Coordinate(1,2), Coordinate(2, 2)),
                arrayListOf(Coordinate(1,3), Coordinate(2, 3)))

        assertEquals(expectedRows, actualSubMatrix.rows)
    }
}