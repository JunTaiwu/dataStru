package mergesort

/**
  * 此种方式更容易理解
  */
object MergeSort2 {
  def main(args: Array[String]): Unit = {
    val arr = Array(3, 1, 7, 4, 9, 7, 6)
    mergeSort(arr, 0, arr.length - 1, new Array[Int](arr.length))
    println(arr.mkString(","))
  }

  def mergeSort(arr: Array[Int], left: Int, right: Int, temp: Array[Int]): Unit = {
    if (left < right) { //(3,1,6,8)  left = 0 right =3
      val mid = (left + right) / 2 //mid = 1
      mergeSort(arr, left, mid, temp) //mergeSort()  -->
      mergeSort(arr, mid + 1, right, temp)
      merge(arr, left, mid, right, temp)
    }
  }

  def merge(arr: Array[Int], left: Int, mid: Int, right: Int, temp: Array[Int]): Unit = {
    var i = left
    var j = mid + 1
    var t = 0
    //在两个数组中挑最小的放在临时数组中
    while (i <= mid && j <= right) {
      if (arr(i) <= arr(j)) {
        temp(t) = arr(i)
        t += 1
        i += 1
      } else {
        temp(t) = arr(j)
        t += 1
        j += 1
      }
    }
    //挑完之后，如果左边的还有剩余，则将左边的数据依次放入到临时数组
    while (i <= mid) {
      temp(t) = arr(i)
      t += 1
      i += 1
    }
    //如果挑完之后右边还有剩余，则将右边的数据依次放入到临时数组中
    while (j <= right) {
      temp(t) = arr(j)
      t += 1
      j += 1
    }
    //将temp数组中的数据拷贝到left到right这段区域内
    t = 0
    var tempLeft = left
    while (tempLeft <= right) {
      arr(tempLeft) = temp(t)
      t += 1
      tempLeft += 1
    }
  }
}
