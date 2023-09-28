package com.ztoais.dailycoding.algoexpert.medium

import kotlin.io.path.createTempDirectory

/*
 Three Number Sum

Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum. The
function should find all triplets in the array that sum up to the target sum and return a two-dimensional array of all
these triplets. The numbers in each triplet should be ordered in ascending order, and the triplets themselves should be
ordered in ascending order with respect to the numbers they hold.

If no three numbers sum up to the target sum, the function should return an empty array.

Sample Input:
array = [12,3,1,2,-6,5,-8,6]
targetSum = 0

Sample Output:
[[-8,2,6],[-8,3,5],[-6,1,5]]
 */

fun threeNumberSum(array: MutableList<Int>, targetSum: Int):List<List<Int>>{
    //1. Sort the array
    //2. Current number firs
    //3. User Right and left pointer movement one at time.
    //4. Left pointer movement increase the current sum
    //5. Right pointer movement decrease the current sum
    //6. If the target sum equal then move the left and right same time
    //7. Time : O(N2) Space:  O(N)
    array.sort()
    val result = mutableListOf<List<Int>>()
    for(i in 0..array.size-2){
        var left = i+1
        var right = array.size-1
        while(left < right){
            val currentSum = array[i]+array[left]+array[right]
            if(currentSum == targetSum){
                result.add(listOf(array[i],array[left],array[right]))
                left+=1
                right-=1
            }else if(currentSum < targetSum){
                left+=1
            }else if(currentSum > targetSum){
                right-=1
            }
        }
    }

    return result
}


/*
Tests

Test Case 1
{
  "array": [12, 3, 1, 2, -6, 5, -8, 6],
  "targetSum": 0
}
Test Case 2
{
  "array": [1, 2, 3],
  "targetSum": 6
}
Test Case 3
{
  "array": [1, 2, 3],
  "targetSum": 7
}
Test Case 4
{
  "array": [8, 10, -2, 49, 14],
  "targetSum": 57
}
Test Case 5
{
  "array": [12, 3, 1, 2, -6, 5, 0, -8, -1],
  "targetSum": 0
}
Test Case 6
{
  "array": [12, 3, 1, 2, -6, 5, 0, -8, -1, 6],
  "targetSum": 0
}
Test Case 7
{
  "array": [12, 3, 1, 2, -6, 5, 0, -8, -1, 6, -5],
  "targetSum": 0
}
Test Case 8
{
  "array": [1, 2, 3, 4, 5, 6, 7, 8, 9, 15],
  "targetSum": 18
}
Test Case 9
{
  "array": [1, 2, 3, 4, 5, 6, 7, 8, 9, 15],
  "targetSum": 32
}
Test Case 10
{
  "array": [1, 2, 3, 4, 5, 6, 7, 8, 9, 15],
  "targetSum": 33
}
Test Case 11
{
  "array": [1, 2, 3, 4, 5, 6, 7, 8, 9, 15],
  "targetSum": 5
}
 */