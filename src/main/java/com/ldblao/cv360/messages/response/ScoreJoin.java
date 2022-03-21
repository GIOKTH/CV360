package com.ldblao.cv360.messages.response;

import lombok.Data;

import java.util.Date;

@Data
public class ScoreJoin {
    private Long scId;
    private Long scMnId;
    private Long scThvId;
    private Date scDate;
    private String scRemarkStrength;
    private String scRemarkWeakness;
    private String scRemarkSolutions;
    private String scOwnWork;
    private Date scCreateAt;
    private Date scUpdateAt;
    private Long scDetailsScoreId;
    private Long mnId;
    private String mnEvaluator;
    private String mnEvaluatedPerson;
    private Date mnDate;
    private String mnStatus;
    private Date mnCreateAt;
    private Date createdAt;
    private Date updatedAt;
}
