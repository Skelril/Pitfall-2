package com.skelril.Pitfall;

public class DataPair<Type, Data> implements Cloneable {

    private Type type;
    private Data data;

    public DataPair(Type type, Data data) {
        this.type = type;
        this.data = data;
    }

    public Type getType() {
        return type;
    }

    public DataPair<Type, Data> setType(Type type) {
        this.type = type;
        return this;
    }

    public Data getData() {
        return data;
    }

    public DataPair<Type, Data> setData(Data data) {
        this.data = data;
        return this;
    }

    @Override
    public DataPair<Type, Data> clone() {
        return new DataPair<Type, Data>(type, data);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof DataPair && type.equals(((DataPair) o).getType()) && data.equals(((DataPair) o).getData());
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash *= 31 + getType().hashCode();
        hash *= 31 + getData().hashCode();
        return hash;
    }
}
