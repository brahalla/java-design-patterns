package com.brahalla.gateway;

public class YahooWeatherGateway implements WeatherGateway {

  @Override
  public Forecast getForecast() {
    System.out.println("Calling getForecast from YahooWeatherGateway!");
    Forecast forecast = new Forecast();
    forecast.setTemp("53");
    return forecast;
  }

}
