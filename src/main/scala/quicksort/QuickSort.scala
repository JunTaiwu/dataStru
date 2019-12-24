package quicksort

object QuickSortDemo {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, 2, 6, 3, 8, 4, 9)
    quickSort(arr, 0, arr.length-1)
    println(arr.mkString(","))
  }

  //left为左指针，right为右指针 排序完成后左边小右边大
  def quickSort(arr: Array[Int], left: Int, right: Int): Unit = {
    if (right <= left) return
    val mid = quickPartitioin(arr: Array[Int], left: Int, right: Int)
    //对左边的数据进行快排
    quickSort(arr, left, mid - 1)
    //对右边的数据进行快排
    quickSort(arr, mid + 1, right)
  }

  def quickPartitioin(arr: Array[Int], left: Int, right: Int): Int = {
    var low = left
    var high = right
    var p = arr(left)

    while (low < high) {
      //从low往右，找到一个比p大的值，当arr(low)>p时停止 或者low已经找到high的位置还没有找到，也需要停止
      while (low <= high && arr(low) <= p) {
        low += 1
      }
      //从high往左，找一个比p小的值
      while (high >= low && arr(high) > p) {
        high -= 1
      }
      //如果low的位置仍然小于high,则交换两个位置的值
      if (low <= high) {
        swap(arr, low, high)
      }
    }

    //当上述一次 循环完成后，将p放到正确的位置，high的位置
    swap(arr, left, high)
    high
  }

  def swap(arr: Array[Int], index1: Int, index2: Int): Unit = {
    val temp = arr(index1)
    arr(index1) = arr(index2)
    arr(index2) = temp
  }
}
