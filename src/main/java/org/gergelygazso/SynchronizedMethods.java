package org.gergelygazso;

public class SynchronizedMethods {

    private int sum = 0;

    public void calculate() {
        setSum(getSum() + 1);
    }

    public synchronized void synchronisedCalculate() {
        setSum(getSum() + 1);
    }

    public int getSum() {
        return sum;
    }

    private void setSum(int sum) {
        this.sum = sum;
    }
}
