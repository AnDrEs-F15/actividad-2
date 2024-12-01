package com.trad.trad.application.controller.api;

import com.trad.trad.application.security.AuthCredentials;
import com.trad.trad.application.security.AuthenticationResponse;
import com.trad.trad.domain.constants.TradAppPaths;
import com.trad.trad.domain.dto.UserDto;
import com.trad.trad.domain.dto.ValidAccountDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(TradAppPaths.AUTH_PATH)
public interface IUserApi {
    @PostMapping(value = "/login",produces = "application/json")
    public ResponseEntity<AuthenticationResponse> login (@RequestBody AuthCredentials credentials);
    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto );
    @PostMapping("/validAccount")
    public ResponseEntity<String> validAccount(@RequestBody @Valid ValidAccountDto validatedAccount);
}
