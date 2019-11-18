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

package com.github.thibstars.profiles;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;

/**
 * Utility class enabling programmatic checks on Spring profiles.
 *
 * @author Thibault Helsmoortel
 */
@AllArgsConstructor
@SuppressWarnings("WeakerAccess") // Methods should be available publicly
public class SpringProfileUtils {

    private final Environment environment;

    /**
     * Returns true if the provided profile is activated in the current environment.
     *
     * @param profile the parameter to check
     * @return true if the provided profile is activated, false if otherwise
     */
    public boolean isProfileActive(String profile) {
        return Arrays.asList(environment.getActiveProfiles()).contains(profile);
    }

    /**
     * Returns true if the provided profiles are activated in the current environment.
     *
     * @param profiles the parameters to check
     * @return true if the provided profiles are activated, false if otherwise
     */
    public boolean areProfilesActive(String... profiles) {
        return Arrays.asList(environment.getActiveProfiles()).containsAll(Arrays.asList(profiles));
    }
}
