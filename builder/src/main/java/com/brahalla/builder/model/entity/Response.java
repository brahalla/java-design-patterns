package com.brahalla.builder.model.entity;

import com.brahalla.builder.model.base.AbstractModel;
import com.brahalla.builder.model.builder.ResponseBuilder;

public class Response extends AbstractModel {

  private String data;

  public Response() {
    super();
  }

  public Response(final ResponseBuilder builder) {
    this.data = builder.getData();
  }

  public String getData() {
    return this.data;
  }

}
