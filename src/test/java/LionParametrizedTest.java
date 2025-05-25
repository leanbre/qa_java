import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParametrizedTest {
    private final boolean hasMane;
    private final String sex;

    @Mock
    Feline feline;

    public LionParametrizedTest(String sex, boolean hasMane) {
        this.hasMane = hasMane;
        this.sex = sex;
    }

    @Parameterized.Parameters(name = "пол = {0}, есть грива = {1}")
    public static Object[][] data() {
        return new Object[][] {
                {"Самка", false},
                {"Самец", true},
        };
    }


    @Test
    public void hasManeTest() throws Exception {
        Lion lion = new Lion(this.sex, feline);
        boolean actual = lion.doesHaveMane();
        assertEquals(this.hasMane, actual);
    }
}
