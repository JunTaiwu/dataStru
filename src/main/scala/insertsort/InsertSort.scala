package insertsort

object InsertSortDemo {
  def main(args: Array[String]): Unit = {
    val arr = Array(3,34 ,-9,78,2, 15, 9)
    println(insertSort(arr).mkString(","))
  }

  def insertSort(arr: Array[Int]) ={
    for (i <-1 until arr.length) {                   //相当于对手中的牌进行排序，从第二张开始需要进行排序  前i张牌（手中的牌）是有序的
      for (j <- 0 until i) {                         //此后每抽到一张排都需要和手中的其他牌进行比较，循环手中牌数量的次数
        if (arr(i) < arr(j)) swap(arr, i, j)         //   如果抽到的牌比此刻被比较的牌小，则把抽到的牌往前挪
      }
    }
    arr
  }


  def swap(arr: Array[Int], index1: Int, index2: Int): Unit = {
    var temp = arr(index1)
    arr(index1) = arr(index2)
    arr(index2) = temp
  }
}


