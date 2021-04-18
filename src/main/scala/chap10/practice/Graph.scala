package chap10.practice

case class Edge(to: Int, w: Long)

case class Graph(n: Int) {
  val g: Array[List[Edge]] = Array.fill(n)(List.empty)

  def push(from: Int, edge: Edge): Unit = {
    g(from) ::= edge
  }
}
