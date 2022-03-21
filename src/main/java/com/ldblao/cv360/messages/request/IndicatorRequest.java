package com.ldblao.cv360.messages.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class IndicatorRequest {
    @NotEmpty
    @NotNull
    @NotBlank
    @JsonProperty("thv_name_la")
    private String thvNameLa;

    @NotEmpty
    @NotNull
    @NotBlank
    @JsonProperty("thv_name_en")
    private String thvNameEn;

    @JsonProperty("thv_scv_id")
    private Long thvScvId;

    @NotEmpty
    @NotNull
    @NotBlank
    @JsonProperty("scv_name_en")
    private String scvNameEn;

    @NotEmpty
    @NotNull
    @NotBlank
    @JsonProperty("sc_name_la")
    private String scvNameLa;
}
