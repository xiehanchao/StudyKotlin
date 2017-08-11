package com.example.mac.studykotlin

/**
 * Created by MAC on 2017/8/10.
 */
class DomainClasses {

    data class result(
            val resultcode: String,
            val reason: String,
            val result: myResult,
            val error_code: Int
    )

    data class myResult(
            val sk: mySk,
            val future: ArrayList<Future>
    ) {
        operator fun get(position: Int): Future = future[position]
        fun size(): Int = future.size
    }


    data class mySk(
            val temp: String,
            val wind_direction: String,
            val wind_strength: String,
            val humidity: String,
            val time: String
    )


    data class Future(
            val temperature: String,
            val weather: String,
            val wind: String,
            val week: String,
            val date: String
    )


}