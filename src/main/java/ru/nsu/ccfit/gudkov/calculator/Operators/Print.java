package ru.nsu.ccfit.gudkov.calculator.Operators;

import com.sun.source.util.SourcePositions;
import ru.nsu.ccfit.gudkov.calculator.Exceptions.BadNumberOfOperandsException;
import ru.nsu.ccfit.gudkov.calculator.Exceptions.NotEnoughElementsOnTheStackException;
import ru.nsu.ccfit.gudkov.calculator.ExecutionContext;
import ru.nsu.ccfit.gudkov.calculator.Exceptions.ExceptionText;


public class Print implements Operator {
    @Override
    public void execute(ExecutionContext context, String[] args) throws BadNumberOfOperandsException, NotEnoughElementsOnTheStackException {
        if (args.length != 1) {
            throw new BadNumberOfOperandsException(ExceptionText.PRINT_BAD_NUMBER_OF_OPERANDS);
        }
        if (context.getStack().size() < 1) {
            throw new NotEnoughElementsOnTheStackException(ExceptionText.NOT_ENOUGH_ELEMENTS_ON_STACK_1);
        }
        System.out.println(context.getStack().peek().getValue());
    }
}
