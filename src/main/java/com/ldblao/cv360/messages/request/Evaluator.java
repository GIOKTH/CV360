package com.ldblao.cv360.messages.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Evaluator {
    @JsonProperty("evaluator")
    private String evaluator;
}
