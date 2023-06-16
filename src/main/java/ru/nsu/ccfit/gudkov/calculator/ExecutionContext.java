package ru.nsu.ccfit.gudkov.calculator;

import ru.nsu.ccfit.gudkov.calculator.Operand.Operand;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ExecutionContext {
    private Stack<Operand> stack;
    private Map<String, Double> vars;

    public ExecutionContext() {
        stack = new Stack<>();
        vars = new HashMap<>();
    }

    public Stack<Operand> getStack() {
        return stack;
    }

    public Map<String, Double> getVars() {
        return vars;
    }

}
