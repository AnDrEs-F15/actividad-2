package com.trad.trad.domain.dto;

import com.trad.trad.domain.constants.TradMessageValid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;

@Data
public class UserDto {
    @NotEmpty(message = TradMessageValid.MESSAGE_NAME)
    private String name;
    @NotEmpty(message = TradMessageValid.MESSAGE_EMAIL)
    @Email(message = TradMessageValid.MESSAGE_INVALID_TYPE_EMAIL)
    private String email;
    @NotEmpty  @Pattern(regexp="\\d{6,}", message= TradMessageValid.NUMBER_VALID_SIZE )
    private String phone;
    @NotEmpty
    private String password;
}
