package com.trad.trad.domain.services.Interfaz;

import com.trad.trad.domain.dto.BudgetDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;

public interface IBudgetService {
    Page<BudgetDto> getBudgetByUser (Authentication authentication , Pageable pageable);
    void saveBudget (BudgetDto budgetDto);
    void deleteBudget (int id);
    String updateBudget(int id, BudgetDto budgetDto );
}
