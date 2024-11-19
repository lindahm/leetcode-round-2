package org.example.hard;
/**
 * 327
 * */
public class CountOfRangeSum {
    private static class SumCounter {
        int sum;
        int counter;
        final int lowerBound;
        final int upperBound;

        public SumCounter(int value, int lowerBound, int upperBound) {
            this.sum = value;
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
            updateCounter();
        }

        private void updateCounter() {
            this.counter += this.sum >= lowerBound && this.sum <= this.upperBound ? 1 : 0;
        }

        public SumCounter merge(SumCounter sumCounter) {
            this.sum += sumCounter.sum;
            this.counter += sumCounter.counter;
            updateCounter();
            return this;
        }
    }
    public int countRangeSum(int[] nums, int lower, int upper) {

            return countSum(nums, 0, nums.length - 1, lower, upper).counter;
    }

    private SumCounter countSum(int[] nums, int low, int high, int lower, int upper) {
        if (low < high) {
            int mid = (low + high) / 2;
            SumCounter left = countSum(nums, low, mid, lower, upper);
            SumCounter right = countSum(nums, mid + 1, high, lower, upper);
            return left.merge(right);
        } else {
            return new SumCounter(nums[low], lower, upper);
        }
    }


}
