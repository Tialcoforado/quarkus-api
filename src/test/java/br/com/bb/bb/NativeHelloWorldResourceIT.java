package br.com.bb.bb;

import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativeHelloWorldResourceIT extends HelloWorldResourceTest {
    // Execute the same tests but in native mode.
}