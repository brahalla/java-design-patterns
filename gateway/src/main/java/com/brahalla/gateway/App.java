package com.brahalla.gateway;

public class App {

  public static void main(String[] args) {

    WeatherGateway gateway = new OpenWeatherMapWeatherGateway();
    Forecast forecast = gateway.getForecast();
    System.out.println(String.format("The current temperature is: %s", forecast.getTemp()));

    gateway = new YahooWeatherGateway();
    forecast = gateway.getForecast();
    System.out.println(String.format("The current temperature is: %s", forecast.getTemp()));

  }

}
