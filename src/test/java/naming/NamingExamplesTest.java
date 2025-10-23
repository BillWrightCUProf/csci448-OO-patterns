package naming;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class NamingExamplesTest {

    @Test
    void testF() {
        // Test the f method with a sample list
        List<Integer> input = List.of(-1, 0, 1, 2, 3);
        List<Integer> expectedOutput = List.of(2, 4, 6);

        assertEquals(expectedOutput, NamingExamples.f2(input));
    }

}