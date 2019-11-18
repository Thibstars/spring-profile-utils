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

    public boolean isProfileActive(String profile) {
        return Arrays.asList(environment.getActiveProfiles()).contains(profile);
    }

    public boolean areProfilesActive(String... profiles) {
        return Arrays.asList(environment.getActiveProfiles()).containsAll(Arrays.asList(profiles));
    }
}
