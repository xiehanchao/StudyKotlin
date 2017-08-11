package com.example.mac.studykotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import com.google.gson.Gson
import org.jetbrains.anko.*
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val forecastList = findViewById(R.id.forecast_list) as RecyclerView

        async {
            var requestForecastCommand = RequestForecastCommand("feffc99d76feb8c4c8283f6ec2fadfc8")
            val execute = requestForecastCommand.execute()
            println("execute = ${execute}")

            uiThread {
                forecastList.layoutManager = LinearLayoutManager(this@MainActivity)

                forecastList.adapter = ForecastListAdapter(execute.result, object : ForecastListAdapter.OnItemClickListener {
                    override fun invoke(forecast: DomainClasses.Future) {
                        toast(forecast.temperature)
                    }
                })
            }
        }

    }

    class AAA : RecyclerView.Adapter<ForecastListAdapter.MyViewHolder>() {
        override fun onBindViewHolder(holder: ForecastListAdapter.MyViewHolder?, position: Int) {


        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ForecastListAdapter.MyViewHolder {
            parent!!.ctx
        }

        override fun getItemCount(): Int {
        }

    }
}

operator fun ViewGroup.get(position: Int): View = getChildAt(position)

class RequestForecastCommand(val zipCode: String) : Command<DomainClasses.result> {
    override fun execute(): DomainClasses.result {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())

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