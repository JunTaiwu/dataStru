package queue

import scala.reflect.ClassTag

object CircleQueueDemo {
  def main(args: Array[String]): Unit = {
    val queue = new CircleQueue[Int](4)
    queue.enQueue(1)
    queue.enQueue(2)
    queue.enQueue(3)
    queue.enQueue(4)
    println(queue.deQueue)
    queue.enQueue(5)
    println(queue.deQueue)
    println(queue.deQueue)
    println(queue.deQueue)
    println(queue.deQueue)

  }
}

class CircleQueue[T: ClassTag](size: Int) {
  val arr = new Array[T](size)

  var head = 0
  var tail = 0
  //采用了一个计数器，
  var count = 0

  //是否为空
  def isEmpty: Boolean = count == 0

  //是否已满
  def isFull: Boolean = count == size

  //入队
  def enQueue(ele: T) = {
    if (!isFull) {
      arr(tail) = ele
      tail += 1
      count += 1
      if(tail == size) tail = 0
      true
    }else{
      throw new Exception("full")
    }
  }

  //出队
  def deQueue ={
   if(!isEmpty){
     val out = arr(head)
     head +=1
     count-=1
     if(head ==size) head = 0
     out
   }else{
     throw new Exception("empty")
   }
  }

}