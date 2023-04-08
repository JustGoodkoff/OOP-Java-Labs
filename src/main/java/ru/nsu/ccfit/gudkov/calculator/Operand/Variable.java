package ru.nsu.ccfit.gudkov.calculator.Operand;

import ru.nsu.ccfit.gudkov.calculator.ExecutionContext;
import ru.nsu.ccfit.gudkov.calculator.Operand.Operand;

import java.util.Map;

public class Variable implements Operand {
    private final ExecutionContext context;
    private final String variable;

    public Variable(String variable, ExecutionContext context){
        this.variable = variable;
        this.context = context;
    }
    @Override
    public double getValue() {
        Map<String, Double> varMap = context.getVars();
        return varMap.get(variable);
    }
}
