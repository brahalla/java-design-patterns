package com.brahalla.builder.model.entity.builder;

import com.brahalla.builder.model.base.AbstractModelBuilder;
import com.brahalla.builder.model.entity.Request;

public class RequestBuilder implements AbstractModelBuilder {

  private String data;

  public RequestBuilder() {
    super();
  }

  public static RequestBuilder create() {
    return new RequestBuilder();
  }

  public RequestBuilder withData(final String data) {
    this.data = data;
    return this;
  }

  public String getData() {
    return this.data;
  }

  @Override
  public Request build() {
    return new Request(this);
  }

}