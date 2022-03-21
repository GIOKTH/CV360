package com.ldblao.cv360.messages.request;

import brave.internal.Nullable;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ScoreRequest {
    @JsonProperty("sc_mn_id")
    private Long scMnId;

    @JsonProperty("sc_thv_id")
    private Long scThvId;

    @JsonProperty("sc_details_score_id")
    private Long scDetailsScoreId;

    @Nullable
    @JsonProperty("sc_date")
    private Date scDate = new Date();

    @NotEmpty
    @NotNull
    @NotBlank
    @JsonProperty("sc_remark_strength")
    private String scRemarkStrength;

    @NotEmpty
    @NotNull
    @NotBlank
    @JsonProperty("sc_remark_wekness")
    private String scRemarkWeakness;

    @NotEmpty
    @NotNull
    @NotBlank
    @JsonProperty("sc_remark_solutions")
    private String scRemarkSolutions;

    @NotEmpty
    @NotNull
    @NotBlank
    @JsonProperty("sc_own_work")
    private String scOwnWork;
}
