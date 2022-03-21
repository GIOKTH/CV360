package com.ldblao.cv360.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "scores")
@Data
public class ScoresEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sc_id")
    private Long scId;

    @ManyToOne(targetEntity = ManagesEntity.class, fetch = FetchType.EAGER)
    private ManagesEntity manages;

    @ManyToOne(targetEntity = ThirteenIndicatorsEntity.class, fetch = FetchType.EAGER)
    private ThirteenIndicatorsEntity thirteenIndicators;

    @ManyToOne(targetEntity = DetailsScoresEntity.class, fetch = FetchType.EAGER)
    private DetailsScoresEntity detailsScores;

    @Column(name = "sc_date")
    @JsonFormat(locale="Asia/Bangkok",pattern = "YYYY-MM-DD HH:MM:SS")
    private Date scDate;

    @Column(name = "sc_remark_strength")
    private String scRemarkStrength;

    @Column(name = "sc_remark_weakness")
    private String scRemarkWeakness;

    @Column(name = "sc_remark_solutions")
    private String scRemarkSolutions;

    @Column(name = "sc_own_work")
    private String scOwnWork;

    @CreationTimestamp
    @Column(name = "sc_create_at")
    @JsonFormat(locale="Asia/Bangkok",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date scCreateAt;

    @UpdateTimestamp
    @Column(name = "sc_update_at")
    @JsonFormat(locale="Asia/Bangkok",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date scUpdateAt;
}
