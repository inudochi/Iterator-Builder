package com.task4.module;

public class ConcreteAggregate implements Aggregate {
    private String folderPath;

    public ConcreteAggregate(String folderPath) {
        this.folderPath = folderPath;
    }

    @Override
    public Iterator getIterator() {
        return new ImageIterator(folderPath);
    }

    @Override
    public boolean hasNext(int i) {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
}
