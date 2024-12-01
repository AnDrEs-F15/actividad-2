package com.trad.trad.application.security;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class AuthCredentials {
    private String username ;
    private String password;
}
