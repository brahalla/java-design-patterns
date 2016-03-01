package com.brahalla.builder.model.entity.builder;

import com.brahalla.builder.model.base.AbstractModelBuilder;
import com.brahalla.builder.model.entity.Request;
import com.brahalla.builder.model.entity.Response;

import org.apache.commons.lang3.StringUtils;

public class ResponseBuilder implements AbstractModelBuilder {

  private String data;

  public ResponseBuilder() {
    super();
  }

  public static ResponseBuilder create() {
    return new ResponseBuilder();
  }

  public ResponseBuilder withData(final String data) {
    this.data = data;
    return this;
  }

  public String getData() {
    return this.data;
  }

  public ResponseBuilder fromRequest(final Request request) {
    this.data = StringUtils.reverse(request.getData());
    return this;
  }

  @Override
  public Response build() {
    return new Response(this);
  }

}
