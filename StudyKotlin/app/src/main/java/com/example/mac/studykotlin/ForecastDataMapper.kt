package com.example.mac.studykotlin

import java.text.DateFormat
import com.example.mac.studykotlin.DomainClasses.Forecast as ModelForecast
import java.util.*

/**
 * Created by MAC on 2017/8/10.
 */

public class ForecastDataMapper {
//    fun convertFromDataModel(forecast: DomainClasses.ForecastResult): DomainClasses.ForecastList {
//        return DomainClasses.ForecastList(forecast.city.name, forecast.city.country, convertForecastItemToDomain(forecast.list))
//        fun convertForecastListToDomain(list: List<DomainClasses.Forecast>): List<ModelForecast> {
//            return list.map { convertForecastItemToDomain(it) }
//        }
//
//        fun convertForecastItemToDomain(forecast: List<DomainClasses.Forecast>): ModelForecast {
//            return ModelForecast(convertDate(forecast.dt), forecast.weather[0].description, forecast.temp.max.toInt(), forecast.temp.min.toInt())
//        }
//
//        fun convertDate(date: Long): String {
//            val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
//            return df.format(date * 1000)
//        }
//    }

    fun convertFromDataModel(forecast: DomainClasses.result): ArrayList<DomainClasses.Future> {
        val Future = forecast.result
        return Future.future
    }

}