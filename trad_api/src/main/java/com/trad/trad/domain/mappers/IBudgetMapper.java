package com.trad.trad.domain.mappers;

import com.trad.trad.domain.dto.BudgetDto;
import com.trad.trad.infrastructure.entity.Budget;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IBudgetMapper {
    BudgetDto toDto (Budget entity);
    default Page<BudgetDto> toDto(Page<Budget> entity ){ return entity.map(this::toDto);}
    Budget toEntity (BudgetDto dto);
}
