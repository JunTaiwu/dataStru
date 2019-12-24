package bubble

/**
  * 冒泡排序需要注意内外层循环的次数
  * 外层循环表示有多少个元素需要排序，（2个元素的数组有一个需要排序，3个元素的数组有两个需要排序，，，n个元素有n-1个需要排序）
  * 内层表示每次排序需要比较的次数，第j个值需要比较n-1-i次
  *
  */
object BubbleSortDemo {
  def main(args: Array[String]): Unit = {
    val arr = Array(2, 3, 5, 1, 6)
    val arr2 = bubbleSort(arr)
    println(arr2.mkString(","))

  }

  //每次比较只比较相邻的值，如果前一个值大于后一个值，则交换
  def bubbleSort(arr: Array[Int]) = {
    for (i <- 0 until arr.length - 1) { //每次循环都找一个当前循环的最大值 总共需要找n-1次
      for (j <- 0 until arr.length - i - 1) { //每次找时，都需要和剩余的所有的元素进行比较 n-i-1
        if (arr(j) > arr(j + 1)) swap(arr, j, j + 1) //如果前面的值大于后面的值，交换顺序
      }
    }
    arr
  }

  //在原数组上进交换
  def swap(arr: Array[Int], index1: Int, index2: Int): Unit = {
    val temp = arr(index1)
    arr(index1) = arr(index2)
    arr(index2) = temp
  }
}

