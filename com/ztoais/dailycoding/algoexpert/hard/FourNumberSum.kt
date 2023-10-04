package com.ztoais.dailycoding.algoexpert.hard

/*
 Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum. The
 function should find all quadruplets in the array that sum up to the target sum and return a tow-dimensional array of
 all these quadruplets in no particular order.

 If no four numbers sum up to the target sum, the function should return an empty array

 Sample input
 array = [7,6,4,-1,1,2]
 targetSum = 16

 Sample output
 [[7,6,4,-1],[7,6,1,2]]
 */

/*

 */

fun fourNumberSum(array: MutableList<Int>, targetSum:Int):List<List<Int>>{
    val result = mutableListOf<List<Int>>()
    val appPairSums = mutableMapOf<Int,List<Pair<Int,Int>>>()
    for (i in 1 until array.size-1) {
        for(j in i+1 until array.size){
            val currentSum:Int = array[i]+array[j]
            val difference = targetSum - currentSum
            if(appPairSums.containsKey(difference)){
                val pairValues = appPairSums[difference]
                pairValues?.let {
                    for(pair in it){
                        val quadruplets = listOf(pair.first,pair.second, array[i], array[j])
                        result.add(quadruplets)
                    }

                }

            }
        }
        for(k in 0 until i){
            val currentSum = array[i]+array[k]
            if(!appPairSums.containsKey(currentSum)){
                appPairSums[currentSum] = listOf(Pair(array[k],array[i]))
            }else{
                val pairList = appPairSums[currentSum]?.toMutableList()
                pairList?.add(Pair(array[k],array[i]))
                if (pairList != null) {
                    appPairSums[currentSum] = pairList.toList()
                }
            }
        }
    }

    return result
}



/*


Tests

Quick Test

Sandbox


Test Case 1
{
  "array": [7, 6, 4, -1, 1, 2],
  "targetSum": 16
}
Test Case 2
{
  "array": [1, 2, 3, 4, 5, 6, 7],
  "targetSum": 10
}
Test Case 3
{
  "array": [5, -5, -2, 2, 3, -3],
  "targetSum": 0
}
Test Case 4
{
  "array": [-2, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9],
  "targetSum": 4
}
Test Case 5
{
  "array": [-1, 22, 18, 4, 7, 11, 2, -5, -3],
  "targetSum": 30
}
Test Case 6
{
  "array": [-10, -3, -5, 2, 15, -7, 28, -6, 12, 8, 11, 5],
  "targetSum": 20
}
Test Case 7
{
  "array": [1, 2, 3, 4, 5],
  "targetSum": 100
}
Test Case 8
{
  "array": [1, 2, 3, 4, 5, -5, 6, -6],
  "targetSum": 5
}
 */