package com.example.administrator.hellokotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.administrator.hellokotlin.domain.ForecastList
import com.example.administrator.hellokotlin.domain.Forecast
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

import kotlinx.android.synthetic.main.item_forecast.view.*

class ForecastListAdapter(val weekForecast: ForecastList,
                          val itemClick: (Forecast)->Unit)
    : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    //original code
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        return ViewHolder(TextView(parent.context))
//
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        with(weekForecast.dailyForecast[position]) {
//            holder.textView.text = "$date - $description - $high /$low"
//        }
//    }
//
//    override fun getItemCount(): Int = weekForecast.dailyForecast.size
//
//
//    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast.dailyForecast[position])
    }

    override fun getItemCount(): Int = weekForecast.dailyForecast.size

    //style 2
//    class ViewHolder(view: View, val itemClick: (Forecast)->Unit): RecyclerView.ViewHolder(view) {
//        private val iconView: ImageView
//        private val dateView: TextView
//        private val descriptionView: TextView
//        private val maxTemperatureView: TextView
//        private val minTemperatureView: TextView
//        init {
//            iconView = view.find(R.id.icon)
//            dateView = view.find(R.id.dateText)
//            descriptionView = view.find(R.id.descriptionText)
//            maxTemperatureView = view.find(R.id.maxTemperature)
//            minTemperatureView = view.find(R.id.minTemperature)
//        }
//        fun bindForecast(forecast: Forecast) {
//            with(forecast) {
//                Picasso.with(itemView.context).load(iconUrl).into(iconView)
//                dateView.text = date
//                descriptionView.text = description
//                maxTemperatureView.text = "${high.toString()}"
//                minTemperatureView.text = "${low.toString()}"
//                itemView.setOnClickListener { itemClick(forecast) }
//            }
//        }
//    }

    //sytle 3
    class ViewHolder(view: View, val itemClick: (Forecast)->Unit): RecyclerView.ViewHolder(view) {
        //        private val iconView: ImageView
//        private val dateView: TextView
//        private val descriptionView: TextView
//        private val maxTemperatureView: TextView
//        private val minTemperatureView: TextView
//        init {
//            iconView = view.find(R.id.icon)
//            dateView = view.find(R.id.dateText)
//            descriptionView = view.find(R.id.descriptionText)
//            maxTemperatureView = view.find(R.id.maxTemperature)
//            minTemperatureView = view.find(R.id.minTemperature)
//        }
        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.context).load(iconUrl).into(itemView.icon)
                itemView.dateText.text = date
                itemView.descriptionText.text = description
                itemView.maxTemperature.text = "${high.toString()}"
                itemView.minTemperature.text = "${low.toString()}"
                itemView.setOnClickListener { itemClick(forecast) }
            }
        }
    }


    public interface OnItemClickListener {
        operator fun invoke(forecast: Forecast)
    }

}