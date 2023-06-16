package ru.nsu.ccfit.gudkov.calculator.Operators;

import ru.nsu.ccfit.gudkov.calculator.Exceptions.BadNumberOfOperandsException;
import ru.nsu.ccfit.gudkov.calculator.ExecutionContext;
import ru.nsu.ccfit.gudkov.calculator.Exceptions.ExceptionText;


public class Define implements Operator{
    @Override
    public void execute(ExecutionContext context, String[] args) throws BadNumberOfOperandsException, NumberFormatException {
        if (args.length != 3) {
            throw new BadNumberOfOperandsException(ExceptionText.DEFINE_BAD_NUMBER_OF_OPERANDS);
        }
        context.getVars().put(args[1], Double.valueOf(args[2]));
    }
}
