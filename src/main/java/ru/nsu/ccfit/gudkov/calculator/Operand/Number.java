package ru.nsu.ccfit.gudkov.calculator.Operand;

import ru.nsu.ccfit.gudkov.calculator.Operand.Operand;

public class Number implements Operand {
    private final double value;

    public Number() {
        value = 0;
    }

    public Number(double value) {
        this.value = value;
    }

    @Override
    public double getValue() {
        return value;
    }
}
