package com.claro.nicouema.configuration.segurity;

import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@NoArgsConstructor
@Component
public class SecurityBeans {


    @Bean
    protected PasswordEncoder encoder()  {
        return new BCryptPasswordEncoder();
    }

}
