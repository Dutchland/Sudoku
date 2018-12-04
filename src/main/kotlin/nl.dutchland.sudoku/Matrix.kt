package nl.dutchland.sudoku

class Matrix<T> private constructor(
        val horizontalSize : Int,
        val verticalSize: Int,
        producer: (Coordinate) -> T) {

    companion object {
        fun <T> of(horizontalSize : Int, verticalSize: Int, producer: (Coordinate) -> T) : Matrix<T> {
            assert(horizontalSize > 0) {"Matrix must have positive horizontal size: $horizontalSize"}
            assert(verticalSize > 0) {"Matrix must have positive vertical size: $verticalSize"}

            return Matrix(horizontalSize, verticalSize, producer)
        }
    }

    private val array : List<T>

    init {
        array = (0 until horizontalSize)
                .flatMap { columnIndex -> coordinatesForColumn(columnIndex) }
                .map { coordinate -> producer.invoke(coordinate) }
    }

    val cells : Collection<T> = array

    val columns : List<List<T>> get() {
        println("Calculating columns")
        return (0 until horizontalSize)
                .map { columnIndex -> getColumn(columnIndex) }
    }

    val rows: List<List<T>> get() {
        return (0 until verticalSize)
                .map { rowIndex -> getRow(rowIndex) }
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
        assert(isWithinMatrix(coordinate)) {"Coordinate is not within matrix. Matix size: $horizontalSize by $verticalSize"}

        val indexInArray = calculateIndexInArray(coordinate)
        return array[indexInArray]
    }

    fun subMatrix(topLeft: Coordinate, bottomRigh: Coordinate): Matrix<T> {
        val horizontalSize = bottomRigh.colunmIndex - topLeft.colunmIndex + 1
        val verticalSize = bottomRigh.rowIndex - topLeft.colunmIndex + 1
        return Matrix(horizontalSize, verticalSize) { coordinate -> valueAt(coordinate.sum(topLeft)) }
    }

    private fun isWithinMatrix(coordinate: Coordinate): Boolean {
        return coordinate.colunmIndex < horizontalSize && coordinate.rowIndex < verticalSize
    }

    private fun calculateIndexInArray(coordinate: Coordinate): Int {
        val multiplier = coordinate.colunmIndex
        val adder = coordinate.rowIndex

        return multiplier * (verticalSize) + adder
    }
}