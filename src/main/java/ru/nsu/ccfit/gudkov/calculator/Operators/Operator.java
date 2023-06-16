package ru.nsu.ccfit.gudkov.calculator.Operators;


import ru.nsu.ccfit.gudkov.calculator.Exceptions.BadNumberOfOperandsException;
import ru.nsu.ccfit.gudkov.calculator.Exceptions.DivisionByZeroException;
import ru.nsu.ccfit.gudkov.calculator.Exceptions.NotEnoughElementsOnTheStackException;
import ru.nsu.ccfit.gudkov.calculator.Exceptions.PassedNotInitializedVariable;
import ru.nsu.ccfit.gudkov.calculator.ExecutionContext;

public interface Operator {
    void execute(ExecutionContext context, String[] args) throws BadNumberOfOperandsException, NotEnoughElementsOnTheStackException, DivisionByZeroException, PassedNotInitializedVariable;
}

