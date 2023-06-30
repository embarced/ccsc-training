package ccsc.legacy.badtelefon;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.fail;

public class KundeTests {

    private PrintStream originalSysOut;
    private ByteArrayOutputStream consoleStream;

    @BeforeEach
    void init() {
        originalSysOut = System.out;
        consoleStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(consoleStream));
    }

    @AfterEach
    void teardown() {
        System.setOut(originalSysOut);
    }

    @Test
    @Disabled
    void golden_master() {
        fail("not yet implemented");
        Approvals.verify(consoleStream.toString());
    }
}
