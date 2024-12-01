package com.trad.trad.infrastructure.entity.config;

import com.trad.trad.application.security.service.UserDetail;
import com.trad.trad.domain.exception.TradAppException;
import com.trad.trad.infrastructure.entity.User;
import com.trad.trad.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.domain.AuditorAware;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Optional;

public class TradAuditorAwareImp implements AuditorAware<Integer> {
    @Autowired
    private UserRepository repository;
    @Override
    public Optional<Integer> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication!= null && authentication.isAuthenticated() ){
            return Optional.of(repository.getByEmail(authentication.getName()).getId());
        }else{
            return Optional.empty();
        }

    }
}
