package com.ldblao.cv360.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "manages")
@Data
public class ManagesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mn_id;

    @Column(name = "mn_evaluator")
    private String mnEvaluator;

    @Column(name = "mn_evaluated_person")
    private String mnEvaluatedPerson;

    @Column(name = "mn_date")
    @JsonFormat(locale = "Asia/Bangkok", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date mnDate;

    @Column(name = "mn_status")
    private String mnStatus;

    @CreationTimestamp
    @Column(name = "mn_create_at")
    @JsonFormat(locale = "Asia/Bangkok", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date mnCreateAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    @JsonFormat(locale = "Asia/Bangkok", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;
}
