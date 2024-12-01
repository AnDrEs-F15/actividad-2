package com.trad.trad.application.controller.implementation;

import com.trad.trad.application.controller.api.IBudgetApi;
import com.trad.trad.domain.dto.BudgetDto;
import com.trad.trad.domain.exception.TradAppException;
import com.trad.trad.domain.services.Interfaz.IBudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BudgetImp implements IBudgetApi {
    @Autowired
    private IBudgetService budgetService;
    @Override
    public ResponseEntity<Page<BudgetDto>> getBudgetByUser(Pageable pageable, Authentication authentication) {
        return ResponseEntity.ok(budgetService.getBudgetByUser(authentication,pageable));
    }

    @Override
    public ResponseEntity<HttpStatus> postBudget(BudgetDto budgetDto) {
            budgetService.saveBudget(budgetDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<HttpStatus> deleteBudget(int id) {
        budgetService.deleteBudget(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<String> updateBudget(int id, BudgetDto budgetDto) {
        return new ResponseEntity<>(budgetService.updateBudget(id,budgetDto), HttpStatus.OK);
    }
}
