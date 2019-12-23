package link

object JosephuDemo {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, 3, 5, 2, 8)
    josephu(arr, 3, 3)



  }

  def josephu(arr: Array[Int], k: Int, m: Int) = {
    var cir = new CircleDoubleLink[Int]()
    for (elem <- arr) cir.add(elem)

    //先找到第k个人的前一个
    var cur1 = cir.search(k).pre

    println(cur1)
    while(cir.count >1){
      //找到第m个人
      for (i <- 1 to m) {
        cur1 = cur1.next
      }

      cir.delete(cur1.value)
    }

    cir.foreach(println)
  }
}


