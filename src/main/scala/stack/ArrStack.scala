package stack

import scala.reflect.ClassTag

object ArrStackDemo {

}

class ArrStack[T: ClassTag](size: Int) {
  val arr = new Array[T](size)
  var top: Int = 0

  //判断栈空
  def isEmpty: Boolean = top == 0

  def isFull: Boolean = top == size - 1

  //入栈
  def push(ele: T): Unit = {
    if (!isEmpty) {
      top += 1  //注意：入栈时需要先将top位置上移
      arr(top) = ele
    } else
      throw new Exception("栈满")
  }

  //出栈
  def pop: T ={
    if(!isEmpty){
      var out = arr(top)
      top -=1
      out
    }else{
      throw new Exception("栈空")
    }
  }

}
