package com.ldblao.cv360.messages.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@JsonSerialize
public class ManagesRequest implements Serializable {
    @NotBlank
    @NotNull
    @NotEmpty
    @JsonProperty("mn_evaluator")
    private String mnEvaluator;

    @NotBlank
    @NotNull
    @NotEmpty
    @JsonProperty("mn_evaluated_person")
    private String mnEvaluatedPerson;

    @JsonProperty("mn_date")
    private Date mnDate;

    @NotBlank
    @NotNull
    @NotEmpty
    @JsonProperty("mn_status")
    private String mnStatus;
}
