package org.example.dynamicprograming;

import java.util.Map;

/**
 * Given a grid's dimensions
 * -> find the number of ways to go from the top left to the bottom right corner.
 *  */
public class GridTraveler {

    public int howManyWays(int rows, int columns, Map<String, Integer> memo) {
        final String key = rows + "," + columns;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (rows == 0 || columns == 0) {
            return 0;
        }
        if (rows == 1 && columns == 1) {
            return 1;
        }

        int result = howManyWays(rows - 1, columns, memo) + howManyWays(rows, columns - 1, memo);
        memo.put(key, result);

        return  result;
    }
}
