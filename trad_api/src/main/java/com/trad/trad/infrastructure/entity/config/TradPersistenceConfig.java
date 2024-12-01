package com.trad.trad.infrastructure.entity.config;

import com.trad.trad.infrastructure.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class TradPersistenceConfig {
    @Bean
    AuditorAware<Integer> auditorProvider(){return new TradAuditorAwareImp(); }
}
