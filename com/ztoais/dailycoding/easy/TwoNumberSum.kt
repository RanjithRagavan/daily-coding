package com.ztoais.dailycoding.easy

//Sample input
/*
{
  "array": [3, 5, -4, 8, 11, 1, -1, 6],
  "targetSum": 10
}
 */
fun twoNumberSum(array: MutableList<Int>,targetSum:Int):List<Int>{
    val initialValue = array[0]

    val newArray = mutableListOf<Int>()

    array.drop(1).forEach{nextValue ->
        if(initialValue+nextValue == targetSum){
            return listOf(initialValue,nextValue)
        }else{
            newArray.add(nextValue)
        }
    }

    if(newArray.size >1){
        return twoNumberSum(newArray,targetSum)
    }

    return listOf()
}