package com.jsystems.qa.qaapi.model.azure.book;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Book {

    @JsonProperty(value = "ID", required = true)
    public long id;

    @JsonProperty(value = "Title", required = true)
    public String title;

    @JsonProperty(value = "Description", required = true)
    public String description;

    @JsonProperty(value = "PageCount", required = true)
    public int pageCount;

    @JsonProperty(value = "Excerpt", required = true)
    public String excerpt;

    @JsonProperty(value = "PublishDate", required = true)
    public String publishDate;

}
