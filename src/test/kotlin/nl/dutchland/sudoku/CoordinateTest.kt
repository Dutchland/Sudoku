package nl.dutchland.sudoku

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class CoordinateTest {
    @Test
    fun testInvalidColumn() {
        val message = assertFailsWith<AssertionError> { Coordinate(-1, 0) }
                .message
        assertEquals("Columnindex cannot be negative", message)
    }

    @Test
    fun testInvalidRow() {
        val message = assertFailsWith<AssertionError> { Coordinate(0, -1) }
                .message
        assertEquals("Rowindex cannot be negative", message)
    }

    @Test
    fun testSumCoordinates() {
        val coordinate1 = Coordinate(1,1)
        val coordinate2 = Coordinate(2, 1)

        val sumCoordinate = coordinate1.sum(coordinate2)

        assertEquals(Coordinate(3,2), sumCoordinate)
    }

}