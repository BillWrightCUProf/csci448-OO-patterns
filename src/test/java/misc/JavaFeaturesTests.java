package misc;

import org.junit.jupiter.api.Test;

import java.text.spi.DateFormatProvider;
import java.text.spi.DateFormatSymbolsProvider;
import java.time.OffsetDateTime;

public class JavaFeaturesTests {

    @Test
    void testDateFormat() {
        var startDateTime = OffsetDateTime.parse("2013-10-20T19:20:30+01:00");
        System.out.println(startDateTime);
    }
}
