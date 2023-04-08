package ru.nsu.ccfit.gudkov.calculator.Exceptions;

public class BadNumberOfOperandsException extends Exception{
    public BadNumberOfOperandsException(String errorMessage) {
        super(errorMessage);
    }
}