package com.jsystem.qa.qaapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Device {

    @JsonProperty(required = true)
    public String type;

    @JsonProperty(value = "device.model", required = true)
    List<DeviceModel>  deviceModel;

}
