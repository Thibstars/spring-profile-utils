/*
 * Copyright (c) 2019 Thibault Helsmoortel.
 *
 * This file is part of spring-profile-utils.
 *
 * spring-profile-utils is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * spring-profile-utils is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with spring-profile-utils.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.github.thibstars.profiles.config;

import com.github.thibstars.profiles.SpringProfileUtils;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Auto configuration providing a bean of {@link SpringProfileUtils}.
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
