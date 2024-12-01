package com.trad.trad.application.controller.api;

import com.trad.trad.domain.constants.TradAppPaths;
import com.trad.trad.domain.dto.BudgetDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RequestMapping(TradAppPaths.BUDGET_PATH)
public interface IBudgetApi {
    @GetMapping
     ResponseEntity<Page<BudgetDto>> getBudgetByUser (
            @PageableDefault Pageable pageable,
            Authentication authentication
    );
    @PostMapping
    ResponseEntity<HttpStatus> postBudget (@RequestBody BudgetDto budgetDto );
    @DeleteMapping("/{id}")
    ResponseEntity<HttpStatus> deleteBudget(@PathVariable(value = "id") int id );
    @PutMapping("/{id}")
    ResponseEntity<String> updateBudget (
            @PathVariable(value = "id") int id ,
            @RequestBody BudgetDto budgetDto );

}
