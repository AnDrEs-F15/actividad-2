package com.trad.trad.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "BUDGET")
public class Budget extends BudgetAbstract {
    @ManyToOne
    @JoinColumn(name = "USER_ID" , referencedColumnName = "USER_ID" )
    @CreatedBy
    private User ownBudget;
    @JsonIgnore
    @OneToMany(mappedBy = "id")
    private List<BudgetRecord> budgetRecords;
}
