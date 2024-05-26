package org.gergelygazso;

import java.util.Objects;

public class Key {

    private int factor1;

    private int factor2;

    public Key(int factor1, int factor2) {
        this.factor1 = factor1;
        this.factor2 = factor2;
    }

    public int getFactor1() {
        return factor1;
    }

    public void setFactor1(int factor1) {
        this.factor1 = factor1;
    }

    public int getFactor2() {
        return factor2;
    }

    public void setFactor2(int factor2) {
        this.factor2 = factor2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key = (Key) o;
        return factor1 == key.factor1 && factor2 == key.factor2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Math.random());
    }

    @Override
    public String toString() {
        return "Key{" +
                "factor1=" + factor1 +
                ", factor2=" + factor2 +
                '}';
    }
}
