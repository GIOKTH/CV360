package com.ldblao.cv360.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "sevencorevalues")
public class SevenCoreValuesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scv_id")
    private Long scvId;

    @Column(name = "scv_name_la")
    private String scvNameLa;

    @Column(name = "scv_name_en")
    private String scvNameEn;

    @CreationTimestamp
    @Column(name = "scv_create_at")
    @JsonFormat(locale="Asia/Bangkok",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date scvCreateAt;

    @UpdateTimestamp
    @Column(name = "scv_update_at")
    @JsonFormat(locale="Asia/Bangkok",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date scvUpdateAt;
}
