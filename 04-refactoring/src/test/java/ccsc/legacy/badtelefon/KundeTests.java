package ccsc.legacy.badtelefon;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

public class KundeTests {

    private PrintStream originalOutStream;
    private ByteArrayOutputStream consoleStream;
    @BeforeEach
    void init() {
        originalOutStream = System.out;
        consoleStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(consoleStream));
    }

    @AfterEach
    void teardown() {
        System.setOut(originalOutStream);
    }

    private static class DummyTarifeRunner extends TarifeRunner {
        @Override
        protected Random createRandom() {
            return new Random(1);
        }
    }

    @Test
    void golden_master() {
        new TarifeRunner() {
            @Override
            protected Random createRandom() {
                return new Random(1);
            }
        }.run();
        Approvals.verify(consoleStream.toString());


    }
}
