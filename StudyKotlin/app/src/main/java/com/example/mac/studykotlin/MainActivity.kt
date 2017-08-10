package com.example.mac.studykotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import org.jetbrains.anko.async
import java.net.URL
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        async {
            var requestForecastCommand = RequestForecastCommand("feffc99d76feb8c4c8283f6ec2fadfc8")
            val execute = requestForecastCommand.execute()
            val map = execute.map { convertForecastItemToDomain(it) }

            println(map)
        }

    }

     fun convertForecastItemToDomain(it: DomainClasses.Future): DomainClasses.Future{
            val week=it.week.substring(2,3)
            return DomainClasses.Future(it.temperature,it.weather,it.wind,week,it.date)
     }
}


class RequestForecastCommand(val zipCode: String) : Command<ArrayList<DomainClasses.Future>> {
    override fun execute(): ArrayList<DomainClasses.Future> {
        val forecastRequest = ForecastRequest(zipCode)
        return  ForecastDataMapper().convertFromDataModel(forecastRequest.execute())

    }
}

class ForecastRequest(val zipCode: String) {
    companion object {
        private val URL = "http://v.juhe.cn/weather/index?format=2&cityname=苏州&key="
    }

    fun execute(): DomainClasses.result {
        val forecastJsonStr = URL(URL + zipCode).readText()
        return Gson().fromJson(forecastJsonStr, DomainClasses.result::class.java)
    }
}


//class RequestForecastCommand(val zipCode: String) : Command<DomainClasses.ForecastList> {
//    override fun execute(): DomainClasses.ForecastList {
//        val forecastRequest = ForecastRequest(zipCode)
//        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
//    }
//}
//

