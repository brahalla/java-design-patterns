package com.brahalla.builder;

import com.brahalla.builder.model.entity.Request;
import com.brahalla.builder.model.entity.Response;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BuilderTest {

  private final static String REQUEST_DATA = "abc123";
  private final static String RESPONSE_DATA = "321cba";

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
    Request request = Request.Builder.create().withData(REQUEST_DATA).build();
    assertEquals(REQUEST_DATA, request.getData());
  }

  @Test
  public void buildingResponse_WithData_ReturnsExpectedObject() {
    Response response = Response.Builder.create().withData(RESPONSE_DATA).build();
    assertEquals(RESPONSE_DATA, response.getData());
  }

  @Test
  public void buildingResponse_FromRequest_ReturnsExpectedObject() {
    Request request = Request.Builder.create().withData(REQUEST_DATA).build();
    Response response = Response.Builder.create().fromRequest(request).build();
    assertEquals(RESPONSE_DATA, response.getData());
  }

}
