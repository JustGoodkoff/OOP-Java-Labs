import org.junit.jupiter.api.Test;
import ru.nsu.ccfit.gudkov.calculator.Exceptions.BadNumberOfOperandsException;
import ru.nsu.ccfit.gudkov.calculator.Exceptions.DivisionByZeroException;
import ru.nsu.ccfit.gudkov.calculator.Exceptions.NotEnoughElementsOnTheStackException;
import ru.nsu.ccfit.gudkov.calculator.Exceptions.PassedNotInitializedVariable;
import ru.nsu.ccfit.gudkov.calculator.ExecutionContext;
import ru.nsu.ccfit.gudkov.calculator.Operand.Number;
import ru.nsu.ccfit.gudkov.calculator.Operators.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class CalcTest {
    @Test
    void addCommandTest() throws NotEnoughElementsOnTheStackException, BadNumberOfOperandsException {
        ExecutionContext context = new ExecutionContext();
        context.getStack().add(new Number(1));
        context.getStack().add(new Number(2));
        Add add = new Add();
        add.execute(context, new String[]{"+"});
        assertEquals(3.0, context.getStack().peek().getValue());

        assertThrows(BadNumberOfOperandsException.class, () -> {
            add.execute(context, new String[]{"+", "/"});
        }, "BadNumberOfOperandsException error was expected");
        assertThrows(NotEnoughElementsOnTheStackException.class, () -> {
            add.execute(context, new String[]{"+"});
        }, "NotEnoughElementsOnTheStackException error was expected");
    }

    @Test
    void defineCommand() throws BadNumberOfOperandsException {
        ExecutionContext context = new ExecutionContext();
        Define define = new Define();
        define.execute(context, new String[]{"DEFINE", "a", "1"});
        assertEquals(1.0, context.getVars().get("a"));

        assertThrows(BadNumberOfOperandsException.class, () -> {
            define.execute(context, new String[]{"define"});
        }, "BadNumberOfOperandsException error was expected");

        assertThrows(NumberFormatException.class, () -> {
            define.execute(context, new String[]{"DEFINE", "a", "a"});
        }, "NumberFormatException error was expected");

    }

    @Test
    void divCommand() throws NotEnoughElementsOnTheStackException, DivisionByZeroException, BadNumberOfOperandsException {
        ExecutionContext context = new ExecutionContext();
        Div div = new Div();
        context.getStack().add(new Number(2));
        context.getStack().add(new Number(2));
        div.execute(context, new String[]{"/"});
        assertEquals(1.0, context.getStack().peek().getValue());

        context.getStack().pop();
        context.getStack().push(new Number(0));
        context.getStack().push(new Number(1));
        assertThrows(DivisionByZeroException.class, () -> {
            div.execute(context, new String[]{"/"});
        }, "DivisionByZeroException error was expected");
        assertThrows(BadNumberOfOperandsException.class, () -> {
            div.execute(context, new String[]{"/", "/"});
        }, "BadNumberOfOperandsException error was expected");
        assertThrows(NotEnoughElementsOnTheStackException.class, () -> {
            div.execute(context, new String[]{"/"});
        }, "NotEnoughElementsOnTheStackException error was expected");
    }


    @Test
    void mulTest() throws NotEnoughElementsOnTheStackException, BadNumberOfOperandsException {
        ExecutionContext context = new ExecutionContext();
        context.getStack().add(new Number(1));
        context.getStack().add(new Number(2));
        Mul mul = new Mul();
        mul.execute(context, new String[]{"*"});
        assertEquals(2.0, context.getStack().peek().getValue());

        assertThrows(BadNumberOfOperandsException.class, () -> {
            mul.execute(context, new String[]{"*", "/"});
        }, "BadNumberOfOperandsException error was expected");
        assertThrows(NotEnoughElementsOnTheStackException.class, () -> {
            mul.execute(context, new String[]{"*"});
        }, "NotEnoughElementsOnTheStackException error was expected");
    }

    @Test
    void subTest() throws BadNumberOfOperandsException, NotEnoughElementsOnTheStackException {
        ExecutionContext context = new ExecutionContext();
        context.getStack().add(new Number(1));
        context.getStack().add(new Number(2));
        Sub sub = new Sub();
        sub.execute(context, new String[]{"-"});
        assertEquals(1.0, context.getStack().peek().getValue());

        assertThrows(BadNumberOfOperandsException.class, () -> {
            sub.execute(context, new String[]{"-", "/"});
        }, "BadNumberOfOperandsException error was expected");
        assertThrows(NotEnoughElementsOnTheStackException.class, () -> {
            sub.execute(context, new String[]{"-"});
        }, "NotEnoughElementsOnTheStackException error was expected");
    }

    @Test
    void popTest() throws NotEnoughElementsOnTheStackException, BadNumberOfOperandsException {
        ExecutionContext context = new ExecutionContext();
        context.getStack().push(new Number(1));
        Pop pop = new Pop();
        pop.execute(context, new String[]{"POP"});
        assertTrue(context.getStack().isEmpty());

        assertThrows(BadNumberOfOperandsException.class, () -> {
            pop.execute(context, new String[]{"POP", "/"});
        }, "BadNumberOfOperandsException error was expected");
        assertThrows(NotEnoughElementsOnTheStackException.class, () -> {
            pop.execute(context, new String[]{"POP"});
        }, "NotEnoughElementsOnTheStackException error was expected");
    }

    @Test
    void pushTest() throws BadNumberOfOperandsException, PassedNotInitializedVariable {
        ExecutionContext context = new ExecutionContext();
        Push push = new Push();
        push.execute(context, new String[]{"PUSH", "1"});
        assertFalse(context.getStack().isEmpty());

        Define define = new Define();
        define.execute(context, new String[]{"DEFINE", "a", "2"});

        push.execute(context, new String[]{"PUSH", "a"});
        assertEquals(2, context.getStack().peek().getValue());

        assertThrows(PassedNotInitializedVariable.class, () -> {
            push.execute(context, new String[]{"PUSH", "b"});
        }, "PassedNotInitializedVariable error was expected");

        assertThrows(BadNumberOfOperandsException.class, () -> {
            push.execute(context, new String[]{"PUSH", "/", "."});
        }, "BadNumberOfOperandsException error was expected");
    }

    @Test
    void printTest() throws NotEnoughElementsOnTheStackException, BadNumberOfOperandsException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        ExecutionContext context = new ExecutionContext();
        context.getStack().add(new Number(1));
        Print print = new Print();
        print.execute(context, new String[]{"PRINT"});

        assertEquals("1.0\r\n", output.toString());

        context.getStack().pop();

        assertThrows(NotEnoughElementsOnTheStackException.class, () -> {
            print.execute(context, new String[]{"PRINT"});
        }, "NotEnoughElementsOnTheStackException error was expected");

        assertThrows(BadNumberOfOperandsException.class, () -> {
            print.execute(context, new String[]{"PRINT", "/"});
        }, "BadNumberOfOperandsException error was expected");
    }

    @Test
    void sqrtTest() throws NotEnoughElementsOnTheStackException, BadNumberOfOperandsException {
        ExecutionContext context = new ExecutionContext();
        context.getStack().add(new Number(4));
        Sqrt sqrt = new Sqrt();
        sqrt.execute(context, new String[]{"SQRT"});
        assertEquals(2.0, context.getStack().peek().getValue());
        assertThrows(BadNumberOfOperandsException.class, () -> {
            sqrt.execute(context, new String[]{"SQRT", "/"});
        }, "BadNumberOfOperandsException error was expected");
        context.getStack().pop();
        assertThrows(NotEnoughElementsOnTheStackException.class, () -> {
            sqrt.execute(context, new String[]{"SQRT"});
        }, "NotEnoughElementsOnTheStackException error was expected");
    }
}



