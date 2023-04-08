package ru.nsu.ccfit.gudkov.calculator.Exceptions;


public class PassedNotInitializedVariable extends Exception {
    public PassedNotInitializedVariable(String errorMessage) {
        super(errorMessage);
    }
}
