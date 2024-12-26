package com.task4.module;

public interface Aggregate {
    public Iterator getIterator();

    boolean hasNext(int i);

    Object next();
}

