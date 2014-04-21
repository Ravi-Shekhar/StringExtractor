package com.mps.main;

import com.mps.service.StringService;
import com.mps.service.StringServiceException;
import com.mps.service.impl.StringServiceImpl;

public class StringExtractor {

    public static void main(String[] args) throws Exception {
        try {
            String input = getStringService().getInputFromUser();
            getStringService().generateOutput(input);
        } catch (StringServiceException stringServiceException) {
            System.out.println(stringServiceException.getMessage());
        }
    }

    private static StringService getStringService() {
        return StringServiceImpl.getInstance();
    }
}
