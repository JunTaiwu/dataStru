package test

object MergeSort3 {
  def main(args: Array[String]): Unit = {
    val arr = Array(2,1,5)
    mergeSort(arr,0,arr.length-1,new Array[Int](arr.length))
    println(arr.mkString(","))
  }

  def mergeSort(arr: Array[Int], left: Int, right: Int, temp: Array[Int]): Unit = {
    if (left < right) {
      //求出中间值
      val mid = (left + right) / 2
      mergeSort(arr, left, mid, temp)
      mergeSort(arr, mid + 1, right, temp)
      merge(arr, left, mid, right, temp)
    }
  }

  def merge(arr: Array[Int], left: Int, mid: Int, right: Int, temp: Array[Int]): Unit = {
    var i = left
    var j = mid + 1
    var t = 0

    while (i <= mid && j <= right) {
      if (arr(i) <= arr(j)) {
        temp(t) = arr(i)
        i += 1
        t += 1
      } else {
        temp(t) = arr(j)
        j += 1
        t += 1
      }
    }

    while (i <= mid) {
      temp(t) = arr(i)
      i += 1
      t += 1
    }

    while (j <= right) {
      temp(t) = arr(j)
      j += 1
      t += 1
    }

    t = 0
    var tempLeft = left
    while (tempLeft <= right) {
      arr(tempLeft) = temp(t)
      t += 1
      tempLeft += 1
    }

  }
}
