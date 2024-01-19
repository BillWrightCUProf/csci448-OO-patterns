package examples.builder;

import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void testStringCreation() {
        Integer errorCode = 123;
        String statusMessage = "Error:";
        statusMessage += "More information. ";
        statusMessage += "Error code: ";
        statusMessage += errorCode.toString();
        System.out.println(statusMessage);

        // Or
        String statusMessage2 = "Error:" + "More information. " +
                "Error code: " +
                errorCode;
        System.out.println(statusMessage2);

        // With a builder
        // Only really worth it if you are appending a LOT of strings
        StringBuilder messageBuilder = new StringBuilder("Error:");
        messageBuilder.append("More information. ");
        messageBuilder.append("Error code: ");
        messageBuilder.append(errorCode);
        System.out.println(messageBuilder);

        // With StringBuffer -- slower, but thread safe
        StringBuffer messageBuffer = new StringBuffer("Error:");
        messageBuffer.append("More information. ");
        messageBuffer.append("Error code: ");
        messageBuffer.append(errorCode);
        System.out.println(messageBuffer);
    }
}
