package com.github.thibstars.profiles.config;

import com.github.thibstars.profiles.SpringProfileUtils;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Autoconfiguration providing a bean of {@link SpringProfileUtils}.
 *
 * @author Thibault Helsmoortel
 */
@Configuration
@AllArgsConstructor
public class SpringProfileUtilsAutoConfiguration {

    private final Environment environment;

    @Bean
    public SpringProfileUtils springProfileUtils() {
        return new SpringProfileUtils(environment);
    }

}
