package nl.dutchland.sudoku

class Square {
    private val neighbours: MutableSet<Square> = HashSet()

    var possibleValues: Set<Int> = (1 until 10).toSet()
        private set

    var value: Int? = null
        set(newValue) {
            if (newValue != field) {
                field = newValue
                neighbours.forEach { n -> n.recalculatePossibleValues() }
            }
        }

    fun addNeighbours(neighbours : Set<Square>) {
        this.neighbours.addAll(neighbours)
    }

    private fun recalculatePossibleValues() {
        possibleValues = (1 until 10).toSet()
                .minus(retrieveNeigbourValues())
    }

    private fun retrieveNeigbourValues(): Set<Int> {
        return neighbours
                .mapNotNull { n -> n.value }
                .toSet()
    }
}