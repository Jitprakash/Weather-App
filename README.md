# 🌦️ Weather App

A simple and responsive Weather Application built using **Spring Boot**, **Thymeleaf**, **Bootstrap**, and the **OpenWeather API**.  
Enter a city name and instantly view real-time weather information including temperature, humidity, and general weather conditions.

## 🚀 Features

- Search weather by city name
- Real-time weather data using OpenWeather API
- Clean and responsive UI with Bootstrap
- Server-side rendering with Thymeleaf

## 🛠️ Tech Stack

- Java
- Spring Boot
- Thymeleaf
- Bootstrap
- OpenWeather API

## 🔧 Setup Instructions

1. **Clone the repository**  
   ```bash
   git clone https://github.com/Jitprakash/Weather-App.git
   cd Weather-App
    ```

2.**Add your OpenWeather API key**\
    Open `src/main/resources/application.properties` and add your API key:
    ```
    api.key=YOUR_API_KEY_HERE
    ```
   You can get a free API key by signing up at OpenWeather.

3. **Run the application**\
    Using Maven:
    ```
    mvn spring-boot:run
    ```
    
4.**Open in browser**\
    Visit `http://localhost:8080` and try it out!
