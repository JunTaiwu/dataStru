package test

object StruTest {
  def main(args: Array[String]): Unit = {
    val arr = Array(3, 1, 5, 7, 2, 8)
    mergeSort(arr, 0, arr.length - 1)
    println(arr.mkString(","))
  }

  def mergeSort(arr: Array[Int], low: Int, high: Int): Unit = {
    if (low >= high) return
    val mid: Int = (low + high) / 2
    mergeSort(arr, low, mid)
    mergeSort(arr, mid + 1, high)
    merge(arr, low, mid, high)

  }

  def merge(arr: Array[Int], low: Int, mid: Int, high: Int): Unit = {
    val left = arr.slice(low, mid + 1)
    val right = arr.slice(mid + 1, high + 1)

    var i = 0
    var j = 0
    for (k <- low to high) {
      if (i > left.length - 1) {
        arr(k) = right(j)
        j += 1
      } else if (j > right.length - 1) {
        arr(k) = left(i)
        i += 1
      } else if (left(i) <= right(j)) {
        arr(k) = left(i)
        i += 1
      } else {
        arr(k) = right(j)
        j += 1
      }

    }

  }
}
