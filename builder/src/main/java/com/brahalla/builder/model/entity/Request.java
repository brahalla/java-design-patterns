package com.brahalla.builder.model.entity;

import com.brahalla.builder.model.base.AbstractModel;
import com.brahalla.builder.model.entity.builder.RequestBuilder;

public class Request extends AbstractModel {

  private String data;

  public Request() {
    super();
  }

  public Request(final RequestBuilder builder) {
    this.data = builder.getData();
  }

  public String getData() {
    return this.data;
  }

}
