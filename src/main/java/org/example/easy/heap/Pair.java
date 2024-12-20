package org.example.easy.heap;

public class Pair<L, R> {

    private final L left;
    private final R right;

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public static <L, R> Pair<L, R> create(L left, R right) {
        return new Pair<>(left, right);
    }
    public L left() {
        return this.left;
    }

    public R right() {
        return this.right;
    }

}
