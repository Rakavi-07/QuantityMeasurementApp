package com.quantity;

public enum WeightUnit {

    KILOGRAM(1.0),
    GRAM(0.001),          // 1 g = 0.001 kg
    POUND(0.453592);     // 1 lb ≈ 0.453592 kg

    private final double toKg;

    WeightUnit(double toKg) {
        this.toKg = toKg;
    }

    // → base (kg)
    public double toBase(double value) {
        return value * toKg;
    }

    // ← base (kg)
    public double fromBase(double value) {
        return value / toKg;
    }
}