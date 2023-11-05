package examples.builder;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.nio.file.Paths;

public class HttpTest {

    @Test
        // So many options to configure that passing them all in
        // a constructor is very unwieldy...
        // We could pass them as a map of objects, but then we'd lose
        // all the type checking of Java...
    void testHttpRequestGeneration2() {
        HttpRequest request = new HttpRequest(uri,
                listOfHeaders?,
                timeOut,
                action,
                body,
                ...
                )
    }

    // We just add setters to everything...
    // But now our object can be mutated at any time by a client,
    // possibly into an invalid state...
    @Test
    void testHttpRequestGeneration2() {
        HttpRequest request = new HttpRequest();
        request.setUri(uri);
        request.addHeader("Content-Type", "text/plain;charset=UTF-8");
        request.setAction(HttpActions.POST);
        request.setBody(body);
        request.setTimeout(myTimeOut);
        ...
    }

    // Or we can do what the Java java.net.http library did and...
    // use the Builder pattern.
    //
    // Once the request is built, it is immutable and can be used over
    // and over if need be.
    @Test
    void testHttpRequestGeneration() throws URISyntaxException, FileNotFoundException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/post"))
                .headers("Content-Type", "text/plain;charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofFile(
                        Paths.get("src/test/resources/sample.txt")))
                .build();
    }


}
