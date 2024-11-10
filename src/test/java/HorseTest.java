import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

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
    public void nameParameterConstructorIsEmpty(String name) {

        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Horse(name, 1, 1)
        );
        assertEquals("Name cannot be blank.", exception.getMessage());
    }

    @Test
    public void speedParameterConstructorIsNegative() {

        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Horse("name", -1, 1)
        );
        assertEquals("Speed cannot be negative.", exception.getMessage());
    }

    @Test
    public void distanceParameterConstructorIsNegative() {

        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Horse("name", 1, -1)
        );
        assertEquals("Distance cannot be negative.", exception.getMessage());
    }

    @Test
    void getNameTest() {
        Horse horse = new Horse("name", 1, 2);
        assertEquals("name", horse.getName());
    }

    @Test
    void getSpeedTest() {
        Horse horse = new Horse("name", 1, 2);
        assertEquals(1, horse.getSpeed());
    }

    @Test
    void getDistanceTest() {
        Horse horse = new Horse("name", 1, 2);
        assertEquals(2, horse.getDistance());
    }

    @Test
    void getDistanceTestByDefault() {
        Horse horse = new Horse("name", 1);
        assertEquals(0, horse.getDistance());
    }

    @Test
    void moveTest() {
        try (MockedStatic<Horse> mockedStatic = mockStatic(Horse.class)) {
            new Horse("name", 1, 2);
            mockedStatic.verify(() -> Horse.getRandomDouble(0.2, 0.9));
        }

    }
}
