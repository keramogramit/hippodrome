import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class HippodromeTest {

  @Test
    public void constructorNullArgument(){
      Throwable exception = assertThrows(
              IllegalArgumentException.class,
              () -> new Hippodrome(null)
      );
      assertEquals("Horses cannot be null.", exception.getMessage());
  }
  @Test
  public void constructorEmptyArrayList(){
    Throwable exception = assertThrows(
            IllegalArgumentException.class,
            () -> new Hippodrome(new ArrayList<>())
    );
    assertEquals("Horses cannot be empty.", exception.getMessage());
  }
  @Test
  public void getHorsesTest(){
    List<Horse> horseList = new ArrayList<>();
    for (int i = 1; i < 31; i++) {
      horseList.add(new Horse("Horse " + i, i + 1, i));
    }
    assertEquals(horseList, new Hippodrome(horseList).getHorses());
  }
  @Test
  public void moveTest(){
    List<Horse> horseList = new ArrayList<>();
    for (int i = 0; i < 50; i++) {
       horseList.add(mock(Horse.class));
    }
    new Hippodrome(horseList).move();
    for (Horse horse : horseList){
      verify(horse).move();
    }
  }
  @Test
  public void getWinnerTest(){
   Horse horse1 = new Horse("horse 1", 1, 2);
   Horse horse2 = new Horse("horse 2", 2, 2);
   Horse horse3 = new Horse("horse 3", 1, 1);
   Horse horse4 = new Horse("horse 4", 3, 3);
   Hippodrome hippodrome = new Hippodrome(List.of(horse1, horse2, horse3, horse4));
    assertSame(horse4, hippodrome.getWinner());
  }
}