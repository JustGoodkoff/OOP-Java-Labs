package ru.nsu.ccfit.gudkov.calculator;

import ru.nsu.ccfit.gudkov.calculator.Exceptions.ExceptionText;
import ru.nsu.ccfit.gudkov.calculator.Exceptions.FailedOperationCreationException;
import ru.nsu.ccfit.gudkov.calculator.Operators.Operator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class OperatorsFactory {
    private final String SEPARATOR = " ";
    private final String COMMANDS_FILE_NAME = "/commands.txt";
    private final Map<String, Class<?>> map;

    OperatorsFactory() throws IOException {
        map = new HashMap<>();
        InputStream in = OperatorsFactory.class.getResourceAsStream(COMMANDS_FILE_NAME);
        BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(in)));
        while (reader.ready()) {
            String[] sep = reader.readLine().split(SEPARATOR);
            try {
                map.put(sep[0], Class.forName(sep[1]));
            } catch (ClassNotFoundException e) {
                System.out.println(sep[0] + SEPARATOR + sep[1]);
            }
        }
    }

    public Operator createOperation(String operationName) throws FailedOperationCreationException {
        try {
            return (Operator) map.get(operationName).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException |
                 NullPointerException e) {
            throw new FailedOperationCreationException(ExceptionText.FAILED_OPERATION_CREATION);
        }
    }
}
