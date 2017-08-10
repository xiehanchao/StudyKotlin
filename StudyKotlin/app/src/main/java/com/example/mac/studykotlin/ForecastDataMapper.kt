package com.example.mac.studykotlin

import com.example.mac.studykotlin.DomainClasses.result as Result
import java.util.*


/**
 * Created by MAC on 2017/8/10.
 */

public class ForecastDataMapper {



    fun convertFromDataModel(forecast: Result): ArrayList<DomainClasses.Future> {
        val Future = forecast.result
        return Future.future
    }

}