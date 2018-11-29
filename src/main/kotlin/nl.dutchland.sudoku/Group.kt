package nl.dutchland.sudoku

data class Group(private val squares : Set<Square>) {
    init {
        squares.forEach {
            square -> square.addNeighbours(squares)
        }
    }
}