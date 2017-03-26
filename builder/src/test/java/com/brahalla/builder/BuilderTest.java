package com.brahalla.builder;

import com.brahalla.builder.model.entity.Request;
import com.brahalla.builder.model.entity.Response;

import com.flextrade.jfixture.JFixture;

import java.lang.StringBuilder;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuilderTest {

  private final JFixture fixture = new JFixture();
  private String requestData;
  private String responseData;

  @Before
  public void before() {
    this.requestData = this.fixture.create(String.class);
    this.responseData = new StringBuilder(requestData).reverse().toString();
  }

  @Test
  public void buildingRequest_WithNullData_ReturnsExpectedObject() {
    Request request = Request.Builder.create().withData(null).build();

    assertNull(request.getData());
  }

  @Test
  public void buildingResponse_WithNullData_ReturnsExpectedObject() {
    Response response = Response.Builder.create().withData(null).build();

    assertNull(response.getData());
  }

  @Test
  public void buildingRequest_WithData_ReturnsExpectedObject() {
    Request request = Request.Builder.create().withData(this.requestData).build();

    assertEquals(this.requestData, request.getData());
  }

  @Test
  public void buildingResponse_WithData_ReturnsExpectedObject() {
    Response response = Response.Builder.create().withData(this.responseData).build();

    assertEquals(this.responseData, response.getData());
  }

  @Test
  public void buildingResponse_FromRequest_ReturnsExpectedObject() {
    Request request = Request.Builder.create().withData(this.requestData).build();
    Response response = Response.Builder.create().fromRequest(request).build();

    assertEquals(this.responseData, response.getData());
  }

}
