import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private Lion lion;

    @Mock
    Feline feline;

    @Before
    public void beforeEach() throws Exception {
        lion = new Lion("Самка", feline);
    }

    @Test(expected = Exception.class)
    public void createLionWithInvalidSexType() throws Exception {
        String invalidSexType = "Запрещенный пол";
        new Lion(invalidSexType, feline);
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> expectedProducts = Arrays.asList("Рыба", "Мясо");

        when(feline.getFood("Хищник")).thenReturn(expectedProducts);

        List<String> food = lion.getFood();

        assertNotNull(food);
        assertEquals(expectedProducts, food);
    }

    @Test
    public void getKittensTest() {
        int expected = 1;
        Mockito.when(feline.getKittens()).thenReturn(expected);
        int actual = lion.getKittens();
        assertEquals(expected, actual);
    }
}
