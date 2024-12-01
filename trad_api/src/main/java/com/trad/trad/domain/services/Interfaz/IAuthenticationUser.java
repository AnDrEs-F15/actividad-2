package com.trad.trad.domain.services.Interfaz;

import com.trad.trad.application.security.AuthCredentials;
import com.trad.trad.application.security.AuthenticationResponse;
import com.trad.trad.domain.dto.UserDto;
import com.trad.trad.domain.dto.ValidAccountDto;
import jakarta.validation.Valid;

public interface IAuthenticationUser {
    public AuthenticationResponse generateToken (AuthCredentials credentials);
    public UserDto registerUser (@Valid  UserDto userDto);
    public void sendMailToVerifyAccount (String email);
    public Boolean validAccount(ValidAccountDto validatedAccount);
}
