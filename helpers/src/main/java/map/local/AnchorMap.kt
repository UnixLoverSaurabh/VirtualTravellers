package map.local

import androidx.core.util.Pair
import java.util.*

abstract class AnchorMap {
    abstract fun getAdjacencyMatrix(): Map<Int, List<Int>>
    abstract fun getPOIs(): List<Pair<Int, Int>>

    fun getRoute(startShortCode: Int?, destinationShortCode: Int?): List<Int>? {
        if (startShortCode == null || destinationShortCode == null) {
            return null
        }
        val visited = HashMap<Int, Boolean>()
        val adjMatrix = getAdjacencyMatrix();
        val queue = ArrayList<Int>()
        val prevAnchor = HashMap<Int, Int>()

        queue.add(startShortCode)
        visited.put(startShortCode, true)

        while (!queue.isEmpty()) {
            val currentAnchor = queue.removeAt(0)
            if (currentAnchor == destinationShortCode) {
                return generateRoute(prevAnchor, destinationShortCode)
            }
            val neighbourAnchors = adjMatrix.get(currentAnchor)
            neighbourAnchors?.forEach {
                if (!visited.getOrDefault(it, false)) {
                    visited.put(it, true)
                    queue.add(it)
                    prevAnchor.put(it, currentAnchor)
                }
            }
        }
        return null
    }

    private fun generateRoute(prevAnchorMap: HashMap<Int, Int>, destinationShortCode: Int): List<Int> {
        val route = LinkedList<Int>()
        var prevAnchorShortCode: Int? = destinationShortCode

        while (prevAnchorShortCode != null) {
            route.addFirst(prevAnchorShortCode)
            prevAnchorShortCode = prevAnchorMap.get(prevAnchorShortCode)
        }

        return route
    }
}