package com.trad.trad.application.controller.implementation;
import com.trad.trad.application.controller.api.IUserApi;
import com.trad.trad.application.security.AuthCredentials;
import com.trad.trad.application.security.AuthenticationResponse;
import com.trad.trad.domain.dto.UserDto;
import com.trad.trad.domain.dto.ValidAccountDto;
import com.trad.trad.domain.exception.TradAppException;
import com.trad.trad.domain.services.Interfaz.IAuthenticationUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserImp implements IUserApi {
    @Autowired
    private IAuthenticationUser iAuthenticationUser;

    @Override
    public ResponseEntity<AuthenticationResponse> login(AuthCredentials credentials) {
        try {
            return ResponseEntity.ok(iAuthenticationUser.generateToken(credentials));
        }catch (BadCredentialsException err ){
            return new ResponseEntity<>(new AuthenticationResponse(err.getMessage()), HttpStatus.UNAUTHORIZED );
        }
    }

    @Override
    public ResponseEntity<UserDto> registerUser(@Valid UserDto userDto )  {
        return new ResponseEntity<>(iAuthenticationUser.registerUser(userDto) , HttpStatus.CREATED );
    }

    @Override
    public ResponseEntity<String> validAccount(@Valid ValidAccountDto validatedAccount) {
        try {
            return ResponseEntity.ok().body("Estado: " + iAuthenticationUser.validAccount(validatedAccount) );
        }catch (TradAppException ex){
            return new ResponseEntity<>(ex.getMessage(),ex.getHttpStatusCode());
        }
    }
}
