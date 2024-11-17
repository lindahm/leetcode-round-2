package org.example.easy.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1337
 * */
public class KWeakestRowInMatrix {

    public int[] kWeakestRows(int[][] mat, int k) {
        final int SOLDIER = 1;
        Comparator<Pair<Integer, Integer>> compareByCount  = Comparator.comparingInt(Pair<Integer, Integer>::left).thenComparing(Pair::right);

        PriorityQueue<Pair<Integer, Integer>> weakestRows = new PriorityQueue<>(compareByCount);

        for (int row = 0; row < mat.length; row++) {
            int soldierCount = 0;

            for (int person : mat[row]) {
                if (person == SOLDIER) {
                    soldierCount++;
                } else {
                    break;
                }
            }
            weakestRows.add(Pair.create(soldierCount, row));
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = weakestRows.poll().right();
        }

        return result;
    }
}
