package ru.nsu.ccfit.gudkov.calculator.Operators;

import ru.nsu.ccfit.gudkov.calculator.Exceptions.BadNumberOfOperandsException;
import ru.nsu.ccfit.gudkov.calculator.Exceptions.PassedNotInitializedVariable;
import ru.nsu.ccfit.gudkov.calculator.ExecutionContext;
import ru.nsu.ccfit.gudkov.calculator.Operand.Number;
import ru.nsu.ccfit.gudkov.calculator.Operand.Operand;
import ru.nsu.ccfit.gudkov.calculator.Operand.Variable;
import ru.nsu.ccfit.gudkov.calculator.Exceptions.ExceptionText;


public class Push implements Operator{
    @Override
    public void execute(ExecutionContext context, String[] args) throws BadNumberOfOperandsException, PassedNotInitializedVariable {
        if (args.length != 2) {
            throw new BadNumberOfOperandsException(ExceptionText.PUSH_BAD_NUMBER_OF_OPERANDS);
        }
        Operand operand;
        try {
            double num = Double.parseDouble(args[1]);
            operand = new Number(num);
            context.getStack().push(operand);
        } catch (NumberFormatException e) {
            if (context.getVars().get(args[1]) != null) {
                operand = new Variable(args[1], context);
                context.getStack().push(operand);
            }
            else {
                throw new PassedNotInitializedVariable(ExceptionText.PASSED_NOT_INITIALIZED_VARIABLE);
            }
        }
    }
}
