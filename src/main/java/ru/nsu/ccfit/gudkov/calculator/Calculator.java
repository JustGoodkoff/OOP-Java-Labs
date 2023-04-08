package ru.nsu.ccfit.gudkov.calculator;

import ru.nsu.ccfit.gudkov.calculator.Exceptions.*;
import ru.nsu.ccfit.gudkov.calculator.Operators.Operator;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import ru.nsu.ccfit.gudkov.calculator.LoggerText;

public class Calculator {

    private final String EXIT_COMMAND = "EXIT";
    private final String SEPARATOR = " ";
    private final int SEPARATION_LIMIT = 3;

    public void execute(BufferedReader reader) throws IOException {
        Logger logger = Logger.getLogger(Calculator.class.getName());
        LogManager.getLogManager().readConfiguration(Calculator.class.getResourceAsStream(LoggerText.LOGGING_PROPERTIES));
        logger.fine(LoggerText.CALCULATION_STARTED);
        String commandLine;
        ExecutionContext context = new ExecutionContext();
        String[] separatedLine;
        OperatorsFactory operatorsFactory = new OperatorsFactory();
        logger.fine(LoggerText.OPERATOR_FACTORY_CREATED);
        while ((commandLine = reader.readLine()) != null && !commandLine.equals(EXIT_COMMAND)) {
            separatedLine = commandLine.split(SEPARATOR, SEPARATION_LIMIT);
            String command = separatedLine[0];
            try {
                Operator operator = operatorsFactory.createOperation(command);
                logger.fine(command + LoggerText.SUCCESSFULLY_CREATED);
                operator.execute(context, separatedLine);
                logger.fine(command + LoggerText.SUCCESSFULLY_COMPLETED);
            } catch (BadNumberOfOperandsException | ArithmeticException | NotEnoughElementsOnTheStackException |
                     NumberFormatException | DivisionByZeroException |
                     PassedNotInitializedVariable e) {
                logger.warning(command + LoggerText.OPERATION_FAILED);
                logger.warning(e.getMessage());
            } catch (FailedOperationCreationException e) {
                logger.warning(command + LoggerText.FAILED_CREATION_OPERATION);
                logger.warning(e.getMessage());
            }
        }
    }
}
