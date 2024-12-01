package com.trad.trad.domain.services.Implementation;

import com.trad.trad.application.security.AuthCredentials;
import com.trad.trad.application.security.AuthenticationResponse;
import com.trad.trad.application.security.jwt.TokenUtils;
import com.trad.trad.application.security.service.UserDetail;
import com.trad.trad.domain.dto.UserDto;
import com.trad.trad.domain.dto.ValidAccountDto;
import com.trad.trad.domain.exception.TradAppException;
import com.trad.trad.domain.exception.TradAppExceptionMessage;
import com.trad.trad.domain.mappers.IUserMapper;
import com.trad.trad.domain.services.Interfaz.IAuthenticationUser;
import com.trad.trad.domain.services.Interfaz.ITradSendMail;
import com.trad.trad.infrastructure.entity.User;
import com.trad.trad.infrastructure.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationUser implements IAuthenticationUser {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetail tradUserDetail;
    @Autowired
    private IUserMapper userMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ITradSendMail sendMail;
    @Override
    public AuthenticationResponse generateToken(AuthCredentials credentials) {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            credentials.getUsername(),
                            credentials.getPassword()
                    )
            );
          return new AuthenticationResponse(TokenUtils.createToken(credentials.getUsername())) ;
    }

    @Override
    public UserDto registerUser(@Valid  UserDto userDto) {
            if(!userRepository.findByEmail(userDto.getEmail()).isPresent()) {
                userRepository.save(userMapper.toEntity(userDto));
                this.sendMailToVerifyAccount(userDto.getEmail());
            } else throw new TradAppException("Correo existente", HttpStatus.BAD_REQUEST );
        return userMapper.toDto(userRepository
                .findByEmail(userDto.getEmail())
                .orElseThrow(()-> new TradAppException(TradAppExceptionMessage.errorSaving, HttpStatus.NOT_FOUND )  ));
    }

    @Override
    public void sendMailToVerifyAccount(String email) {
        sendMail.sendEmail(
                 email,
                "Verify account with a code" ,
                 userRepository
                         .findByEmail(email)
                         .orElseThrow(()-> new TradAppException("Something wrong with email", HttpStatus.NOT_FOUND )  )
                         .getCodeValidated()
        );
    }
    @Override
    public Boolean validAccount(ValidAccountDto validatedAccount) {
        if (userRepository.activeAccountByCode(validatedAccount.getEmail(),validatedAccount.getCodeValidated()).isPresent()){
                User user =  userRepository.findByEmail(validatedAccount.getEmail()).get();
                user.setCodeValidated();user.setIsAccountValidated(true);
                userRepository.saveAndFlush(user); return true;
            }else {
                throw new TradAppException("Codigo o correo no valido" , HttpStatus.BAD_REQUEST );
            }
    }
}
