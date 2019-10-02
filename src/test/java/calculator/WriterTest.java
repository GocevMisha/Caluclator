package calculator;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class WriterTest {

    private ByteArrayOutputStream byteArray;
    private Writer writer;

    @Before
    public void prepare() {
        preparePrintStream();
    }

    @Test
    public void printResultTest() {
        writer.printResult(-123.456);
        assertThat(byteArray.toString(), equalTo("Your result: -123.456\r\n"));
    }

    @Test
    public void printInsertOperandTest() {
        writer.printInsertOperand();
        assertThat(byteArray.toString(), equalTo("Insert operand: "));
    }

    @Test
    public void printGoodbyeTest() {
        writer.printGoodbye();
        assertThat(byteArray.toString(), equalTo("Goodbye!\r\n"));
    }

    private void preparePrintStream() {
        byteArray = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArray);
        writer = new Writer(stream);
    }
}