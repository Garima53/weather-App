package com.example. weatherapp
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.example.weatherapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

//f3d1aed7cd01aa1bb451f09619c7e3cb

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        fetchWeatherData("Jaipur")
        searchCity()
    }

    private fun searchCity(){
        val searchView= binding.searchView
        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    fetchWeatherData(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
    }

     private fun fetchWeatherData(cityName:String) {
         val retrofit= Retrofit.Builder()
             .addConverterFactory(GsonConverterFactory.create())
             .baseUrl("https://api.openweathermap.org/data/2.5/")
             .build().create(ApiInterface::class.java)

         val response = retrofit.getWeatherData(cityName,"f3d1aed7cd01aa1bb451f09619c7e3cb","metric")
         response.enqueue(object : Callback<WeatherApp>{
             override fun onResponse(call: Call<WeatherApp>, response: Response<WeatherApp>) {
                 val responseBody=response.body()

                 if(response.isSuccessful && responseBody !=null){
                     val temperature= responseBody.main.temp.toString()
                     val humidity= responseBody.main.humidity
                     val windSpeed= responseBody.wind.speed
                     val sunRise= responseBody.sys.sunrise.toLong()
                     val sunSet= responseBody.sys.sunset.toLong()
                     val seaLevel= responseBody.main.pressure
                     val maxTemp= responseBody.main.temp_max
                     val minTemp= responseBody.main.temp_min

                     val condition= responseBody.weather.firstOrNull()?.main?:"unknown"

                     //Log.d("TAG","onResponse: $temperature")
                     binding.humidity?.text = "$humidity hfa"
                     binding.temp?.text = "$temperature °C"
                     binding.weather?.text=condition
                     binding.maxTemp?.text ="Max Temp:$maxTemp °C"
                     binding.minTemp?.text ="Min temp:$minTemp °C"
                     binding.windSpeed?.text ="$windSpeed m/s"
                     binding.sunRise?.text ="${time(sunRise)}"
                     binding.sunSet?.text ="${time(sunSet)}"
                     binding.sea?.text ="$seaLevel hPa %"
                     binding.condition?.text = condition
                     binding.Day?.text =dayName(System.currentTimeMillis())

                        binding.Date?.text=date()
                        binding.cityName?.text = cityName

                     changeImage(condition)
                 }
             }

             override fun onFailure(call: Call<WeatherApp>, t: Throwable) {

             }

         })

        }

    private fun changeImage(conditions:String) {
       when(conditions) {
           "Clear Sky", "Sunny", "Clear" -> {
               binding.root.setBackgroundResource(R.drawable.sunny)
               binding.lottieAnimationView?.setAnimation(R.raw.sun)
           }

           "Partly Clouds", "Clouds", "Overcast", "Mist", "Foggy","Smoke","Haze" -> {
               binding.root.setBackgroundResource(R.drawable.cloud_background)
               binding.lottieAnimationView?.setAnimation(R.raw.cloud)
           }

           "Light Rain", "Drizzle", "Moderate Rain", "Showers", "Heavy Rain" -> {
               binding.root.setBackgroundResource(R.drawable.rain_background)
               binding.lottieAnimationView?.setAnimation(R.raw.rain)
           }

           "Light Snow", "Moderate Snow", "Blizzard", "Heavy Snow"-> {
               binding.root.setBackgroundResource(R.drawable.snow_background)
               binding.lottieAnimationView?.setAnimation(R.raw.snow)
           }
           else ->{
               binding.root.setBackgroundResource(R.drawable.sunny)
               binding.lottieAnimationView?.setAnimation(R.raw.sun)
           }
       }
        binding.lottieAnimationView?.playAnimation()
    }

    private fun date(): String{

            val sdf= SimpleDateFormat("dd MMMM yyyy",Locale.getDefault())
            return sdf.format((Date()))
    }

    private fun time(timestamp: Long): String{

        val sdf= SimpleDateFormat("HH:mm",Locale.getDefault())
        return sdf.format((Date(timestamp * 1000)))
    }

    fun dayName(timestamp:Long): String{
        val sdf=SimpleDateFormat("EEEE", Locale.getDefault())
        return sdf.format((Date()))
     }
 }








