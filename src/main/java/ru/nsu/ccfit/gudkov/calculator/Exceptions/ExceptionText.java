package ru.nsu.ccfit.gudkov.calculator.Exceptions;

public final class ExceptionText {

    private ExceptionText(){}
    public static String ADD_BAD_NUMBER_OF_OPERANDS = "Operator + must not have operands";
    public static String SUB_BAD_NUMBER_OF_OPERANDS = "Operator - must not have operands";
    public static String DIV_BAD_NUMBER_OF_OPERANDS = "Operator / must not have operands";
    public static String MUL_BAD_NUMBER_OF_OPERANDS = "Operator * must not have operands";
    public static String POP_BAD_NUMBER_OF_OPERANDS = "Operator pop must not have operands";
    public static String PRINT_BAD_NUMBER_OF_OPERANDS = "Operator print not have operands";
    public static String SQRT_BAD_NUMBER_OF_OPERANDS = "Operator sqrt not have operands";
    public static String PUSH_BAD_NUMBER_OF_OPERANDS = "Operator push must have 1 operand";
    public static String SQRT_BAD_OPERAND = "Operand must be greater than or equal to zero.";
    public static String PASSED_NOT_INITIALIZED_VARIABLE = "Variable not initialized passed to function";
    public static String DEFINE_BAD_NUMBER_OF_OPERANDS = "Operator define must have 2 operands";
    public static String NOT_ENOUGH_ELEMENTS_ON_STACK_2  = "Not enough elements on the stack. Required 2";
    public static String NOT_ENOUGH_ELEMENTS_ON_STACK_1  = "Not enough elements on the stack. Required 1";
    public static String DIVISION_BY_ZERO  = "Division by zero has occurred, the last two operands are removed from the stack";
    public static String FAILED_OPERATION_CREATION = "Unable to create operation";

}
