package com.jsystems.qa.qaapi.model.device;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class User {
    @JsonProperty(required = true)
    public String imie;

    @JsonProperty(required = true)
    public String nazwisko;

    @JsonProperty(required = true)
    public List<Device> device;

}