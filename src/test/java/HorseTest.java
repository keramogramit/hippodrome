import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {

    @Test
    public void whenAssertingException() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Horse(null, 1, 1)
        );
        assertEquals("Name cannot be null.", exception.getMessage());
    }
@ParameterizedTest
@ValueSource(strings = {"", " ", "\t", "\n"})
public void nameParameterConstructorIsEmpty(String name){

    Throwable exception = assertThrows(
            IllegalArgumentException.class,
            () -> new Horse(name, 1, 1)
    );
    assertEquals("Name cannot be blank.", exception.getMessage());
}
    @Test
    public void speedParameterConstructorIsNegative(){

        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Horse("name", -1, 1)
        );
        assertEquals("Speed cannot be negative.", exception.getMessage());
    }
    @Test
    public void distanceParameterConstructorIsNegative(){

        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Horse("name", 1, -1)
        );
        assertEquals("Distance cannot be negative.", exception.getMessage());
    }


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getName() {
    }

    @Test
    void getSpeed() {
    }

    @Test
    void getDistance() {
    }

    @Test
    void move() {
    }

    @Test
    void getRandomDouble() {
    }
}