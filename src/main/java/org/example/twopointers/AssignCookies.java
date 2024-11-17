package org.example.twopointers;

import java.util.Arrays;

/**
 * 455
 * */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        int gIndex = 0;
        int sIndex = 0;
        int happyKids = 0;

        Arrays.sort(g);
        Arrays.sort(s);

        while (gIndex < g.length && sIndex < s.length) {
            if (s[sIndex] >= g[gIndex]) {
                happyKids++;
                gIndex++;
            }
            sIndex++;
        }

        return happyKids;
    }
}
