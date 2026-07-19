# Weather App 🌦️

A modern Android weather application that provides real-time weather information using the **OpenWeather API**. The app fetches live weather data based on searched cities and displays temperature, weather conditions, humidity, wind speed, and other essential details through a clean and interactive interface.

## 🚀 Features

- Real-time weather updates
- Search weather by city name
- Current temperature display
- Weather condition details
- Humidity and wind speed information
- Dynamic weather backgrounds
- Splash screen implementation
- Responsive Android UI
- REST API based data fetching


## 🛠️ Technologies Used

### Android Development
- Kotlin
- Android Studio
- XML Layout Design
- Android SDK

### API Integration
- OpenWeather API
- REST API
- JSON Parsing

### Libraries & Tools
- Retrofit (API Communication)
- Gson (JSON Conversion)
- Lottie Animation
- Gradle
- Git & GitHub

### Development Tools
- Android Studio
- VS Code
- Emulator / Android Device Testing


## 🔑 API Integration Flow

1. User enters a city name.
2. Application sends a request to the OpenWeather API.
3. API returns weather data in JSON format.
4. JSON response is parsed and displayed on the user interface.


## 📂 Project Structure

```
app/
│
├── java/com/example/weatherapp
│   ├── MainActivity.kt
│   └── SplashActivity.kt
│
├── res/
│   ├── layout/
│   ├── drawable/
│   ├── values/
│   └── raw/
│
└── assets/
    ├── weather animations
    ├── weather backgrounds
    └── custom fonts
```

## ⚙️ Setup & Installation

### 1. Clone Repository

```bash
git clone https://github.com/Garima53/weather-App.git
```

### 2. Open Project

Open the project in **Android Studio**.

### 3. Configure OpenWeather API Key

Create an API key from OpenWeather:

https://openweathermap.org/api

Add your API key in the project configuration:

```properties
API_KEY="YOUR_API_KEY"
```

### 4. Run Application

- Connect an Android device or start an emulator.
- Build and run the application.


## 📱 Screenshots

(Add application screenshots here)


## 🔮 Future Enhancements

- Weather forecast for upcoming days
- Weather notifications
- GPS-based automatic location detection
- Multiple saved cities
- Dark mode support


## 👩‍💻 Author

**Garima Gupta**

GitHub:  
https://github.com/Garima53


## 📄 License

This project is developed for learning and demonstration purposes.
