package com.dnsimple.response;

import com.dnsimple.Service;

import com.google.api.client.util.Key;

public class GetServiceResponse extends ApiResponse {
  @Key("data")
  private Service data;

  public Service getData() {
    return data;
  }

}
