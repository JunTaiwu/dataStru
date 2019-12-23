package link

object DoubleLinkDemo {
  def main(args: Array[String]): Unit = {
    val link = new DoubleLink[Int]()
    link.add(1)
    link.add(3)
    link.add(2)
    link.foreach(println)

    link.delete(2)
    println("===================")
    link.foreach(println)


  }
}

class DoubleLink[T: Ordering] {
  var head: Node = _
  var tail: Node = _
  var count: Int = _

  //添加元素
  def add(ele: T): Boolean = {
    val node = Node(ele, null, null)
    if (head == null) {
      head = node
      tail = node
    } else {
      tail.next = node
      node.pre = tail
      tail = node
    }
    count += 1
    true
  }

  //删除元素
  def delete(ele: T): Boolean = {
    find(ele) match {
      case Some(current) =>
        if (current == head) {
          head = head.next
          head.pre = null
        } else if (current == tail) {
          tail = tail.pre
          tail.next = null
        } else {
          current.next.pre = current.pre
          current.pre.next = current.next
        }
      case _ =>
    }
    count -= 1
    true
  }

  def find(ele: T): Option[Node] = {
    val ord: Ordering[T] = implicitly[Ordering[T]]
    var current = head
    while (current != null) {
      if (ord.equiv(ele, current.value)) return Some(current)
      current = current.next
    }
    None
  }

  //遍历元素
  def foreach(op: T => Unit): Unit = {
    var currentNode = head
    while (currentNode != null) {
      op(currentNode.value)
      currentNode = currentNode.next
    }
  }

  case class Node(value: T, var pre: Node, var next: Node) {
    override def toString: String = value.toString
  }

}
