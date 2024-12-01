package com.trad.trad.infrastructure.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BudgetCategoryRecordPK implements Serializable {

    @JoinColumn(name = "RECORD_ID" , referencedColumnName = "RECORD_ID")
    @ManyToOne
    private BudgetRecord budgetRecord;
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "CATEGORY_ID")
    @ManyToOne
    private BudgetCategory budgetCategory;
}
