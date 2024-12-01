package com.trad.trad.infrastructure.repository;

import com.trad.trad.infrastructure.entity.Budget;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IBudgetRepository extends JpaRepository<Budget,Integer> {
    Optional<Page<Budget>> findAllByOwnBudgetEmail(String user, Pageable pageable);
    Optional<Budget> findByBudgetDateId(int dateId);
}
