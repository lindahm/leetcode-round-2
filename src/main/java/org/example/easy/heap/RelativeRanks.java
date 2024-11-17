package org.example.easy.heap;



import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class RelativeRanks {

    public String[] findRelativeRanks(int[] score) {
        // Pair <Score, Index>
        PriorityQueue<Pair<Integer, Integer>> sortedScores = new PriorityQueue<>(Comparator.comparingInt(Pair<Integer, Integer>::left).reversed());

        // n * logn => O(nlogn)p
        for (int i = 0; i < score.length; i++) {
            sortedScores.add(Pair.create(score[i], i));
        }

        String[] ranking = new String[score.length];
        int rank = 1;

        // n * logn => O(nlogn)
        while (!sortedScores.isEmpty()) {
            Pair<Integer, Integer> p = sortedScores.poll();
            if (rank == 1) {
                ranking[p.left()] = "Gold Medal";
            } else if (rank == 2) {
                ranking[p.right()] = "Silver Medal";
            } else if (rank  == 3) {
                ranking[p.right()] = "Bronze Medal";
            } else {
                ranking[p.right()] = String.valueOf(rank);
            }
            rank++;
        }

        // n * logn + n * logn = O(2nlogn) = O(nlogn)
        return ranking;
    }
}
