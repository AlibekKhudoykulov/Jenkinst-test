
import org.example.HelloWorld;
import org.junit.Test;
import static org.junit.Assert.*;
public class HelloWorldTest {
    @Test
    public void testSayHello() {
        HelloWorld helloWorld = new HelloWorld();
        String result = helloWorld.sayHello();
        assertEquals("Hello, World!", result);
    }

    @Test
    public void testSayHelloNotNull() {
        HelloWorld helloWorld = new HelloWorld();
        String result = helloWorld.sayHello();
        assertNotNull(result);
    }

    @Test
    public void testSayHelloNotEmpty() {
        HelloWorld helloWorld = new HelloWorld();
        String result = helloWorld.sayHello();
        assertFalse(result.isEmpty());
    }

    @Test
    public void testSayHelloCaseInsensitive() {
        HelloWorld helloWorld = new HelloWorld();
        String result = helloWorld.sayHello();
        assertEquals("hello, world!", result.toLowerCase());
    }

    @Test
    public void testSayHelloContainsHello() {
        HelloWorld helloWorld = new HelloWorld();
        String result = helloWorld.sayHello();
        assertTrue(result.contains("Hello"));
    }

    @Test
    public void testSayHelloStartsWithHello() {
        HelloWorld helloWorld = new HelloWorld();
        String result = helloWorld.sayHello();
        assertTrue(result.startsWith("Hello"));
    }

    @Test
    public void testSayHelloEndsWithWorld() {
        HelloWorld helloWorld = new HelloWorld();
        String result = helloWorld.sayHello();
        assertTrue(result.endsWith("World!"));
    }

    @Test
    public void testSayHelloLength() {
        HelloWorld helloWorld = new HelloWorld();
        String result = helloWorld.sayHello();
        assertEquals(13, result.length());
    }

    @Test
    public void testSayHelloWithAdditionalText() {
        HelloWorld helloWorld = new HelloWorld();
        String result = helloWorld.sayHello() + " Have a great day!";
        assertEquals("Hello, World! Have a great day!", result);
    }

    @Test
    public void testSayHelloMultipleTimes() {
        HelloWorld helloWorld = new HelloWorld();
        String result = helloWorld.sayHello() + " " + helloWorld.sayHello();
        assertEquals("Hello, World! Hello, World!", result);
    }
}
