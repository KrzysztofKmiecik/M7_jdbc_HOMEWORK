package pl.kmiecik.M7_jdbc_HOMEWORK.zad1.vehicle.domain;

public class Limit {

    private int min;
    private int max;

    public Limit(final int min, final int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    @Override
    public String toString() {
        return "Limit{" +
                "min=" + min +
                ", max=" + max +
                '}';
    }
}
