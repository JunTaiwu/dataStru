package link

object CircleDoubleLinkDemo {
  def main(args: Array[String]): Unit = {
    val link = new CircleDoubleLink[Int]()
    link.add(1)
    link.add(3)
    link.add(2)
    link.foreach(println)
println("00000000000000000000000000000")
    println(link.search(2))
  }
}

class CircleDoubleLink[T:Ordering] extends DoubleLink[T]{
  override def add(ele: T): Boolean = {
    super.add(ele)
    tail.next = head
    head.pre = tail
    true
  }

  override def delete(ele: T): Boolean = {
    if(super.delete(ele)){
      tail.next = head
      head.pre = tail
      true
    }else{
      false
    }

  }

  //从头开始，找到第i个人
  def search(i:Int): Node =  {
    if(i==1){
      return head
    }else{
      var cur = head
      for (i <- 1 to i-1){
        cur = cur.next
      }
      return cur
    }

  }

  override def foreach(op: T => Unit): Unit = {
    var current = head
    while(current !=null){
      op(current.value)
      if(current == tail) return
      current = current.next
    }
  }
}
