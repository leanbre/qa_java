import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void getSoundTest() {
        Cat cat = new Cat(feline);
        String expected = "Мяу";
        String actual = cat.getSound();

        assertEquals(expected, actual);
    }

    @Test
    public void getFoodTest() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expectedProducts = Arrays.asList("Рыба", "Мясо");

        when(feline.eatMeat()).thenReturn(expectedProducts);

        List<String> food = cat.getFood();

        assertNotNull(food);
        assertEquals(expectedProducts, food);
    }
}