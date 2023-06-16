package ru.nsu.ccfit.gudkov.calculator;

import com.beust.jcommander.Parameter;

public class CommandLineArgs {
    @Parameter(names = {"-f", "--filename"})
    String filename;
}
