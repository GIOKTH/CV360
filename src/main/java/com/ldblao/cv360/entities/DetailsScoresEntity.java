package com.ldblao.cv360.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "detailsscores")
@Data
public class DetailsScoresEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ds_id")
    private Long dsId;

    @Column(name = "ds_no")
    private Long dsNo;

    @Column(name = "ds_score")
    private Long dsScore;

    @Column(name = "ds_name_la")
    private String dsNameLa;

    @Column(name = "ds_name_en")
    private String dsNameEn;

    @CreationTimestamp
    @Column(name = "ds_create_at")
    @JsonFormat(locale = "Asia/Bangkok", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dsCreatedAt;

    @UpdateTimestamp
    @Column(name = "ds_update_at")
    @JsonFormat(locale = "Asia/Bangkok", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dsUpdateAt;
}
