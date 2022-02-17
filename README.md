# ds-algos

Data Structures and Algorithms in Java

## Sorting

* [Selection Sort](./src/main/java/com/felix/ds/sort/SelectionSort.java)
  * Time Complexity = <code>O(n<sup>2</sup>)</code>
  * Space Complexity = `O(1)`
  * Not Adaptive

* [Bubble Sort](./src/main/java/com/felix/ds/sort/BubbleSort.java)
  * Time Complexity = <code>O(n<sup>2</sup>)</code>
  * Space Complexity = `O(1)`
  * Adaptive

* [Insertion Sort](./src/main/java/com/felix/ds/sort/InsertionSort.java)
  * Time Complexity = <code>O(n<sup>2</sup>)</code>
  * Space Complexity = `O(1)`
  * Adaptive
  * In average case, Insertion sort performs fewer comparisions and fewer swaps than Bubble sort

* [Shell Sort](./src/main/java/com/felix/ds/sort/ShellSort.java)
  * Shell sort users Insertion sort, the entire list id divided and those sub-lists are sorted.
  * Getting the exact complexity of shell sort is hard because it depends on the increment values choosen
  * Also it's not clear what the best incement value is
  * The complexity of shell sort is better than insertion sort as the final iteration with ***increment = 1*** has to work with ***nearly sorted list***
  * We can say, the Time Complexity of shell sort is somewhere between `O(n)` and <code>O(n<sup>2</sup>)</code>
  * Adaptive; since it's based on Insertion sort which is adaptive
  * Space complexity = `O(1)`

* [Merge Sort](./src/main/java/com/felix/ds/sort/MergeSort.java)

* [Quick Sort](./src/main/java/com/felix/ds/sort/QuickSort.java)

* [Binary Search](.src/main/java/com/felix/ds/search/BinarySearch.java)

* Binary Tree






