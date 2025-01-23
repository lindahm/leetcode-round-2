package dynamicprograming;

import org.example.dynamicprograming.GridTraveler;
import org.example.hard.CountOfRangeSum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class GridTravelerTest {

    @Test
    void test() {
        GridTraveler traveler = new GridTraveler();
        Assertions.assertEquals(3, traveler.howManyWays(2, 3, new HashMap<>()));
        Assertions.assertEquals(48620, traveler.howManyWays(10, 10, new HashMap<>()));
    }

    }