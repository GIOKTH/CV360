package com.ldblao.cv360.messages.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@JsonSerialize
public class SevenCoreScoreValueRequest implements Serializable {
    @NotBlank
    @NotNull
    @NotEmpty
    @JsonProperty("scv_name_la")
    private String scvNameLa;

    @NotBlank
    @NotNull
    @NotEmpty
    @JsonProperty("scv_name_en")
    private String scvNameEn;
}
