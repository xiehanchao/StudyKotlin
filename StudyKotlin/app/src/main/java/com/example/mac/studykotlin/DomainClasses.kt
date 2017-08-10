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
    )

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


    data class ForecastList(val city: String, val country: String,
                            val dailyForecast: List<Forecast>)

    data class ForecastResult(val city: City, val list: List<Forecast>)
    data class City(val id: Long, val name: String, val coord: Coordinates,
                    val country: String, val population: Int)

    data class Coordinates(val lon: Float, val lat: Float)
    data class Forecast(val dt: Long, val temp: Temperature, val pressure: Float,
                        val humidity: Int,
                        val weather: List<Weather>,
                        val speed: Float,
                        val deg: Int,
                        val clouds: Int,
                        val rain: Float)

    data class Temperature(val day: Float, val min: Float, val max: Float, val night: Float, val eve: Float, val morn: Float)
    data class Weather(val id: Long, val main: String, val description: String, val icon: String)

}