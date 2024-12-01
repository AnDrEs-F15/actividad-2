package com.trad.trad.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "BUDGET_CATEGORY")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class BudgetCategory {
    @Id
    @Column(name = "CATEGORY_ID")
    private int id;
    @Column(name = "CATEGORY_NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private User user;

    @OneToMany(mappedBy = "id.budgetCategory" )
    private List<BudgetCategoryRecord> recordsByCategory;

}
