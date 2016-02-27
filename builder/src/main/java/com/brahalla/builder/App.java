package com.brahalla.builder;

import com.brahalla.builder.model.builder.RequestBuilder;
import com.brahalla.builder.model.builder.ResponseBuilder;
import com.brahalla.builder.model.entity.Request;
import com.brahalla.builder.model.entity.Response;

public class App {

  public static void main(String[] args) {

    Request request = RequestBuilder.create().withData("abc123").build();
    Response response = ResponseBuilder.create().fromRequest(request).build();

    System.out.println(String.format("Request: %s, Response: %s", request, response));

  }

}
