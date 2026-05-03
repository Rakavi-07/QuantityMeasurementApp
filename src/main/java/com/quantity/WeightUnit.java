package com.quantity;

public enum WeightUnit implements IMeasurable {

    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    private final double toKg;

    WeightUnit(double toKg) {
        this.toKg = toKg;
    }

    @Override
    public double toBase(double value) {
        return value * toKg;
    }

    @Override
    public double fromBase(double value) {
        return value / toKg;
    }

    @Override
    public String getUnitName() {
        return name();
    }
}