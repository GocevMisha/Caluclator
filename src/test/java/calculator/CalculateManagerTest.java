package calculator;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class CalculateManagerTest {

    private ByteArrayOutputStream byteArray;
    private Reader reader;
    private Writer writer;

    @Before
    public void prepare() {
        preparePrintStream();
    }

    @Test
    public void simpleTest() {
        putStringIntoScanner("2\n +\n 2\n END");
        new CalculateManager(reader, writer).run();
        assertThat(byteArray.toString(), containsString("4.0"));
    }

    @Test
    public void continueWithFirstResultTest() {
        putStringIntoScanner("2\n ^\n 2\n CONT\n *\n 2.2\n END");
        new CalculateManager(reader, writer).run();
        assertThat(byteArray.toString(), containsString("8.8"));
    }

    @Test
    public void startNewOperationTest() {
        putStringIntoScanner("2\n -\n 2\n NEW\n 27\n /\n 3\n END");
        new CalculateManager(reader, writer).run();
        assertThat(byteArray.toString(), containsString("9.0"));
    }

    @Test
    public void floodTest() {
        putStringIntoScanner("q\n W\n @\n 2\n #\n +\n -\n[-]\n -_-\n 2\n endend\n end\n END");
        new CalculateManager(reader, writer).run();
        System.out.println(byteArray.toString());
        assertThat(byteArray.toString(), containsString("4.0"));
    }

    private void putStringIntoScanner(String input) {
        InputStream stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(stream);
        reader = new Reader(scanner);
    }

    private void preparePrintStream() {
        byteArray = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArray);
        writer = new Writer(stream);
    }
}