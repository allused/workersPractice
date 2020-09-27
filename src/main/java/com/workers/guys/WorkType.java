package com.workers.guys;

public enum WorkType {
    BEGINNER(0.6),
    MEDIUM(0.7),
    EXPERT(0.8);

    private final double value;
    WorkType(double value){
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
