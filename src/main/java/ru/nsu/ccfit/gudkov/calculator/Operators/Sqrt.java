package ru.nsu.ccfit.gudkov.calculator.Operators;

import ru.nsu.ccfit.gudkov.calculator.Exceptions.BadNumberOfOperandsException;
import ru.nsu.ccfit.gudkov.calculator.Exceptions.NotEnoughElementsOnTheStackException;
import ru.nsu.ccfit.gudkov.calculator.ExecutionContext;
import ru.nsu.ccfit.gudkov.calculator.Operand.Number;
import ru.nsu.ccfit.gudkov.calculator.Operand.Operand;
import ru.nsu.ccfit.gudkov.calculator.Exceptions.ExceptionText;


public class Sqrt implements Operator {
    @Override
    public void execute(ExecutionContext context, String[] args) throws BadNumberOfOperandsException, NotEnoughElementsOnTheStackException {
        if (args.length != 1) {
            throw new BadNumberOfOperandsException(ExceptionText.SQRT_BAD_NUMBER_OF_OPERANDS);
        }
        if (context.getStack().size() < 1) {
            throw new NotEnoughElementsOnTheStackException(ExceptionText.NOT_ENOUGH_ELEMENTS_ON_STACK_1);
        }
        double a = context.getStack().pop().getValue();
        if (a < 0) {
            throw new ArithmeticException(ExceptionText.SQRT_BAD_OPERAND);
        }
        Operand operand = new Number(Math.sqrt(a));
        context.getStack().add(operand);
    }
}
