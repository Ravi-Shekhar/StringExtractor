package com.mps.service.impl;

import static com.mps.util.constant.Constants.COMMA_SEPERATED;
import static com.mps.util.constant.Constants.ENTER_INPUT;
import static com.mps.util.constant.Constants.EXCEPTION_MESSAGE;
import static com.mps.util.constant.Constants.EXCEPTION_MESSAGE_ON_OUTPUT;
import static com.mps.util.constant.Constants.INVALID_INPUT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.mps.service.StringService;
import com.mps.service.StringServiceException;
import com.mps.util.FileUtil;
import com.mps.util.ValidationUtil;

public class StringServiceImpl implements StringService {

    private static StringService instance = new StringServiceImpl();

    private StringServiceImpl() {
    }

    public static StringService getInstance() {
        return instance;
    }

    public String getInputFromUser() throws StringServiceException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(ENTER_INPUT);
        try {
            return br.readLine();
        } catch (IOException ioException) {
            throw new StringServiceException(EXCEPTION_MESSAGE + ioException.getMessage());
        }
    }

    public void generateOutput(String input) throws StringServiceException {
        try {
            if (!ValidationUtil.isValidInputString(input)) {
                System.out.println(INVALID_INPUT);
                return;
            }
            FileUtil.writeOutputInFile(getOutputString(input).toString());
        } catch (IOException ioException) {
            throw new StringServiceException(EXCEPTION_MESSAGE_ON_OUTPUT + ioException.getMessage());
        }
    }

    private StringBuilder getOutputString(String inputString) {
        StringBuilder alphabets = new StringBuilder();
        StringBuilder numbers = new StringBuilder();
        StringBuilder outputString = new StringBuilder();

        for (int i = 0; i < inputString.length(); i++) {
            if (Character.isLetter(inputString.charAt(i)))
                alphabets.append(inputString.charAt(i));
            if (Character.isDigit(inputString.charAt(i)))
                numbers.append(inputString.charAt(i));
        }
        return outputString.append(alphabets).append(COMMA_SEPERATED).append(alphabets.length())
                .append(COMMA_SEPERATED).append(numbers).append(COMMA_SEPERATED).append(numbers.length());
    }

    public void writeOutputToFile() throws StringServiceException {
        try {
            String input = getInputFromUser();
            if (!ValidationUtil.isValidInputString(input)) {
                System.out.println(INVALID_INPUT);
                writeOutputToFile();
            } else {
                FileUtil.writeOutputInFile(getOutputString(input).toString());
            }
        } catch (IOException ioException) {
            throw new StringServiceException(EXCEPTION_MESSAGE_ON_OUTPUT + ioException.getMessage());
        }
    }

}
