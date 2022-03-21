package com.ldblao.cv360.messages.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
public class MultiManage {
    @NotBlank
    @NotNull
    @NotEmpty
    @JsonProperty("mn_evaluator")
    private List<Evaluator> mnEvaluator;

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
