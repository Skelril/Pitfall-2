package com.skelril.Pitfall;

public class DataPair<Type, Data> {

    private Type type;
    private Data data;

    public DataPair(Type type, Data data) {
        this.type = type;
        this.data = data;
    }

    public Type getType() {
        return type;
    }

    public Data getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof DataPair && type.equals(((DataPair) o).getType()) && data.equals(((DataPair) o).getData());
    }
}