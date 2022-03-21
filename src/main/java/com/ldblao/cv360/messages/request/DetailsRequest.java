package com.ldblao.cv360.messages.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class DetailsRequest {
    @JsonProperty("ds_no")
    private Long dsNo;

    @JsonProperty("ds_score")
    private Long dsScore;

    @NotBlank
    @NotNull
    @NotEmpty
    @JsonProperty("ds_name_la")
    private String dsNameLa;

    @NotBlank
    @NotNull
    @NotEmpty
    @JsonProperty("ds_name_en")
    private String dsNameEn;
}
