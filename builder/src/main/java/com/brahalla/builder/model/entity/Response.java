package com.brahalla.builder.model.entity;

import com.brahalla.builder.model.base.AbstractModel;
import com.brahalla.builder.model.base.AbstractModelBuilder;

import org.apache.commons.lang3.StringUtils;

public class Response extends AbstractModel {

  private String data;

  public Response(final Builder builder) {
    this.data = builder.getData();
  }

  public String getData() {
    return this.data;
  }

  public static class Builder implements AbstractModelBuilder {

    private String data;

    public static Builder create() {
      return new Builder();
    }

    public Builder withData(final String data) {
      this.data = data;
      return this;
    }

    public String getData() {
      return this.data;
    }

    public Builder fromRequest(final Request request) {
      this.data = StringUtils.reverse(request.getData());
      return this;
    }

    @Override
    public Response build() {
      return new Response(this);
    }

  }

}
