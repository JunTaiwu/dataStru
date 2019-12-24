package mergesort

object MergeSort {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, 2, 4, 6, 2, 4)
    mergeSorts(arr, 0, arr.length - 1)
    println(arr.mkString(","))
  }

  def mergeSorts(arr: Array[Int], left: Int, right: Int): Unit = {
    if (left >= right) return
    var mid = (left + right) / 2

    mergeSorts(arr, left, mid)
    mergeSorts(arr, mid + 1, right)

    merge(arr, left, mid, right)
  }

  def merge(arr: Array[Int], left: Int, mid: Int, right: Int): Unit = {
    //把传进来的数组按照中值切分为两个数组
    val sta = arr.slice(left, mid) //slice从0开始，前闭后开
    val en = arr.slice(mid, right + 1)

    var m = 0
    var n = 0
    for (i <- left to right) {
      if (m > sta.length - 1) {
        arr(i) = en(n)
        n += 1
      } else if (n > en.length - 1) {
        arr(i) = sta(m)
        m += 1
      } else if (sta(m) <= en(n)) {
        arr(i) = sta(m)
        m += 1
      } else if(sta(m) > en(n)) {
        arr(i) = en(n)
        n += 1
      }
    }
  }
}
