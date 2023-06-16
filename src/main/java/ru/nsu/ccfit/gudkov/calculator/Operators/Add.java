package ru.nsu.ccfit.gudkov.calculator.Operators;

import ru.nsu.ccfit.gudkov.calculator.Exceptions.BadNumberOfOperandsException;
import ru.nsu.ccfit.gudkov.calculator.Exceptions.NotEnoughElementsOnTheStackException;
import ru.nsu.ccfit.gudkov.calculator.ExecutionContext;
import ru.nsu.ccfit.gudkov.calculator.Operand.Number;
import ru.nsu.ccfit.gudkov.calculator.Operand.Operand;
import ru.nsu.ccfit.gudkov.calculator.Exceptions.ExceptionText;

public class Add implements Operator{
    @Override
    public void execute(ExecutionContext context, String[] args) throws BadNumberOfOperandsException, NotEnoughElementsOnTheStackException {
        if (args.length != 1){
            throw new BadNumberOfOperandsException(ExceptionText.ADD_BAD_NUMBER_OF_OPERANDS);
        }
        if (context.getStack().size() < 2) {
            throw new NotEnoughElementsOnTheStackException(ExceptionText.NOT_ENOUGH_ELEMENTS_ON_STACK_2);
        }
        double a = context.getStack().pop().getValue();
        double b = context.getStack().pop().getValue();
        Operand operand = new Number(a + b);
        context.getStack().add(operand);
    }
}
