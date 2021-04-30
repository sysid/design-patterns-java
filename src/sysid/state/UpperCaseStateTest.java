package sysid.state;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/*
 * https://www.baeldung.com/java-testing-system-out-println
 */
class UpperCaseStateTest {

    private final UpperCaseState upperCaseState = new UpperCaseState();
    private final StateContext stateContext = new StateContext();

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    /**
     * reassign the standard output stream to a new PrintStream with a ByteArrayOutputStream.
     */
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void writeName() {
        upperCaseState.writeName(stateContext, "xxx");
        assertEquals("XXX", outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

}