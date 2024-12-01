package com.trad.trad.application.security.service;

import com.trad.trad.infrastructure.entity.User;
import com.trad.trad.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetail  implements UserDetailsService {
    @Autowired
    private UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User findUser = repository
                .findByActiveEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("Usuario no existe") );
        return new TradUserDetailImpl(findUser) ;
    }
}
