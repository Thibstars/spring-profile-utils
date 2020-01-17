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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author Thibault Helsmoortel
 */
@ActiveProfiles({"test", "myTestProfile"})
@SpringBootTest(classes = SpringProfileUtils.class)
class SpringProfileUtilsTest {

    @Autowired
    private SpringProfileUtils springProfileUtils;

    @Autowired
    private Environment environment;

    @DisplayName("Should find active profile")
    @Test
    void shouldFindActiveProfile() {
        assertDetected(environment.getActiveProfiles()[0]);
    }

    private void assertDetected(String activeProfile) {
        Assertions.assertTrue(springProfileUtils.isProfileActive(activeProfile), "Active profile must be detected.");
    }

    @DisplayName("Should find active profiles individually")
    @Test
    void shouldFindActiveProfilesIndividually() {
        for (String activeProfile : environment.getActiveProfiles()) {
            assertDetected(activeProfile);
        }
    }

    @DisplayName("Should find active profiles individually")
    @Test
    void shouldFindActiveProfiles() {
        Assertions.assertTrue(springProfileUtils.areProfilesActive(environment.getActiveProfiles()), "Active profiles must be detected.");
    }

    @DisplayName("Should not find inactive profile")
    @Test
    void shouldNotFindInactiveProfile() {
        assertNotDetected("profileThatDoesNotExistInCurrentContext");
    }

    private void assertNotDetected(String activeProfile) {
        Assertions.assertFalse(springProfileUtils.isProfileActive(activeProfile), "Inactive profile must not be detected.");
    }

    @DisplayName("Should not find inactive profiles individually")
    @Test
    void shouldNotFindInactiveProfilesIndividually() {
        Arrays.asList("profileThatDoesNotExistInCurrentContext", "someOtherProfileThatDoesNotExistInCurrentContext").forEach(this::assertNotDetected);
    }

    @DisplayName("Should not find inactive profiles")
    @Test
    void shouldNotFindInactiveProfiles() {
        Assertions.assertFalse(
            springProfileUtils.areProfilesActive(
                "profileThatDoesNotExistInCurrentContext", "someOtherProfileThatDoesNotExistInCurrentContext"),
            "Inactive profiles must not be detected.");
    }
}
