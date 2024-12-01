package com.trad.trad.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "BUDGET_RECORD")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BudgetRecord {
    @Id
    @Column(name = "RECORD_ID")
    private int id;
    @Column(name = "RECORD_VALUE")
    private int recordValue;
    @Column(name = "RECORD_DESCRIPTION")
    private String recordDescription;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "BUDGET_ID" , referencedColumnName = "BUDGET_ID")
    private Budget budget;
    @OneToMany(mappedBy = "id.budgetRecord")
    private List<BudgetCategoryRecord> categoryRecords;
}
