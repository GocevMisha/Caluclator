package calculator;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ReaderTest {

    private Reader reader;

    @Test
    public void readOperationAdditionalPositiveTest() {
        putStringIntoScanner("+");
        assertThat(reader.readOperation(), equalTo('+'));
    }

    @Test
    public void readOperationSubtractionPositiveTest() {
        putStringIntoScanner(" -");
        assertThat(reader.readOperation(), equalTo('-'));
    }

    @Test
    public void readOperationMultiplicationPositiveTest() {
        putStringIntoScanner("* ");
        assertThat(reader.readOperation(), equalTo('*'));
    }

    @Test
    public void readOperationDivisionPositiveTest() {
        putStringIntoScanner(" / ");
        assertThat(reader.readOperation(), equalTo('/'));
    }

    @Test
    public void readOperationExponentiationPositiveTest() {
        putStringIntoScanner("           ^            ");
        assertThat(reader.readOperation(), equalTo('^'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void readOperationManyOperationsNegativeTest() {
        putStringIntoScanner("+-");
        reader.readOperation();
    }

    @Test(expected = IllegalArgumentException.class)
    public void readOperationManyCharsNegativeTest() {
        putStringIntoScanner("QWErty123");
        reader.readOperation();
    }

    @Test(expected = IllegalArgumentException.class)
    public void readOperationEmptyLineNegativeTest() {
        putStringIntoScanner(" ");
        reader.readOperation();
    }

    @Test
    public void readOperandPositiveTest() {
        putStringIntoScanner("-123.456");
        assertThat(reader.readOperand(), equalTo(-123.456));
    }

    @Test(expected = NumberFormatException.class)
    public void readOperandNegativeTest() {
        putStringIntoScanner("Zero");
        reader.readOperand();
    }

    @Test
    public void readCommandContPositiveTest() {
        putStringIntoScanner("CONT");
        assertThat(reader.readCommand(), equalTo("CONT"));
    }

    @Test
    public void readCommandNewPositiveTest() {
        putStringIntoScanner("NEW");
        assertThat(reader.readCommand(), equalTo("NEW"));
    }

    @Test
    public void readCommandEndPositiveTest() {
        putStringIntoScanner("END");
        assertThat(reader.readCommand(), equalTo("END"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void readCommandNegativeTest() {
        putStringIntoScanner("WORD");
        reader.readCommand();
    }

    private void putStringIntoScanner(String input) {
        InputStream stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(stream);
        reader = new Reader(scanner);
    }
}