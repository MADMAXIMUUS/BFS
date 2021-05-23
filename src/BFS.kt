import java.io.File
import java.io.InputStream
import java.util.*

fun bfs(matrix: Array<IntArray>, startNode: Int, endNode: Int, n: Int): Boolean {
    var v = startNode
    val queue: Queue<Int> = LinkedList()
    queue.add(v)
    matrix[v][v] = 1
    while (!queue.isEmpty()) {
        v = queue.poll()
        if (v == endNode) return true
        for (u in 0 until n) {
            if ((matrix[v][u] and matrix[u][u].inv()) == 1) {
                println("v=$v \t u=$u")
                queue.add(u)
                matrix[u][u] = 1;
            }
        }
    }
    return false
}

fun main() {
    val inputStream: InputStream = File("src/input.txt").inputStream()
    val lineList = mutableListOf<String>()
    println("Введите количество вершин:")
    val n = readLine().toString().toInt()
    inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it) } }
    val matrix = Array(n) { IntArray(n) }
    for (i in matrix.indices) {
        val rowArray = lineList[i].split(" ")
        matrix[i] = rowArray.map { it.toInt() }.toIntArray()
    }

    println("Введите номер начальной вершины:")
    val startNode = readLine().toString().toInt()

    println("Введите номер искомой вершины:")
    val endNode = readLine().toString().toInt()

    println("\n"+bfs(matrix, startNode,endNode, n))
}


