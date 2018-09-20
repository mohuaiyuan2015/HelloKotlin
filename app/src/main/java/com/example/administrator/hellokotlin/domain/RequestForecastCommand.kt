package com.example.administrator.hellokotlin.domain

import com.example.administrator.hellokotlin.databases.ForecastRequest

class RequestForecastCommand(val zipCode: String) :Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        val forecastResult=forecastRequest.execute()
        return ForecastDataMapper().convertFromDataModel(forecastResult)
    }
}