package nl.dutchland.sudoku


class Matrix<T> private constructor(
        val horizontalSize : Int,
        val verticalSize: Int,
        private val producer: (Coordinate) -> T) {

    private val array : List<T>
    init {
        array = (0 until horizontalSize)
                .flatMap { columnIndex -> coordinatesForColumn(columnIndex) }
                .map { coordinate -> producer.invoke(coordinate) }
    }

    val cells : Collection<T> = array

    val columns : List<List<T>> get() {
        return (0 until horizontalSize)
                .map { columnIndex -> getColumn(columnIndex) }
    }

    val rows: List<List<T>> get() {
        return (0 until verticalSize)
                .map { rowIndex -> getRow(rowIndex) }
    }
    companion object {
        fun <T> of(horizontalSize : Int, verticalSize: Int, producer: (Coordinate) -> T) : Matrix<T> {
            return Matrix(horizontalSize, verticalSize, producer)
        }

    }

    private fun coordinatesForColumn(columnIndex: Int) : List<Coordinate> {
        return (0 until verticalSize)
                .map { rowIndex -> Coordinate(columnIndex, rowIndex) }
    }

    fun getRow(rowIndex: Int) : List<T> {
        return (0 until horizontalSize)
                .map { columnIndex -> Coordinate(columnIndex, rowIndex) }
                .map { coordinate -> valueAt(coordinate) }

    }

    fun getColumn(columnIndex: Int) : List<T> {
        return (0 until verticalSize)
                .map { rowIndex -> Coordinate(columnIndex, rowIndex) }
                .map { coordinate -> valueAt(coordinate) }
    }

    fun valueAt(coordinate: Coordinate) : T {
        val indexInArray = calculateIndex(coordinate);
        return array.get(indexInArray)
    }

    private fun calculateIndex(coordinate: Coordinate): Int {
        val multiplier = coordinate.colunmIndex
        val adder = coordinate.rowIndex

        return multiplier * (verticalSize) + adder
    }

    fun subMatrix(topLeft: Coordinate, bottomRigh: Coordinate): Matrix<T> {
        val horizontalSize = bottomRigh.colunmIndex - topLeft.colunmIndex + 1
        val verticalSize = bottomRigh.rowIndex - topLeft.colunmIndex + 1
        return Matrix(horizontalSize, verticalSize) { coordinate -> valueAt(coordinate.sum(topLeft)) }
    }
}