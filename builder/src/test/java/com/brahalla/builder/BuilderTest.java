package com.brahalla.builder;

import com.brahalla.builder.model.builder.RequestBuilder;
import com.brahalla.builder.model.builder.ResponseBuilder;
import com.brahalla.builder.model.entity.Request;
import com.brahalla.builder.model.entity.Response;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BuilderTest {

  private final static String REQUEST_DATA = "abc123";
  private final static String RESPONSE_DATA = "321cba";

  @Test
  public void buildingRequestWithNullDataReturnsExpectedObject() {
    Request request = RequestBuilder.create().withData(null).build();
    assertNull(request.getData());
  }

  @Test
  public void buildingResponseWithNullDataReturnsExpectedObject() {
    Response response = ResponseBuilder.create().withData(null).build();
    assertNull(response.getData());
  }

  @Test
  public void buildingRequestWithDataReturnsExpectedObject() {
    Request request = RequestBuilder.create().withData(REQUEST_DATA).build();
    assertEquals(REQUEST_DATA, request.getData());
  }

  @Test
  public void buildingResponseWithDataReturnsExpectedObject() {
    Response response = ResponseBuilder.create().withData(RESPONSE_DATA).build();
    assertEquals(RESPONSE_DATA, response.getData());
  }

  @Test
  public void buildingResponseFromRequestReturnsExpectedObject() {
    Request request = RequestBuilder.create().withData(REQUEST_DATA).build();
    Response response = ResponseBuilder.create().fromRequest(request).build();
    assertEquals(RESPONSE_DATA, response.getData());
  }

}
