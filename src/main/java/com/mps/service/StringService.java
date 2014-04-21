package com.mps.service;

public interface StringService {
    public void writeOutputToFile() throws StringServiceException;

    public String getInputFromUser() throws StringServiceException;

    public void generateOutput(String input) throws StringServiceException;
}
