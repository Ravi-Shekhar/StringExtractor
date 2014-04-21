package com.mps.util;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;

public class ValidationUtil {

    public static boolean isValidInputString(String input) throws IOException {
        if (StringUtils.isBlank(input)) {
            return false;
        }
        char firstCharacter = input.charAt(0);
        char lastCharacter = input.charAt((input.length()) - 1);
        if ((Character.isDigit(firstCharacter)) && (Character.isLetter(lastCharacter))) {
            return true;
        }
        return false;
    }
}
