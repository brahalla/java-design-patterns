package com.brahalla.builder;

import com.brahalla.builder.model.entity.Request;
import com.brahalla.builder.model.entity.Response;

public class App {

  public static void main(String[] args) {

    Request request = Request.Builder.create().withData("abc123").build();
    Response response = Response.Builder.create().fromRequest(request).build();

    System.out.println(String.format("Request: %s", request));
    System.out.println(String.format("Response: %s", response));

  }

}
