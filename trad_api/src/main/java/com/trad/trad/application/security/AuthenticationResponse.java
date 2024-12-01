package com.trad.trad.application.security;

import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class AuthenticationResponse {
    private String tokenJwt;
}
