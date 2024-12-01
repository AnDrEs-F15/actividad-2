package com.trad.trad.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class BudgetDto {
    private int id;
    private int budgetDateId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateBegin;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateEnd;
    private int budgetValue;
    private boolean active;
}
