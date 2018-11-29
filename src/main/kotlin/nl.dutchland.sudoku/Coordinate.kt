package nl.dutchland.sudoku

import java.math.BigDecimal

data class Coordinate(val colunmIndex: Int,
                      val rowIndex: Int) {

    fun sum(coordinateToAdd: Coordinate): Coordinate {
        return Coordinate(colunmIndex + coordinateToAdd.colunmIndex, rowIndex + coordinateToAdd.rowIndex)
    }
}