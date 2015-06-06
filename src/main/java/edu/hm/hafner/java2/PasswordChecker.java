package edu.hm.hafner.java2;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;

import com.google.common.collect.Sets;

/**
 * Simple password checker.
 *
 * @author Ullrich Hafner
 */
public class PasswordChecker {
    /**
     * Checks whether the provided password is a strong password, i.e. contains at least 10 different characters.
     *
     * @param password the password to check
     * @return {@code true} if the password is valid, {@code false} otherwise
     */
    public boolean isValid(final String password) {
        Set<Character> characters = new HashSet<>();
        for (char current : password.toCharArray()) {
            characters.add(current);
        }
        return characters.size() >= 10;
    }

    /**
     * Checks whether the provided password is a strong password, i.e. contains at least 10 different characters.
     *
     * @param password the password to check
     * @return {@code true} if the password is valid, {@code false} otherwise
     */
    public boolean isValid2(final String password) {
        Set<Character> characters = Sets.newHashSet(ArrayUtils.toObject(password.toCharArray()));
        return characters.size() >= 10;
    }
}
