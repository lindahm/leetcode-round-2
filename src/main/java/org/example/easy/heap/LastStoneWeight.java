package org.example.easy.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * 1046 Pers
 * */
public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        final int numberOfPlayers = 2;
        PriorityQueue<Integer> heaviestStones = new PriorityQueue<>(Comparator.reverseOrder());
        heaviestStones.addAll(Arrays.stream(stones).boxed().toList());

        while (heaviestStones.size() >= numberOfPlayers) {
            Integer stone1 = heaviestStones.poll();
            Integer stone2 = heaviestStones.poll();

            if (!stone1.equals(stone2)) {
                heaviestStones.add(stone1 - stone2);
            }
        }
        return heaviestStones.isEmpty() ? 0 : heaviestStones.poll();
    }

    /**
     * if stones are equals, smash result will be 0 and will be added to the end of the heap
     * at the end we will return either the last biggest or 0 means none are left.
     * */
    public int lastStoneWeight_simplierVersion(int[] stones) {
        final int numberOfPlayers = 2;
        PriorityQueue<Integer> heaviestStones = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            heaviestStones.add(stone);
        }

        while (heaviestStones.size() >= numberOfPlayers) {
            heaviestStones.add(heaviestStones.poll() - heaviestStones.poll());
        }
        return heaviestStones.poll();
    }
}
