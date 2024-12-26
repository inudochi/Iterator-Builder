package com.task5.module;

public class Director {

    public Indicator construct(Builder builder, float start, float stop, float measure) {
        builder.setView(1, 'N', 'S'); // Пример параметров: длина, норма, метка
        builder.lineBounds(start, stop);
        builder.linePaint(measure);
        builder.lineMark(String.format("%.1f", measure));
        builder.addTitle("Норма");

        return builder.build();
    }
}
