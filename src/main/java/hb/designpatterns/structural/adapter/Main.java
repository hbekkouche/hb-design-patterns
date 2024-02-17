package hb.designpatterns.structural.adapter;

// Interface representing the unified weather service
interface WeatherService {
    String getTemperature();
    String getWindSpeed();
}

// Adapters for Third-Party Weather Services

// Adapter for ThirdPartyWeatherService1Impl
class ThirdPartyWeatherService1Adapter implements WeatherService {
    private ThirdPartyWeatherService1Impl service;

    public ThirdPartyWeatherService1Adapter(ThirdPartyWeatherService1Impl service) {
        this.service = service;
    }

    @Override
    public String getTemperature() {
        // Convert the temperature from ThirdPartyWeatherService1Impl format to the unified format
        double temperatureCelsius = service.getTemperatureCelsius();
        return String.valueOf(temperatureCelsius) + "°C";
    }

    @Override
    public String getWindSpeed() {
        // Convert the wind speed from ThirdPartyWeatherService1Impl format to the unified format
        double windSpeedKmph = service.getWindSpeedKmph();
        return String.valueOf(windSpeedKmph) + " km/h";
    }
}

// Adapter for ThirdPartyWeatherService2Impl
class ThirdPartyWeatherService2Adapter implements WeatherService {
    private ThirdPartyWeatherService2Impl service;

    public ThirdPartyWeatherService2Adapter(ThirdPartyWeatherService2Impl service) {
        this.service = service;
    }

    @Override
    public String getTemperature() {
        // Convert the temperature from ThirdPartyWeatherService2Impl format to the unified format
        double temperatureFahrenheit = service.getTemperatureFahrenheit();
        return String.valueOf(temperatureFahrenheit) + "°F";
    }

    @Override
    public String getWindSpeed() {
        // Convert the wind speed from ThirdPartyWeatherService2Impl format to the unified format
        double windSpeedMph = service.getWindSpeedMph();
        return String.valueOf(windSpeedMph) + " mph";
    }
}

// Concrete implementations of Third-party weather services

// Third-party weather service 1
class ThirdPartyWeatherService1Impl {
    public double getTemperatureCelsius() {
        // Sample implementation to get temperature in Celsius from third-party service 1
        return 25.5;
    }

    public double getWindSpeedKmph() {
        // Sample implementation to get wind speed in kilometers per hour from third-party service 1
        return 15.3;
    }
}

// Third-party weather service 2
class ThirdPartyWeatherService2Impl {
    public double getTemperatureFahrenheit() {
        // Sample implementation to get temperature in Fahrenheit from third-party service 2
        return 77.0;
    }

    public double getWindSpeedMph() {
        // Sample implementation to get wind speed in miles per hour from third-party service 2
        return 9.0;
    }
}

// Client code using the unified WeatherService interface
public class Main {
    public static void main(String[] args) {
        // Using First Third-party Weather Service
        ThirdPartyWeatherService1Impl service1 = new ThirdPartyWeatherService1Impl();
        WeatherService adapter1 = new ThirdPartyWeatherService1Adapter(service1);

        System.out.println("Temperature: " + adapter1.getTemperature());
        System.out.println("Wind Speed: " + adapter1.getWindSpeed());

        // Using Second Third-party Weather Service
        ThirdPartyWeatherService2Impl service2 = new ThirdPartyWeatherService2Impl();
        WeatherService adapter2 = new ThirdPartyWeatherService2Adapter(service2);

        System.out.println("Temperature: " + adapter2.getTemperature());
        System.out.println("Wind Speed: " + adapter2.getWindSpeed());
    }
}
