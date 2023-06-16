package ru.nsu.ccfit.gudkov.calculator;

import com.beust.jcommander.JCommander;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        CommandLineArgs commandLineArgs = new CommandLineArgs();
        JCommander.newBuilder()
                .addObject(commandLineArgs)
                .build()
                .parse(args);
        BufferedReader reader;
        InputStream inputStream;
        if (commandLineArgs.filename != null) {
            try {
                inputStream = new FileInputStream(commandLineArgs.filename);
            } catch (FileNotFoundException e) {
                inputStream = System.in;
            }
        } else {
            inputStream = System.in;
        }
        reader = new BufferedReader(new InputStreamReader(inputStream));
        Calculator calculator = new Calculator();
        calculator.execute(reader);
    }
}