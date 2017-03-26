package com.brahalla.gateway;

public class OpenWeatherMapWeatherGateway implements WeatherGateway {

  @Override
  public Forecast getForecast() {
    System.out.println("Calling getForecast from OpenWeatherMapWeatherGateway!");
    Forecast forecast = new Forecast();
    forecast.setTemp("52");
    return forecast;
  }

}
