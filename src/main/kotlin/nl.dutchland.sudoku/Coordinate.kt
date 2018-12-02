package nl.dutchland.sudoku

data class Coordinate(val colunmIndex: Int,
                      val rowIndex: Int) {

    init {
        assert(colunmIndex >= 0, {"Columnindex cannot be negative"})
        assert(rowIndex >= 0, {"Rowindex cannot be negative"})
    }

    fun sum(coordinateToAdd: Coordinate): Coordinate {
        return Coordinate(colunmIndex + coordinateToAdd.colunmIndex, rowIndex + coordinateToAdd.rowIndex)
    }
}