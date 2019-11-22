package com.jsystems.qa.qaapi.model.azure;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AzureAuthor {

    @JsonProperty(required = true)
    public String type;

    @JsonProperty(value = "Authors", required = true)
    public List<AzureAuthor> Authors;

}
