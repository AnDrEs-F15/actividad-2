package com.trad.trad.domain.services.Implementation;

import com.trad.trad.domain.dto.BudgetDto;
import com.trad.trad.domain.exception.TradAppException;
import com.trad.trad.domain.mappers.IBudgetMapper;
import com.trad.trad.domain.services.Interfaz.IBudgetService;
import com.trad.trad.infrastructure.entity.Budget;
import com.trad.trad.infrastructure.repository.IBudgetRepository;
import com.trad.trad.utils.GenerateDateId;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class BudgetServiceImp implements IBudgetService {
    @Autowired
    private IBudgetRepository budgetRepository;
    @Autowired
    private IBudgetMapper mapper;
    @Override
    public Page<BudgetDto> getBudgetByUser(Authentication authentication, Pageable pageable) {
        return mapper.toDto(
                budgetRepository
                        .findAllByOwnBudgetEmail(authentication.getName(),pageable)
                        .orElseThrow(()-> new TradAppException("Record invalid" , HttpStatus.BAD_REQUEST ))
        );
    }

    @Override
    public void saveBudget(BudgetDto budgetDto) {
        try {
            budgetDto.setBudgetDateId(GenerateDateId.generateDateId(budgetDto.getDateBegin()));
            if (!budgetRepository.findByBudgetDateId(budgetDto.getBudgetDateId()).isPresent()){
                budgetRepository.save(
                        mapper.toEntity(budgetDto)
                );
            }else throw new TradAppException("Existing budget for this date." , HttpStatus.BAD_REQUEST );

        }catch (Exception e){
            throw new TradAppException(e.getMessage() , HttpStatus.BAD_REQUEST );
        }
    }

    @Override
    public void deleteBudget(int id) {
        try {
            if (budgetRepository.findById(id).isPresent()){
                budgetRepository.deleteById(id);
            }else throw new TradAppException("Budget not exist" , HttpStatus.NOT_FOUND );
        }catch (Exception e){
            throw new TradAppException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional
    public String updateBudget(int id, BudgetDto budgetDto) {
                try {
                    budgetRepository.findById(id)
                            .map(item -> {
                                item.setBudgetValue(budgetDto.getBudgetValue());
                                budgetRepository.save(item);
                                return item;
                            } )
                            .orElseThrow(()-> new TradAppException("record does not exist", HttpStatus.NOT_FOUND ) );
                    return "record updated";
                }catch (TradAppException ex){
                    throw new TradAppException(ex.getMessage(),ex.getHttpStatusCode());
                }catch (Exception e){
                    throw new TradAppException(e.getMessage(), HttpStatus.BAD_REQUEST);
                }

        }

}
