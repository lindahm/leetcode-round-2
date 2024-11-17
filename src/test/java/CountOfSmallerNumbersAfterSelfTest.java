import org.example.hard.CountOfSmallerNumberAfterSelf;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CountOfSmallerNumbersAfterSelfTest {

    @Test
    void name() {
        CountOfSmallerNumberAfterSelf count = new CountOfSmallerNumberAfterSelf();
        Assertions.assertArrayEquals(new Integer[]{3,3,3,3,1,1,0}, count.countSmaller(new int[]{5,5,5,5,2,2,1}).toArray());


    }
}