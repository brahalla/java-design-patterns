package com.brahalla.builder.model.entity;

import com.brahalla.builder.model.base.AbstractModel;
import com.brahalla.builder.model.base.AbstractModelBuilder;

public class Request extends AbstractModel {

  private String data;

  public Request(final Builder builder) {
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

    @Override
    public Request build() {
      return new Request(this);
    }

  }

}
