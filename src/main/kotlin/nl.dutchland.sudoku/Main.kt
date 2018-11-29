package nl.dutchland.sudoku

fun main(args: Array<String>) {
    val matrix = Matrix.of(9,9) { (_, _) -> Square()}

    matrix.rows.forEach {r -> Group(r.toSet()) }
    matrix.columns.forEach {r -> Group(r.toSet()) }

    Group(matrix.subMatrix(Coordinate(0,0), Coordinate(2,2)).cells.toSet())
    Group(matrix.subMatrix(Coordinate(3,0), Coordinate(5,2)).cells.toSet())
    Group(matrix.subMatrix(Coordinate(6,0), Coordinate(8,2)).cells.toSet())

    Group(matrix.subMatrix(Coordinate(0,3), Coordinate(2,5)).cells.toSet())
    Group(matrix.subMatrix(Coordinate(3,3), Coordinate(5,5)).cells.toSet())
    Group(matrix.subMatrix(Coordinate(6,3), Coordinate(8,5)).cells.toSet())

    Group(matrix.subMatrix(Coordinate(0,6), Coordinate(2,8)).cells.toSet())
    Group(matrix.subMatrix(Coordinate(3,6), Coordinate(5,8)).cells.toSet())
    Group(matrix.subMatrix(Coordinate(6,6), Coordinate(8,8)).cells.toSet())

    matrix.valueAt(Coordinate(0, 8)).value = 1
    matrix.valueAt(Coordinate(8, 0)).value = 2
    matrix.valueAt(Coordinate(1, 1)).value = 9

    var possibleValues = matrix.valueAt(Coordinate(0,0)).possibleValues
    println("Possible values for 1,1:  $possibleValues")

    possibleValues = matrix.valueAt(Coordinate(8,8)).possibleValues
    println("Possible values for 9,9:  $possibleValues")
}
