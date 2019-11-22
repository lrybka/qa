package com.jsystems.qa.qaapi.model.azure;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AzureAuthor {

    @JsonProperty(value = "Authors", required = true)
    public List<AzureAuthor> deviceModel;

}
