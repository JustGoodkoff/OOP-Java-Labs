package ru.nsu.ccfit.gudkov.calculator.Exceptions;

public class DivisionByZeroException extends Exception {
    public DivisionByZeroException(String errorMessage) {
        super(errorMessage);
    }
}
