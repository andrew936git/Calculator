package com.example.calculator

class Operation(private val first: String, private val second: String) {

    fun sum(): String{
        val result = convertToInt(first) + convertToInt(second)
        return convertToString(result)
    }

    fun dif(): String{
        val result = convertToInt(first) - convertToInt(second)
        return convertToString(result)
    }

    private fun convertToInt(value: String):Int{
        val hour:Int
        val minute: Int
        val second: Int
        var subText: String
        if (value.contains('h')) {
            subText = value.substringBefore('h')
            hour = subText.toInt() * 3600
        }
        else hour = 0
        if (value.contains('m')) {
            subText = value.substringAfter('h')
            minute = subText.substringBefore('m').toInt() * 60
        }
        else minute = 0
        if (value.contains('s')) {
            subText = value.substringAfter('m')
            second = subText.substringBefore('s').toInt()
        }
        else second = 0
        return  hour + minute + second
    }
    private fun convertToString(value: Int): String{
        val hour = value / 3600
        val minute = (value - hour * 3600) / 60
        val second = (value - hour * 3600) - minute * 60
        return "${hour}h${minute}m${second}s"
    }
}