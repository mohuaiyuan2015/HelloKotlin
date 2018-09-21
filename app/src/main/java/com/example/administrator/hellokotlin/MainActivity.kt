package com.example.administrator.hellokotlin

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.TextView
import com.example.administrator.hellokotlin.domain.Forecast
import com.example.administrator.hellokotlin.domain.RequestForecastCommand
import org.jetbrains.anko.async
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //可空 属性的声明
//    private  var context :Context?=null

    //后期初始化 属性的声明
    private lateinit var context :Context

    //延迟初始化  属性的声明
    private val mStr:String by lazy {
        "我是延迟初始化字符串 变量"
    }


//    private lateinit var message: TextView
//    private lateinit var forecastList: RecyclerView


    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context=this;

//        init()
        initListenter()
        initData()

        message.text="Hello Kotlin \n"

        toast("Hello World")
        longToast("Hello Kotlin")




    }

    private fun initData() {
        Log.d("yfing.wei","initData....")


        forecastList.layoutManager=LinearLayoutManager(context)

        async() {
            Log.d("yfing.wei","async()...")
            val result=RequestForecastCommand("94043").execute()
            Log.d("yfing.wei","result:"+result)
            uiThread {
                //origin code
//                forecastList.adapter = ForecastListAdapter(result)
                //style 1
//                forecastList.adapter = ForecastListAdapter(result,
//                        object : ForecastListAdapter.OnItemClickListener {
//                            override fun invoke(forecast: Forecast) {
//                                toast(forecast.date)
//                            }
//                        })

//                //style 2
//                forecastList.adapter = ForecastListAdapter( result, { forecast: Forecast -> toast(forecast.date) } )
//                //style 3
//                forecastList.adapter = ForecastListAdapter( result)  { forecast: Forecast -> toast(forecast.date) }
//                //style 4
                forecastList.adapter = ForecastListAdapter( result)  { toast(it.date) }
            }


        }

    }

    private fun initListenter() {

    }

//    private fun init(){
//        message=findViewById(R.id.message) as TextView
//        forecastList=findViewById(R.id.forecastList) as RecyclerView
//
//    }
}
