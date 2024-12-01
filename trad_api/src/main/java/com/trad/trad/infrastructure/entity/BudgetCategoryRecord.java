package com.trad.trad.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CATEGORY_BUDGET_RECORD")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BudgetCategoryRecord {
    @EmbeddedId
    private BudgetCategoryRecordPK id;
    @Column(name = "ACTIVE")
    private Boolean active = Boolean.TRUE;
}
