package com.task5.module;

public interface Builder {
    void setView(int N, char norm, char select);
    void lineBounds(float start, float stop);
    void linePaint(float mesuare);
    void lineMark(String mesuare);
    void addTitle(String name);

    Indicator build();
}

