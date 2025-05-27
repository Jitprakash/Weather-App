package com.example.weather_app.controller;

import com.example.weather_app.model.WeatherInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class WeatherController {

    @Value("${api.key}")
    private String apiKey;

    @GetMapping("/")
    public String showIndex() {
        return "index";
    }

    @GetMapping("/weather")
    public String getWeather(@RequestParam("city") String city, Model model) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appId=" + apiKey + "&units=metric";
        System.out.println(url);

        //RestTemplate is a synchronous HTTP client used to make requests to external APIs and services in Spring. It allows applications to interact with RESTful web services.
        //✔ Part of Spring Framework → It’s built-in, no extra dependencies needed!
        RestTemplate restTemplate= new RestTemplate();
        WeatherInfo weatherInfo = restTemplate.getForObject(url, WeatherInfo.class);//- This method sends a GET request to the provided url and converts the response into an instance of WeatherInfo.

        if (weatherInfo != null) {
            model.addAttribute("city", weatherInfo.getName());
            model.addAttribute("country", weatherInfo.getSys().getCountry());
            model.addAttribute("weatherDescription", weatherInfo.getWeather().get(0).getDescription());
            model.addAttribute("temperature", weatherInfo.getMain().getTemp());
            model.addAttribute("humidity", weatherInfo.getMain().getHumidity());
            model.addAttribute("windSpeed", weatherInfo.getWind().getSpeed());

            //- "wi wi-owm-": This is a fixed prefix, likely used for Weather Icons in a CSS framework.
            String weatherIcon = "wi wi-owm-" + weatherInfo.getWeather().get(0).getId();//e.g-> let id is 100 then icon name is "wi wi-owm-800"

            model.addAttribute("weatherIcon", weatherIcon);
        } else {
            model.addAttribute("error", "City Not found!");
        }

        return "weather";
    }
}
