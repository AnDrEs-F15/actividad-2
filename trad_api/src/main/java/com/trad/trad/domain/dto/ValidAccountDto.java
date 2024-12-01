package com.trad.trad.domain.dto;

import com.trad.trad.domain.constants.TradMessageValid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
@Data
public class ValidAccountDto {
    @Email @NotEmpty
    private String email;
    @NotEmpty  @Pattern(regexp="\\d{6,}", message= TradMessageValid.NUMBER_VALID_SIZE )
    private String codeValidated;
}
