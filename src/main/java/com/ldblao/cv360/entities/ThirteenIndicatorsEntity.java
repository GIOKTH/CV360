package com.ldblao.cv360.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "thirteenindicators")
@Data
public class ThirteenIndicatorsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "thv_id")
    private Long thvId;

    @ManyToOne(targetEntity = SevenCoreValuesEntity.class, fetch = FetchType.EAGER)
    private SevenCoreValuesEntity sevenCoreValues;

    @Column(name = "thv_name_la")
    private String thvNameLa;

    @Column(name = "thv_name_en")
    private String thvNameEn;

    @Column(name = "scv_name_en")
    private String scvNameEn;

    @Column(name = "scv_name_la")
    private String scvNameLa;

    @CreationTimestamp
    @Column(name = "thv_create_at")
    @JsonFormat(locale="Asia/Bangkok",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date thvCreateAt;

    @UpdateTimestamp
    @Column(name = "thv_update_at")
    @JsonFormat(locale="Asia/Bangkok",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date thvUpdateAt;
}
