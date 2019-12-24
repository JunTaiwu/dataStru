package select

object selectSort {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, 3, 2, 6, 4, 8)
    val arr1 = selectSort(arr)
    println(arr1.mkString(","))
  }

  def selectSort(arr: Array[Int]) = {
    for (i <- 0 until arr.length - 1) {             //每循环一次就找到一个当前的最小值，最后一个值不需要和其他比较，故只需要寻找n-1次
      var minindex = i                          //每次循环前，先假定当前的第一个值为最小值
      for (j <- i + 1 until arr.length) {           //从当前循环值开始，在后续的所有元素中循环遍历，看能否找到比该值还要小的值
        if (arr(j) < arr(minindex)) minindex = j    //如果找到了一个值比上面的值小，将其索引更新到minindex
      }

      if (i != minindex) {                          //当内层循环完毕后，更新当前第一个值为最小值
        swap(arr, i, minindex)
      }
    }
    arr
  }

  def swap(arr: Array[Int], index1: Int, index2: Int): Unit = {
    val temp = arr(index1)
    arr(index1) = arr(index2)
    arr(index2) = temp
  }

}
