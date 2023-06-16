package ru.nsu.ccfit.gudkov.calculator.Operators;

import ru.nsu.ccfit.gudkov.calculator.Exceptions.BadNumberOfOperandsException;
import ru.nsu.ccfit.gudkov.calculator.Exceptions.NotEnoughElementsOnTheStackException;
import ru.nsu.ccfit.gudkov.calculator.ExecutionContext;
import ru.nsu.ccfit.gudkov.calculator.Exceptions.ExceptionText;

public class Pop implements Operator{
    @Override
    public void execute(ExecutionContext context, String[] args) throws BadNumberOfOperandsException, NotEnoughElementsOnTheStackException {
        if (args.length != 1) {
            throw new BadNumberOfOperandsException(ExceptionText.POP_BAD_NUMBER_OF_OPERANDS);
        }
        if (context.getStack().size() < 1) {
            throw new NotEnoughElementsOnTheStackException(ExceptionText.NOT_ENOUGH_ELEMENTS_ON_STACK_1);
        }
        context.getStack().pop();
    }
}
