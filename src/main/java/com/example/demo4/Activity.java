package com.example.demo4;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Value;

@JsonSerialize
@Value
public class Activity {

    @JsonProperty("nazwa")
    private String name;
    @JsonProperty("priorytet")
    private Integer priority;

}
