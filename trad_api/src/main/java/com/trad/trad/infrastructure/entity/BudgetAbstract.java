package com.trad.trad.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public abstract class BudgetAbstract {
    @Id
    @Column(name = "BUDGET_ID")
    private int id;
    @Column(name = "BUDGET_DATE_ID")
    private int budgetDateId;
    @Column(name = "BUDGET_DATE")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateBegin;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "BUDGET_DATE_END")
    private Date dateEnd;
    @Column(name = "BUDGET_VALUE")
    private int budgetValue;
    @Column(name = "ACTIVE")
    private boolean active = Boolean.TRUE;
}
