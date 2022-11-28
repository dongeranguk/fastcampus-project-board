package com.fastcampus.projectboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@EnableJpaAuditing
@Configuration
public class JpaConfig {

    @Bean
    public AuditorAware<String> auditorAware() {
        return () -> Optional.of("du"); // TODO : 지금은 누가 입력하는지 인증 기능을 제공 하지 않으므로 식별 할 수 없으므로 스프링 시큐리티로 인증 기능을 붙이게 될 때, 수정 필요.
    }
}
