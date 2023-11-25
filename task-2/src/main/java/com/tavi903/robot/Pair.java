package com.tavi903.robot;

import java.util.Objects;

public class Pair<U,V> {
    private U u;
    private V v;

    public Pair(U u, V v) {
        this.u = u;
        this.v = v;
    }

    public U getU() {
        return u;
    }

    public void setU(U u) {
        this.u = u;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(u, pair.u) && Objects.equals(v, pair.v);
    }

    @Override
    public int hashCode() {
        return Objects.hash(u, v);
    }
}
